// Time Complexity : O(logN) binary serach and finding the high and low are reduced operation by 2 fold  it's O(log (n*m)) for both ops and O(logN) combined
// Space Complexity : O(1) no extra space used for both ops
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Leetcode(702): https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
/*Approach:
    As this an infinity array, there is no clear idea on what high can be: the solution starts with finding high by incrementing 
    two fold every time from it previous value if the traget is not under that value. and new low will be next element of previous high
    i.e. high = high * 2; low = high + 1

    After determining the the high and lows do a binary search
*/
#include<iostream>

using namespace std;

// As the requriement clearly states this solution needed to run in O(log n) time, Binary search is performed to find the elements
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
    
    int low = 0, high = 1;

    //just sanity check if the target is either intial high or low
    if(reader.get(low) == target) return low;
    if(reader.get(high) == target) return high;

    //finding my high by incrimenting 2 fold everytime until we reach the postion where high > target
    while(reader.get(high) < target){
        //low = high;//if it's not less that high then new low can be high
        
        // does it really required to start the low as previous high?? and we know the target is not under the previous high
        //so i did high + 1 and surprisingly recuded some time to run too
        low = high + 1;
        high = high * 2; 
    }

    //after finding the high and low, do binary search
    while(low <= high){
        int mid = low + (high - low) / 2;

        if(reader.get(mid) == target) {
            return mid;
        }
        else if(target > reader.get(mid)) {
            low = mid + 1;//search to the right
        }
        else{ 
            high = mid - 1; // move the search to right
        }
    }
        return - 1;
    }
};