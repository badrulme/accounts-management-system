package com.nahalit.realestateapimanager.utillibrary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtillDate {
  public static String getNowTimeNameForFile() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssms");
    String formatDateTimeForFile = now.format(format);
    return formatDateTimeForFile;
  }
}
