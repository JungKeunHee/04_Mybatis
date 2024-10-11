package com.ohgiraffers.common;

public class SearchCriteria {

    private String condition; // 검색기준(메뉴 이름 혹은 카테고리 명)
    private String value;     // 검색어

    public SearchCriteria() {}

    public SearchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
