class Solution {
    /*Time Complexity : O(logn);
     * Space Complexity : O(1);
     * 
     * Executed in leetcode;
     */
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        int low = 0;
        int high = 1;
        while (reader.get(high) < target ){
            low = high;
            high = 2 * high;
        }
        while (low <= high){
            int mid = low + (high - low)/2;
            if (reader.get(mid) == target){
                return mid;
            }else if (reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return -1;  
    }
}
