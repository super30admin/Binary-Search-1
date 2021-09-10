// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int right = 2;
        int left = 0;
        while(reader.get(right) < target)
        {
            left = right;
            right = right * 2;
        }
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
};
