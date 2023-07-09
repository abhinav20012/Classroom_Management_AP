package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Backpack backpack =new Backpack();
        backpack.add_instructor(new Instructor(0,backpack));
        backpack.add_instructor(new Instructor(1,backpack));
        backpack.add_student(new Student(0,backpack));
        backpack.add_student(new Student(1,backpack));
        backpack.add_student(new Student(2,backpack));

        Scanner scan =new Scanner(System.in);
        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");
        int n;
        n=scan.nextInt();
        while(n!=3)
        {
            if(n==1)
            {
                backpack.enter_as_instructor();
            }
            else if(n==2)
            {
                backpack.enter_as_student();
            }
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            n=scan.nextInt();
        }
        }
}
