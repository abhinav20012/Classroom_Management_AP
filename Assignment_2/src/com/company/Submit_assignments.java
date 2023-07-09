package com.company;

public class Submit_assignments {
    private int max_scored;

    public void setMax_scored(int max_scored) {
        this.max_scored = max_scored;
    }

    private final int assignment_id;
    private final String work;
    private final int type;
    private int checker;

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public int getChecker() {
        return checker;
    }

    public int getMax_scored() {
        return max_scored;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public String getWork() {
        return work;
    }

    public int getType() {
        return type;
    }

    public Submit_assignments(int max_scored, int assignment_id, String work, int type,int checker) {
        this.max_scored = max_scored;

        this.assignment_id = assignment_id;
        this.work = work;
        this.type = type;
        this.checker=checker;
    }

}
