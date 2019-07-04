//
// Created by shazmaan on 7/4/2019.
//
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        return binarySearch(nums,0,nums.size()-1,target);
    }
    int binarySearch(vector<int>& nums, int low, int high, int target){
        if(low>high){
            return -1;
        }

        int mid = (low+high)/2;
        if(nums[mid]==target){ //found
            return mid;
        }else if(nums[mid]>=nums[low]){ //left sorted
            if(target>=nums[low] && target<=nums[mid]){
                return binarySearch(nums,low,mid,target);
            }
            return binarySearch(nums,mid,high,target);
        }else{  //right sorted
            if(target>=nums[mid] && target<=nums[high]){
                return binarySearch(nums,mid,high,target);
            }
            return binarySearch(nums,low,mid,target);
        }
    }

//    int findRotPoint(vector<int>& nums,int low, int high){
//        if(low==high){ //base
//            return low;
//        }else if(low>high){
//            return -1;
//        }
//
//        int mid = (low+high)/2;
//        if(nums[mid]<nums[mid-1]){
//            return mid;
//        }else if(nums[mid]>nums[low]){
//            low=mid;
//        }else if(nums[mid]==nums[low]){
//            if(nums[mid]<nums[high]){
//                return 0;
//            }
//            return nums.size()-1;
//        }else if(nums[mid]<nums[low]){
//            high = mid;
//        }
//        findRotPoint(nums,low,high);
//    }

};

int main(){
    Solution s;
    vector<int> num{5, 6, 7, 8, 9, 10, 1, 2, 3};
    cout<<s.search(num,7)<<endl;
    return 0;
}