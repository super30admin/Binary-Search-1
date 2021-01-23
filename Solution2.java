//Search in Rotated Sorted Array
//T: O(logN)
//S: O(1)

class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int val = nums[mid];

            // We use nums[0] to check whether both target & nums[mid] are within a sorted range.
            //If yes then we continue our binary search.
            //If no then we make the nums[mid] value as infinity or -infinity depending on it's position

            if((target<nums[0] && nums[mid]<nums[0]) || (target>=nums[0] && nums[mid]>=nums[0])){
                val = nums[mid];
            }else{
                if(target<nums[0]){ //This is similar to (target<nums[0] && nums[mid]>nums[0])
                    val = Integer.MIN_VALUE;
                }else{              //This is similar to (target>nums[0] && nums[mid]<nums[0])
                    val = Integer.MAX_VALUE;
                }
            }

            if(target==val){
                return mid;
            }else if(target<val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }
}