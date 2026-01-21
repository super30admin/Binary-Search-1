
//Search in Infinite sorted array:

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

//Given a sorted array of unknown length and a number to search for, 
// return the index of the number in the array. Accessing an element out of bounds 
// throws exception. If the number occurs multiple times, return the index of any occurrence. 
// If it isn’t present, return -1.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        //get the range of low and high
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }

        //Now applying binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
     return -1;
    }
}
class Problem3
{
    public static void main(String[] args) {
        Solution sol = new sol();
        int[] array = new int[] {7,1,5,3,6,4,6};
        System.out.println(sol.search(array, 6));
        
    }
}