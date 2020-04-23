#Search in Infinite sorted array:

#Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
#Time Complexity :O(log n)
#Space Complexity :O(1)



#Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
#if it is greater than high index element then copy high index in low index and double the high index.
#if it is smaller, then apply binary search on high and low indices found.

class Solution:

def binarySearch(nums, low, high, target):
    if high>=low:
        mid=high+(low-high)//2
        
    if nums[mid]==target:
        return mid
    if nums[mid]>target:
        return binarySearch(nums, low, mid-1, target)
    else:
        return binarySearch(nums, mid+1, high, target)
    return -1
    
def search(self, nums: List[int], target: int) -> int:
  low=0
  high=1
  val=nums[0]
  
  while val<=target:
    low=high
    high=2*high
    val=nums[high]
     
return binarySearch(nums, low, high, target)

