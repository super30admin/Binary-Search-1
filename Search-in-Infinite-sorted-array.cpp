// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Keep a low pointer and a high pointer one after the another and keep shifting high in multiple of two
// Along with high keep shifting low to the previous high until you find that high is greater than target. 
// When found use that range of high and low and apply binary search to find the target

#include <iostream>
#include <vector>
  
using namespace std;


class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        //arrayreader class is predefined in the question
        int low;
        int high;
        while (reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        
        while (low <= high){
            int mid = low + (high - low)/2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
};



