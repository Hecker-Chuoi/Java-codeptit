package TH2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Problem3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("TH2/SV.in"));
        ArrayList<Integer> arr = (ArrayList<Integer>) reader.readObject();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x : arr){
            int cnt = 0;
            if(map.containsKey(x))
                cnt = map.get(x);
            map.put(x, cnt+1);
        }
        for(Map.Entry<Integer, Integer >x : map.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
        reader.close();
    }
}
