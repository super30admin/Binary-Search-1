// Time Complexity : O(Log(M+N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        //O(log M)
        //to determine the high in an infinite array
        while(reader.get(high) < target) {
            low = high;
            high*=2;
        }
        //O(log N)
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) high = mid -1;
            else low = mid+1;
        }
        return -1;
    }
}