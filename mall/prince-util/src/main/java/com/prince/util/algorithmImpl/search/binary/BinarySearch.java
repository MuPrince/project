package com.prince.util.algorithmImpl.search.binary;


/**
 * @description: 说明：元素必须是有序的，如果是无序的则要先进行排序操作。  　　
 *              基本思想：也称为是折半查找，属于有序查找算法。用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，若相等则查找成功；
 *                      若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，这样递归进行，直到查找到或查找结束发现表中没有这样的结点。  　　
 *              复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；  　　
*               注：折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。
 *                 但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
 *                                                                                  ——《大话数据结构》
 * @author Prince
 * @time 2020/9/25 13:53
 */
public class BinarySearch {

   /**
    * @description: 基础二分查找模板方法
    * @param numbers
    * @param target
    * @return int
    * @author Prince
    * @date 2020/9/25 16:23
    */
    public int base(int[] numbers, int target){
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        if(numbers[start] == target){
            return start;
        }
        if(numbers[end] == target){
            return end;
        }
        return -1;
    }

    /**
     * @description : 在旋转有序的数组中查找
     * @param numbers
     * @param target
     * @return int
     * @author Prince
     * @date 2020/9/25 16:06
     */
    public int  searchInRotatedSortedArray(int[] numbers, int target){
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) /2;
            if(numbers[mid] == target){
                return mid;
            }
            if(numbers[mid] > numbers[start]){
                if(target <= numbers[mid] && numbers[start] <= target){
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                if(target >= numbers[mid] && target <= numbers[end]){
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }
        if(numbers[start] == target){
            return start;
        }
        if(numbers[end] == target){
            return end;
        }
        return -1;
    }

    /**
     * @description : 在旋转的有序数组中找最小值
     * @param numbers
     * @return int
     * @author Prince
     * @date 2020/9/25 17:22
     */
    public int findMinimumInRotatedSortedArray(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (numbers[mid] >= numbers[start]){
                if(numbers[end] <= numbers[mid]){
                    start = mid;
                }else {
                    end = mid;
                }
            }else {
                end = mid;
            }
        }
        return Math.min(numbers[start],numbers[end]);
    }

    /**
     * @description : 查找峰值元素
     * @param  numbers
     * @return int
     * @author Prince
     * @date 2020/9/25 17:32
     */
    public int findPeakElement(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(numbers[mid] < numbers[mid - 1]){
                end = mid;
            }else if(numbers[mid] < numbers[mid + 1]){
                start = mid;
            }else {
                return mid;
            }
        }
        return numbers[start] > numbers[end] ? start : end;
    }

    /**
     * @description : Given n pieces of wood with length L[i](integer array). Cut them into small pieces to guarantee
     *                you could have equal or more than k pieces with the same length.What is the longest length you can get
     *                from the n pieces of wood?Given L&k,return the maximum length of the small pieces.
     * @param
     * @return int
     * @author Prince
     * @date 2020/9/25 17:48
     */
    public int woodCut(int[] L, int k){
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            int pieces = getPieces(L,mid);
            if (pieces >= k){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (getPieces(L,end) >= k){
            return end;
        }
        if(getPieces(L,start) >= k){
            return start;
        }
        return 0;
    }

    private int getPieces(int[] L, int woodLength) {
        int pieces = 0;
        for (int wood : L) {
            pieces += wood / woodLength;
        }
        return pieces;
    }

    private int getMax(int[] L) {
        int max = L[0];
        for (int i = 0; i < L.length; i++) {
            if (max < L[i]){
                max = L[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        int[] numbers = {4,5,6,7,0,1,2,3};
//        int[] numbers = {4,5,6,3,4,3,0,1,4,3};
//        System.out.println(new BinarySearch().findPeakElement(numbers));
        int[] L = {232,124,456};
        System.out.println(new BinarySearch().woodCut(L,7));
    }
}
