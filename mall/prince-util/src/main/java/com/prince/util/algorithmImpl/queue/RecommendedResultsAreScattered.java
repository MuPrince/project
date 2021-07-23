package com.prince.util.algorithmImpl.queue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Prince
 * @description: 推荐结果打散
 * @time 2020/9/23 17:16
 */
public class RecommendedResultsAreScattered {
    public List<String> getRecommendedResult(List<String> list, int maxInterval) {
        List<String> result = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return result;
        }
        Queue<String> main = new LinkedList<>();
        Queue<String> other = new LinkedList<>();
        boolean otherFirst = false;
        int index = 0;
        int count = list.size();
        while (!otherFirst && index < count) {
            if (isMain(list.get(index))) {
                result.add(index, list.get(index));
            } else {
                otherFirst = true;
            }
            index ++;
        }
        while (index < count) {
            if (isMain(list.get(index))) {
                main.add(list.get(index));
            } else {
                other.add(list.get(index));
            }
            index++;
        }
        int currentSize = result.size();
        while (!main.isEmpty() && !other.isEmpty()){
            if(currentSize >= maxInterval){
                result.add(other.poll());
                currentSize = 0;
            }else {
                result.add(main.poll());
                currentSize ++;
            }
        }
        while (!main.isEmpty()){
            result.add(main.poll());
        }
        if(currentSize >= maxInterval && !other.isEmpty()){
            result.add(other.poll());
        }
        return result;
    }

    private boolean isMain(String clip) {
        if (clip == null) {
            return false;
        }
        return clip.startsWith("m");
    }

    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("m1");
       list.add("m2");
       list.add("m3");
       list.add("o4");
       list.add("m5");
       list.add("m6");
       list.add("o7");
       list.add("o8");
       list.add("m9");
       list.add("o10");
       System.out.println(new RecommendedResultsAreScattered().getRecommendedResult(list,2));
    }
}
