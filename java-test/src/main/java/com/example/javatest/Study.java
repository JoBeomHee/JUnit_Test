package com.example.javatest;public class Study {
    private StudyStatus status = StudyStatus.DRAFT;
    private int limit = 3;

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
