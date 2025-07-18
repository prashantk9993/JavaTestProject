package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

       // input={-7,3,-4,2,6,-1}
       // output={2,-1,3,-4,6,-7}

        Integer[] array1 = {-7, 3, -4, 2, 6, -1};

        List<Integer>  p_array = new ArrayList<>();
        List<Integer>  n_array = new ArrayList<>();
        List<Integer> array = Arrays.asList(array1);

        for(int i = 0;i < array1.length;i++){
            if(array1[i]<0){
                n_array.add(array1[i]);
            }else {
                p_array.add(array1[i]);
            }
        }

        n_array.sort((x,y)->y-x);
        p_array.sort((x,y)->x-y);
        array.sort((x,y)->x-y);

        for (int i = 0 ; i<p_array.size();i++){
                System.out.println(p_array.get(i));
                System.out.println(n_array.get(i));
        }
    }
}
