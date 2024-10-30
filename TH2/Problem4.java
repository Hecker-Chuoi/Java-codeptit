package TH2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Problem4 {
    private static class Student{
        private static int num = 0;
        String studentID;
        String fullName;
        String Class;
        String dob;
        double gpa;

        public void input(Scanner sc){
            num++;
            studentID = "B20DCCN" + String.format("%03d", num);
            fullName = sc.nextLine();
            Class = sc.nextLine();
            dob = sc.nextLine();
            gpa = Double.parseDouble(sc.nextLine());
            normalize();
        }

        private void normalize(){
            String[] arr = dob.split("/");
            int date = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int year = Integer.parseInt(arr[2]);
            dob = String.format("%02d/%02d/%04d", date, month, year);
        }

        @Override
        public String toString(){
            StringJoiner joiner = new StringJoiner(" ");
            joiner.add(studentID);
            joiner.add(fullName);
            joiner.add(Class);
            joiner.add(dob);
            joiner.add(String.format("%.2f", gpa));
            return joiner.toString();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("TH2/SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            Student stu = new Student();
            stu.input(sc);
            arr.add(stu);
        }
        for(Student stu : arr){
            System.out.println(stu);
        }
        sc.close();
    }
}
