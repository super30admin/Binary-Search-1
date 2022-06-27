class Solution {

    public int search(int[] nums, int target) {

       int mid;

       int left = 0;

       int right = nums.length - 1;

       while(left <= right){

           mid = left +  (right-left) /2;

           if(nums[mid] == target) return mid;

           // if left array is sorted

           if(nums[left] <= nums[mid]){

               if(target >= nums[left]  && target <= nums[mid] )
                   right= mid -1;
               else
                   left = mid + 1;
           }
           //right array is sorted
           else {
               if(target >= nums[mid]  && target <= nums[right])
                   left= mid +1;
               else
                   right = mid - 1;
           }

       }

       return -1;

   }

}