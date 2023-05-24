// Time Complexity : O(log(n)base2)
    //n is the size of the array.

// Space Complexity : O(1)

// Did this code successfully run on Leetcode :
    //Yes. It beats 100% of all Java submissions in terms of TC and 5.7% of them in terms of SC.

// Any problem you faced while coding this :
    //How do I reduce the space taken to run the program?

// Your code here along with comments explaining your approach in three sentences only
    //I am initializing low and high indexes as 0 and 10001, keeping in mind the given secret array length.
    //Just divide the search space by 2 every time and would find out if the number is present in the array or in log(10001)base2 time.
    //we can ignore ArrayIndexOutOfBoundsException as the ArrayReader method would return Integer.MAX_VALUE, which is always greater than the target. 

/**
 * Given Constraints:
 * 1 <= secret.length <= 10^4
 * -10^4 <= secret[i], target <= 10^4
 * secret is sorted in a strictly increasing order.
 */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    
    public int search(ArrayReader reader, int target) {
        int low = 0, high = Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (reader.get(mid)==target)
            {
                return mid;
            }
            else if (reader.get(mid)<target)
            {
                low = mid+1;
            }
            else
            {
                //does not matter if the index is out of bounds, Integer.MAX_VALUE is always greater than target.
                high = mid-1;
            }
        }
        return -1;
    }
}