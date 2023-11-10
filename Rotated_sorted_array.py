class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left=0
        right=len(nums)-1
        while left<=right:
            mid=(left+right)//2
            if nums[mid]==target:
                return mid
            elif nums[left]<=nums[mid]:
                if nums[left]<=target and target<nums[mid]:
                    right=mid-1
                else:
                    left=mid+1
            else:
                if nums[right]>=target and nums[mid]<target:
                    left=mid+1
                else:
                    right=mid-1
            print(str(left)+" "+str(right)+" ")
        return -1
        