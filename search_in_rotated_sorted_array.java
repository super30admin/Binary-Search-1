// Time Complexity :0(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none


"""
Taking the concept of, one part of rotated array will be sorted
"""

class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            """
            This condition, helps to know whether left part is sorted
            """
            
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=target && arr[mid]>target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                 if(arr[mid]<target && arr[high]>=target)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }

        }
        return -1;
    }
}