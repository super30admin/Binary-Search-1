// Time Complexity :O(log n)
// Space Complexity :O(1) ~ Please confirm
//      since we are not storing any varibles
//
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Problem2 {

    // changes reader from ArrayReader to int [] as could'nt find appropriate package
    public int search(int[] reader, int target) {

        // 1. Find the bounds

        // initialize
        int start = 0;
        int end = 2;
        
        // increse the bound if target is in higher bound
        while(target>reader[end]){
            start = end;
            end *=2;   
        }
        
        // 2. Do Binary Search on the bounds
        return binarySearch(reader, start, end , target);
        
    }
    
    /**Binary search */
    private int binarySearch(int[] reader, int low, int high, int target){
    
        while(low<=high){

            // find mid by avoiding integer overfloe
            int mid = low +(high-low)/2;

            // return index if found
            if(reader[mid] == target)
                return mid;
            // check the range
            else if (reader[mid] < target){
                low= mid+1;
            }else{
                high = mid -1;
            }
        }
        // not found
        return -1;
    }
}