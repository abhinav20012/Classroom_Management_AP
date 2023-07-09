package com.company;

public class Lecture_Video {
    private final String topic;
    private final String vide_name;
    private final int instructor_name;
    private final String date;

    public int getInstructor_name() {
        return instructor_name;
    }

    public String getDate() {
        return date;
    }

    public Lecture_Video(String topic, String vide_name, int instructor_name, String date) {
        this.topic = topic;
        this.vide_name = vide_name;
        this.instructor_name = instructor_name;
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public String getVide_name() {
        return vide_name;
    }
}
