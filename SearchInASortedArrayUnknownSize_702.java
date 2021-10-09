// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class SearchInASortedArrayUnknownSize_702 {
    public  int search(ArrayReader reader, int target) {
    	// we dont know size of array so we will assume highest integer possible values
        int l =0;
        int h = Integer.MAX_VALUE;
        
        while(h>= l){
            
            int mid = l +( h-l)/2;
            //using given function to get element of secret array
            int midElement = reader.get(mid);
            
            if(midElement == target){
                return mid;
            } else if (target < midElement ) {
                h = mid -1;
            } else {
                l = mid +1;
            }
        }
        
        return -1;
    }
}