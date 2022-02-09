//search element in sorted array of unknown size
// Time Complexity : O(long n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class SearchInSortedArray {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        while(target > reader.get(high){        //Finding the end where our target becomes less than the end and also moving start
               low = high;
               high = high*2; 
        }
        while(low<=high){                           //Binary search 
            int mid = low + (high-low) / 2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target){
                low = mid+1;
            }
            else     
                high = mid - 1;  
        }
        return -1;
    }
}
