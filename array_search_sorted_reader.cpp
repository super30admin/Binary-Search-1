/*

// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : intial condition for the range of search.


// Your code here along with comments explaining your approach in three sentences only
intialized 2 pointers on the array, where if target is less than high, then high is incresed twice
and lower value is made to high value to determine the range where to perform search.
*/



#include<iostream>
#include<vector>

using namespace std;

class ArrayReader;

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low{0};
        int high{1};
        if(reader.get(low) == target){
            return low;
        }
        if(reader.get(high) == target){
            return high;
        }
        while(reader.get(high)<target){
            low = high;
            high = 2*high;
        }
        while(low<=high){
            int mid{low + (high-low)/2};
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid)>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
        
};


