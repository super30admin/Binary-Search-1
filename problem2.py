class Solution:
    def search(self, nums: List[int], target: int) -> int:
        print(nums,target)
        #find pivot
        pivot=-1
        start=0
        end=len(nums)-1
        while(start<end):
            
            mid=(start+end)//2
            
            if nums[mid]>nums[mid+1] or nums[mid]<nums[mid-1]:
                pivot=mid
                break
            elif nums[mid]<=nums[len(nums)-1]:
                end=mid-1
            elif nums[mid]>nums[len(nums)-1]:
                start=mid+1
        
        if pivot==-1:
            pivot=0
        
        if target==nums[pivot]:
            return pivot
        elif target>nums[len(nums)-1]:
            return self.findNumber(0,pivot-1,nums,target)
        else:
            return self.findNumber(pivot+1,len(nums)-1,nums,target)
    def findNumber(self,start,end,nums,target):
        while(start<=end):
            mid=(start+end)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                end=mid-1
            else:
                start=mid+1
        return -1
        
 #Time complexity O(log n)
 #Space complexity O(1)
 #Leetcode https://leetcode.com/submissions/detail/512719459/
