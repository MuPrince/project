package com.prince.util.algorithmImpl.pointer;


import java.util.Arrays;

/**
 * @description : 数组中任意两个数相加等于给定值 target
 * @author Prince
 * @time 2020/9/27 13:22
 */
public class TwoSum {

    public int[] getSum(int[] numbers, int target){
        if (numbers == null) {
            return null;
        }
        int[] result = {-1,-1};
        int first = 0;
        int second = numbers.length - 1;
        while (first < second){
            if(numbers[first] + numbers[second] == target){
                result[0] = first;
                result[1] = second;
                break;
            } else if (numbers[first] + numbers[second] > target){
                second --;
            } else {
                first ++;
            }

        }
        return result;
    }

    public int getSumPair(int[] numbers, int target){
        if (numbers == null) {
            return 0;
        }
        int result = 0;
        int first = 0;
        int second = numbers.length - 1;
        while (first < second){
            if(numbers[first] + numbers[second] == target){
                result ++;
                first ++;
                second --;
            } else if (numbers[first] + numbers[second] > target){
                second --;
            } else {
                first ++;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,11,15,16,75};
        System.out.println(Arrays.toString(new TwoSum().getSum(numbers, 21)));

    }
}
