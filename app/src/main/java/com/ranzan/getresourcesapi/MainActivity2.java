package com.ranzan.getresourcesapi;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private TextView name;
    private TextView num;
    private TextView year;
    private TextView company;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initViews();
        int value =Integer.parseInt(getIntent().getStringExtra("value"));
        num.setText(value + "");
        APIClient apiClient = Network.getRetrofitInstance().create(APIClient.class);
        apiClient.getPost(value).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                year.setText(model.getData().getYear()+"");
                name.setText(model.getData().getName());
                linearLayout.setBackgroundColor(Color.parseColor(model.getData().getColor()));
                company.setText(model.getData().getPantoneValue());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        num = findViewById(R.id.num);
        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        company = findViewById(R.id.company);
        linearLayout = findViewById(R.id.layout);
    }
}