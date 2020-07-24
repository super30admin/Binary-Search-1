import java.util.*;
import java.io.*;

class SearchRotatedArray{
  public int search(int[] nums, int target){
    int low=0;
    int high =nums.length-1;
    if(low<=high){
      int mid=low+(high-low)/2;

      if(nums[mid]==target){
        return mid;
      }
      // left sorted
      else if(nums[low]<nums[mid]){
        return binarySearch(nums, target, low, mid-1);
      }
      // right sorted
      else
      return binarySearch(nums, target, mid+1, high);
    }
    return -1;
  }

    public int binarySearch(int[] nums, int target, int low, int high){
      while(low<=high){
        int mid;
        mid=(low+(high-low))/2;

        if(nums[mid]==target){
          return mid;
        }
        else if(nums[mid]>target){
          high=mid-1;
          // binarySearch(ArrayReader reader, int low, int high, int target);
        }

        else{
          low=mid+1;
          // binarySearch(ArrayReader reader, int low, int high, int target);
        }
      }
      return -1;
    }
}
