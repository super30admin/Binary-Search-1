#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
 
/*      
Approach:
Case 1: If there is a rotation and the middle element is in left of the array
Case 2: If there is a rotation and the middle element is in right of the array
Case 3: If there is no rotation 

*/

class Solution {
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size()-1;
        while (left <= right) {
            int middle = (left+right) / 2;
            if (target == nums[middle])
                return middle;
            // if there's exists rotation and the middle element is in the left part of the array
            if (nums[middle] > nums[right]) {
                if (target < nums[middle] && target >= nums[left])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            // if there's exists rotation and the middle element is in the right part of the array
            else if (nums[middle] < nums[left]) {
                if (target > nums[middle] && target <= nums[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            // if there is no rotation use normal binary search approach
            else {
                if (target < nums[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        }
        return -1;
    }

};