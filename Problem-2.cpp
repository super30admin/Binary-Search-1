/*Time Complexity: O(log n)

Space Complexity: O(1)

Did this code successfully run on Leetcode : YES

Approach: Since its a sorted array, even if it's
rotated one part of the array will be sorted using
this we can perform binary search.*/

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            // left sorted or not
            else if (nums[low] <= nums[mid])
            {
                if (nums[low] <= target && nums[mid] > target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            // right sorted or not
            else
            {
                if (nums[mid] < target && nums[high] >= target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};