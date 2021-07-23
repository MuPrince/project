package com.prince.util.algorithmImpl.queue;


import java.util.Stack;

/**
 * @description: 用栈实现队列
 *
 * @author Prince
 * @time 2020/9/23 17:04
 */
public class QueueByStack {
    private Stack<Integer> in;
    private Stack<Integer> out;
    /** Initialize your data structure here. */
    public QueueByStack() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()){
            return -1;
        }
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()){
            return -1;
        }
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
