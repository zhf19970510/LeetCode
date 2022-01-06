package leetcode231.test2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupNum = sc.nextInt();
        int [] results = new int[groupNum];
        for(int i = 0; i < groupNum; i++){
            results[i] = sc.nextInt() + sc.nextInt();
        }
        for(int i = 0; i < results.length; i++){
            System.out.println(results[i]);
        }
    }
}
