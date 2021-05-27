//Time Complexity - O(logN)
//Space Complexity - O(1)

class SearchRotatedSortedArray {
  public int search(int[] nums, int target) {
      int start = 0, end = nums.length - 1;

      while(start <= end){
          int mid = (start + end)/2;

          if(nums[mid] == target)
              return mid;
          else if(nums[mid] >= nums[start]){
              //left side of the array
              if(target >= nums[start] && target < nums[mid])
                  end = mid - 1;
              else
                  start = mid + 1;  //right side of the array
          }else{
              if(target <= nums[end] && target > nums[mid])
                  start = mid + 1; //right side of the array
              else
                  end = mid - 1; //element on the left side of array
          }
      }

      return -1;
  }
}
