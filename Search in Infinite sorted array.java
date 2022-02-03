/** 
Input: secret = [-1,0,3,5,9,12,13,14,16,18,21,23], target = 14
Output: 4                   s         e

possibleSolutions:
- O(n)
- start = 0, end = 1
end = end * 2


// Time Complexity : O(logn) since we are the applying the binary search.
// Space Complexity : total space = O(n) (input array size) + O(1) constant time.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int start = 0;
        int end = 1;
        
        while (target > reader.get(end))
        {
            start = end + 1;
            end = end * 3;
        }
    
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (target > reader.get(mid))
            {
                start = mid + 1;
            }
            else if (target < reader.get(mid))
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        
        return -1;
        
    }
}