// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        //use of 2 pointer 
        //as we dont know the end of array we will assign high as 1 and low as 0
        // we will increase the high *2 in every iteration
        //we will reduce the set of array to run BST buy updating the low as that of high as the data wont be in that range
        while(reader.get(high)<=target){ 
            
            if(reader.get(high)==target){
                return high;
            }
            low = high;
            high = high*2;
        }
        //regular BST logic
        while(low<=high){

            int mid = low + (high-low)/2;
            if(target==reader.get(mid)){
                return mid;
            }

            if(reader.get(mid)>target){

                high = mid -1;

            }else{
                low = mid+1;
            }

        }
        return -1;
        
    }
}