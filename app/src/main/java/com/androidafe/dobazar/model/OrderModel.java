package com.androidafe.dobazar.model;

import java.util.ArrayList;

import retrofit2.Call;

public class OrderModel {

    private int id;
    private int userId;

    ArrayList<ProductModel> productModels;

    int[] quantity;

    private String orderImage;
    private  int amount;

    private boolean orderStatus;

    public OrderModel(int id, int userId, ArrayList<ProductModel> productModels, String orderImage, int amount, int[] quantity,boolean orderStatus) {
        this.id = id;
        this.userId = userId;
        this.productModels = productModels;
        this.orderImage = orderImage;
        this.amount = amount;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<ProductModel> getProductModels() {
        return productModels;
    }

    public void setProductModels(ArrayList<ProductModel> productModels) {
        this.productModels = productModels;
    }

    public String getOrderImage() {
        return "http://10.0.2.2/AdminPanel/admin/panel/order/uploads/"+orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }


    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[]quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getorderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

}
