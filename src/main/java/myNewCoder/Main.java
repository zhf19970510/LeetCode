package myNewCoder;

import java.util.Scanner;

/**
 * @author: 曾鸿发
 * @create: 2021-12-02 07:15
 * @description：
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            System.out.println(Solution.add(in.nextInt(), in.nextInt()));
        }
    }
}

class Solution {

    public static int add(int i, int j){
        return i+j;
    }

}