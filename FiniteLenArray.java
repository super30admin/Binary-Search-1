/*
// Time Complexity : logN
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

Steps: 
-used binary search for this approach
    1) check for pre-conditions like null and length
    2) verification of element if exists in the middle.
    3) verified if element exists on the left / right part of array
    4) toggled positions of high and low appropiately to narrow down index of target.
*/

class FiniteLenArray {
    public int search(int[] nums, int target) {
     
        if(nums== null || nums.length==0 ){return -1;}
        int low =0;
        int high = nums.length-1;
        
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){return mid;}
            if(nums[low] <=nums[mid]){
                //right sorted ?
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid -1;
                }
                else {
                    low = mid +1;
                }
            }
            else {
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
                
            }
        }
        return -1;
     
    }

    public static void main(String args[]){
        int [] nums = {4,5,6,7,0,1,2};
        FiniteLenArray fin = new FiniteLenArray();
        System.out.println(fin.search(nums, 4));
    }

}