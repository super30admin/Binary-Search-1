// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchSortedArrayUnknownSize {
       public int search(ArrayReader reader, int target) {
           int low = 0;
           int high = 1;
           while(reader.get(high) < target)
           {
               low = high;
               high = high * 2;
           }
           
           while(low <= high)
           {
               int mid = low + (high - low) / 2;
               if(reader.get(mid) == target)
               {
                   return mid;
               }
               
               else if (target < reader.get(mid))
               {
                   high = mid - 1;
               }
               
               else
               {
                   low = mid + 1;
               }
           }
           return -1;
       }
   }