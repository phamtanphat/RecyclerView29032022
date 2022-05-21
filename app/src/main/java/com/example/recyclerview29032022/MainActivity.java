package com.example.recyclerview29032022;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvFood;
    List<FoodModel> listFoods;
    FoodAdapter foodAdapter;
    int totalPage, totalItem, currentPage, currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalItem = totalPage = currentItem = currentPage = 0;
        rcvFood = findViewById(R.id.recyclerView);
        listFoods = FoodModel.getMock();
        foodAdapter = new FoodAdapter(listFoods);
        rcvFood.setAdapter(foodAdapter);
        rcvFood.setHasFixedSize(true);

        eventLoadMore();
    }

    private void eventLoadMore() {
        totalItem = 100;
        totalPage = totalItem / 10;
        currentItem = listFoods.size();
        currentPage = totalPage - ((totalItem - currentItem) / 10);


    }


}
