package dsa;

import java.util.Stack;

public class FindValidBrackets {

    public static void main(String[] args) {
        String input1 = "(the[is]{valid})";
        String input2 = "{the(is[valid])}";
        String input3 = "(this)(is)(valid)";
        String inputTest = "([]{))";
        String input4 = "(the[is]{invalid))";
        String input5 = "(the[is]{invalid}}";
        String input6 = "(this](is}{invalid)";
        String input7 = "[this]{is}(invalid))";

        System.out.println(checkBrackets(input1));
        System.out.println(checkBrackets(input2));
        System.out.println(checkBrackets(input3));

        System.out.println(checkBrackets(inputTest));

        System.out.println(checkBrackets(input4));
        System.out.println(checkBrackets(input5));
        System.out.println(checkBrackets(input6));
        System.out.println(checkBrackets(input7));

    }

    public static boolean checkBrackets(String input) {

        Stack<String> stack = new Stack<>();

        String[] array = input.split("");

        for (String cha : array) {
            if (cha.equals("(") || cha.equals("[") || cha.equals("{")) {
                stack.push(cha);
            } else if (!stack.isEmpty() &&
                    stack.peek().equals("(") && cha.equals(")") ||
                    stack.peek().equals("[") && cha.equals("]") ||
                    stack.peek().equals("{") && cha.equals("}")) {
                stack.pop();
            }
        }
        // System.out.println(input+" Stack size :::"+stack.size());
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}
