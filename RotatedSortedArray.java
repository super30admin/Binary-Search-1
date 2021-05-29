
//Time Complexity: O(log(n))
//Space complexity: O(1)
//This is a one pass solution
class Solution {
    //RotatedSortedArray
    public int search(int[] nums, int target) {

        int l=0,r=nums.length-1;
        int mid;
        //For any rotated sorted array, when drivided into two parts, atmost one part of the array is unsorted. Always one side of the array is sorted. Some cases both sides of the array might be sorted.
        if(nums==null || nums.length==0)
            return -1;
        while(l<=r)
        {
            mid=l+ (r-l)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            //if Left array is sorted.
            if(nums[l]<= nums[mid] )
            {
                //if targert is in left sorted array
                if(nums[l]<= target && nums[mid]>target)
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }


            }
            else //rt array is sorted.
            {
                //if targert is in rt sorted array
                if(target <=nums[r] && target > nums[mid])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }

        }

        return -1;

    }
}