package com.nahalit.realestateapimanager.utillibrary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtillDate {
  public static String getNowTimeNameForFile() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyHHmm");
    String formatDateTimeForFile = "file_" + now.format(format) + RandomString.randomAlphaNumeric(6);
    return formatDateTimeForFile;
  }

  public static String getNowTimeNameForImage() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyHHmm");
    String formatDateTimeForImage = "img_" + now.format(format) + RandomString.randomAlphaNumeric(6);
    return formatDateTimeForImage;
  }
}
