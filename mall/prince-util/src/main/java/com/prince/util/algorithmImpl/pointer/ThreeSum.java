package com.prince.util.algorithmImpl.pointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description :
 * @author Prince
 * @time 2020/9/27 14:49
 */
public class ThreeSum {
    public List<List<Integer>> getSum(int[] numbers, int target){
        if (numbers == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if(i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            int first = i + 1;
            int second = numbers.length - 1;
            while (first < second) {
                if (numbers[i] + numbers[first] + numbers[second] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[first]);
                    list.add(numbers[second]);
                    result.add(list);
                    first ++;
                    second --;
                    while (first < second && numbers[first] == numbers[first - 1]){
                        first ++;
                    }
                    while (first < second && numbers[second] == numbers[second + 1]){
                        second --;
                    }
                } else if (numbers[i] + numbers[first] + numbers[second] < target){
                    first ++;
                }else {
                    second --;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().getSum(nums, 0));
    }
}
