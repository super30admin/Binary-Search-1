// Search in Rotated Sorted Array
// TC=O(log n)
// sc=O(n)
// it was solved in leet code

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int mid;
        if(nums.length==0)
            return -1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
             } else if(nums[low]<=nums[mid] ){//checking if left sorted{
                    if(nums[low]<=target && nums[mid]>target){
                        high=mid-1;
                    } else{
                        low=mid +1;
                    }

                }
            else {if (nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            
        }
    return -1;
        
        
    }
}