//Search in a sorted array of unknown size


// Time Complexity : o(log(n) )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : used if loop on increasing the serach space but later understood and made changes

// Your code here along with comments explaining your approach in three sentences only



class Solution {
    public int search(ArrayReader reader, int target) {

    int low = 0 ; int high = 1;

    while(target < reader.get(high)) {
    low = high;
    high = high *2;

    }

    while(low<=high) {
   
     int mid = low + (high-low)/2;
     
     if( target == reader.get(mid) {
     return mid;
    }

    if(reader.get(mid) > target) {
    high = mid -1;
      } else {

      low = mid + 1;
      }


    }
     return -1;
    }