package com.prince.util.algorithmImpl.pointer;


import java.util.Arrays;

/**
 * @author Prince
 * @description : 验证三角形
 * @time 2020/9/27 16:02
 */
public class ValidTriangleNumber {

    public int valid(int[] numbers){
        if (numbers == null || numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);
        int total = 0;
        for (int i = numbers.length - 1; i >= 2; i --) {
            int first = 0;
            int second = i - 1;
            while (first < second){
                if(numbers[first] + numbers[second] > numbers[i]){
                    total += (second - first);
                    second --;
                } else {
                    first ++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] numbers = {2,2,3,4};
        System.out.println(new ValidTriangleNumber().valid(numbers));
    }
}
