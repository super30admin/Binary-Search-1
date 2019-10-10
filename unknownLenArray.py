class Solution:
    def binSearch(self,nums,target,low,high):


        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1


    def modifiedBinSearch(self,nums,target):
        low = 0
        high = low+1
        while target > nums[high] :
            low = high
            high = high *2
        return self.binSearch(nums,target,low,high)

obj = Solution()
print("Found at index : {}".format(obj.modifiedBinSearch([1,2,3,5,7,9,10,11,12],7)))
print("Found at index : {}".format(obj.modifiedBinSearch([1,2,3,5,7,9,10,11,12],0)))
