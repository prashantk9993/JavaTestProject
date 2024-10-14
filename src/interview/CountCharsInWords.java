package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountCharsInWords {

	public static void main(String[] args) {
		 
		String name="uihdhgjdjfdgjdbvjkdbjsjs";
		String[] alphabets = name.split("");
		Map<String,Integer> str = new HashMap<>();
		
		Arrays.stream(name.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting())).forEach((x,y)->System.out.println(x+" "+y));
		
		System.out.println("====================================================");
		
		for(int i =0;i<alphabets.length;i++) {
			if(str.containsKey(alphabets[i])) {	
				int num = str.get(alphabets[i]);
				str.put(alphabets[i],num+1);			
			}else {
				str.put(alphabets[i], 1);
			}
		}
		
		str.forEach((x,y)-> System.out.println(x+" "+y));
	}

}
