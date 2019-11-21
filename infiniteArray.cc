// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : It ran successfully on my IDE
// Any problem you faced while coding this : None

#include <iostream>
#include <vector>

int binarySearch(std::vector<int>& nums, int target, int high, int low){
    if(nums.size() == 0) return -1;
    if(high < low) return -1;
    int mid = low + (high - low)/2;
    if(target == nums[mid]){
        return mid;
    }
    else if(target >= nums[low] && target <= nums[mid]){
        high = mid - 1;
    }
    else{
        low = mid + 1;
    }
    return binarySearch(nums, target, high, low);
}

int searchInfiniteArray(std::vector<int>& nums, int target){
    int low = 0;
    int high = 1;
    while(!(target >= nums[low] && target <= nums[high])){
        low = high + 1;
        high = high * 2;
    }
    return binarySearch(nums, target, high, low);
}

int main(){
    std::vector<int> arr = {0, 1, 4, 5, 7, 8, 13, 17, 45, 56, 76, 98, 101, 104, 123, 145, 167};
    int target = 167;
    std::cout << searchInfiniteArray(arr, target) << "\n";
}