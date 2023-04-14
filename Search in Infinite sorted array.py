#Time Complexity:O(logn)
#Space Complexity:O(1)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        h=1
        x=-1
        while (h<len(nums) or target<nums[h]):
            x=self.binarySearch(nums,l,h,target)
            if x!=-1:
                return x
            else:
                l=h
                h=h*2
        return -1
    
    def binarySearch(self,nums,l,h,target):
        while(l<=h):
            mid=(l+h)//2
            if nums[mid]<target:
                l=mid+1
            elif nums[mid]>target:
                h=mid-1
            else:
                return mid+1
        return -1
    
a=Solution()
nums=[1,2,3,5,6,7,8,9,10]
print(a.search(nums,9))
