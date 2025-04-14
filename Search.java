import java.lang.reflect.Array;

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

        class Solution {
            public int search(int[] nums, int target) {

                int start = 0;
                int end = nums.length - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (nums[mid] == target) {
                        return mid;
                    }
                    if (nums[start] <= nums[mid]){
                        if (nums[start] <= target && target < nums[mid]){
                            end = mid - 1;
                        }
                        else{
                            start = mid + 1;
                        }
                    }
                    else{
                        if (nums[mid] < target && target <= nums[end]){
                            start = mid + 1;
                        }
                        else{
                            end = mid -1;
                        }
                    }
                }
                return -1;
            }


            // Approach: 1
            //return binarySearch(nums, 0, nums.length - 1, target);

        /* private  int binarySearch(int arr[], int l, int r, int x)
        {
            if (x > arr[l]){
                for (int i = 0; i <= r; i++){
                if (arr[i] == x){
                    return i;
                }
            }
        }
        else{
            for (int i = r; i >=0 ; i--){
                if (arr[i] == x){
                    return i;
                }
            }
        }

        return -1;
    }*/

    public static void main(String [] args) {
        int [] nums = {3,1};
        Solution obj = new Solution();
        System.out.println(obj.search(nums, 1));

    }
}