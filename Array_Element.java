// Time Complexity : O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

public class Main {

    public static void main(String[] args) {

        int[] numsArray = {1, 2, 3, 4, 5, 6, 7, 25, 75, 13}; // intializing the array of unknown length
        System.out.println(search(numsArray,71));      // returns -1
        System.out.println(search(numsArray,25));      // returns 7
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = 1;
        while(target >= nums[high]){
            low = high;
            high = high * 2;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] == target){
                return mid;
            }else{
                low = mid + 1;
            }
        }
        return -1;          // return -1 if the element is not found
    }
}
