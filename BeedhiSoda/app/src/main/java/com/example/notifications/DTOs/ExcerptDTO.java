package com.example.notifications.DTOs;

public class ExcerptDTO {
    public int bookId;
    public int excerptId;
    public String bookName;
    public String excerptText;

    public ExcerptDTO(int bookId, int excerptId, String bookName, String excerptText){
        this.bookId = bookId;
        this.excerptId = excerptId;
        this.bookName = bookName;
        this.excerptText = excerptText;
    }
}
