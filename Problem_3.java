// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the boundry by setting fast pointer and then apply bubble sort to it.
// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        while( low <= high ){
            int mid = low + ( high - low ) / 2;
            if ( reader.get(mid) == target){
                return mid;
            }else if( reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}