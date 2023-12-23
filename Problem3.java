//Time Complexity : log n + log k = O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

//Aproach
/*
 1. First we need to find the range in the array READER
    means low and high
    --> if element not found in that range, By using appraoch like we twice the  high and make low the prev range high
 2. when we found the low and high then we apply the Binary search.
 3. we are doing twice, because if we are incraese the high by thrice, four.. 10000 times,... but might find the range quickly,
            but binary search range will increase and affect the complexity.
 */

 class Solution {
    /**
    * @reader: reader.get(k) returns the element of the array at index k (0-indexed).
    * @return: return target index
    */
   public int search(ArrayReader reader, int target) {
       // write your code here
       int low =0, high = 1;
       while(reader.get(high) < target)
       {
           low = high;
           high *= 2;
       }
       while(low <= high)
       {
           
               int mid = low + (high - low)/2;
               if(reader.get(mid) == target) return mid;
               else if(reader.get(mid) > target) high = mid -1; //search on left side
               else low = mid + 1;
   
       }
       return -1;
   }
}