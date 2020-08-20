class TargetRotatedSortedArray 
{
    int right;
    int left;
    int mid;
    public int search(int[] nums, int target) 
    { 
     int first=0;
     int last = nums.length-1;
        
     while(first<last)
     {
      mid=first+(last-first)/2;
      if(nums[mid]>nums[last])
          first=mid+1;
      else
          last=mid;
     }   
        
     if(target>=nums[first]&&target<=nums[nums.length-1])
     {
         left = first;
         right=nums.length-1;
     }
     else
     {
     left=0;
     right=first-1;    
     }
        
     while(left<=right)
     {
     mid=left+(right-left)/2;
     if(nums[mid]==target) 
         return mid;
     else if(target>nums[mid])
         left=mid+1;
     else
         right=mid-1;
     }
        return -1;        

        
    }
    
}