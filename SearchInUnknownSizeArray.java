/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

/* Algorithm:
* 1. As we do not have higher bound (secret), first we need to think of how we can define the search space
*    1.1 With linear search, we can check each index and getReader(index) and compare with target, this will cost O(n)
*    1.2 To reduce search space and improve binary search time, we can define smaller search space
         -> low = 0 and high = 2 (multiply by 2)
         -> [high] > target --> then set this high
     1.3 Run Binary search on above search space (low ---> high)
* 
* Time complexity: O(log n) --> Find search space (log n) + binary search (log n) = 2(log n)
* Space complexity: O(1)
*/
class SearchInUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        
        if(reader.get(0) == Integer.MAX_VALUE){
            return -1;
        }
        
        int low = 0;
        int high = 1;
        
        //Define the search space
        while(reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }
        
        //Run Binary Search on the above search space
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            
            if(reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return -1;
    }
}