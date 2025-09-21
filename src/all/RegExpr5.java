package all;// Use wildcard and quantifier.
import java.util.regex.*;
class RegExpr5 {
public static void main(String[] args) {

    //match any sequence that begins with e and ends with d.
Pattern pat = Pattern.compile("e.+d");
Matcher mat = pat.matcher("extend cup end table");
while(mat.find())
System.out.println("Match: " + mat.group());
}
}

//Match: extend cup end