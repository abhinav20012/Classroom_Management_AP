package com.company;

import java.util.*;

public class Instructor implements Find,Grades{
    private final int name;
    private Backpack backpack;
    public Instructor(int name,Backpack backpack) {
        this.name = name;
        this.backpack=backpack;
    }
    Scanner scan =new Scanner(System.in);
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
            if(backpack.getAssessments().get(i).getType()==0 &&  backpack.getAssessments().get(i).getStatus()==1)
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


    public void enter(int k) {
        System.out.println("Welcome I"+k);
        System.out.println("1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");

        int menu;
        menu=scan.nextInt();
        while(menu!=9)
        {
            if(menu==1)
            {
                int s;
                System.out.println("1. Add Lecture Slide\n" +
                        "2. Add Lecture Video");
                s = scan.nextInt();
                if (s == 1) {
                    add_slides();
                } else  {
                    add_video();
                }
            }
            else if( menu==2)
            {
                int s;
                System.out.println("1. Add Assignment\n" +
                        "2. Add Quiz");
                s = scan.nextInt();
                add_assesment(s);
            }
            else if( menu==3)
            {
                view_lecture_material();
            }
            else if( menu==4)
            {
                view_assessment();
            }
            else if( menu==5)
            {
                backpack.gradess(this);
            }
            else if( menu==6)
            {
                close_assessment();
            }
            else if( menu==7)
            {
                view_comments();
            }
            else if( menu==8)
            {
                add_comments();
            }
            else{
                break;
            }
            System.out.println("Welcome I"+k);
            System.out.println("1. Add class material\n" +
                    "2. Add assessments\n" +
                    "3. View lecture materials\n" +
                    "4. View assessments\n" +
                    "5. Grade assessments\n" +
                    "6. Close assessment\n" +
                    "7. View comments\n" +
                    "8. Add comments\n" +
                    "9. Logout");
            menu=scan.nextInt();

        }
    }
    private void all_assessment()
    {
        int rr=0    ;
        for(int i=0;i<backpack.getAssessments().size();i++)
        {
            if(backpack.getAssessments().get(i).getType()==1)
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
            if(backpack.getAssessments().get(i).getType()==0)
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
    private void close_assessment() {
        if(backpack.getAssessments().size()>0){
        System.out.println("List of Open Assignments: ");
        view_assessment();
        int close;
        System.out.println("Enter id of assignment to close:");
        close=scan.nextInt();
        backpack.getAssessments().get(close).setStatus(0);
    }
        else
        {
            System.out.println("No assessments opened. ");
        }
    }

    private void add_comments() {
        String comment;
        System.out.println("Enter Comment: ");
        scan.nextLine();
        comment=scan.nextLine().toString();
        Date date=java.util.Calendar.getInstance().getTime();
        Comments c=new Comments(comment,0,name,date.toString());
        backpack.setComments(c);
    }

    private void add_assesment(int s) {
        if(s==1)
        {
            String problem;
            int max_marks;
            System.out.println("Enter problem statement: ");
            scan.nextLine();
            problem=scan.nextLine().toString();
            System.out.println("Enter max marks: ");
            max_marks=scan.nextInt();
            Assessment a=new Assessment(1,problem,max_marks,1);
            backpack.setAssessments(a);
        }
        else
        {
            String problem;
            System.out.println("Enter quiz question: ");
            scan.nextLine();
            problem=scan.nextLine().toString();
            Assessment a=new Assessment(0,problem,1,1);
            backpack.setAssessments(a);
        }
    }

    private void add_video() {
        String topic,filename;
        System.out.println("Enter topic of video:");
        scan.nextLine();
        topic=scan.nextLine().toString();
        System.out.println("Enter filename of video:");
        filename=scan.nextLine().toString();
        if(filename.endsWith(".mp4")){
        Date date=java.util.Calendar.getInstance().getTime();
        Lecture_Video v1=new Lecture_Video(topic,filename,name,date.toString());
        backpack.setLecture_videos(v1);}
        else
        {
            System.out.println("Please give correct file. [It should be .mp4 file]  Try again!..");

        }
    }

    private void add_slides() {
        String topic;
        System.out.println("Enter topic of slides:");
        scan.nextLine();
        topic=scan.nextLine().toString();
        int n;
        System.out.println("Enter number of slides:");
        n=scan.nextInt();
        int no_of_slides=n;
        System.out.println("Enter content of slides");
        scan.nextLine();
        int i =1;
        String content;
        Vector<String>contents=new Vector<>();
        Date date=java.util.Calendar.getInstance().getTime();
        while(n!=0){
            System.out.println("Content of slide "+i+":");
            content=scan.nextLine().toString();
            contents.add(content);
            i++;
            n--;
        }
        Lecture_slides s=new Lecture_slides(topic,no_of_slides,contents,name,date.toString());
        backpack.setLecture_slides(s);
}

    @Override
    public void grades() {
        all_assessment();
        int id;
        System.out.println("Enter ID of assessment to view submissions: ");
        id=scan.nextInt();
        System.out.println("Choose ID from these ungraded submissions");
        int j=0;
        for(int i=0;i<backpack.getStudents().size();i++)
        {
            for(int k=0;k<backpack.getStudents().get(i).getSubmitted_assignments().size();k++){
                if(backpack.getStudents().get(i).getSubmitted_assignments().get(k).getAssignment_id()==id && backpack.getStudents().get(i).getSubmitted_assignments().get(k).getMax_scored()==-1)
                {
                    System.out.println(j+". S"+backpack.getStudents().get(i).getName());
                    j++;
                }
            }
        }
        if(j>0){
            int where=0;
            int key;
            key=scan.nextInt();
            for(int i=0;i<backpack.getStudents().size();i++)
            {
                for(int k=0;k<backpack.getStudents().get(i).getSubmitted_assignments().size();k++){
                    if(backpack.getStudents().get(i).getSubmitted_assignments().get(k).getAssignment_id()==id && backpack.getStudents().get(i).getSubmitted_assignments().get(k).getMax_scored()==-1)
                    {
                        if(where==key){
                            System.out.println("Submission: "+backpack.getStudents().get(i).getSubmitted_assignments().get(k).getWork());
                        }
                        where++;
                    }}
            }
            where=0;
            System.out.println("Max Marks: "+backpack.getAssessments().get(id).getMax_marks());
            int given_marks;
            System.out.println("Marks Scored: ");
            given_marks=scan.nextInt();
            for(int i=0;i<backpack.getStudents().size();i++)
            {
                for(int k=0;k<backpack.getStudents().get(i).getSubmitted_assignments().size();k++){
                    if(backpack.getStudents().get(i).getSubmitted_assignments().get(k).getAssignment_id()==id && backpack.getStudents().get(i).getSubmitted_assignments().get(k).getMax_scored()==-1)
                    {
                        if(where==key){
                            backpack.getStudents().get(i).getSubmitted_assignments().get(k).setMax_scored(given_marks);
                            backpack.getStudents().get(i).getSubmitted_assignments().get(k).setChecker(name);
                        }
                        where++;
                    }}
            }
        }
        else
        {
            System.out.println("No id found.");
        }

    }
}
