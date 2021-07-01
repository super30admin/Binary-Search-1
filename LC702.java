// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create pointers low, high and calculate mid
//keep updating value of high until you get Integer.MAX_VALUE because that means you have hit array out of bound
//create a separate function specifically for binary search and use it to return the value in the search method.


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high) != Integer.MAX_VALUE){
            high = high*2;
        }
        
        return binarySearch(reader, low, high, target);
        
    }
    
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
        
            if(reader.get(mid) == target){
                return mid;
            } 
            else if(reader.get(mid) > target){
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }

        }
        return -1;
    }
}