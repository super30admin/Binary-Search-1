// Time Complexity : o(logN) + Time for finding pivot(n/2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int pivot = -1;
        //Search the pivot element and do binary search of subarrays after that pivot and before
        // that pivot including pivot. Since these two subarrays would be ordered
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
            pivot = i;
            break;
        }
    }

    int leftBinarySearch = binarySearch(nums,0,pivot,target);
    int rightBinarySearch = binarySearch(nums, pivot+1,nums.length-1, target);

    return leftBinarySearch!=-1 ? leftBinarySearch : rightBinarySearch;
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(left > right)
        return -1;
        int mid = (left+right)/2;
        if(nums[mid] == target)
        return mid;
       if(nums[mid] > target)
       return binarySearch(nums, left, mid-1, target);
       else
       return binarySearch(nums, mid+1,right,target); 
    }
}