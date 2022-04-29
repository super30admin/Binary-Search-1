// Time Complexity : O(Log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid;
            if(nums[start] <= nums[mid]) {// to check if the numbers from start to mid are sorted
                //if sorted, then check whether the target is within that range
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                } else {
                    //else, make the start to middleIndex+1
                    start = mid+1;
                }
            } else {
                //if the numbers from start to mid are not sorted,
                //then check the range from mid to high,
                //also check if the target is within this range,
                //if yes, then start to middleIndex+1, just like the else we have in the above if.
                if(nums[mid] < target && nums[end] >= target) {
                    start = mid+1;
                } else {
                // generally, this will get called, when the target is not in the range,
                //for instance, array like [4,5,6,0,1,2,3] and target = 6
                //now when we enter into the WHILE for first time,
                // the middleIndex will be pointing to 0,
                // we check in the above if 4<=0, it will fail
                // so we come to the parent else,
                // then if the target is not even in the second range, like from 0 to 3
                // then we set high to mid-1, so the next iteration will happen between [4,5,6]
                // from that point, the range is found, and this condition if(nums[start] <= nums[mid]) passes,
                // we will keep on hitting start = mid +1, until the middle becomes 2, then we return the result
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}