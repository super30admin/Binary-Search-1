class Solution {
    public int search(int[] nums, int target) {
        
        int pivot = (nums.length+1)/2;

        if(target>= nums[pivot-1])
        {
            for(int i=0;i<pivot;i++)
            {
                System.out.println(nums[i]); 
                if(target==nums[i])
                {
                    return i;
                    
                }
                
            }
            
        }
        else
        {
              for(int j=pivot;j<nums.length;j++)
            {
               System.out.println(nums[j]); 
                if(target==nums[j])
                {
                    return j;
                    
                }
               
            }
             
            
        }
        
       return -1; 
    }
}