/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInInfiniteSortedArray {
    
    /*
      Time : O(max(log(N), log(M))) | We are doing binaray search two times, first one to get high and low positions, other to do actual binary search
            Time complexity would be dominated by the one which takes more time in both binary searches
      Space : O(1) 
    */
  
    /*
       Approach :
       Binary search is all about reducing a search space by half every time.
       It's infinite array so first we have to find the correct position of the low and high pointers,
       start with low, high = 0,1
       Then check if item at high is less than target if so then we need to expand high further, we do this expansion by making high = high x 2;
       once we found high and low perform classical binary search.
    */
    public int search(ArrayReader reader, int target) {
        if(reader == null) return -1;
        int low = 0;
        int high = 1;
        while(reader.get(high)  < target){
            low = high;
            high *= 2;
        }
        
        return binarySearch(reader, target, low, high);
    }
    
    int binarySearch(ArrayReader reader, int target, int low, int high){
            
            while(low <= high){
                int mid = low + (high - low)/2;
                
                if(reader.get(mid) == target){
                    return mid;
                }else if(reader.get(mid) < target){
                    low = mid +1;
                }else{
                    high = mid - 1;
                }
            }
        return -1;
    }
}
