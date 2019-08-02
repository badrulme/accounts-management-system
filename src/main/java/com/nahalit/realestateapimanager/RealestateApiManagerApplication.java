package com.nahalit.realestateapimanager;

import com.nahalit.realestateapimanager.storage.StorageProperties;
import com.nahalit.realestateapimanager.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RealestateApiManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RealestateApiManagerApplication.class, args);
  }

//  @Bean
//  CommandLineRunner init(StorageService storageService) {
//    return (args) -> {
////            storageService.deleteAll();
////            storageService.init();
//    };
//  }
}
