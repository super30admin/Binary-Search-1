// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.empty() || nums.size() == 0){
            return -1;
        }
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(nums[low] <= nums[mid]){ //left portion
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};

int main(){
    class Solution s;
    vector<int> matrix = {4,5,6,0,1,2,3};
    int value = 1;
    int x = s.search(matrix, value);
    std::cout << x << std::endl;
    return 0;
}
