package leetcode881;

import java.util.Arrays;

public class LeetCode881 {

    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if(people[i] + people[j] <= limit) {
                count++;
                i++;
                j--;
            } else {
                count++;
                j--;
            }
        }
        if(i == j) {
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        {
            LeetCode881 leetCode881 = new LeetCode881();
            int[] people = new int[] {1, 2};
            int limit = 3;
            System.out.println(leetCode881.numRescueBoats(people, limit));
        }

        {
            LeetCode881 leetCode881 = new LeetCode881();
            int[] people = new int[] {3, 2, 2, 1};
            int limit = 3;
            System.out.println(leetCode881.numRescueBoats(people, limit));
        }

        {
            LeetCode881 leetCode881 = new LeetCode881();
            int[] people = new int[] {3, 5, 3, 4};
            int limit = 5;
            System.out.println(leetCode881.numRescueBoats(people, limit));
        }
    }
}
