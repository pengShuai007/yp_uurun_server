package com.pengshuai.school.interview.thoughtWorks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解决方法实现类
 */
public class SolutionService {

    private ArrayList<Graph> graphArrayList;
    private StringBuffer tempRouteStr = new StringBuffer();


    public List<String> getAllRoutes(String begin, String target) {
        List<String> routeList = new ArrayList();
        for (Graph entity : graphArrayList) {
            if (begin.equals(entity.getBegin())) {
                getAllRoutes(graphArrayList, begin, entity.getEnd(), target, routeList);
            }
        }
        return routeList;
    }

    private void getAllRoutes(ArrayList<Graph> graphArrayList, String begin, String nextStep, String target,List<String> routeList) {
        if (nextStep.equals(target)) {
            tempRouteStr.append(nextStep);
            if (!routeList.contains(begin + tempRouteStr.toString())) {
                routeList.add(begin + tempRouteStr.toString());
            }
            String twoWayStr = getTwoWay(target);
            if(twoWayStr != ""){
                routeList.add(begin + tempRouteStr + twoWayStr);
            }
            tempRouteStr.setLength(0); //字符串置空
        } else {
            for (Graph entity : graphArrayList) {
                if (nextStep.equals(entity.getBegin())) {
                    //tempRouteStr为空时，校验下个节点是否是根节点的叶子节点
                    if (tempRouteStr.length() == 0 && !isRootLeaf(begin, nextStep)) {
                        continue;
                    }
                    tempRouteStr.append(nextStep);
                    if (isVaild(entity.getEnd())) { //判断下一步有效性，防止进入死循环
                        this.getAllRoutes(graphArrayList, begin, entity.getEnd(), target, routeList);
                    } else {
                        tempRouteStr.deleteCharAt(tempRouteStr.length() - 1);
                    }
                }
            }
        }
    }

    private String getTwoWay(String target){
        for(Graph graph : graphArrayList){
            if(target.equals(graph.getBegin())){
                for(Graph g : graphArrayList){
                    if(g.getBegin().equals(graph.getEnd()) && target.equals(g.getEnd())){
                        return g.getBegin() + g.getEnd();
                    }
                }
            }
        }
        return "";
    }

    private boolean isRootLeaf(String root, String next) {
        for (Graph graph : graphArrayList) {
            if (root.equals(graph.getBegin()) && next.equals(graph.getEnd())) {
                return true;
            }
        }
        return false;
    }

    private boolean isVaild(String next) {
        StringBuffer stringBuffer = new StringBuffer(tempRouteStr + next);
        if (stringBuffer.length() >= 4) {
            String before = stringBuffer.substring(stringBuffer.length() - 2);
            String behind = stringBuffer.substring(stringBuffer.length() - 4, stringBuffer.length() - 2);
            if (before.equals(behind)) {
                return false;
            }
        }
        return true;
    }

    public int getDistanceByString(String rout){
        int distance = 0;
        for(int i = 0;i < rout.length() - 1; i++){
            int temp = getDistance(String.valueOf(rout.charAt(i)), String.valueOf(rout.charAt(i+1)));
            if(temp > 0){
                distance += temp;
            }else{
                return 0;
            }
        }
        return distance;
    }

    public String getDistanceByArray(String[] route) {
        int distance = 0;
        for (int i = 0; i < route.length - 1; i++) {
            int temp = getDistance(route[i], route[i + 1]);
            if (temp > 0) {
                distance += temp;
            } else {
                return "NO SUCH ROUTE";
            }
        }
        return String.valueOf(distance);
    }

    public int getDistance(String begin, String end) {
        int distance = 0;
        for (int i = 0; i < graphArrayList.size(); i++) {
            if (graphArrayList.get(i).getBegin().equals(begin)
                    && graphArrayList.get(i).getEnd().equals(end)) {
                distance = graphArrayList.get(i).getDistance();
            }
        }
        return distance;
    }

    public void buildData() {
        String basePath = SolutionService.class.getResource("").toString();
        basePath = basePath.replace("file:/", "");
        basePath = basePath.replace("/", "//");
        String[] dataArray = readInputData(basePath);
        ArrayList<Graph> graphArrayList = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {
            if (!"".equals(dataArray[i]) && dataArray[i].length() > 2) {
                String begin = String.valueOf(dataArray[i].charAt(0));
                String end = String.valueOf(dataArray[i].charAt(1));
                String distanceStr = dataArray[i].substring(2);
                if (!isNumeric(distanceStr)) {
                    continue;
                }
                int distance = Integer.parseInt(distanceStr);
                graphArrayList.add(new Graph(begin, end, distance));
            }
        }
        this.graphArrayList =  graphArrayList;
    }

    public String[] readInputData(String basePath) {
        String pathName = basePath + "input.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String[] resultArray = null;
        try {
            fileReader = new FileReader(pathName);
            bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!"".equals(line)) {
                    stringBuffer.append(line + ",");
                }
            }
            String resultStr = stringBuffer.toString();
            if (resultStr.endsWith(",")) {
                resultStr = resultStr.substring(0, resultStr.length() - 1);
            }
            resultStr = resultStr.replace(" ", "");
            resultArray = resultStr.split(",");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultArray;
    }

    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
