package com.bosch.visitor_management;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.bosch.visitor_management.adapters.CompanyImageAdapter;
import com.bosch.visitor_management.api.CompanyApi;
import com.bosch.visitor_management.dto.CompanyInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.153:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CompanyApi service = retrofit.create(CompanyApi.class);
        service.getCompanies().enqueue(new Callback<List<CompanyInfo>>() {
            @Override
            public void onResponse(Call<List<CompanyInfo>> call, Response<List<CompanyInfo>> response) {
                if (response.isSuccessful()) {
                    GridView gridview = findViewById(R.id.companyGridview);
                    gridview.setAdapter(new CompanyImageAdapter(getApplicationContext(), response.body()));
                } else {
                    Toast.makeText(MainActivity.this, "Can't load company list", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CompanyInfo>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                Toast.makeText(MainActivity.this, "Can't load company list", Toast.LENGTH_SHORT).show();
            }
        });
        GridView gridview = findViewById(R.id.companyGridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CapturePictureActivity.class);
                startActivity(intent);
            }
        });
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
}