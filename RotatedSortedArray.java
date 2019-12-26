// Time Complexity : O(logN)
// Space Complexity : O(1) in iterative method and O(logN) in recursive method
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int search(int[] nums, int target) {
        int result;
        int low=0, high=nums.length-1; /* Calculating the start and end point of the array */
        return searchBST(nums, target, low, high); /* helper function */
    }

    private int searchBST(int[] nums, int target, int low, int high){
        if(low>high){ /* Base case : Search element Not found */
            return -1;
        }
        while(low<=high){ /* Condition for the loop and to not make it infinite loop */
            int mid=low + (high-low)/2; /* mid element for Binary search */
            if(nums[mid]==target){
                return mid;
            }
            
            if(nums[low]<=nums[mid]){ /* Left Side sorted */
                if(target<nums[mid] && target>=nums[low]){ /* Case 1: Target in between low and mid-1 */
                    high=mid-1;
                }
                else{
                    low=mid+1; /* Means element not on left side. Go to right side */
                }
            }
            else{ /* Right Side sorted */
                if(target>nums[mid] && target<=nums[high]){ /* Case 2: Target in between mid+1 and high */
                    low=mid+1; /* Means element not on right side. Go to left side */
                }
                else{
                    high=mid-1; /* Go to left side */
                }
            }
            
        }
        return -1;
    }
}
