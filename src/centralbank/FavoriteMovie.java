package centralbank;

import java.util.*;
import java.util.stream.Collectors;

public class FavoriteMovie {
    public static void main(String[] args) {

        List<String> moview  = Arrays.asList("Uri 4", "Kabirsingh 5", "Gullyboy 5","Kesari 4", "Kalank 1","Lukachuppi 2",
                "Badla 3", "Uri 5","Kabirsingh 3", "Gullyboy 4","Kalank 2", "Lukachuppi 2", "Badla 2","Uri 4", "Gullyboy 4");



        Arrays.stream(new String("ythdfbjhsd ").split(""));

        Map<String,Long> mapCount = moview.stream().map(x->x.split(" " ))
                .collect(Collectors.groupingBy( x-> String.valueOf(x[0]),Collectors.counting()));

        Map<String,Double> mapSum = moview.stream().map(x->x.split(" " )) //.collect(Collectors.toMap())
                .collect(Collectors.groupingBy( x-> String.valueOf(x[0]),Collectors.summingDouble(x-> Double.parseDouble(x[1]))));

        Map<String,Integer> mapSum3 = moview.stream().map(x->x.split(" " ))
                .collect(Collectors.groupingBy( x-> String.valueOf(x[0]),   Collectors.summingInt(x-> Integer.parseInt(x[1]))  ));

        mapCount.forEach((x,y)-> {
            if(mapSum.containsKey(x)){
             //   System.out.println(x+" === "+y + " ==== " + mapSum.get(x)/ (int) (long)  y);
                mapSum.put(x, mapSum.get(x)/ (int) (long)  y);
            }

        });

        Optional<Map.Entry<String, Double>> d =  mapSum.entrySet().stream().max((x, y)-> (int) (x.getValue()-y.getValue()));

       if (d.isPresent()){
           Double d1 =  d.get().getValue();
           System.out.println(d.get().getKey()+" "+ String.format("%.1f", d1)  );
        }

    }
}
