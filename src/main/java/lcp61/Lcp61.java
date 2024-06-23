package lcp61;

public class Lcp61 {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res = 0;
        int current = 0;
        for(int i = 1; i < temperatureA.length; i++) {
            if(isSameTend(temperatureA[i - 1], temperatureA[i], temperatureB[i - 1], temperatureB[i])) {
                current++;
            } else {
                res = Math.max(res, current);
                current = 0;
            }
        }
        res = Math.max(res, current);
        return res;
    }

    public boolean isSameTend(int a1, int a2, int b1, int b2) {
        int t1 = a2 - a1;
        int t2 = b2 - b1;
        return (t1 > 0 && t2 > 0) || (t1 == 0 && t2 == 0) || (t1 < 0 && t2 < 0);
    }

    public static void main(String[] args) {
        Lcp61 lcp61 = new Lcp61();
        int[] temperatureA = new int[] {21,18,18,18,31};
        int[] temperatureB = new int[] {34,32,16,16,17};
        System.out.println(lcp61.temperatureTrend(temperatureA, temperatureB));
    }
}
