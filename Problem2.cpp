// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : find sorted array in binary search.


// Your code here along with comments explaining your approach in three sentences only
// 1. used binary search
// 2. Check which part is sorted using mid term and variable fl.
// 3. If key is between this sorted part binary search on this else binary search on other.

class Solution {
public:
    int binarys(vector<int>& nums,int f,int l,int target){
        int mid= f + (l-f)/2;
        if(f>l){
            return -1;
        }
        int fl=0;
        if(nums[mid]<nums[l]){
            fl=1;
        }
        if(fl==0){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target && nums[f]<=target){
                return binarys(nums,f,mid-1,target);
            }
            else{
                return binarys(nums,mid+1,l,target);
            }
        }
        else{
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target && nums[l]>=target){
                return binarys(nums,mid+1,l,target);
            }
            else{
                return binarys(nums,f,mid-1,target);
            }
        }
    }
    int search(vector<int>& nums, int target) {
        int f=0,l=nums.size()-1;
        return binarys(nums,f,l,target);
    }
};