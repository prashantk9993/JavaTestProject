package interview;

public class CalsoftTest {

    public static void main(String[] args) {

       /**
       Find index of input fro str
       without using any inbuild indexOF method in java
       **/
        CalsoftTest obj = new CalsoftTest();
        String str = "aaaaababbbaaaccccabcdaaabaccdddd";
        String input = "aba";
        obj.getIndex(str,input);
    }

    public void getIndex(String str , String sub){

        int strLength = str.length();
        int subLength = sub.length();

        for (int i = 0 ; i < strLength-subLength ; i++){
            String res = "";
            for (int j = 0 ; j < subLength ; j ++){
              res = res+str.charAt(i+j);
            }
            System.out.println("========="+res);
            if(res.equals(sub)){
                System.out.println("====Index is :::::"+i);
            }
        }
    }
}


/*
str := "aaaaababbbaaaccccabcdaaabaccdddd"
searchStr := "aba"


database:
employee(id, name, salary, department)*/
