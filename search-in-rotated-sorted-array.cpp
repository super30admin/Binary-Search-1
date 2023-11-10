// The code implements the binary search algorithm to find the target element in a rotated sorted array.
// It first identifies the minimum element's index (min) in the rotated array.
// Then, it performs a binary search in the appropriate half of the array based on the comparison of the target with the array's first and last elements.
// Time Complexity: O(log n)
// Space Complexity: O(1)

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int binarySearch(vector<int>& nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    };
    
public:
    int search(vector<int>& nums, int target) {
        int s = 0, n = nums.size(), e = nums.size() - 1, min = 0;
        if (n == 0) {
            return -1;
        }
        if (nums[e] < nums[s]) {
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    min = mid + 1;
                    break;
                } else if (nums[mid] < nums[s]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            if (target >= nums[0] && target <= nums[min - 1]) {
                return binarySearch(nums, 0, min - 1, target);
            } else {
                return binarySearch(nums, min, n - 1, target);
            }
        } else {
            return binarySearch(nums, 0, n - 1, target);
        }
    }
};
