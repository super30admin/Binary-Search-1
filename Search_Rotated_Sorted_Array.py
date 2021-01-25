class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0,len(nums)-1
        while l<=r:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            #we are in the left-hand sorted array
            if nums[mid] >= nums[l]:
                if target > nums[mid] or target < nums[l]:
                    l =mid +1
                else:
                    r=mid -1
            #we are in the right-hand sorted array
            else:
                if target < nums[mid] or target >nums[r]:
                    r=mid-1
                else:
                    l=mid+1
        return -1