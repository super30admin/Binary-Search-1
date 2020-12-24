// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, not sure how to calculate the high point at first. Then learned that we can just increase high by 2 until
//it passes the target, then we can just run binary search on it. 


class Solution {
    public int search(ArrayReader reader, int target) {
        //Need to figure out high point first
        //Then run binary search, passing low and high
        int high = 1;
        while(reader.get(high) < target){
            high = 2 * high;
        }
        return binarySearch(0,high, target, reader);
        
    }
    
    public int binarySearch(int low, int high, int target, ArrayReader reader){
        while(low <= high){
            int mid = (low+high)/2;
            int midElement = reader.get(mid);
            
            if(midElement == target){
                return mid;
            }else if(midElement > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}