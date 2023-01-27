// Time Complexity : O(log(m) + log(n)) //log m accounts for expansion phase, log n accounts for binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* Since its an infinite sorted array, we find the upper bound of our search space by multiplying high by 2 and setting low to high.
   Once the search space is defined, we have the low and high values. After that we just perform binary search on the search space 
   defined to find the target.
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        while(reader.get(end) < target) {
            start = end;
            end = end * 2;
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == reader.get(mid))
                return mid;
            else if(target < reader.get(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}