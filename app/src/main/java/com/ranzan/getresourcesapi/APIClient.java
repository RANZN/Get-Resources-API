package com.ranzan.getresourcesapi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIClient {
    @GET("api/unknown/{id}")
    Call<ResponseModel> getPost(@Path("id") int id);

}
