package com.example.recyclerview29032022;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvFood;
    List<FoodModel> listFoods;
    FoodAdapter foodAdapter;
    int totalPage, totalItem, currentPage, currentItem;
    boolean isLoading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalItem = totalPage = currentItem = currentPage = 0;
        rcvFood = findViewById(R.id.recyclerView);
        listFoods = FoodModel.getMock();
        listFoods.add(null);
        foodAdapter = new FoodAdapter(listFoods);
        rcvFood.setAdapter(foodAdapter);
        rcvFood.setHasFixedSize(true);

        event();
    }

    private void event() {
        totalItem = 21;
        totalPage = (int) Math.ceil((float) totalItem / 10);

        rcvFood.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                currentItem = listFoods.size() - 1;
                currentPage = (int) (totalPage - (Math.ceil((double) (totalItem - currentItem) / 10)));

                if (isLoading || currentPage >= totalPage){
                    return;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
                int totalItems = linearLayoutManager.getItemCount();
                int visibleItems = linearLayoutManager.getChildCount();

                if (firstVisiblePosition > 0 && (visibleItems + firstVisiblePosition) >= totalItems){
                    isLoading = true;
                    loadMore();
                }

                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void loadMore() {
        listFoods.remove(listFoods.size() - 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listFoods.addAll(FoodModel.getMoreData());
                if (currentPage < totalPage - 1) {
                    listFoods.add(null);
                }
                foodAdapter.notifyDataSetChanged();
                isLoading = false;
            }
        },1500);
    }
}
