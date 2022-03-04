// Time Complexity : O(logn) n is size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SearchRotatedSortedArray
{
  public int search(int[] nums, int target) {

        //concept : one side of the array will always be sorted when we choose the mid
        //check if this sorted side has the target using range then find it's index using binary search

        int n = nums.length;
        int l=0, h=n-1;

        while(l<=h)
        {
            int m = l + (h-l)/2;

            if(target==nums[m])
                return m;

            else if(nums[l]<=nums[m]) //left side is sorted
            {
                //target is in range of left side
                if(target>=nums[l] && target<nums[m])
                    h = m-1;
                else
                    l = m+1;
            }
            else //right side is rotated
            {

                //target is in range of right side
                if(target>nums[m] && target<=nums[h])
                    l = m+1;
                else
                    h = m-1;
            }
        }

        return -1;

    }
}
