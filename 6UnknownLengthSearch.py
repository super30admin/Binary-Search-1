"""
Not in LC
// Time Complexity :O(Log n) Binary search is used
// Space Complexity :O(1) No extra space is used.
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :

// Explanation:
#BF: Since the array is sorted, calculate the maximum number from array and compare
each number in array with target. T=O(n)

#Optimized solution using binary search:
slow,high = 0,1
if high < target -> high = slow * 2 and slow = high


"""
class Solution:
  def modifiedBinarySearch(self,nums,target):
    # Edge case
    if (len(nums) == 0 or nums is None):
        return -1

    low,high = 0,1
    while (nums[high] < target):
        print(low, high,",",nums[low],nums[high])
        low = high
        high = 2 * high
    return self.BinarySearch(nums, low,high,target)

  def BinarySearch(self,nums, low,high,target):

      while(low <= high):
        mid = int(low + (high-low)/2)

        if nums[mid] == target:
          return mid
        elif target < nums[mid]:
          high = mid-1
        else:
          low = mid+1
      return -1




if __name__ == "__main__":
  s = Solution()
  nums = [1,3,6,9,12,15,18,21,24,27,30,33]
  target = 27
  print("Idx=",s.modifiedBinarySearch(nums,target))
