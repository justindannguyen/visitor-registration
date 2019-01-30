/**
 * Copyright (C) 2019, Justin Nguyen
 */
package com.bosch.visitormanagementserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuan3.nguyen@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo {
  private String name;
  private String base64Image;
}
