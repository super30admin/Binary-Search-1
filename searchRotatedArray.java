// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.*;

class searchRotatedArray {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;

        while(start <= end)
        {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] <= nums[mid]) { // first sorted part
                //Target is in the range of sorted array
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                }
                //Target in not in range of sorted array
                else {
                    start = mid+1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[mid]) {
                    start = mid+1;
                }
                else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String arg[]){
        int numbers[] = {4,5,6,0,1,2};
        int result;
        result = search(numbers, 2);
        if(result >= 0)
        {
            System.out.println("element found at index " + result);
        }
        else{
            System.out.println("element not found " + result);
        }
    }

}
