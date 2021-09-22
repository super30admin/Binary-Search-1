class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[low]<=nums[mid]){ //left sorted part
                if(target>=nums[low] &&target<nums[mid])
                {
                    high=mid-1;
                }else
                {
                    low=mid+1;
                }
            }
            //right side is sorted
            else{
                if(target<=nums[high] &&target>nums[mid]){
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}

//time complexity : O(logn)
//space :O(1)
//ran onleetcode
//solved after class so was easy to solve it
