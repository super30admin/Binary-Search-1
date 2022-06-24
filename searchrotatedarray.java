// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums==null || nums.length==0){
            return -1;
        }
        
        int high=nums.length-1;
        int low=0;
        
        while(low <= high){
            int mid=low+ (high-low) / 2; //to avoid int overflow
            
            if(nums[mid]==target){
                return mid;
            }
            
            if(nums[low]<=nums[mid]){
                if(target>= nums[low] && target < nums[mid] ){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target<=nums[high] && target > nums[mid] ){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
       return -1; 
    }
}

MY APPROACH:

1. Here main thing is we are doing binary search in first if we will find mid and one part will be sorted another will be unsorted.
2. Each time we need to select array which is sorted by comparing low with mid if mid>=low we will get first part sorted so second part is unsorted vice versa now we can reach sorted part by first if else.
3. After reaching sorted part comparing seeing if element is between mid and high or low and mid whichever is sorted. We will understand if element is in range divide it more and do same.
4. If in unsorted part we will select it and divide that too and same procedure see in sorted part if element is there.
5. Takeaway --> we will always see if it lies in range of sorted array if not divide other part we will get sorted part in that too and we can see there and repeat process. 