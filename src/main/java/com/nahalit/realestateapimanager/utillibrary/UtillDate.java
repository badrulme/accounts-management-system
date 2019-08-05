package com.nahalit.realestateapimanager.utillibrary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtillDate {
  private LocalDateTime now = LocalDateTime.now();

  private DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssmsns");
  private String formatDateTimeForFile = now.format(format);

  public String getFormatDateTimeForFile() {
    return formatDateTimeForFile;
  }
}
