/*
 *  Time Complexity: O(log n) since we are searching for the high index in factor of 2 and then performing binary search between the low and high also gives us (log n) time complexity.
 *  Space Complexity: O(1) Constanct space as we do not store any info and use iterative approach
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Identify the higher index by search for the element greater that target in multiples of 2. Once we get the high and lower would be the previous high index. From this we can simply perform normal binary search.
 */

class Solution {
    public int search(ArrayReader reader, int target) {
       int low =0, high=1;
        while(reader.get(high)<target){
            low=high;
            high*=2;
        }
        return binarySearch(reader, low, high, target);
    }
    public int binarySearch(ArrayReader reader, int low, int high, int target){
            while(low<=high){
                int mid = low + (high-low)/2;
                int currVal = reader.get(mid);
                if(currVal==target) return mid;
                else if(currVal<target) low = mid+1;
                else if(currVal>target) high = mid-1;
            }
          return -1;   
        }
}