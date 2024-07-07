package basic.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 使用队列实现栈 {

    private Queue<Integer> qa = new LinkedList<>();
    private Queue<Integer> qb = new LinkedList<>();

    private int size;

    public Integer pop() throws Exception {
        if(size == 0) {
            throw new Exception("当前栈为空，无法获取元素");
        }

        if(size == 1) {
            size--;
            if(!qa.isEmpty()) {
                return qa.poll();
            }
            if(!qb.isEmpty()) {
                return qb.poll();
            }
        }

        // 保证qa永远是有元素的那个
        if(qa.isEmpty()) {
            swapQueue();
        }

        int count = 0;
        while (count < size - 1) {
            qb.add(qa.poll());
            count++;
        }
        size--;
        return qa.poll();
    }

    public void push(Integer ele) {
        if(size == 0) {
            qa.add(ele);
            size++;
            return;
        }
        if(qa.isEmpty()) {
            swapQueue();
        }
        qa.add(ele);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Integer peek() throws Exception{
        if(size == 0) {
            throw new Exception("栈中元素为空");
        }

        if(size == 1) {
            if(!qa.isEmpty()) {
                return qa.peek();
            }

            if(!qb.isEmpty()) {
                return qb.peek();
            }
        }

        int result = 0;
        if(qa.isEmpty()) {
            while (!qb.isEmpty()) {
                result = qb.poll();
                qa.add(result);
            }
        }

        if(qb.isEmpty()) {
            while (!qa.isEmpty()) {
                result = qa.poll();
                qb.add(result);
            }
        }

        return result;
    }

    private void swapQueue() {
        Queue<Integer> tmp = qa;
        qa = qb;
        qb = tmp;
    }

    public static void main(String[] args) throws Exception{
        使用队列实现栈 t1 = new 使用队列实现栈();
        t1.push(1);
        t1.push(2);
        t1.push(3);
        t1.push(4);
        t1.push(5);

        System.out.println(t1.pop());
        System.out.println(t1.pop());
        System.out.println(t1.pop());
        System.out.println(t1.peek());
        t1.push(10);
        System.out.println(t1.pop());
        System.out.println(t1.pop());

    }
}
