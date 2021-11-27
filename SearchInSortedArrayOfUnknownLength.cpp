// Time Complexity : O(log n)
// Space Complexity : O(1) Constant Space
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;


        while(target > reader.get(high))
        {
            low = high;
            high = high * 2;
        }

        while(low <= high)
        {
            int mid = low + (high - low) / 2; // Avoid integer overflow

            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) > target)
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