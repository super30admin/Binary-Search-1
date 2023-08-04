// Time Complexity : O(log m)+O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * using window technique: stored array so, we can find the range of window by making 2*high everytime 
 * and apply BS in that range
 * problem with out of bound will also be managed to go infinite and can find mid still..
 */

class Solution {
    public int search(ArrayReader reader, int target){

        int low;
        int high =1;

        //window 
        while (reader.get(high)< target){
            low=high;
            high=2*high;
        }

        // binary search
        while(low<=high){
            int mid=low+ high-low /2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return -1;

    }
    
}
