class Solution {
    int mid,midd,l,r;
    public int search(int[] nums, int target) {
        
        l=0;
        r=nums.length-1;
      
        if(nums.length==1)
        {
            if(nums[0]==target)
            {
                return 0;  
            }
            return -1;
        }
        
        while(l<=r)
        {
            mid=(l+r)/2;
            if(nums[mid] == target){
                return mid;
            } 
            if(nums[mid]>=nums[l])
            {
                if(target<=nums[mid]&&target>=nums[l])
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            else
            {
                if(target>=nums[mid]&&target<=nums[r])
                {
                    l=mid+1;
                    
                }else
                {
                    r=mid-1;
                }
            }
            
        }
        return -1;
    }
}
