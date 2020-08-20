// Time Complexity : O(log n) - Binary Search
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing SPecific

// 1.Find mid point in the array
// 2. if target is equal to mid, then return mid
// 3. find if the first half is sorted, then see if the target lies in that half (l,mid) or check the other half(mid+1,h)
// 4. otherwise second half will be sorted, then check if target lies in this half (mid+1,h) or else check (l,mid)

class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]){
            if(target>=nums[l]&&target<nums[mid])
                h=mid-1;
            else
             l=mid+1;
        }
        else{
            if(target>nums[mid]&&target<=nums[h])
                l=mid+1;
            else
             h=mid-1;   
        }
    }
return -1;
    }
}