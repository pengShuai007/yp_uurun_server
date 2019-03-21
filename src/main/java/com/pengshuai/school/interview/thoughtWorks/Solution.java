package com.pengshuai.school.interview.thoughtWorks;

import java.util.List;

/**
 * 各问题解决方案
 */
public class Solution {

    private SolutionService solutionService = new SolutionService();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildData();
        solution.questionOne();
        solution.questionTwo();
        solution.questionThree();
        solution.questionFour();
        solution.questionFive();
        solution.questionSix();
        solution.questionSeven();
        solution.questionEight();
        solution.questionNine();
        solution.questionTen();
    }

    /**
     * 获取文件并构建实体
     */
    public void buildData(){
        solutionService.buildData();
    }

    /**
     * 求A到B到C的距离
     * The distance of the route A-B-C
     */
    public void questionOne() {
        String[] route = {"A", "B", "C"};
        System.out.println(solutionService.getDistanceByArray(route));
    }

    /**
     * 求A到D的距离
     * The distance of the route A-D
     */
    public void questionTwo() {
        String[] route = {"A", "D"};
        System.out.println(solutionService.getDistanceByArray(route));
    }

    /**
     * 求从A到D到C的距离
     * The distance of the route A-D-C
     */
    public void questionThree() {
        String[] route = {"A", "D", "C"};
        System.out.println(solutionService.getDistanceByArray(route));
    }

    /**
     * 求从A到E到B在到C到D的距离
     * The distance of the route A-E-B-C-D
     */
    public void questionFour() {
        String[] route = {"A", "E", "B", "C", "D"};
        System.out.println(solutionService.getDistanceByArray(route));
    }

    /**
     * 求从A到E到D的距离
     * The distance of the route A-E-D
     */
    public void questionFive() {
        String[] route = {"A", "E", "D"};
        System.out.println(solutionService.getDistanceByArray(route));
    }

    /**
     * 找到3步之内从C到C的路线数量
     * The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below,
     * there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops)
     */
    public void questionSix() {
        String begin = "C";
        String target = "C";
        int maxSteps = 3; //最大步数
        int count = 0;
        List<String> routeList = solutionService.getAllRoutes(begin,target);
        for(String route : routeList){
            if(route.length() <= maxSteps + 1){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 求A到C之间正好四步的路线数
     * The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are
     * three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
     */
    public void questionSeven(){
        String begin = "A";
        String target = "C";
        int exactSteps = 4; //最大步数
        int count = 0;
        List<String> routeList = solutionService.getAllRoutes(begin,target);
        for(String route : routeList){
            if(route.length() == exactSteps + 1){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 求A到C之间的最短距离
     * The length of the shortest route (in terms of distance to travel) from A to C.
     */
    public void questionEight(){
        String begin = "A";
        String target = "C";
        List<String> routeList = solutionService.getAllRoutes(begin,target);
        int shortest = 0;
        for(String route : routeList){
            int temp = solutionService.getDistanceByString(route);
            if(shortest == 0 || (temp < shortest && temp > 0) ){
                shortest = temp;
            }
        }
        System.out.println(shortest);
    }

    /**
     * 求B到B之间的最短距离
     *The length of the shortest route (in terms of distance to travel) from B to B.
     */
    public void questionNine(){
        String begin = "B";
        String target = "B";
        List<String> routeList = solutionService.getAllRoutes(begin,target);
        int shortest = 0;
        for(String route : routeList){
            int temp = solutionService.getDistanceByString(route);
            if(shortest == 0 || (temp < shortest && temp > 0) ){
                shortest = temp;
            }
        }
        System.out.println(shortest);
    }

    /**
     *
     */
    public void questionTen(){
        String begin = "C";
        String target = "C";
        int count = 0;
        List<String> routeList = solutionService.getAllRoutes(begin,target);
        for(String route : routeList){
            int temp = solutionService.getDistanceByString(route);
            if(temp <= 30){
                count++;
            }
        }
        System.out.println(count);
    }
}
