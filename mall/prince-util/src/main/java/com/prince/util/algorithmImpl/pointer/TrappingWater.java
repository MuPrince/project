package com.prince.util.algorithmImpl.pointer;


/**
 * @description: 双指针计算存水问题
 *              https://leetcode-cn.com/problems/trapping-rain-water/
 * @author Prince
 * @time 2020/9/23 9:41
 */
public class TrappingWater {
    public int trap(int[] height){
        if(height == null || height.length < 3){
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left < right){
            if(leftHeight < rightHeight) {
                if (leftHeight > height[left + 1]) {
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left ++;
            }else {
                if(rightHeight > height[right -1]){
                    sum += rightHeight - height[right -1];
                } else {
                    rightHeight = height[right -1];
                }
                right --;
            }
        }

        return sum;
    }
}
