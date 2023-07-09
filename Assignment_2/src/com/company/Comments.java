package com.company;

public class Comments {
    private final String comments;
    private final int type;         // who is adding the comments
    private final int no;           // its id
    private final String date;

    public String getComments() {
        return comments;
    }

    public int getType() {
        return type;
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public Comments(String comments, int type, int no, String date) {
        this.comments = comments;
        this.type = type;
        this.no = no;
        this.date = date;
    }
}