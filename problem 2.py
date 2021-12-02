
# // Time Complexity :O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        # binary search condition to break loop

        while low<=high:
            mid=(low+high)//2 #finding new mid
            # if found element return 
            if nums[mid]==target:
                return mid
            else:
                # if left part sorted move left
                if nums[low]<=nums[mid]:
                    # if element is in the sorted part
                    if nums[low]<=target and nums[mid]>target:
                        high=mid-1
                    # if not
                    else:
                        low=mid+1
                # element is not in the sorted part then in nor sorted part
                else:
                    # if in unsoted 
                    if nums[mid]<target and target<=nums[high]:
                        low=mid+1
                    # if not in unsorted 
                    else:
                        high=mid-1
        # if not found
        return -1