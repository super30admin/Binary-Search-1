// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: we set the low at first index and high next to it. Now if the target is greater then high then we shift the high to double of low and low to high.
//Then we calculate mid and see if that is the target. if not we check if it is greater than the target , we search in that range by shifting high to mid-1
//else we search in the range of mid+1 to high.
interface ArrayReader{
    public int get(int index);
}
class Solution{

    private int low = 0;
    private int high = 1;
    public int search(int[] reader, int target){

        while (low<=high) {
            int mid = low + (high-low)/2;
            if (reader[mid] == target) {
                return mid;
            }else if(reader[high] < target){
                low = high;
                high = 2 * low;
            }else{
                if (reader[mid]> target) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}