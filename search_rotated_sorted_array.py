'''
To search for an element in rotated sorted array using binary search, we compute mid and check if target is reached, else we first check which side of array beside mid is sorted, as atleast one side will be sorted. To check which side is sorted, just compare low and high extremes with mid. If our target lies on the sorted side, move towards the sorted side, else opposite the sorted side. If element is not present after coming out of loop return -1.

Time Complexity: O(log(n))
Space Complexity: O(1)

Passes all testcases in leetcode

'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            print("mid ",mid)
            if target == nums[mid]:
                print("reached mid")
                return mid
            
            elif nums[mid]>=nums[low]:
                if target>=nums[low] and target<nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid]<=nums[high]:
                if target<=nums[high] and target>nums[mid]:
                    low = mid + 1
                
                else:
                    high = mid - 1
        return -1
