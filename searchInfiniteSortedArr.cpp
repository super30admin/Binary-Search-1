// Time Complexity : O(log m * log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int search(const ArrayReader& reader, int target) {

        int low = 0;
        int high = 1;

        // This takes time complexity of O(log m)
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        // This takes time complexity of O(log n), where n ranges between low and high
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
};