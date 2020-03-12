// Time Complexity : Log n because i am doing binary search for find elemnet once i get the rotating index
// Space Complexity : O(1)- Since the search is in place
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Finding a rotating index


// Your code here along with comments explaining your approach

class RotatingIndexSearch {
    private  int[] nums;
    private int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if(nums.length==0)
            return -1;
        if(nums.length ==1)
            return nums[0] == target ? 0:-1;
        int rotatingIndex = findRotatingIndex(0,nums.length-1);
        
        // Smallest number is the target
        if(nums[rotatingIndex]==target)
            return rotatingIndex;
        // If the array is not rotated
        if(rotatingIndex==0)
            return binarySearch(0,nums.length-1);
        else if(target <nums[0])
            return binarySearch(rotatingIndex,nums.length-1);
        else
            return binarySearch(0,rotatingIndex);
            
         
    }
    private int binarySearch(int left , int right)
    {
        if(l>r)
        return -1;
    int m = (l+r)/2;
    if(nums[m]==target)
        return m;
    else if(nums[m]>target)
        return binarySearch(l,m-1);
    else
        return binarySearch(m+1,r);
    
        
    }
    
    private int findRotatingIndex(int l,int r)
    {
        // list already sorted
        if(nums[l]<nums[r])
            return 0;
        while(l<=r)
        {
            int p = (l+r)/2;
            if(nums[p]>nums[p+1])
                return p+1;
            else
            {
                if(nums[p]<nums[l])
                    r=p-1;
                else
                    l=p+1;
            }
        }
        return 0;
    }
    
    
}