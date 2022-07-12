// Time Complexity : O(log T) where T is the index of the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Problem3: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

class Solution {
    public int search(ArrayReader reader, int target) {

        int left = 0;
        int right = 1;

        if(reader.get(right) == target){
            return right;
        }

        while(target > reader.get(right)){
            left = right;
            right = right * 2;
        }

        int midIndex, mid;
        while(left <= right){
            midIndex = left + (right - left)/2;
            mid = reader.get(midIndex);

            if(target == mid){
                return midIndex;
            }else if(target > mid){
                left = midIndex + 1;
            }else{
                right = midIndex - 1;
            }
        }
        return -1;
    }
}