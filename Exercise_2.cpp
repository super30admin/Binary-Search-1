// Time Complexity                                  : O(N)
// Space Complexity                                 : O(Log N)
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : Faced issues with the edge cases. 
//                                                    1. When the array has not been rotated, I did not consider this case initially.               

#include<bits/stdc++.h>
using namespace std;

class Solution {
private: 
    int n;
    int getP(vector<int>& nums) {
        if(nums[0] < nums[n-1]) return 0;
        
        int l=0,r=n-1,md;
        while(l<=r) {
            md = l+(r-l)/2;
            
            if(nums[md]>nums[md+1]) 
                return md+1;
            else {
                if(nums[md]>=nums[0]) 
                    l = md+1;
                else 
                    r=md-1;
            }
        }
        return 0;
    }
    
    int srch(vector<int>& nums, int target, int l, int r) {
        int md;
        while(l<=r){
            md=l+(r-l)/2;
            if(nums[md]==target) return md;
            else if(target > nums[md]) l = md+1;
            else r = md-1;
        }
        return -1;
    }
    
public:
    int search(vector<int>& nums, int target) {
        n = nums.size();
        if(n==1){
            if(nums[0]==target) return 0;
            else return -1;
        }
        
        int p=getP(nums);
        
        if(nums[p] == target)
            return p;
        if(p == 0)
            return srch(nums,target,0,n-1);
        
        if(target >= nums[0])
            return srch(nums,target,0,p-1);
        else
            return srch(nums,target,p,n-1);
        
        return -1;
        
    }
};