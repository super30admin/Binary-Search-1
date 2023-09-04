/* 

Problem 3: Search in Infinite sorted array (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


Approach : Implemented binary search after finding the low and high index. It is logrithmic as high is multiplied by 2.

*/

class Solution {
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(target > reader.get(high)){
            low = high;
            high = high * 2;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return target;
            }
            else if(reader.get[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return -1;
    }
}