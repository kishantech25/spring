package com.ds.model;

public class Product {

    private int productId;

    private String productName;

    private String category;

    private String brand;

    private double price;

    private double discountPercent;

    private int sQuantity;

    private double rating;

    private int reviewCount;

    private String sku;

    private String status;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getsQuantity() {
        return sQuantity;
    }

    public void setsQuantity(int sQuantity) {
        this.sQuantity = sQuantity;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", discountPercent=" + discountPercent +
                ", sQuantity=" + sQuantity +
                ", rating=" + rating +
                ", reviewCount=" + reviewCount +
                ", sku='" + sku + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}