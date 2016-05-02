package com.rba.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rba.retrofitdemo.adapter.PlaceAdapter;
import com.rba.retrofitdemo.model.response.PlaceResponse;
import com.rba.retrofitdemo.util.api.ApiManager;
import com.rba.retrofitdemo.util.control.SimpleDividerItemDecoration;
import com.rba.retrofitdemo.util.http.ConnectionDetector;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;
    private List<PlaceResponse.DataBean> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        placeList = new ArrayList<>();

        placeAdapter = new PlaceAdapter(this, placeList);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(placeAdapter);

        recyclerView.addOnItemTouchListener(new PlaceAdapter.RecyclerTouchListener(getApplicationContext(),
                recyclerView, new PlaceAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, placeList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        getData();

    }

    private void getData(){

        if(!ConnectionDetector.validateConnection(this)) {
            Toast.makeText(this, getString(R.string.connect_internet), Toast.LENGTH_SHORT).show();
        } else {

            Call<PlaceResponse> call = ApiManager.apiInterface().getPlace();
            call.enqueue(new Callback<PlaceResponse>() {
                @Override
                public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> data) {

                    if(data.isSuccessful()){

                        PlaceResponse response = data.body();

                        if(response.getSuccess()==1){
                            placeList = response.getData();

                            Log.i("x- list", new Gson().toJson(placeList));

                            placeAdapter = new PlaceAdapter(MainActivity.this, placeList);
                            recyclerView.setAdapter(placeAdapter);
                            placeAdapter.notifyDataSetChanged();


                        }else{
                            Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                @Override
                public void onFailure(Call<PlaceResponse> call, Throwable t) {
                    Log.i("x- error", t.getMessage());
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}
