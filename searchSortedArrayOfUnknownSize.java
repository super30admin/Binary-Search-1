// Time Complexity : O(logN)
// Space Complexity : O(1), recursive stack not sure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, took more time than other
//                          questions to figure out and think about
//                          0 as the edge case.



/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


class searchSortedArrayOfUnknownSize
{
     public int search(ArrayReader reader, int target)
     {
    	 if(target == 0)
             return recursiveSearch(reader, 2, 0, target);

         return recursiveSearch(reader, Math.abs(target), 0, target);
     }


     public int recursiveSearch(ArrayReader reader,int index, int low,
                                int target){

         if(low > index) return -1;

         if(low == index && reader.get(index) == Integer.MAX_VALUE - 1)
        	 return -1;

         int ans;

         if(reader.get(index) != Integer.MAX_VALUE - 1)
         {
             if(reader.get(index) == target)
            	 return index;

             if(reader.get(index) > target)
            	 return binarySearch(reader, low, index, target);

             else
            	 ans = recursiveSearch(reader,index+index/2,index, target);
         }
         else
        	 ans = recursiveSearch(reader, low+index/2,low, target);

         return ans;
     }

     public int binarySearch(ArrayReader reader,int low, int high, int target){

         int mid;

         while(low <= high)
         {
             mid = low + (high - low)/2;

             int val = reader.get(mid);

             if(val == target) return mid;

             if(val < target)
            	 low = mid + 1;

             else
            	 high = mid - 1;

         }

         return -1;
     }
 }
