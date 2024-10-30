package TH2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem6 {
    private static class Subject implements Comparable<Subject>{
        String subjectID;
        String name;
        int credit;

        public void input(Scanner sc){
            subjectID = sc.nextLine();
            name = sc.nextLine();
            credit = Integer.parseInt(sc.nextLine());
        }

        @Override
        public int compareTo(Subject y) {
            return name.compareTo(y.name);
        }

        @Override
        public String toString(){
            return subjectID + " " + name + " " + credit;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Subject> arr = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            Subject sub = new Subject();
            sub.input(sc);
            arr.add(sub);
        }
        Collections.sort(arr);
        for(Subject sub : arr){
            System.out.println(sub);
        }
        sc.close();
    }
}
