// Time Complexity : O(log N) for binary search implemented.
// Space Complexity : O(1) is constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        //Since the size is unknown - cannot figure out mid index if looking for binary search.
        //Algorithm:
        //Based on assumption, going with choosing a random left and right idx
        //Say, left = 0 and right = 1;
        //if(get left=right +1 exists and target>arr[right]=> left = right+1 && right=right+randomIndex OR right*2)
        //when target < right => we are now good with binary search
        int left = 0;
        int right = 1;
        int pivot, num ;
        if(reader.get(0) == target) return 0;
        //If target we are looking is out of right boundary,
        //then move the indices
        while(reader.get(right)<target){
            left = right;
            right = right*2;
        }
        //Other valid conditions:
        while(left<=right){
            pivot = left + (right-left)/2;
            num = reader.get(pivot);
            if(num==target) return pivot;
            if(num>target){
                right = pivot -1;
            }
            else{
                left = pivot+1;
            }
        }
        
        return -1;
    }
}