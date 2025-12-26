// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : finding rotationPoint which one is the rotation point
//array[mid]>array[mid+1] is it mid or mid+1


// Your code here along with comments explaining your approach in three sentences only

class SortedArray {
    public int search(int[] nums, int target) {
        //first search in nums if rotated
        //if rotated search where rotated
        int rotationPointVar = rotationPoint(nums,0,nums.length-1);
        //not rotated find in whole array
        if(rotationPointVar==-1)
        {
            return findIndex(nums,0,nums.length-1,target);
        }
        //rotated search in two places
        //first half and scond half by rotation point
        else
        {
            int indexFirst = findIndex(nums,0,rotationPointVar,target);
            int indexSec = findIndex(nums,rotationPointVar+1,nums.length-1,target);
            if(indexFirst!=-1)
            {
                return indexFirst;
            }
            else if(indexSec!=-1)
            {
                return indexSec;
            }
        }

        return -1;
    }

    private int rotationPoint(int[] nums,int start, int end)
    {
        if(nums[start]<=nums[end])
        {
            return -1;//array is not rotated
        }
        while(start<end)
        {
            int mid = start + ((end-start)/2);
            if(nums[mid] > nums[mid+1])
            {
                return mid;//mid is the rotation point
            }
            //incraesing order till mid, so start from mid+1
            if(nums[start]<=nums[mid])
            {
                start = mid + 1;
            }else
            {
                end = mid;//else search in start to mid
            }
        }
        return -1;
    }

    //binary serach algo
    private int findIndex(int[] nums, int start, int end, int target)
    {
        if(start>end)
        {
            return -1;
        }
        int mid = start + ((end-start)/2);
        if(nums[mid]==target)
        {
            return mid;
        }
        if(target > nums[mid])
        {
            return findIndex(nums,mid+1,end,target);
        }
        else
        {
            return findIndex(nums,start,mid-1,target);
        }

    }
}