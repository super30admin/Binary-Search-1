class Solution {
    public int search(int[] nums, int target) {
        
        
        int first=0;int last=nums.length-1;
        while(first<=last){
        int mid=first+(last-first)/2;
        if(target==nums[mid])return mid;
            //left array sorted
        else if(nums[first]<=nums[mid]){
            //exist in left sort array
            if(target<nums[mid] &&nums[first]<=target)
                last=mid-1;
            //doesnt exist in left sort array  
            else first=mid+1;    
        }
            //right sorted
           else {
               if(nums[mid]<=nums[last]){
               if(target>nums[mid]&&target<=nums[last])
                   first=mid+1;
                else
                    last=mid-1;}
        
        }
        }  
        return -1;
    }
}
