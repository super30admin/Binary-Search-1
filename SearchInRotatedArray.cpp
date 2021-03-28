#include <bits/stdc++.h>

using namespace std;

/*
 * We are doing Binary Search here.
 * Time Complexity   : O(log(n)) - Search space is divided by half every iteration
 * Space Complexity  : O(1)      - No extra space is being used 
 */
int search(vector<int>& nums, int target)
{
    int low = 0, high = nums.size() - 1, mid;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
 
    return -1;
}

int main ()
{
    vector<int> ar = {1,2,4,5,6,7,0};
    cout << "0 present at " << search(ar, 0) << endl;

    return 0;
}
