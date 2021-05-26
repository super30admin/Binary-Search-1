# Time Complexity : )(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took sometime to solve

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        a = self.conversionPoint(nums,0,len(nums)-1)
        print(a)
        if a == -1:
            return self.binarySearch(nums,0,len(nums)-1,target)
        else:
            if target >= nums[0] and target <= nums[a-1]:
                return self.binarySearch(nums,0,a-1,target)
            else:
                return self.binarySearch(nums,a,len(nums)-1,target)
        
    def conversionPoint(self,nums,l,r):
        if l == r-1:
            return r
        mid = (l + r) //2
        if nums[mid] < nums[l]:
            return self.conversionPoint(nums,l,mid)
        elif nums[mid] > nums[r]:
            return self.conversionPoint(nums,mid,r)
        else:
            return -1
    def binarySearch(self,a,l,r,t):
        if l > r:
            return -1
        else:
            mid = (l+r)//2
            if a[mid] == t:
                return mid
            if a[mid] > t:
                return self.binarySearch(a,l,mid-1,t)
            else:
                return self.binarySearch(a,mid+1,r,t)
            
               
