//LC 33 Rotated Sorted Array
//We use the fact that no matter where your middle is, at least one half will be sorted always [Both the dised can also be sorted]
// first of all check if middle is the target
// NEXT, we check which side is sorted and if the target lies in that range and eliminate the other half
// We change the pointers such that the desired side is traversed 

//Time Complexity - O(log n)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if(nums[low]<=nums[mid]){ //to check left side is sorted <= as there could be only 1 element, Low= Mid in that case
                if((nums[low]<=target)&&(target<nums[mid])){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            else 
                if(nums[mid]<=nums[high]){
                    if ((nums[mid]<target)&&(target<=nums[high])){
                        low = mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
        }
        return -1;
    }
}