package chapter02;

import java.util.*;

/**
 * @ClassName SelectionSort 选择排序
 * @Author cuizhigang
 * @Date 2020/10/30 15:02
 * @Description SelectionSort
 * @Version 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        ArrayList<Integer> sourceList = new ArrayList<>(Arrays.asList(1, 1, 3, 5, 5, 2, 4, 6));
        List<Integer> sortedList = sort.selectionSort(sourceList);
        System.out.println(sortedList);
    }

    /**
     * 选择排序 时间复杂度 O(n²)
     * @param sourceList
     * @return
     */
    private List<Integer> selectionSort(ArrayList<Integer> sourceList) {
        int size = sourceList.size();
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int smallestIndex = getSmallestIndex(sourceList);
            Integer smallestValue = sourceList.remove(smallestIndex);
            sortedList.add(smallestValue);
        }
        return sortedList;
    }

    /**
     * 获取最小值的下标
     * @param list
     * @return
     */
    private int getSmallestIndex(List<Integer> list) {
        int smallestIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(smallestIndex)) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

}
