// Time Complexity : O(log n) + O(logn) == O(logn)
// Space Complexity : O(3) ~ O(1) ... need to allocate 3 new variables, but its nothing but O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Search in a Sorted Array of Unknown Size

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.
Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
You must write an algorithm with O(log n) runtime complexity.
*/


/*
Code explanation : 
slow and fast index methos is used here.
Slow and Fast indexes are used to check if number lies within the range
and then binary sorting can be used between slow and fast index.
*/


class Solution {
public:

    int search(const ArrayReader& reader, int target) {
        if(reader.get(0) == INT_MAX) return -1;
        if(reader.get(0) == target) return 0;
 
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }

         while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid-1;
            } else {                    
                low = mid+1;
            }
        }

        return -1;
    }
};