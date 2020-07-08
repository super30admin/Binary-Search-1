# Time complexity - O(logn)
# Space complexity - O(1)
# Works on leetcode - yes 

class Solution:
    #Function to search in a rotated sorted array. We find the middle element in array, resulting in 3 cases
    # case1 - return mid if the mid element is the target, case2  - if left element is less than equal to mid element
    # we know that the point of rotation is in right of mid and we adjust left and right indices based on 
    # where target lies in the array, case3 - if mid element is less than left element, we know the point of rotation is some
    # where left of mid and we try to fit the target and adjust left and right indices accordingly 
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0,len(nums)-1
        while l<=r:
            mid = l + (r-l)//2
            if nums[mid]==target:
                return mid
            elif nums[l]<=nums[mid]:
                if nums[l]<=target<=nums[mid]:
                    r = mid-1
                else:
                    l = mid+1
            else:
                if nums[mid]<=target<=nums[r]:
                    l=mid+1
                else:
                    r=mid-1
        return -1