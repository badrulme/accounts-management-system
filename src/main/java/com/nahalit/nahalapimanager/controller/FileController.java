package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.StorageFileNotFoundException;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@RequestMapping("/api/rest/files")
@Controller
public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

//  @GetMapping("/")
//  public String listUploadedFiles(Model model) throws IOException {
//
//    model.addAttribute("files", storageService.loadAll().map(
//        path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
//            "serveFile", path.getFileName().toString()).build().toString())
//        .collect(Collectors.toList()));
//
//    return "uploadForm";
//  }


    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("/delete-file")
    public Map deleteFile(String fileName) throws IOException {
        return storageService.deleteFile(fileName);
    }

    @PostMapping("/upload-file")
    public String uploadFile(@Valid @RequestParam MultipartFile multipartFile) {
        if (multipartFile != null) {
            String nowTime = UtillDate.getNowTimeNameForFile();
            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
            storageService.store(multipartFile, filename);
            return filename;
        } else {
            return "File Upload Failed";
        }
    }

//  @PostMapping("/")
//  public String handleFileUpload(@RequestParam("file") MultipartFile file, String name,
//                                 RedirectAttributes redirectAttributes) {
////            file.re
//   String s= storageService.store(file, filename);
//    redirectAttributes.addFlashAttribute("message",
//        "You successfully uploaded " + s + "!"+name);
//
//    return "redirect:/";
//  }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}