//in leetcode, code executed

import java.util.*;
import java.io.*;

class SearchRotatedArray{
  public int search(int[] nums, int target){
    int low=0;
    int high =nums.length-1;
    while(low<=high){
      int mid;
      mid =low+(high-low)/2;
      if(nums[low]<nums[mid]){
        if(nums[low]<=target&&nums[mid]>target){
          high=mid-1;
        }
        else
        low=mid+1;
      }
      else if(nums[mid]<nums[high]){
        if(nums[high]>=target&&nums[mid]<target){
          low=mid+1;
        }
        else
        high=mid-1;
      }
      else
      return nums[mid];
    }
    return -1;
  }
}
