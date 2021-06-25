class Solution:
    
    def getPivot(self, nums, l, r):
        while l<r:
            mid = (l+r)//2 

            if (nums[mid]>nums[mid+1]):
                return mid
            elif (nums[mid]>nums[l]):
                l = mid + 1
            elif (nums[mid]<nums[l]):
                r = mid - 1
    
    def binarySearch(self, arr, l, r, x):
        while l<r:
            mid_point = (l+r)//2

            if (x == arr[mid_point]):
                return mid_point
            elif (x < arr[mid_point]):
                r = mid_point - 1
            else:
                l = mid_point + 1

        return -1
        
    def search(self, nums, target):
        pivotValue = self.getPivot(nums, 0, len(nums)-1)
        if (nums[pivotValue]>target):
            self.binarySearch(nums, 0, pivotValue -1, target)
        elif(nums[pivotValue]<target):
            self.binarySearch(nums, pivotValue+1, len(nums) - 1, target)
        elif(nums[pivotValue] == target):
            return pivotValue
        else:
            return -1