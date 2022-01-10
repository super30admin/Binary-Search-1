/* Problem3: Search inside a sorted array of unknown length
Suppose you are given sorted array of unknown length and target(to search for)
then return i)index of target ii)index of any occurence(if occur multiple times) iii) -1
Note: accessing element out of bounds throws exception 
*/
// Time Complexity : O(log m), where m is window size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Since its sorted array, we will apply binary search.
//1) deciding window size by keeping two index low as 0 and high as 1
//2) and incrementing low as high and high as 2times(high)
//this will create window size and binary search will be better
//3) make sure that high index does not go out of bounds so keep high < target while incrementing
//4) after having window size, set mid pointers and compare mid index value with target
//4.1)if mid value < target, set low as mid+1
//4.2)if mid value > target, set high as mid-1

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
 class Solution{
     public int search(ArrayReader reader, int target){
         //set low and high indexes
         int low = 0; int high = 1;
         //validating that high index doesn't go out of bound
         while(reader.get(high) < target){
             low = high;
             high = 2*high;
         }
         //set window size and once target is within specified range
         while(low <= high){
             //avoid integer overflow
             int mid = low + (high-low)/2;
             if(reader.get(mid) == target) return mid;
             else if(reader.get(mid) > target){
                 high = mid - 1;
             } else {
                 low = mid + 1;
             }
         }
         return - 1;
     }
 }
