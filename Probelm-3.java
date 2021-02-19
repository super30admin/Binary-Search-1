// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;
        
        int left = 0, right = 1;
        while(reader.get(right) < target){
            left = right;
            right = right*2;
        }
        
        int mid, num;
        while(left <=right){
            mid = left + (right-left)/2;
            num=reader.get(mid);
            if(num == target) return mid;
            if(num > target) right = mid -1;
            else left = mid + 1;
                            }
        return -1;
    }
}