package com.company;

public class Assessment {
    private final int type;
    private final String problem;
    private final  int max_marks;
    private int status =1;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public String getProblem() {
        return problem;
    }

    public int getMax_marks() {
        return max_marks;
    }

    public Assessment(int type, String problem, int max_marks,int status) {
        this.type = type;
        this.problem = problem;
        this.max_marks = max_marks;
        this.status=status;
    }
}
