package com.company;

import java.util.Vector;

public class Lecture_slides {
    private final String topic;
    private final int no_of_slides;
    private final Vector<String>contents;
    private final int instructor_name;
    private final String date;

    public int getInstructor_name() {
        return instructor_name;
    }

    public String getDate() {
        return date;
    }

    public Lecture_slides(String topic, int no_of_slides, Vector<String> contents, int instructor_name, String date) {
        this.topic = topic;
        this.no_of_slides = no_of_slides;
        this.contents = contents;
        this.instructor_name = instructor_name;
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public int getNo_of_slides() {
        return no_of_slides;
    }

    public Vector<String> getContents() {
        return contents;
    }
}
