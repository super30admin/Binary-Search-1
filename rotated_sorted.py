# Time Complexity :O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
def search(nums,n,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            elif target>nums[high] and target<nums[low]:
                return -1
            if nums[low]<=nums[mid]:
                if nums[low]<=target<=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if nums[mid]<=target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1

nums = [5, 6, 7, 8, 9, 10, 1, 2, 3]
n = len(nums)
target = 3
print("Index of the element is : ",
      search(nums, n, target))