// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : This Question is locked as a premium feature.


// Your code here along with comments explaining your approach

//

/*
1. Sicne we know the limit of the array size and
2. We can take the entire size as the array and perform binary search on
3. We take low = first element and high as Integer.Max
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        
        int lo = reader.get(0); 
        int hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int val = reader.get(mi);
            if (val == target) return mi;
            else if (val < target) lo = mi + 1;
            else hi = mi - 1;
        }
        return -1;
    }
}
