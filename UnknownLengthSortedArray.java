// Time Complexity : O(long(n)) since we are reducing the search by half array each iteration.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Following normal 2 pointer algorithm for binary search tree but since we dont have length of array, I am taking int max value.

class Solution {
    public int search(ArrayReader reader, int target) {
        int startIndex = 0,endIndex = Integer.MAX_VALUE;
        while(startIndex<=endIndex){
            int mid = startIndex + (endIndex-startIndex)/2;
            if(reader.get(mid)==target)
                return mid;
            if(reader.get(mid) > target)
                endIndex = mid-1;
            else
                startIndex = mid + 1;

        }
        return -1;
    }
}
