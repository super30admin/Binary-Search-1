// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Since we dont have acccess for secret array we don't know the size , So i have started with two pointers low positioned at index 0 and high positioned at index 1.
// I run while loop until high becomes > target , i move low to high position , hight to 2*high position.So that we have the low and high bounds of the target.
// once bounds are set, i perform binary search within that range if target exist it return the pos, if target dosen found in range it comes ou tof while loop and returns -1. 

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        while(reader.get(high)<=target){
            low=high;
            high=high*2;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            if(reader.get(low)<= target && target < reader.get(mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;         

    }
}
