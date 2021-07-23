package com.prince.util.algorithmImpl.stack;


import java.util.Stack;

/**
 * @description: 区间最大值
 *               取最大的 任意区间的和乘以该区间中最小值的积
 * @author Prince
 * @time 2020/9/23 15:32
 */
public class MaximumRange {
    public int getMax(int[] numbers){
        if (numbers == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] sum = new int[numbers.length + 1];
        for (int i = 1; i < numbers.length; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]){
                int index = stack.pop();
                int left = i;
                int right = i;
                if(stack.isEmpty()){
                    left = 0;
                }else {
                    left = index;
                }
                max = Math.max(max,numbers[index] * (sum[right] - sum[left]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int left = 0;
            int right = numbers.length;
            if(stack.isEmpty()){
                left = 0;
            }else {
                left = index;
            }
            max = Math.max(max,numbers[index] * (sum[right] - sum[left]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 4, 1};
        System.out.println(new MaximumRange().getMax(numbers));
    }
}
