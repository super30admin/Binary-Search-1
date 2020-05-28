#include <iostream>
#include <cmath>
#include <vector>

using namespace std;
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()>0){
            int l=0; int r=nums.size()-1;
            while(l<=r){
                int mid= l+floor((r-l)/2);
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>=nums[l]){ //left sorted
                    if(nums[mid]>target && nums[l]<=target){
                        r = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
                else{ //right sorted
                    if(nums[mid]<target && nums[r]>=target){
                        l = mid+1;
                    }
                    else{
                        r = mid-1;
                    }
                }
            }
        }
        return -1;
    }
};