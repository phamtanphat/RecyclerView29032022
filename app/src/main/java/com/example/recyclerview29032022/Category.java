package com.example.recyclerview29032022;

public enum Category {
    RESTAURANT("Nhà hàng"),
    SHOP_ONLINE("Shop online"),
    FAMILY("Gia đình"),
    GROUP("Hội nhóm"),
    BIRTHDAY("Sinh nhật"),
    BUFFET("Buffet"),
    STREET_FOOD("Quán vỉa hè");

    private String text;

    Category(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
