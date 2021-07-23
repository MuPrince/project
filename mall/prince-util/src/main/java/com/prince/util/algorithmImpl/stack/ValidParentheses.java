package com.prince.util.algorithmImpl.stack;


import java.util.Stack;

/**
 * @description: 括号验证
 *              https://leetcode-cn.com/problems/valid-parentheses/
 * @author Prince
 * @time 2020/9/23 14:42
 */
public class ValidParentheses {
    public boolean isValid(String parentheses){
        if (parentheses == null || parentheses.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : parentheses.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
            if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
