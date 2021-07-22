// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : the breaking conditin of 1st loop was a tough job


// Your code here along with comments explaining your approach

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size(),s=0,e=n-1,mid,f=0;
        //This loop finds rotation point
        while(s<=e){
            mid=s+(e-s)/2;
            if(mid<n-1&&nums[mid]>nums[mid+1]){
                break;
            }
            if(nums[mid]<nums[0]){
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
            if(mid==n-1){
                break;
            }
        }
        if(mid==n-1){
            if(nums[mid]==target)
                return mid;
        }
        s=0;e=mid;
        //Searching target before rotation point
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]<target){
                s=m+1;
            }
            if(nums[m]>target){
                e=m-1;
            }
            if(nums[m]==target){
                return m;
            }
        }
        s=mid+1;e=n-1;
        //Searching target after rotation point
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]<target){
                s=m+1;
            }
            if(nums[m]>target){
                e=m-1;
            }
            if(nums[m]==target){
                mid=m;
                f=1;
                break;
            }
        }
        if(f==1)
        return mid;
        return -1;
    }
};