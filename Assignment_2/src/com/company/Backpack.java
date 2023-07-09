package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Backpack {
    private final Vector<Student> students=new Vector<>();
    private final Vector<Instructor>instructors;

    private  ArrayList<Lecture_slides>lecture_slides = new ArrayList<>();
    private  ArrayList<Lecture_Video>lecture_videos = new ArrayList<>();
    private  ArrayList<Assessment>assessments=new ArrayList<>();
    private  ArrayList<Comments>commentss=new ArrayList<>();

    public Vector<Student> getStudents()
    {
        return students;
    }


    public  void setComments(Comments c) {
        commentss.add(c);
    }

    public  ArrayList<Comments> getComments() {
        return commentss;
    }

    public  ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    public  void setAssessments(Assessment a) {
        assessments.add(a);
    }

    public void setLecture_slides(Lecture_slides s) {
        lecture_slides.add(s);
    }

    public void setLecture_videos(Lecture_Video v) {
        lecture_videos.add(v);
    }

    public ArrayList<Lecture_slides> getLecture_slides() {
        return lecture_slides;
    }

    public ArrayList<Lecture_Video> getLecture_videos() {
        return lecture_videos;
    }



    public Backpack() {
        instructors=new Vector<>();
    }

    Scanner scan=new Scanner(System.in);

    public void add_instructor(Instructor instructor)
    {
        instructors.add(instructor);
    }
    public void add_student(Student studen)
    {
        students.add(studen);
    }

    public void enter_as_instructor() {
        System.out.println("Instructors:");
        for(int i=0;i<instructors.size();i++)
        {
            System.out.println(i+" - I"+i);
        }
        int k;
        System.out.println("Choose id:");
        k=scan.nextInt();
        instructors.get(k).enter(k);
    }

    public void enter_as_student() {
        System.out.println("Students:");
        for(int i=0;i<students.size();i++)
        {
            System.out.println(i+" - S"+i);
        }
        int k;
        System.out.println("Choose id:");
        k=scan.nextInt();
        students.get(k).enter(k);
    }

    public void gradess(Object object_call)
    {
       Grades g=(Grades)object_call;
       g.grades();
    }
}
