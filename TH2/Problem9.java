package TH2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problem9 {
    private static class Time{
        int hour, minute, second;

        public Time(String s) {
            String[] arr = s.split("\\s+");
            hour = Integer.parseInt(arr[0]);
            minute = Integer.parseInt(arr[1]);
            second = Integer.parseInt(arr[2]);
        }

        @Override
        public String toString(){
            return hour + " " + minute + " " + second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0){
            arr.add(new Time(sc.nextLine()));
        }
        Collections.sort(arr, new Comparator<Time>() {
            @Override
            public int compare(Time x, Time y) {
                if(x.hour == y.hour){
                    if(x.minute == y.minute){
                        return x.second - y.second;
                    }
                    return x.minute - y.minute;
                }
                return x.hour - y.hour;
            }
        });

        for(Time time : arr){
            System.out.println(time);
        }
        sc.close();
    }
}
