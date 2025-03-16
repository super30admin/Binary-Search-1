//
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Unable to test as it is premium problem
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach in three sentences only
// 1. find the bucket in which key maybe present by multiplying size of it by 2.
// 2. Perform binary search on that range.
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