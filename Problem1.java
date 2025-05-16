// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Approach
// initially low = 0 , high = 1 . check if target lies between 0 , 1 . if not , double the high until you find the range
// After you find the high , now run the binary search 

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; //initially low pointer as index 0
        int high = 1; //initially high pointer as index 1
        while(target > reader.get(high)){ // we will get range here
            low = high;
            high = high * 2;
        }
        //run binary search now 
        while(low<=high){
            int mid = low + (high - low)/2;
            if(target < reader.get(mid)){
                high = mid - 1;
            }
            else if(target > reader.get(mid)){
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;

        
    }
}