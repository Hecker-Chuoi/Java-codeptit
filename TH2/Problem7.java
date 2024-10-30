package TH2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem7 {
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
    private static class LoaiPhong implements Comparable<LoaiPhong>{
        char sign;
        String type;
        int pricePerDay;
        double extra;

        public LoaiPhong(String s){
            String[] arr = s.trim().split("\\s+");
            sign = arr[0].charAt(0);
            type = arr[1];
            pricePerDay = Integer.parseInt(arr[2]);
            extra = Double.parseDouble(arr[3]);
        }

        @Override
        public int compareTo(LoaiPhong o) {
            return type.compareTo(o.type);
        }

        @Override
        public String toString(){
            return sign + " " + type + " " + pricePerDay + " " + extra;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
