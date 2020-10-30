package chapter01;

/**
 * @ClassName BinarySearch
 * @Author cuizhigang
 * @Date 2020/10/30 11:13
 * @Description BinarySearch
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int target = 7;
        int low = 0;
        int high = array.length - 1;  // 6

        BinarySearch search = new BinarySearch();

        //int rtVal = search.binarySearch(array, target, low, high);
        int rtVal = search.simpleSearch(array, target);

        System.out.println(rtVal);
    }

    /**
     * 简单查找 时间复杂度 O(n)
     * @param array
     * @param targetValue
     * @return
     */
    private int simpleSearch(int[] array, int targetValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        throw new RuntimeException("没这个元素!");
    }

    /**
     * 二分查找 时间复杂度 O(log₂n) 从n个数里的找到1个数，每次查找总数都缩小一半，即 n / 2^p = 1 ->
     *                                                                       n = 2^p     ->
     *                                                                       p = log₂n
     * @param array
     * @param targetValue
     * @param lowIndex
     * @param highIndex
     * @return
     */
    private int binarySearch(int[] array, int targetValue, int lowIndex, int highIndex) {
        if (lowIndex < 0 || highIndex > array.length - 1 || lowIndex >= highIndex)
            throw new RuntimeException("没这个元素！");
        // 不整除向下取整
        int midIndex = (lowIndex + highIndex) / 2;
        if (array[midIndex] == targetValue)
            return midIndex;
        else if (array[midIndex] > targetValue)
            highIndex = midIndex - 1;
        else
            lowIndex = midIndex + 1;
        return binarySearch(array, targetValue, lowIndex, highIndex);
    }
}
