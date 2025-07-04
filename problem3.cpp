// Time Complexity : O(log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

//Search in Infinite sorted array: 

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

//Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

#include <climits>

class ArrayReader {
    public:
    int get(int index);
};

class Solution {
    public:
    int search(const ArrayReader& reader, int target) {
        int start = 0, end = 1;

        while(reader.get(end) < target) {
            start = end;
            end *=2;
        }

        while(reader.get(end) < target) {
            start = end;
            end *= 2;
        }
        while (start<=end) {
            int mid = start + (end - start)/2;
            int midVal = reader.get(mid);

            if (midVal == target) return mid;
            if (midVal > target || midVal == INT_MAX)
            end = mid -1;
            else
            start = mid +1;
        }
        return -1;
    }
};