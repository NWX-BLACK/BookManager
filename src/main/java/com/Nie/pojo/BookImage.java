package com.Nie.pojo;

public class BookImage {
    Integer bookImageId;
    Integer bookId;
    String  imgUrl;

    public BookImage() {
    }

    public BookImage(Integer bookImageId, Integer bookId, String imgUrl) {
        this.bookImageId = bookImageId;
        this.bookId = bookId;
        this.imgUrl = imgUrl;
    }

    public Integer getBookImageId() {
        return bookImageId;
    }

    public void setBookImageId(Integer bookImageId) {
        this.bookImageId = bookImageId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "BookImage{" +
                "bookImageId=" + bookImageId +
                ", bookId=" + bookId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
