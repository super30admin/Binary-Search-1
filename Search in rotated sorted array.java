//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int l= 0; int h= nums.length-1;
        int res= BinarySearch(nums,l,h,target);
        return res;
    }
    public int BinarySearch(int[]nums, int l,int h, int target)
    {
        int mid= (l+h)/2; int res=-1;
        if(h>=l)
        {
            if(target==nums[mid])
            {
                res= mid;
            }
            else if(target<nums[mid] && target<nums[0])
            {
                l= mid+1;
                res= BinarySearch(nums, l, h, target);
            }
            else if(target >nums[mid] && target> nums[0])
            {
                l=mid+1;
                res= BinarySearch(nums, l, h, target);
            }
            else if(target<nums[mid] && target>=nums[0])
            {
                h=mid-1;
                res= BinarySearch(nums, l, h, target);
            }
            else if(target >nums[mid] && target<=nums[0])
            {
                l=mid-1;
                res= BinarySearch(nums, l, h, target);
            }
                
        }
        return res;
    }
}