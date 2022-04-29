// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took lots of time to solve/come up with approach

// Your code here along with comments explaining your approach
// Initially, 2 cases - 1) array is sorted w rotation ; 2)Array is sorted with no rotation
// If Case 2 - Simple Binary Search 
// If Case 1 --------------------Array is sorted w rotation 
//                           ..                              ..
//                        ..                                    ..
// Middle ele in left half = nums[mid]> nums[r]             Middle ele in right half = nums[mid] < nums[l]
//                   ..                                               ..  
//               ..       ..                                       ..         ..
//            ..              ..                               ..                 ..
// Tar<Mid & Tar>L          Other possibility          Tar>Mid & Tar<=R        Other possibility
// r = mid - 1               l = mid + 1                  l = mid + 1               r =mid - 1

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0, r = nums.size()-1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[mid] > nums[r]) {
                if (target < nums[mid] && target >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else if (nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else {
                if (target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
};


