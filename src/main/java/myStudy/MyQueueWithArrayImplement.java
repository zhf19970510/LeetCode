package myStudy;

public class MyQueueWithArrayImplement {

    private int[] arr;
    private int pushi;
    private int polli;
    private int size;
    private final int limit;

    public MyQueueWithArrayImplement(int limit) {
        arr = new int[limit];
        pushi = 0;
        polli = 0;
        size = 0;
        this.limit = limit;
    }

    public void push(int value) {
        if(size == limit) {
            throw new RuntimeException("队列满了，不能再加了");
        }
        size++;
        arr[pushi] = value;
        pushi = nextIndex(pushi);
    }

    public int pop() {
        if(size == 0) {
            throw new RuntimeException("队列空了，不能再拿了");
        }
        size--;
        int ans = arr[polli];
        polli = nextIndex(polli);
        return ans;
    }

    private int nextIndex(int i) {
        return i >= limit - 1 ? 0 : i + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
