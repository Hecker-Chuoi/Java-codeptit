package TH2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringJoiner;

public class Problem5 {
    private static String normalize(String s) {
        StringJoiner sb = new StringJoiner(" ");
        for (String x : s.toLowerCase().trim().split("\\s+")) {
            StringBuilder tmp = new StringBuilder(x);
            tmp.setCharAt(0, Character.toUpperCase(tmp.charAt(0)));
            sb.add(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("DATA.in"));
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.equals("END"))
                break;
            System.out.println(normalize(s));
        }
        sc.close();
    }
}
