/**
 * Copyright (C) 2019, Justin Nguyen
 */
package com.bosch.visitormanagementserver.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.visitormanagementserver.dto.CompanyInfo;

/**
 * @author tuan3.nguyen@gmail.com
 */
@RestController()
@RequestMapping("/api/v1/companies")
public class CompanyController {
  @GetMapping
  @ResponseBody
  public List<CompanyInfo> getCompanies() throws IOException {
    final ClassLoader classLoader = getClass().getClassLoader();
    final URL resource = classLoader.getResource("bosch.png");
    final InputStream is = resource.openStream();
    final ByteArrayOutputStream os = new ByteArrayOutputStream();
    final byte[] buffer = new byte[1024];
    int read = 0;
    while ((read = is.read(buffer, 0, buffer.length)) != -1) {
      os.write(buffer, 0, read);
    }
    os.flush();
    final String base64Image = Base64Utils.encodeToString(os.toByteArray());
    final List<CompanyInfo> list = new ArrayList<>();
    for (int i = 0; i <= 10; i++) {
      list.add(new CompanyInfo("Bosch" + i, base64Image));
    }
    return list;
  }
}
