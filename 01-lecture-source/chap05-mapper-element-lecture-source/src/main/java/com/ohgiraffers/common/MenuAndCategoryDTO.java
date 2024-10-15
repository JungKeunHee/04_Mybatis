package com.ohgiraffers.common;

public class MenuAndCategoryDTO {

    private int code;
    private String name;
    private int price;
    private CategoryDTO categoryDTO;
    private String orderableStatus;

    public MenuAndCategoryDTO() {
    }

    public MenuAndCategoryDTO(int code, String name, int price, CategoryDTO categoryDTO, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryDTO = categoryDTO;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryDTO=" + categoryDTO +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}