// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : how to get the high and low values.


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;

        //find low and high indices by starting from 1 and then doubling the jump until  you get condition of target
        // less than high or end of array
        while(reader.get(high) < target){
            low=high;
            high=2*high;
        }
        return binarySearch(reader, target, high, low);
    }

    private int binarySearch(ArrayReader reader, int target, int high, int low){
        //perform regualr binary search

        while(low <= high){
            int midpoint = low +(high -low)/2; // to avoid integer overflow
            if(target == reader.get(midpoint)){
                return midpoint;
            } else if(reader.get(midpoint) > target){
                high = midpoint -1;
            } else {
                low = midpoint + 1;
            }
        }
        return -1;
    }
}