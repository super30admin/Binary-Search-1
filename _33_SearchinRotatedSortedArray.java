// space complexity - o(1)
	//time - o(log(n))
  //Ran on leeetcode successfully : Yes
  // Problem faced  : No
	//Approach : FInd mid and see which side is sorted, go to the sorted side and
            //check if number could lie in the sorted side, if not move to other side

class Solution {
    public int search(int[] nums, int target) {

      if(nums == null || nums.length == 0) return -1;

      int start = 0 ;
      int end = nums.length -1;
      int mid  = start + (end - start)/2;

      while(start <= end){
        mid  = start + (end - start)/2;
        if(nums[mid] == target) return mid;

        if(nums[mid] <= nums[end]){
          if(nums[mid] <= target && target <= nums[end]){
            start = mid + 1;
          }
          else{
            end = mid -1;
          }
        }

        if(nums[start] <= nums[mid]){
          if(nums[start] <= target && target <= nums[mid]){
              end = mid -1;
          }
          else{
              start = mid + 1;
          }
        }
      }
      return -1;
    }
}
