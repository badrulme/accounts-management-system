package com.nahalit.realestateapimanager;

import com.nahalit.realestateapimanager.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RealestateApiManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RealestateApiManagerApplication.class, args);
  }

//  @Bean
//  public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurer() {
//      @Override
//      public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
//      }
//    };
//  }

//  @Bean
//  CommandLineRunner init(StorageService storageService) {
//    return (args) -> {
////            storageService.deleteAll();
////            storageService.init();
//    };
//  }
}
