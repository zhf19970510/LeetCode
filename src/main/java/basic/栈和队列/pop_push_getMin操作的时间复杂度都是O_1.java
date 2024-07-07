package basic.栈和队列;

import java.util.Stack;

/**
 * 实现一个特殊的栈，该栈支持push、pop、getMin方法，别分别是放入一个元素，弹出一个元素，获取元素的最小值，并且时间复杂度都是O(1)
 */
public class pop_push_getMin操作的时间复杂度都是O_1 {


    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void pop() throws Exception {
        if(data.isEmpty()) {
            throw new Exception("栈已经空了，没有元素可以弹出了.");
        }
        data.pop();
        minStack.pop();
    }

    public void push(Integer ele) {
        if(data.isEmpty()) {
            minStack.push(ele);
        } else {
            if(ele.equals(minStack.peek())) {
                minStack.push(ele);
            } else {
                minStack.push(minStack.peek());
            }
        }
        data.push(ele);
    }

    public int getMin() throws Exception {
        if(minStack.isEmpty()) {
            throw new Exception("栈为空，不存在最小值.");
        }
        return minStack.peek();
    }
}
