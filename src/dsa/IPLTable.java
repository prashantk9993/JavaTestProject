package dsa;

import java.util.*;
import java.util.stream.Collectors;

public class IPLTable {

    public static void main(String[] args) {

        IPLTable obj = new IPLTable();

        int numberOfTeams = 4;
        List<String> teamNames = Arrays.asList("A","B","C","D");

        Map<String,Integer> IPLTableMap = new TreeMap<>();

        int numberOfMatches = 5;
        Map<String,String> scores = new HashMap<>();
        scores.put("A 1.0","B 2.0");
        scores.put("B 1.0","C 2.1");
        scores.put("D 2.5","A 1.2");
        scores.put("B 1.5","D 1.0");
        scores.put("C 1.2","A 2.0");
        obj.findWinningPoints(IPLTableMap,scores);


        Map<String,Float> average = new TreeMap<>();

        for (Map.Entry<String,String> entry : scores.entrySet()){

            String[] match1 = entry.getKey().split(" ");
            String teamName1 = match1[0];
            Float point1 = Float.valueOf(match1[1]);

            String[] match2 = entry.getValue().split(" ");
            String teamName2 = match2[0];
            Float point2 = Float.valueOf(match2[1]);


                if(average.containsKey(teamName1)){
                    average.put(teamName1,average.get(teamName1)+point1);
                }else {
                    average.put(teamName1,point1);
                }

                if(average.containsKey(teamName2)){
                    average.put(teamName2,average.get(teamName2)+point2);
                }else {
                    average.put(teamName2,point2);
                }

        }
System.out.println();
        average.entrySet().stream().forEach((x)-> System.out.println(x.getKey()+" "+String.format("%.2f",x.getValue())));
    }

    private void findWinningPoints(Map<String, Integer> iplTableMap, Map<String, String> scores) {

        for (Map.Entry<String,String> entry : scores.entrySet()){
            String[] match1 = entry.getKey().split(" ");
            String teamName1 = match1[0];
            Float point1 = Float.valueOf(match1[1]);

            String[] match2 = entry.getValue().split(" ");
            String teamName2 = match2[0];
            Float point2 = Float.valueOf(match2[1]);

            if(point1>point2){
                if(iplTableMap.containsKey(teamName1)){
                    iplTableMap.put(teamName1,iplTableMap.get(teamName1)+2);
                }else {
                    iplTableMap.put(teamName1,2);
                }
            }else {
                if(iplTableMap.containsKey(teamName2)){
                    iplTableMap.put(teamName2,iplTableMap.get(teamName2)+2);
                }else {
                    iplTableMap.put(teamName2,2);
                }
            }
        }

        iplTableMap.entrySet().stream().sorted(Map.Entry.comparingByValue((x,y)->y-x)).forEach((x)-> System.out.println(x.getKey()+" "+x.getValue()));
    }


}
