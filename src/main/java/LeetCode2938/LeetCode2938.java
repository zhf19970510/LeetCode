package LeetCode2938;

public class LeetCode2938 {
    public long minimumSteps(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length - 1;
        int step = 0;
        while (left < right) {
            while (chs[left] == '0' && left < right) {
                left++;
            }
            while (chs[right] == '1' && left < right) {
                right--;
            }
            if(left < right) {
                swap(chs, left, right);
                step++;
            }
            left++;
            right--;
        }
        return step;
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
