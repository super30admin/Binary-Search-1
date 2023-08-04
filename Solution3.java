// Time Complexity : O(log m +  log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution3 {
    public int search(ArrayReader reader, int target) {
        
        int low=0;
        int high=1;
        

        while(reader.get(high)<target)
        {
            low=high;
            high=2*high;
        }
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(reader.get(mid)==target) return mid;
            else if(target< reader.get(mid))
            high=mid-1;
            else
            low = mid+1;
        }
      return -1;  
    }
}