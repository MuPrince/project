package com.prince.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 约瑟夫问题(约瑟夫环;约瑟夫置换)
 *
 * @author Prince
 * @time 2020/9/16 16:02
 */
public class JosephProblem<T> {
    private List<T> list;

    public JosephProblem(List<T> list) {
        this.list = new LinkedList<>(list);
    }

    public T get(int number){
        int index = 1;
        while(true) {
            int count = list.size();
            int time = 0;
            for (int i = 0; i < count; i++) {
                if((index % number) == 0){
                    list.remove(i - time);
                    time ++;
                }
                index ++;
            }
            if(list.size() == 1){
                break;
            }
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        long start = System.currentTimeMillis();
        JosephProblem<Integer> integerJosephProblem = new JosephProblem<>(integers);
        Integer integer = integerJosephProblem.get(5);
        long end = System.currentTimeMillis();
        System.out.println(integer);
        System.out.println("耗时:" + (end - start));
    }
}
