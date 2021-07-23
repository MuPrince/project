package com.prince.util.algorithmImpl.stack;


import java.util.Stack;

/**
 * @description: 最小栈
 *              取栈中最小的值
 *              https://leetcode-cn.com/problems/min-stack/
 * @author Prince
 * @time 2020/9/23 15:23
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
