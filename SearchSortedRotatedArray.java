// Time Complexity : O(log N) average
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not sure about the space complexity. I'm using recursion so I think that the space complexity isn't O(1)


// Your code here along with comments explaining your approach

class SearchSortedRotatedArray {
    public int search(int[] nums, int target) {
        return helper(nums,0,nums.length-1,target);
    }
    public int helper(int[] nums, int start, int end, int target){
        if(end>=start) {
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<nums[end]) {
                if(nums[mid]<target && target<=nums[end])
                    return helper(nums,mid+1,end,target);
                else
                    return helper(nums,start,mid,target);
            }
            else if(nums[mid]>nums[end]) {
                if(nums[start]<=target && target<nums[mid])
                    return helper(nums,start,mid-1,target);
                else
                    return helper(nums,mid+1,end,target);
            }
        }
        return -1;
    }
}