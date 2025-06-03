// Time Complexity : O(log n + log k), where n is the size and k is the size of the range
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Don't have a premium
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
//Since the array size is unknown, we first exponentially increase the high index
//until we find a range [low, high] where the target could lie.

//Once the range is identified, we perform a standard binary search
//within that range to find the target.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = low+1;
        //Find the range that target lies
        while(reader.get(high) < target) {//log n
            low = high + 1;
            high = high * 2;
        }
        //Normal binary search
        while(low <= high){//log k
            int mid = low + (high - low)/2;
            if(reader.get(mid)==target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}