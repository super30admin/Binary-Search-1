// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// as per the problem statment leghth is not know length is considered double the by checking if the high is < target condition
//binary serch is perform based on the low, high and mid.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            high = high*2;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}