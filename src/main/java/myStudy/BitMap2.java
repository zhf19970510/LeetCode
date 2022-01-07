package myStudy;

import java.util.HashSet;

/**
 * BitMap 位图实现
 */
public class BitMap2 {

    public static class BitMap{
        private long [] bits;

        public BitMap(int max){
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num){
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num){
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num){
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }


    public static void main(String[] args) {
        System.out.println("开始测试！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 1000000;
        for(int i = 0; i < testTime; i++){
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if(decide < 0.333){
                bitMap.add(num);
                set.add(num);
            }else if(decide < 0.666){
                bitMap.delete(num);
                set.remove(num);
            }else {
                if(bitMap.contains(num) != set.contains(num)){
                    System.out.println("Oops!");
                    break;
                }
            }
        }



    }

    public static void testBitMap(BitMap bitMap){
        System.out.println("223: " + bitMap.contains(223));
        System.out.println("222: " + bitMap.contains(222));
        System.out.println("244: " + bitMap.contains(244));
        System.out.println("221: " + bitMap.contains(221));
        System.out.println("224: " + bitMap.contains(224));
        System.out.println("888: " + bitMap.contains(888));
        System.out.println("887: " + bitMap.contains(887));
        System.out.println("889: " + bitMap.contains(889));
        System.out.println("555: " + bitMap.contains(555));
    }
}
