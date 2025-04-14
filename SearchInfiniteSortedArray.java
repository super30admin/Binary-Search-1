// Time Complexity : O(logn) // since we are doing binary search
// Space Complexity : O(1) //since we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//we find the range to do binary search by doubling the value of high at each iteartion
 class Solution {
    public int search(ArrayReader reader, int target) {
    //check for null
        if(reader.get(0) == Integer.MAX_VALUE) return -1;
    int low = 0;
    int high =1;
    //find the range of binary search
     while(target > reader.get(high) ){
       low = high;
        high = high * 2 ;
       if(reader.get(high) == target) return high;
           }
         
    //do binary search
    while(low<=high){
       int mid = low + (high -low) / 2;//prevent integer overflow
       if (reader.get(mid) == target){
           return mid;
       }
       else if( target < reader.get(mid)){
           high = mid -1;
       }
       else{
           low = mid+1;
       }
    }
     return -1;
    }
}