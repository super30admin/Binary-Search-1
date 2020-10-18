//Time complexity:O(n)
// sapce complexity:O(n)
// Issues faced during execution in leetcode:NO

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int[] arr=new int[2];
        int left=binarySearchLeft(nums,target);
        int right=binarySearchRight(nums,target);
        arr[0]=left;
        arr[1]=right;
        return arr;
    }
    public int binarySearchLeft(int[] nums,int target)
    {
        int lo=0;
        int hi=nums.length-1;
       
          while(lo<=hi)
        {
           int mid=lo+(hi-lo)/2;
            if(nums[mid]==target)
            {
                if(mid==lo||nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    hi=mid-1;
                }
            }
            else if(nums[mid]<target)
            {
                lo=mid+1;
            }
            else 
            {
                hi=mid-1;
            }
        }
        return -1;
    }
    public int binarySearchRight(int[] nums,int target)
    { 
        int lo=0;
        int hi=nums.length-1;
          while(lo<=hi)
        {
           int mid=lo+(hi-lo)/2;
            if(nums[mid]==target)
            {
                if(mid==hi||nums[mid]<nums[mid+1])
                {
                    return mid;
                }
                else
                {
                   lo= mid+1;
                }
            }
            else if(nums[mid]<target)
            {
                lo=mid+1;
            }
            else 
            {
                hi=mid-1;
            }
        }
        return -1;
    }
}
