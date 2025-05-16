//Problem3: Search in Infinite sorted array
// Time Complexity : O(log base 2 n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//We always increase high twice beacuse log base 2 is a good balance of growing and shrining array in binary search
//If we use foe example log base 3, we will reduce low but drastically increase high range


class Solution {
    public int search(ArrayReader reader, int target) {
        int low =0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }

        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low +(high -low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid -1;

            }
            else{
                low = mid +1;
            }
        }

        return -1;
    }
}