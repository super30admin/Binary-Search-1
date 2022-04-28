//time complexity: O(logn)
//space complexity O(1)
//leetcode: yes
//problems: no, had to run few times for = conditions.
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        int left = 0, right = length -1;
        int pivotElement = -1, pivotIndex = -1;
        while (left <= right) {
            pivotIndex = left + (right - left)/2;
            if (nums[pivotIndex] ==target) {
                return pivotIndex;
            }
            if (nums[left] <= nums[pivotIndex]) {
                //now we know this part of the array is sorted and not rotated
                //now check where is the target to left side or to right side
                if (nums[left] <= target && target < nums[pivotIndex]) {
                    right = pivotIndex -1;
                } else {
                    //elemtn can be in the non sorted part of the array
                    left = pivotIndex + 1;
                }
            } else {
                //this means its the 2nd half of the array is rotated.
                //now check if it is in the left or the right
                if (nums[right] >= target && target > nums[pivotIndex]) {
                    left = pivotIndex +1;
                } else {
                    right = pivotIndex -1;
                }
            }
        }//end of while
        return -1;
    }
}

