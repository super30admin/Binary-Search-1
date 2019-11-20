// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the logic was too difficult.


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {int mid= (start+end)/2;
            if(nums[mid]==target)
                return mid;
         //there are two conditions based on the value of the iddle element
                //searching in left half of the array i
             if(nums[mid]>=nums[start])
                {
                    if(target<nums[mid] && target>=nums[start])
                    end=mid-1;
                            else
                    start= mid+1;
                }
                
            else
                //// if middle element is smaller than the first element then that     means the sorted unrotated array is the right half
                //there will be two conditions,either the target lies in the sorted right half or the unsorted left half
            { if(target<=nums[end] && target>=nums[mid])
                    start=mid+1;
                            else
                        end=mid-1;
            }
            
        } 
         return -1;          
            }
    
}
