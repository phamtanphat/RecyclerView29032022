package com.example.recyclerview29032022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    List<FoodModel> listFoods;

    public FoodAdapter(List<FoodModel> listFoods) {
        this.listFoods = listFoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodModel foodModel = listFoods.get(position);
        holder.bind(foodModel);
    }

    @Override
    public int getItemCount() {
        if (listFoods == null || listFoods.size() == 0) {
            return 0;
        }
        return listFoods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTimeOpen, txtName, txtAddress, txtCategory, txtDiscount, txtDistance;
        StringBuilder textCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewFood);
            txtTimeOpen = itemView.findViewById(R.id.textViewOpen);
            txtName = itemView.findViewById(R.id.textViewName);
            txtAddress = itemView.findViewById(R.id.textViewAddress);
            txtCategory = itemView.findViewById(R.id.textViewCategory);
            txtDiscount = itemView.findViewById(R.id.textViewDiscount);
            txtDistance = itemView.findViewById(R.id.textViewDistance);

        }

        public void bind(FoodModel foodModel) {
            img.setImageResource(foodModel.getImage());
            txtName.setText(foodModel.getName());
            txtAddress.setText(foodModel.getAddress());
            txtDistance.setText(String.format(">%f", foodModel.getDistance()));
            if (foodModel.getCategoryList().size() > 0) {
                textCategory = new StringBuilder();
                for (int i = 0; i < foodModel.getCategoryList().size(); i++) {
                    if (i == foodModel.getCategoryList().size() - 1) {
                        textCategory.append(foodModel.getCategoryList().get(i).getText()).append(" - ");
                    } else {
                        textCategory.append(foodModel.getCategoryList().get(i).getText());
                    }
                }
            }
            if (!foodModel.getDiscount().isEmpty()) {
                txtDiscount.setVisibility(View.VISIBLE);
                txtDiscount.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_new, 0, 0, 0);
                txtDiscount.setText(foodModel.getDiscount());
            } else {
                txtDiscount.setVisibility(View.GONE);
            }
            Calendar calendar = Calendar.getInstance();
            if (calendar.before(foodModel.getOpenTime()) || calendar.after(foodModel.getCloseTime())) {
                txtTimeOpen.setVisibility(View.VISIBLE);
                txtTimeOpen.setText(String.format("Đóng cửa\nMở cửa vào lúc %s", Utils.formatHour(foodModel.getOpenTime())));
            }else{
                txtTimeOpen.setVisibility(View.GONE);
            }
        }
    }
}
