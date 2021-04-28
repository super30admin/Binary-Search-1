// Time complexity-O(log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

#include<iostream>
using namespace std;
#include<vector>
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.empty()){return -1;}
        int low =0; int high = nums.size()-1;
        
        while(low <=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                    return mid;
                }
            if(nums[low] <=nums[mid] ){// left side is sorted
                
                if(nums[low] <= target && target <= nums[mid]){
                    high=mid-1;
                }
                else{
                    low =mid +1;
                }
            }
            else if(nums[high] >nums[mid]  ){// right side is sorted
                
                if(nums[mid] <= target && target <= nums[high]){
                    low=mid+1;
                }
                else{
                    high =mid -1;
                }
            }
            
        }
        return -1;
        
    }
};