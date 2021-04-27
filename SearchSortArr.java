// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We solve this problem by dividing it into two parts. 
 * 1. Searching the range of the elements in which the target is present.
 *    a. we check if the target element is greater than the element at the high pointer.
 *    b. If the target element is greater, than we expand the range by twice.
 *    c. If not, then the target element is in the current defined range.
 * 2. Once the range is identified, we perform regular binary search to check if the element is present.
*/
public class SearchSortArr {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high) != Integer.MAX_VALUE && target > reader.get(high)){
            low = high;
            high *= 2;
        }
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(reader.get(mid) == target){
                return mid;
            }else if(target < reader.get(mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return -1;
    }
}
