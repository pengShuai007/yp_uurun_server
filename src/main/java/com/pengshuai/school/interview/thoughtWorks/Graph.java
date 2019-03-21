package com.pengshuai.school.interview.thoughtWorks;

/**
 * Created by YangPeng on 2019/3/14.
 */
public class Graph {
    private String begin;

    private String end;

    private int distance;

    public Graph(String begin,String end,int distance){
        this.begin = begin;
        this.end = end;
        this.distance = distance;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
