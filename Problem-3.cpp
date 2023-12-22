/*Time Complexity: O(log n)

Space Complexity: O(1)

Did this code successfully run on Leetcode : YES

Approach: Since the size of array is unknown, we
use two pointers low and high and based on target
we move low and high by *2 and do binary search
in between the low and high.
*/

#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int search(const ArrayReader &reader, int target)
    {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target)
        {
            low = high;
            high *= 2;
        }
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
            {
                return mid;
            }
            else if (reader.get(mid) > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
};