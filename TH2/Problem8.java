package TH2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Problem8 {
    private static class Candidate{
        private static int num = 0;
        String id;
        String fullName;
        String dob;
        float lt;
        float th;
        int age;
        float bonus;
        String rating;

        public void input(Scanner sc){
            num++;
            id = "PH" + String.format("%02d", num);
            fullName = sc.nextLine();
            dob = sc.nextLine();
            lt = Float.parseFloat(sc.nextLine());
            th = Float.parseFloat(sc.nextLine());
            if(lt >= 8 && th >= 8) bonus = 1F;
            else if(lt >= 7.5 && th >= 7.5) bonus = 0.5F;
            else bonus = 0;
            normalize();
            rate();
        }

        public int avgScore(){
            return (int) Math.min(10, Math.round((lt + th)/2.0 + bonus));
        }

        public void rate(){
            int score = avgScore();
            if(score < 5) rating = "Truot";
            else if(score < 7) rating = "Trung binh";
            else if(score == 7) rating = "Kha";
            else if(score == 8) rating = "Gioi";
            else rating = "Xuat sac";
        }

        public void normalize(){
            fullName = nameNormalize(fullName);
            age = 2021 - Integer.parseInt(dob.substring(dob.length()-4));
        }

        public String nameNormalize(String name){
            StringBuilder res = new StringBuilder();
            for(String x : name.trim().toLowerCase().split("\\s+")){
                res.append(x.substring(0, 1).toUpperCase() + x.substring(1) + " ");
            }
            return res.toString().trim();
        }

        @Override
        public String toString(){
            StringJoiner joiner = new StringJoiner(" ");
            joiner.add(id);
            joiner.add(fullName);
            joiner.add(String.valueOf(age));
            joiner.add(String.valueOf(avgScore()));
            joiner.add(rating);
            return joiner.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("XETTUYEN.in"));
        ArrayList<Candidate> arr = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            Candidate tmp = new Candidate();
            tmp.input(in);
            arr.add(tmp);
        }

        for(Candidate tmp : arr){
            System.out.println(tmp);
        }
    }
}