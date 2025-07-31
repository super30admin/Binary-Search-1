/** Time Complexity: O(log m + log k) (m to identify the space within which the target is present and then log k for binary search in the identified space)
* Space Complexity: O(1) [No extra space is used, only variables are used]
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
* LeetCode Problem: Search in infinite Sorted Array
* Approach:
* 1. Double the search space until the target is within the bounds.
* 2. Once the range is identified, perform binary search within that range.
* Problem Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
*/

class Solution2 {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(reader.get(high) < target){ 
            low = high ;
            high = high * 2;
        }

        while(low <= high){ 
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
      
        return -1;
    }
}