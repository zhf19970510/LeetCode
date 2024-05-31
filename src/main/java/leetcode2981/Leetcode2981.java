package leetcode2981;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode2981 {
    public int maximumLength(String s) {
        char[] chs = s.toCharArray();
        Map<Character, PriorityQueue<Integer>> map = new HashMap<>(32);
        int n = chs.length;
        int maxLen = -1;

        for (int i = 0; i < n; ) {
            char cur = chs[i];
            int next = i + 1;
            int curLen = 1;
            while (next < n && chs[next] == cur) {
                curLen++;
                next++;
            }
            i = next;
            PriorityQueue<Integer> priorityQueue = map.computeIfAbsent(cur, t -> new PriorityQueue<>((o1, o2) -> o2 - o1));
            int lastOne = 0;
            int lastTwo = 0;
            int lastThree = 0;
            Iterator<Integer> iterator = priorityQueue.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                if (index == 0) {
                    lastOne = iterator.next();
                }
                if (index == 1) {
                    lastTwo = iterator.next();
                }
                if (index == 2) {
                    lastThree = iterator.next();
                }
                index++;
            }

            int size = priorityQueue.size();
            if (size < 3) {
                priorityQueue.add(curLen);
            } else {
                if (curLen > lastThree) {
                    priorityQueue.remove(lastThree);
                    priorityQueue.add(curLen);
                }
            }
            size = priorityQueue.size();
            Iterator<Integer> iterator1 = priorityQueue.iterator();
            index = 0;
            while (iterator1.hasNext()) {
                if (index == 0) {
                    lastOne = iterator1.next();
                }
                if (index == 1) {
                    lastTwo = iterator1.next();
                }
                if (index == 2) {
                    lastThree = iterator1.next();
                }
                index++;
            }
            int curMaxLen = -1;

            if (lastOne >= 3) {
                if (size >= 3) {
                    if (lastOne == lastTwo) {
                        if (lastOne == lastThree) {
                            curMaxLen = lastOne;
                        } else {
                            curMaxLen = lastOne - 1;
                        }
                    } else {
                        if (lastOne - lastTwo < 2) {
                            curMaxLen = lastOne - 1;
                        } else {
                            curMaxLen = lastOne - 2;
                        }
                    }
                } else {
                    if (size == 1) {
                        curMaxLen = lastOne - 2;
                    } else {
                        if (lastOne - lastTwo < 2) {
                            curMaxLen = lastOne - 1;
                        } else {
                            curMaxLen = lastOne - 2;
                        }
                    }

                }
            } else {
                if (size >= 3) {
                    if (lastThree == 2) {
                        curMaxLen = 2;
                    } else {
                        curMaxLen = 1;
                    }
                } else {
                    if (size == 2 && lastOne == 2) {
                        curMaxLen = 1;
                    }
                }
            }

            maxLen = Math.max(maxLen, curMaxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        {
            String s = "eccdnmcnkl";

            Leetcode2981 leetcode2981 = new Leetcode2981();
            System.out.println(leetcode2981.maximumLength(s));
            System.out.println("=========================");
        }

        {
            String s = "aaaa";

            Leetcode2981 leetcode2981 = new Leetcode2981();
            System.out.println(leetcode2981.maximumLength(s));
            System.out.println("=========================");
        }

    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/solutions/2792836/zhao-chu-chu-xian-zhi-shao-san-ci-de-zui-pdem/
     */
    // 官方解法，一次遍历，很优秀
    public int maximumLength2(String s) {
        int n = s.length();
        int[][] cnt = new int[26][3];

        for (int i = 0, j = 0; i < s.length(); i = j) {
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int index = s.charAt(i) - 'a';
            int len = j - i;
            if (len > cnt[index][0]) {
                cnt[index][2] = cnt[index][1];
                cnt[index][1] = cnt[index][0];
                cnt[index][0] = len;
            } else if (len > cnt[index][1]) {
                cnt[index][2] = cnt[index][1];
                cnt[index][1] = len;
            } else if (len > cnt[index][2]) {
                cnt[index][2] = len;
            }
        }

        int res = 0;
        for (int[] vec : cnt) {
            res = Math.max(res, Math.max(vec[0] - 2, Math.min(vec[0] - 1, vec[1])));
            res = Math.max(res, vec[2]);
        }
        return res != 0 ? res : -1;
    }
}
