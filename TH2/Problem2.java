package TH2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem2 {
    private static boolean check(String s){
        for(int i = 0; i < s.length(); ++i){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    private static int cmp(String x, String y){
        int signX = 1, signY = 1;
        if(x.charAt(0) == '-') signX = -1;
        if(y.charAt(0) == '-') signY = -1;
        if(signX != signY) return signX - signY;
        if(x.length() == y.length()){
            for(int i = 0; i < x.length(); ++i){
                if(x.charAt(i) != y.charAt(i))
                    return x.charAt(i) - y.charAt(i);
            }
            return 0;
        }
        return x.length() - y.length();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("TH2/SV.in"));
        long res = 0;
        while(sc.hasNext()){
            String s = sc.next();
            if(check(s) &&
                    cmp(s, String.valueOf(Integer.MIN_VALUE)) >= 0 &&
                    cmp(s, String.valueOf(Integer.MAX_VALUE)) <= 0) {
//                System.out.println(s);
                res += Integer.parseInt(s);
            }
        }
        System.out.println(res);
        sc.close();
    }
}
