// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Finding the range of the array where the target lies

//find the range of the array where the target lies, set 2 pointers - one at 0 and another at 1
//move the left pointer by 1 and right pointer *2 until u find any element is > than target


class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0;
        int right=1;
        while(target > reader.get(right)){
            left++;
            right=right*2;
        }
       // System.out.println("left " +left + " right "+right);
        
       //perform normal binary search after finding the left and right boundary around target
        while(left<=right){
            int mid = (left+right)/2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            
           else if(reader.get(mid)<target){
                left=mid+1;
            }
            
            else {
                right=mid-1;
            }
        }
        return -1;
    }
}