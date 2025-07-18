import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SubArrayDemo {

    public static void main(String[] args) {
        int[] arrays =  {1,2,3,3,2,1,1,1,1,2,4};

        List<Integer> res  = new ArrayList<>();
        for (int i = 0 ; i < arrays.length ; i ++){

            if(getSum(res)==6){
                System.out.println(res);
                res.clear();
              // --i;
                //continue;
            } else if(getSum(res)>=6){
                res.remove(arrays[i]);

            } else {
                res.add(arrays[i]);
            }
            //System.out.println("size::::"+res.size());
        }
    }

    public static int getSum(List<Integer> lst){

          Integer sum =  lst.stream().reduce(0,Integer::sum);

          //System.out.println("Sum:::::"+sum);
          return sum;
    }
}
