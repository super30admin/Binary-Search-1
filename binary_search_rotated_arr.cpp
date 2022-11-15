// test case example [1,2,3,4,5] -> [2,3,4,5,1]
//  We need to search for 1

// test case 2 example : [4,5,6,7,0,1,2,3]
// We need to search for 0
#include <vector>
#include <math.h>

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        // initialise low and high values

        int low = 0;
        int high = nums.size() - 1;

        while (low <= high)
        {
            // Middle element initialised
            int mid = floor(low + (high - low) / 2);

            if (nums[mid] == target)
            {
                return mid;
            }

            // Check whether to go to the left part of the array

            if (nums[low] <= nums[mid])
            {
                // Entered the left part of the array

                // Check whether our number is present here or not
                if (nums[low] <= target && nums[mid] > target)
                {
                    high = mid - 1;
                }

                // Else we will have to enter the right part of the array
                else
                {
                    low = mid + 1;
                }
            }

            else
            {

                // checking for next case , when the right part of the array is sorted

                if (nums[mid] <= nums[high])
                {
                    // Entered the right part of the array

                    // Check whether number is present here
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
        }
        return -1;
    }
};