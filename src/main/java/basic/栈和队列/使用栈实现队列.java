package basic.栈和队列;

import java.util.Stack;

public class 使用栈实现队列 {

    public Stack<Integer> pushStack = new Stack<>();

    public Stack<Integer> popStack = new Stack<>();

    public int size;

    public Integer poll() throws Exception {
        if(popStack.isEmpty()) {
            pourEle();
        }
        if(popStack.isEmpty()) {
            throw new Exception("队列中元素为空，没有元素可以获取。");
        }
        size--;
        return popStack.pop();
    }

    public void offer(Integer ele) {
        size++;
        pushStack.push(ele);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer size() {
        return size;
    }

    public Integer peek() throws Exception {
        if(popStack.isEmpty()) {
            pourEle();
        }
        if(popStack.isEmpty()) {
            throw new Exception("队列为空！");
        }
        return popStack.peek();
    }

    public void pourEle() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
