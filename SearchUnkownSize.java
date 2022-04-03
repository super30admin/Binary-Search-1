// Time Complexity : O(log N) where N is the number of elements in the range
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach : Get the ranfe where target lies and do a binary search

class SearchUnkownSize {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        int  mid;
        
        while(target > reader.get(high)){
            low = high;
            high = high * 2;
        }
        
        while(low <= high){
            mid = high - (high - low)/2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            
            if(target < reader.get(mid)){
                high = mid -1;
            }else{
               low = low + 1;
            } 
        }
        return -1;
    }
}