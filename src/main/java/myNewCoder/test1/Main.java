package myNewCoder.test1;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new LinkedList<>();
        while (sc.hasNext()){
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(i == 0 && j == 0){
                break;
            }
            results.add(i + j);
        }
        for(int i = 0; i < results.size(); i++){
            System.out.println(results.get(i));
        }
    }
}
