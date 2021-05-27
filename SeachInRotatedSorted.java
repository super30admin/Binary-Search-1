/*
The time complexity is O(logN) and the space complexity is O(1).

Here, the idea is to use binary search in a modified way. We calculate the mid of the array. Since the array might be rotated we check
additional relationship between target and mid, mid and start. Then we move accodingly.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int search(int[] nums, int target) {

        int start = 0; int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int nmid = nums[mid];
            if(nmid==target){
                return mid;
            }
            else if(nums[start]==target){
                return start;
            }
            else if(nums[end]==target){
                return end;
            }
            else if(nums[start]>target){
                if(nmid>target && nmid<nums[start]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nmid<target && nmid>nums[start]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}