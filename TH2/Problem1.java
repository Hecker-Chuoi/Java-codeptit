package TH2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("TH2/SV.in"));
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
