/*
*  */
import java.util.Arrays;

public class RotatedArray {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end){
                int mid = (start + end) / 2;
                if (nums[mid] == target)
                    return mid;

                if (nums[start] <= nums[mid]){
                    if (target < nums[mid] && target >= nums[start])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }

                if (nums[mid] <= nums[end]){
                    if (target > nums[mid] && target <= nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            RotatedArray rotatedArray = new RotatedArray();

            int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
            int target1 = 0;
            int expectedIndex1 = 4;
            int actualIndex1 = rotatedArray.search(nums1, target1);
            System.out.println("Expected index for target " + target1 + " in array " + Arrays.toString(nums1) + " is " + expectedIndex1 + ". Actual index is " + actualIndex1 + ".");

            int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
            int target2 = 3;
            int expectedIndex2 = -1;
            int actualIndex2 = rotatedArray.search(nums2, target2);
            System.out.println("Expected index for target " + target2 + " in array " + Arrays.toString(nums2) + " is " + expectedIndex2 + ". Actual index is " + actualIndex2 + ".");
        }
    }


