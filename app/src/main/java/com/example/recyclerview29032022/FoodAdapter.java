package com.example.recyclerview29032022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<FoodModel> listFoods;
    int FOOD_ITEM_TYPE = 0;
    int LOADING_TYPE = 1;

    public FoodAdapter(List<FoodModel> listFoods) {
        this.listFoods = listFoods;
    }

    @Override
    public int getItemViewType(int position) {
        if (listFoods.get(position) == null) {
            return LOADING_TYPE;
        }
        return FOOD_ITEM_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == FOOD_ITEM_TYPE) {
            view = layoutInflater.inflate(R.layout.layout_item_food, parent, false);
            return new FoodViewHolder(view);
        }else{
            view = layoutInflater.inflate(R.layout.layout_item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FoodViewHolder){
            FoodModel foodModel = listFoods.get(position);
            ((FoodViewHolder) holder).bind(foodModel);
        }
    }

    @Override
    public int getItemCount() {
        if (listFoods == null || listFoods.size() == 0) {
            return 0;
        }
        return listFoods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTimeOpen, txtName, txtAddress, txtCategory, txtDiscount, txtDistance;
        StringBuilder textCategory;
        int hourCurrent, minusCurrent, hourOpenModel, minusOpenModel, hourCloseModel, minusCloseModel;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewFood);
            txtTimeOpen = itemView.findViewById(R.id.textViewOpen);
            txtName = itemView.findViewById(R.id.textViewName);
            txtAddress = itemView.findViewById(R.id.textViewAddress);
            txtCategory = itemView.findViewById(R.id.textViewCategory);
            txtDiscount = itemView.findViewById(R.id.textViewDiscount);
            txtDistance = itemView.findViewById(R.id.textViewDistance);
            hourCurrent = minusCurrent = hourOpenModel = minusOpenModel = hourCloseModel = minusCloseModel = 0;

        }

        public void bind(FoodModel foodModel) {
            img.setImageResource(foodModel.getImage());
            txtName.setText(foodModel.getName());
            txtAddress.setText(foodModel.getAddress());
            txtDistance.setText(String.format(">%.1f km", foodModel.getDistance()));
            if (foodModel.getCategoryList().size() > 0) {
                textCategory = new StringBuilder();
                for (int i = 0; i < foodModel.getCategoryList().size(); i++) {
                    if (i == foodModel.getCategoryList().size() - 1) {
                        textCategory.append(foodModel.getCategoryList().get(i).getText());
                    } else {
                        textCategory.append(foodModel.getCategoryList().get(i).getText()).append(" - ");
                        ;
                    }
                }
                txtCategory.setText(textCategory.toString());
            }
            if (!foodModel.getDiscount().isEmpty()) {
                txtDiscount.setVisibility(View.VISIBLE);
                txtDiscount.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_new, 0, 0, 0);
                txtDiscount.setText(foodModel.getDiscount());
            } else {
                txtDiscount.setVisibility(View.GONE);
            }
            Calendar calendar = Calendar.getInstance();
            hourCurrent = calendar.get(Calendar.HOUR_OF_DAY);
            minusCurrent = calendar.get(Calendar.MINUTE);
            hourOpenModel = Utils.milliToHour(foodModel.getOpenTime());
            minusOpenModel = Utils.milliToMinus(foodModel.getOpenTime());
            hourCloseModel = Utils.milliToHour(foodModel.getCloseTime());
            minusCloseModel = Utils.milliToMinus(foodModel.getCloseTime());
            if ((hourCurrent < hourOpenModel) || (hourCurrent >= hourCloseModel)) {
                if ((minusCurrent < minusOpenModel) || (minusCurrent >= minusCloseModel)) {
                    txtTimeOpen.setVisibility(View.VISIBLE);
                    txtTimeOpen.setText(String.format("Đóng cửa\nMở cửa vào lúc %s", Utils.formatTimeToString(foodModel.getOpenTime())));
                }
            } else {
                txtTimeOpen.setVisibility(View.GONE);
            }
        }
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
