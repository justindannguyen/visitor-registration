package com.bosch.visitor_management.api;

import com.bosch.visitor_management.dto.CompanyInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CompanyApi {
    @GET("companies")
    Call<List<CompanyInfo>> getCompanies();
}
