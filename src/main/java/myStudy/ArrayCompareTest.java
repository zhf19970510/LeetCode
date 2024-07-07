package myStudy;

import java.util.*;

public class ArrayCompareTest {

    public void compareArray(List<Integer> origin, List<Integer> newArr) {
        if (newArr == null || newArr.size() == 0) {
            newArr.addAll(origin);
            return;
        }

        Map<Integer, Integer> map = new HashMap<>(newArr.size());
        for (int i = 0; i < newArr.size(); i++) {
            map.put(newArr.get(i), i);
        }

        List<Integer> newList = new LinkedList<>(newArr);
        Set<Integer> removeIndex = new HashSet<>();
        for (Integer integer : origin) {
            if (map.containsKey(integer)) {
                Integer index = map.get(integer);
                removeIndex.add(index);
            } else {
                newList.add(integer);
            }
        }
        for (int i = newArr.size() - 1; i >= 0; i--) {
            if (removeIndex.contains(i)) {
                newList.remove(i);
            }
        }

        newArr.clear();
        for (Integer integer : newList) {
            newArr.add(integer);
        }

    }

    public void compareArrayByDoubleCircle(List<Integer> origin, List<Integer> newArr) {
        if (newArr == null || newArr.size() == 0) {
            newArr.addAll(origin);
            return;
        }
        List<Integer> extraList = new LinkedList<>(newArr);

        for (Integer i : origin) {
            boolean flag = false;
            for (Integer j : newArr) {
                if (i.equals(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                extraList.add(i);
            } else {
                extraList.remove(i);
            }
        }

        newArr.clear();
        for (Integer integer : extraList) {
            newArr.add(integer);
        }
    }

    public static void main(String[] args) {
        {
            List<Integer> origin = Arrays.asList(1, 7, 2, 8, 9, 3, 6);
            List<Integer> newArr = new ArrayList<>();
            newArr.add(1);
            newArr.add(2);
            newArr.add(4);
            newArr = Arrays.asList(1, 2, 4);
            ArrayCompareTest arrayCompareTest = new ArrayCompareTest();
            arrayCompareTest.compareArray(origin, newArr);
            System.out.println(newArr);
        }
//
//        System.out.println("==============");
//        {
//            List<Integer> origin = Arrays.asList(1, 7, 2, 8, 9, 3, 6);
//            List<Integer> newArr = new ArrayList<>();
//            newArr.add(1);
//            newArr.add(2);
//            newArr.add(4);
//            ArrayCompareTest arrayCompareTest = new ArrayCompareTest();
//            arrayCompareTest.compareArrayByDoubleCircle(origin, newArr);
//            System.out.println(newArr);
//        }


        System.out.println("性能测试开始。。。。。。");
        {
            ArrayCompareTest arrayCompareTest = new ArrayCompareTest();
            List<Integer> originArr = arrayCompareTest.generateOriginArr();
            List<Integer> newArr = arrayCompareTest.generateNewArr();
            List<Integer> originArr1 = arrayCompareTest.copyList(originArr);
            List<Integer> newArr1 = arrayCompareTest.copyList(newArr);

            long start1 = System.currentTimeMillis();
            arrayCompareTest.compareArray(originArr1, newArr1);
            long end1 = System.currentTimeMillis();
            System.out.println("====== compareArray 执行时间为： ======");
            System.out.println((end1 - start1) + "ms");

            long start = System.currentTimeMillis();
            arrayCompareTest.compareArrayByDoubleCircle(originArr, newArr);
            long end = System.currentTimeMillis();
            System.out.println("====== compareArrayByDoubleCircle 执行时间为： ======");
            System.out.println((end - start) + "ms");


            System.out.println("两个方法执行结束。。。");
            if (newArr.size() != newArr1.size()) {
                System.out.println("两方法执行结果不一致。。");
                System.out.println("size1 = " + newArr.size());
                System.out.println("size2 = " + newArr1.size());
            }

            int size = newArr.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Integer arrNum1 = newArr.get(i);
                Integer arrNum2 = newArr1.get(i);
                if (!arrNum1.equals(arrNum2)) {
                    System.out.println("两方法执行结果不一致。。。");
                    System.out.println("index = " + i);
                    System.out.println("arrNum1 = " + arrNum1);
                    System.out.println("arrNum2 = " + arrNum2);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("两方法执行结果一致。。。");
            }


        }
    }

    public List<Integer> copyList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list.size());
        for (Integer integer : list) {
            newList.add(integer);
        }
        return newList;
    }

    public List<Integer> generateOriginArr() {
        int totalNumber = 100000;

        Set<Integer> set = new HashSet<>(totalNumber);
        Random random = new Random();
        for (int i = 0; i < totalNumber; i++) {
            int now = random.nextInt(Integer.MAX_VALUE);
            while (set.contains(now)) {
                now = random.nextInt(Integer.MAX_VALUE);
            }
            set.add(now);
        }
        return new ArrayList<>(set);
    }

    public List<Integer> generateNewArr() {
        int totalNumber = 10000;

        Set<Integer> set = new HashSet<>(totalNumber);
        Random random = new Random();
        for (int i = 0; i < totalNumber; i++) {
            int now = random.nextInt(Integer.MAX_VALUE);
            while (set.contains(now)) {
                now = random.nextInt(Integer.MAX_VALUE);
            }
            set.add(now);
        }
        return new ArrayList<>(set);
    }


}
