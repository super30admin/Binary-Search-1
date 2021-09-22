//TC:O(logn)
//SC:O(1)

//code
def search(self, nums: List[int], target: int) -> int:
  low=0
  high=len(nums)-1

  while(low<=high):

      mid=low+(high-low)//2

      if (nums[mid]==target):
          return mid

      #left part of the array is sorted
      elif (nums[low]<=nums[mid]):
          if(target>=nums[low] and target<nums[mid]):
              high=mid-1
          else:
              low=mid+1

      #Right part of the array is sorted
      else:
          if(target<=nums[high] and target>nums[mid]):
              low=mid+1
          else:
              high=mid-1


  return -1
