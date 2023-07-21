import java.util.Arrays;
import java.util.Scanner;

/***
 Problem 2: Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 ***/
public class Problem_2 {
    public int search(ArrayReader reader, int target) {
        //null check
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}


//class ArrayReader {
//    public static void main(String[] args) {
//
//        int[] res = readArray();
//        System.out.println(Arrays.toString(res));
//
//    }
//
//    static int[] readArray() {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Please enter the array's size: ");
//        int leng = scan.nextInt();
//        int[] array1 = new int[leng];
//        System.out.print("Please enter" + leng + "elements through space: ");
//        for (int i = 0; i<leng; i++){
//            array1[i] = scan.nextInt();
//        }
//        return array1;
//    }
//
//    public boolean get(int l) {
//        return true;
//    }
//}
