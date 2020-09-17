/*
   
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
 */

//Time comlpexity - O(log n) 
//space complexity - O(1)
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/  

// Your code here along with comments explaining your approach
//two pointer approach where you search the target from the front and back siultaneously
class Solution {

    public int search(int[] nums, int target)
     {
        int i = 0; //pointer 1
        int j = nums.length - 1; //pointer 2
        while( i <= j ) {
            if(nums[i] == target)
                return i;
            else if(nums[j] == target)
                return j;
            i++;
            j--;
        }
        return -1;
    }
}