class Solution
{
    public static int search(int[] nums, int target) {
    	 int n = nums.length;
        
        if(n==0)
            return -1;
        if(n==1)
           return nums[0] == target ? 0 : -1;
           
           // Find rotation
        int rotate_index = findRotateIndex(0,n-1,nums);
        
        if(nums[rotate_index]==target)
            return rotate_index;
            
            
        if(rotate_index == 0)
            return binSearch(nums,0,n-1,target);
            
            //note:  using(target> nums[0] can give wrong results as both sides can have target greater tahn nums)
        if (target <nums[0])
        return binSearch(nums,rotate_index, n - 1,target);
        // search in the left side
        return binSearch(nums,0, rotate_index,target);
            
     
}
    public static int binSearch(int[] nums, int left,int right,int target) {
        
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            
            if(nums[mid]==target)
            {
                return mid;
                
            }
            else if(target>nums[mid])
                left = mid+1;
            else
                right = mid-1;
            }
        return -1;
    }
    
    public static int findRotateIndex(int left, int right,int [] nums)
    {
        if(nums[left]<nums[right])
            return 0;
        
        while(left<=right)
        {
            int mid = (left+right)/2;
            
            //Found the leaset element or turning element [7,1]
            if(nums[mid]> nums[mid+1])
                return mid+1;
            else
            {
                if(nums[left]<=nums[mid]) //increasing order, smaller elements on the right
                //Also remeber the mid can be left index hence "=" sign!!
                    left = mid +1;
                else 
                    right = mid -1;
                    
                    
            }
       
        }
             return 0;
    }
    
    public static void main(String args[])
    {
    	int nums[] = {8,9,2,3,4};
    	int index = search(nums,9);
    	System.out.println(index);
    }
}
