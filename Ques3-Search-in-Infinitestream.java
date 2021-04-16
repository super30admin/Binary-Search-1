// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// I should have paid more attention tot he constraint.
// I thought since the largest element could be 1000 that means that's the max size the array can go upto.
// This was wrong as the ocntriants had mentioned that the array size could be 10000(10^4)


// Your code here along with comments explaining your approach
// Straight forward binary approach by constricting the value of the high index.
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)<target){
                low = mid+1;
            }
            else if(reader.get(mid)>target){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
