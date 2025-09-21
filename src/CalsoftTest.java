public class CalsoftTest {

    public static void main(String[] args) {

        CalsoftTest obj = new CalsoftTest();

        String str = "aaaaababbbaaaccccabcdaaabaccdddd";
        String input = "aba";

        System.out.println(obj.getIndex(str,input));
    }

    public int getIndex(String str , String sub){

        int InputLength = sub.length();
        for (int i = 1 ; i < str.length() ; i++){

            for (int j = 1 ; j < InputLength ; j ++){
                     System.out.print(str.charAt(i-j));
                   //  System.out.print(str.charAt(i));
                    // System.out.print(str.charAt(i+j));
            }
        }
        return 0;
    }
}


/*
str := "aaaaababbbaaaccccabcdaaabaccdddd"
searchStr := "aba"


database:
employee(id, name, salary, department)*/
