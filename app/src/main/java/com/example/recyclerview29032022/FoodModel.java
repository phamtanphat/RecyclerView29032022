package com.example.recyclerview29032022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FoodModel {
    private int image;
    private String name;
    private String address;
    private List<Category> categoryList;
    private String discount;
    private float distance;
    private Date openTime;
    private Date closeTime;

    public FoodModel(int image, String name, String address, List<Category> categoryList, String discount, float distance, Date openTime, Date closeTime) {
        this.image = image;
        this.name = name;
        this.address = address;
        this.categoryList = categoryList;
        this.discount = discount;
        this.distance = distance;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public static List<FoodModel> getMock(){
        return new ArrayList<>(Arrays.asList(
                new FoodModel(R.drawable.img_cheesecake,"Uncle Lu's Cheesecake - Sư Vạn Hạnh","652 Sư Vạn Hạnh, P. 12, Quận 10, TP. HCM",Arrays.asList(Category.FAMILY,Category.GROUP),"Cả ngày - 15%",10.1f,Utils.createDateForHour(8),Utils.createDateForHour(21)),
                new FoodModel(R.drawable.foody_com_tam_minh_long,"Cơm Tấm Minh Long - Nguyễn Thị Thập","607 Nguyễn Thị Thập, P. Tân Hưng, Quận 7, TP. HCM",Arrays.asList(Category.FAMILY,Category.SHOP_ONLINE),"Ca ngay - 30%",22f,Utils.createDateForHour(7),Utils.createDateForHour(21)),
                new FoodModel(R.drawable.foody_pizza_4p,"Pizza 4P’s - Pizza Kiểu Nhật - Lê Thánh Tôn","8/15 Lê Thánh Tôn, P. Bến Nghé,  Quận 1, TP. HCM",Arrays.asList(Category.RESTAURANT,Category.FAMILY,Category.GROUP),"Ca ngay 50%",10.5f,Utils.createDateForHour(10),Utils.createDateForHour(23)),
                new FoodModel(R.drawable.foody_restaurant_sanfulou,"San Fu Lou - Ẩm Thực Quảng Đông - Lê Lai","Tầng Trệt, AB Tower, 76A Lê Lai, P. Bến Thành,  Quận 1, TP. HCM",Arrays.asList(Category.RESTAURANT,Category.FAMILY,Category.GROUP),"Buoi sang - 10%",15f,Utils.createDateForHour(7),Utils.createDateForHour(3)),
                new FoodModel(R.drawable.foody_ut_ut_quan,"Quán Ụt Ụt - Barbecue & Beer - Võ Văn Kiệt","168 Võ Văn Kiệt, P. Cầu Ông Lãnh,  Quận 1, TP. HCM",Arrays.asList(Category.BIRTHDAY,Category.FAMILY,Category.GROUP),"Buoi toi - 20%",18f,Utils.createDateForHour(11),Utils.createDateForHour(23)),
                new FoodModel(R.drawable.foody_restaurant_fuji,"Fuji Japanese Restaurant 富士 - Nikko Saigon Hotel","Tầng Trệt Nikko Saigon Hotel, 235 Nguyễn Văn Cừ, P. Phạm Ngũ Lão,  Quận 1, TP. HCM",Arrays.asList(Category.RESTAURANT,Category.FAMILY,Category.GROUP),"Không có ưu đãi",14.7f,Utils.createDateForHour(11),Utils.createDateForHour(22)),
                new FoodModel(R.drawable.foody_buffet_sabusabu,"Shabu Ya - SC VivoCity","Tầng 4 - SC VivoCity, 1058 Nguyễn Văn Linh, KP. 1, P. Tân Phong,  Quận 7, TP. HCM",Arrays.asList(Category.BUFFET,Category.RESTAURANT,Category.FAMILY,Category.GROUP),"Ca ngay 15%",28.4f,Utils.createDateForHour(9),Utils.createDateForHour(22)),
                new FoodModel(R.drawable.foody_buffet_hana_bbq_and_hot_pot,"Hana BBQ & Hot Pot Buffet - Nguyễn Quý Đức","65 Nguyễn Quý Đức, P. An Phú,  Quận 2, TP. HCM",Arrays.asList(Category.BUFFET,Category.RESTAURANT,Category.FAMILY),"Buoi sang 10%",13.2f,Utils.createDateForHour(8),Utils.createDateForHour(22)),
                new FoodModel(R.drawable.foody_restaurant_kvegetarian,"Quán Chay KVegetarian - Bình Thạnh","20/15 Phan Đăng Lưu, P. 6,  Quận Bình Thạnh, TP. HCM",Arrays.asList(Category.RESTAURANT,Category.FAMILY,Category.GROUP),"Không có ưu đãi",7.3f,Utils.createDateForHour(9),Utils.createDateForHour(21)),
                new FoodModel(R.drawable.foody_streetfood_223flan,"Quán 223 - Bánh Flan Thập Cẩm","223 Trần Bình Trọng,  Quận 5, TP. HCM",Arrays.asList(Category.STREET_FOOD,Category.SHOP_ONLINE,Category.GROUP),"Không có ưu đãi",20f,Utils.createDateForHour(11),Utils.createDateForHour(21)),
                new FoodModel(R.drawable.foody_streetfood_banh_mi_bo_a_tung,"A Tùng - Bánh Mì Bò Nướng Bơ Cambodia - Cống Quỳnh","171 Cống Quỳnh,  Quận 1, TP. HCM",Arrays.asList(Category.STREET_FOOD,Category.SHOP_ONLINE,Category.GROUP),"Không có ưu đãi",11f,Utils.createDateForHour(14),Utils.createDateForHour(21)),
                new FoodModel(R.drawable.foody_shop_online_bep_rua,"Bếp Rùa - Chân Gà Rút Xương Ngâm Sả Tắc - Shop Online","127/5/9 Lê Thúc Hoạch, P. Phú Thọ Hòa,  Quận Tân Phú, TP. HCM",Arrays.asList(Category.SHOP_ONLINE,Category.GROUP,Category.FAMILY),"Ca ngay 10%",20f,Utils.createDateForHour(5),Utils.createDateForHour(24)),
                new FoodModel(R.drawable.foody_shop_online_bep_9_sach,"Bánh 9 Sạch - Bánh Sầu Riêng - Shop Online","73 An Dương Vương, P. 8,  Quận 5, TP. HCM",Arrays.asList(Category.SHOP_ONLINE,Category.GROUP,Category.FAMILY),"Ca ngay 5%",16f,Utils.createDateForHour(8),Utils.createDateForHour(21))

        ));
    }
}
