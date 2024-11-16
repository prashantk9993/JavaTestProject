package interview;

import java.util.Stack;

public class ValidateParenthesisUSingStack {
	
	public static void main(String[] arg) {
		 
		String input = ")()()()()";
		Stack<String> stack = new Stack<String>();
		boolean flag = false;
		String[] strArray = input.split("");
		
		try {
			
			for(String s: strArray) {
				
				if(s.equals("(")) {
					stack.push(s);
				}
				if(s.equals(")")){
					stack.pop();
				}
			}
			
			if(stack.size()==0) {
				flag=true;
			} else {
				flag=false;
			}
		}catch (Exception e) {
			System.out.print("Exception occured....");
			flag=false;
		}
		
		System.out.print("Result::::"+flag);
	}

}
