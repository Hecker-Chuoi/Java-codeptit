package TH2;

import java.util.*;

public class Problem10 {
    private static class Product{
        private static int num = 0;
        String id;
        String name;
        String calUnit;
        int inPrice;
        int outPrice;
        int profit;

        public void input(Scanner sc){
            num++;
            id = "MH" + String.format("%03d", num);
            name = sc.nextLine();
            calUnit = sc.nextLine();
            inPrice = Integer.parseInt(sc.nextLine());
            outPrice = Integer.parseInt(sc.nextLine());
            profit = outPrice - inPrice;
        }

        @Override
        public String toString(){
            StringJoiner joiner = new StringJoiner(" ");
            joiner.add(id);
            joiner.add(name);
            joiner.add(calUnit);
            joiner.add(String.valueOf(inPrice));
            joiner.add(String.valueOf(outPrice));
            joiner.add(String.valueOf(profit));
            return joiner.toString();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Product> arr = new ArrayList<>();
        while(n-- > 0){
            Product tmp = new Product();
            tmp.input(sc);
            arr.add(tmp);
        }

        Collections.sort(arr, new Comparator<Product>(){
            @Override
            public int compare(Product x, Product y){
                return -1*(x.profit - y.profit);
            }
        });

        for(Product tmp : arr){
            System.out.println(tmp);
        }
        sc.close();
    }
}