package com.example.recyclerview29032022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvFood;
    List<FoodModel> listFoods;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvFood = findViewById(R.id.recyclerView);
        listFoods = FoodModel.getMock();
        foodAdapter = new FoodAdapter(listFoods);
        rcvFood.setAdapter(foodAdapter);
        rcvFood.setHasFixedSize(true);

    }
}
