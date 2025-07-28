#include<iostream>
#include<vector>
using namespace std;
/*
->Using binary search we check the conditions whether the array is left or right rotated 
-> Accordingly we apply the conditions 
TC: O(log n), SC : O(1)
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low=0, high=nums.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[low]){
                if(target>=nums[low] && nums[mid]>target) high=mid-1;
                else low=mid+1;
            }else{
                if(nums[mid]<target && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }
};