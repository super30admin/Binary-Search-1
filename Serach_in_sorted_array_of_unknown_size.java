// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 2;
        while (reader.get(high) < target){
            low = high;
            high = high * 2;
        }
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            int midVal = reader.get(mid);
            if(midVal == target) return mid;
            if(midVal > target) high = mid - 1;
            else low = mid + 1;

        }
        return -1;
    }
}