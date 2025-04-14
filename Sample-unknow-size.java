// Time Complexity : O(log n) + O(log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I dont have subscription so question was not showing up for me.
// I had to go over the video recording again to undertstand the problem.

class Solution {
    public int search(ArrayReader reader, int target){
        int low =0, high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
        }
        
        // we have the range of low and high
        while (low <= high){
            int mid = low + (high - low)/2;
            
            if(reader[mid] == target){
                return mid;
            }else if(reader.get(mid) < target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }