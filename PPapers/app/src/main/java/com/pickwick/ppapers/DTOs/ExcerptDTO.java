package com.pickwick.ppapers.DTOs;

public class ExcerptDTO {
    public int bookId;
    public int excerptId;
    public String bookName;
    public String excerptText;
    public byte[] imageBlob;
    public String amazonUri;

    public ExcerptDTO(int bookId, int excerptId, String bookName, String excerptText, byte[] imageBlob, String amazonUri){
        this.bookId = bookId;
        this.excerptId = excerptId;
        this.bookName = bookName;
        this.excerptText = excerptText;
        this.imageBlob = imageBlob;
        this.amazonUri = amazonUri;
    }
}
