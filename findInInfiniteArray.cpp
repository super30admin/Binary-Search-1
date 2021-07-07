// Time Complexity : O(logn) 
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: FIND LEFT AND RIGHT LIMIT BY MAKING LEFT=RIGHT AND RIGHT=RIGHT*2

// 1. Since we don't know right limit, find both limits by making left=right and right=right*2 till the time target isn't less than right
// 2. Once left and right are found, normal BS between them 

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0, high = 1, mid = 0;
        while(target>reader.get(high)){
            low = high;
            high*=2;
        }
        while(low<=high){
            mid = low+(high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            if(target<reader.get(mid))
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
};