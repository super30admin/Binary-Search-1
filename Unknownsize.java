/*This implementation uses Binary Search
 * The time complexity of this implementation is the O(log(n)) where n index of target value
*/
public class Unknownsize {

    public static int searchSortedArray(int[] nums, int target) {
        int left = 0;
        int right = 1;
        while (true) {
            try {
                if (nums[right] < target) {
                    left = right;
                    right *= 2;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                right = left + (right - left) / 2 + 1;
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            try {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29};
        int target = 13;
        int index = searchSortedArray(nums, target);
        System.out.println(index);
    }

}
