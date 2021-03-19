/**Leetcode Question 33 - Search in Rotated Search Array */

public class SortedArraySearch {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int h = nums.length -1;
            int mid;
            /*if(nums.length == 0 || nums == null){
                return -1;
            }*/
            while(l <= h){
                mid = l + (h -l)/2;
                if(nums[mid] == target){
                    return mid;
                }
                
                if(nums[l] <= nums[mid]){
                    if(nums[l]<=target && nums[mid] > target){
                        h = mid-1;
                    }
                    else{
                        l =mid +1;
                    }
                }
                
                else{
                    if(nums[mid]<target && nums[h] >= target){
                        l =mid+ 1;
                    }
                    else{
                        h = mid -1;
                    }
                }
            }
            return -1;
        }
    }
    
}
