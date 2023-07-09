package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student implements Find,Grades {
    private final int name;
    private Backpack backpack;
    private Submit_assignments s;
    private ArrayList<Submit_assignments>submitted_assignments=new ArrayList<>();

    public int getName() {
        return name;
    }
    public ArrayList<Submit_assignments> getSubmitted_assignments() {
        return submitted_assignments;
    }

    public Student(int name,Backpack backpack) {
        this.name = name;
        this.backpack=backpack;
    }
    Scanner scan =new Scanner(System.in);

    @Override
    public void grades() {
        System.out.println("Graded submissions");
        for(int i=0;i<submitted_assignments.size();i++)
        {
            if(submitted_assignments.get(i).getMax_scored()!=-1)
            {
                System.out.println("Submission: " +submitted_assignments.get(i).getWork());
                System.out.println("Marks Scored: "+submitted_assignments.get(i).getMax_scored());
                System.out.println("Graded by: I"+submitted_assignments.get(i).getChecker());
                System.out.println("");
            }
        }
        System.out.println("Ungraded submissions");
        for(int i=0;i<submitted_assignments.size();i++)
        {
            if(submitted_assignments.get(i).getMax_scored()==-1)
            {
                System.out.println("Submission: " +submitted_assignments.get(i).getWork());
                System.out.println("");
            }
        }
        System.out.println("----------");

    }
    @Override
    public void view_lecture_material() {
        for(int i=0;i<backpack.getLecture_slides().size();i++)
        {
            System.out.println("Title:"+backpack.getLecture_slides().get(i).getTopic());
            for(int j=0;j<backpack.getLecture_slides().get(i).getNo_of_slides();j++)
            {
                System.out.println("Slide "+(j+1)+": "+backpack.getLecture_slides().get(i).getContents().get(j));
            }
            System.out.println("Number of Slides: "+backpack.getLecture_slides().get(i).getNo_of_slides());
            System.out.println("Date of Upload: "+backpack.getLecture_slides().get(i).getDate());
            System.out.println("Uploaded by: I"+backpack.getLecture_slides().get(i).getInstructor_name());
            System.out.println("");
        }
        for(int i=0;i<backpack.getLecture_videos().size();i++)
        {
            System.out.println("Title of video: "+backpack.getLecture_videos().get(i).getTopic());
            System.out.println("Video file: "+ backpack.getLecture_videos().get(i).getVide_name());
            System.out.println("Date of Upload: "+backpack.getLecture_videos().get(i).getDate());
            System.out.println("Uploaded by: I"+backpack.getLecture_videos().get(i).getInstructor_name());
            System.out.println("");
        }
    }

    @Override
    public void view_assessment() {
        int rr=0    ;
        for(int i=0;i<backpack.getAssessments().size();i++)
        {
            if(backpack.getAssessments().get(i).getType()==1 && backpack.getAssessments().get(i).getStatus()==1)
            {
                rr++;
                System.out.println("ID: "+i+" Assignemnt: "+backpack.getAssessments().get(i).getProblem()+" Max Marks: "+backpack.getAssessments().get(i).getMax_marks());
            }
        }
        if(rr>0)
        {
            System.out.println("------------");
        }
        rr=0;
        for(int i=0;i<backpack.getAssessments().size();i++)
        {
            if(backpack.getAssessments().get(i).getType()==0  && backpack.getAssessments().get(i).getStatus()==1)
            {
                rr++;
                System.out.println("ID: "+i+" Question: "+backpack.getAssessments().get(i).getProblem());
            }
        }
        if(rr>0)
        {
            System.out.println("------------");
        }
    }

    @Override
    public void view_comments() {
        for (int i=0;i<backpack.getComments().size();i++)
        {
            if(backpack.getComments().get(i).getType()==0)
            {
                System.out.println(backpack.getComments().get(i).getComments()+" - I"+backpack.getComments().get(i).getNo());
                System.out.println(backpack.getComments().get(i).getDate());
                System.out.println("");
            }
            else
            {
                System.out.println(backpack.getComments().get(i).getComments()+" - S"+backpack.getComments().get(i).getNo());
                System.out.println(backpack.getComments().get(i).getDate());
                System.out.println("");
            }
        }

    }

    public void enter(int k) {
        System.out.println("Welcome S"+k);
        System.out.println("1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
        int menu;
        menu=scan.nextInt();
        while(menu!=7)
        {
            if(menu==1)
            {
                view_lecture_material();
            }
            else if (menu==2){
                view_assessment();
            }
            else if (menu==3){
                submit_assignemnts();
            }
            else if (menu==4){
                backpack.gradess(this);
            }
            else if (menu==5){
                view_comments();
            }
            else if (menu==6){
                add_comments();
            }
            else
            {
                break;
            }
            System.out.println("Welcome S"+k);
            System.out.println("1. View lecture materials\n" +
                    "2. View assessments\n" +
                    "3. Submit assessment\n" +
                    "4. View grades\n" +
                    "5. View comments\n" +
                    "6. Add comments\n" +
                    "7. Logout");
            menu= scan.nextInt();
        }
    }
    private void submit_assignemnts() {
        int size=0;
        for (int i = 0; i < backpack.getAssessments().size(); i++) {
            if (backpack.getAssessments().get(i).getStatus() == 1) {
                int j;
                for (j = 0; j < submitted_assignments.size(); j++) {
                    if (submitted_assignments.get(j).getAssignment_id() == i) {
                        break;
                    }
                }
                if (j == submitted_assignments.size()) {
                    if (backpack.getAssessments().get(i).getType() == 1) {
                        size++;
                    } else{
                        size++;
                    }
                }
            }
        }
        if(size>0)
        {
            System.out.println("Pending assessments ");
            for (int i = 0; i < backpack.getAssessments().size(); i++) {
                if (backpack.getAssessments().get(i).getStatus() == 1) {
                    int j;
                    for (j = 0; j < submitted_assignments.size(); j++) {
                        if (submitted_assignments.get(j).getAssignment_id() == i) {
                            break;
                        }
                    }
                    if (j == submitted_assignments.size()) {
                        if (backpack.getAssessments().get(i).getType() == 1) {
                            System.out.println("ID: " + i + " Assignemnt: " + backpack.getAssessments().get(i).getProblem() + " Max Marks: " + backpack.getAssessments().get(i).getMax_marks());
                        } else{
                            System.out.println("ID: " + i + " Question: " + backpack.getAssessments().get(i).getProblem());
                        }
                    }
                }
            }
        int id;
        System.out.println("Enter ID of assessment: ");
        id=scan.nextInt();
        if(backpack.getAssessments().get(id).getType()==1) {
            String filename;
            System.out.println("Enter filename of assignment: ");
            scan.nextLine();
            filename = scan.nextLine().toString();
            if (filename.endsWith(".zip")) {
                s = new Submit_assignments(-1, id, filename, 1, -1);
                submitted_assignments.add(s);
            } else {
                System.out.println("Please give correct submission .[Give file with .zip extension. ]");
            }
        }
        else
        {
            String ans;
            System.out.println(backpack.getAssessments().get(id).getProblem());
            scan.nextLine();
            ans=scan.nextLine().toString();
            if(ans.contains(" ")){
                System.out.println("Please give one word ans. Please try again to submit. ");
        }
            else
            {
                s=new Submit_assignments(-1,id,ans,0,-1);
                submitted_assignments.add(s);
            }
        }
    }
        else
        {
            System.out.println("No Pending Assessements.");
        }
    }
    private void add_comments() {
        String comment;
        System.out.println("Enter Comment: ");
        scan.nextLine();
        comment=scan.nextLine().toString();
        Date date=java.util.Calendar.getInstance().getTime();
        Comments c=new Comments(comment,1,name,date.toString());
        backpack.setComments(c);
    }
}

