// Time Complexity: log(n)
// Space Complexity: log(n)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: No

/**
 * SortedArrayInfinite
 */
public class SortedArrayInfinite {

    int sortArray(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        // Increasing end pointer by 2 times
        while (reader.get(end) < target) {
            start = end;
            end = 2 * end;
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid)] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -10, -7, -2, 0, 1, 3, 4, 5, 6, 8 };
        int target = 5;
        SortedArrayInfinite st = new SortedArrayInfinite();
        System.out.println(st.sortArray(arr, target));
    }

}