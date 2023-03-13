#Time complexity : Find smallest takes O(logn) time. binary_search takes O(logn) time. Search method takes O(logn+logn) =O(logn) time
#Space complexity : No extra space used. Hence O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        pivot = self.find_smallest(nums)
        if(len(nums)==1):
            if(nums[0]==target):
                return 0
            else:
                return -1
        if(nums[pivot]==target):
            return pivot
        if(pivot==0):
            return self.binary_search(0,n-1,nums,target)
        if(target<nums[0]):
            return self.binary_search(pivot,n-1,nums,target)
        else:
            return self.binary_search(0,pivot,nums,target)
        return -1
          

    def binary_search(self,left,right,nums : List[int],target) -> int:
        while(left<=right):
            mid = (left+right)//2
            if(nums[mid]==target):
                return mid
            else:
                if(target>nums[mid]):
                    left = mid+1
                else:
                    right = mid-1
        return -1





    def find_smallest(self,nums:List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        if(nums[low]<nums[high]):
            return low
        while(low<=high):
            mid = (low + high)//2
            if(nums[mid]>nums[mid+1]):
                return mid+1
            #if(nums[mid-1]>nums[mid]):
             #   return mid
            if(nums[mid]>nums[low]):
                low = mid+1
            else:
                high = mid-1