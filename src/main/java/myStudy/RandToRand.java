package myStudy;

public class RandToRand {

    public static void main(String[] args) {
        int count = 0;
        double x = 0.17;
        int testTime = 1000000;
        for(int i = 0; i < testTime; i++){
            if(xToXPower2() < x){
                count++;
            }
        }
        System.out.println((double) count / (double) testTime);
        System.out.println(Math.pow(x, 2));


        count = 0;
        for (int i = 0; i < testTime; i++){
            if(f2() == 0){
                count++;
            }
        }
        System.out.println(count);
        System.out.println((double) count / (double) testTime);


        int[] count1 = new int[8];
        for(int i = 0; i < testTime; i++){
            count1[g()]++;
        }
        for (int i = 0; i < count1.length; i++){
            System.out.println(i + "这个数，出现了" + count1[i] + "次");
        }
    }

    /**
     * 返回【0,1)的一个小数，任意的x，x属于【0,1),[0,,x)范围上的数出现概率由原来的x调整为x平方
     * @return
     */
    public static double xToXPower2(){
        return Math.max(Math.random(), Math.random());
    }




    public static int f(){
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制，只能用f1，等概率返回0和1
     * @return
     */
    public static int f2(){
        int ans = 0;
        do{
            ans = f();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 得到000 ~ 111 做到等概率 0 ~ 7 等概率返回一个
     * @return
     */
    public static int f3(){
        int ans = (f2() << 2) + (f2() << 1) + (f2());
        return ans;
    }

    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans == 7);

        return ans;
    }

    /**
     * 等概率得到1-7
     * @return
     */
    public static int g(){
        return f4() + 1;
    }

    /**
     * 你只知道，x会以固定概率返回0和1，但是x的内容，你看不到
     * @return
     */
    public static int x(){
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y(){
        int ans = 0;
        do {
            ans = x();
        }while (ans == x());
        return ans;
    }



}
