package com.rba.retrofitdemo.util.api;

import com.rba.retrofitdemo.model.response.PlaceResponse;
import com.rba.retrofitdemo.util.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ricardo Bravo on 2/05/16.
 */

public interface ApiInterface {

    //Interface
    @GET(Constant.URL_PLACE)
    Call<PlaceResponse> getPlace();

}

