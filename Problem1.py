#Time Complexity-O(logn)
#Space Complexity-O(n)
class Solution:
    def search(self, nums, target):
        if not nums:
            return -1
        return self.binarySearch(nums, target, 0, len(nums)-1)
    
    def binarySearch(self, nums, target, start, end):
        if start<=end:
            mid=start+(end-start)//2
            if nums[mid]==target:
                return mid
            if nums[start]<=nums[mid]:
                if target<nums[mid] and target>=nums[start]:
                    return self.binarySearch(nums, target, start, mid-1)
                else:
                    return self.binarySearch(nums, target,mid+1, end)
            else:
                if target<=nums[end] and target>nums[mid]:
                    return self.binarySearch(nums, target, mid+1 ,end)
                else:
                    return self.binarySearch(nums, target,start,mid-1)
        return -1

obj=Solution()
output=obj.search([4,5,6,7,0,1,2],0)
print(output)

