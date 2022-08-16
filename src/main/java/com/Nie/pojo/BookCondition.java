package com.Nie.pojo;


public class BookCondition {
    private Integer id;
    private String name;
    private Double minprice;
    private Double maxprice;
    private String category;

    public BookCondition() {

    }

    public BookCondition(Integer id, String name, Double minprice, Double maxprice, String category) {
        this.id = id;
        this.name = name;
        this.minprice = minprice;
        this.maxprice = maxprice;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinprice() {
        return minprice;
    }

    public void setMinprice(Double minprice) {
        this.minprice = minprice;
    }

    public Double getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Double maxprice) {
        this.maxprice = maxprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minprice=" + minprice +
                ", maxprice=" + maxprice +
                ", category='" + category + '\'' +
                '}';
    }
}
