class Solution:
    def search(self, nums, target):
        if not nums:
            return -1 

        i = 0 
        j = len(nums) - 1 
        while i <= j:
            mid = (i+j) //2 
            if nums[mid] == target:
                return mid 
            
            if nums[i] <= nums[mid]:
                if nums[i] <= target <= nums[mid]:
                    j = mid -1 
                else:
                    i = mid + 1 
            else:
                if nums[mid] <= target <= nums[j]:
                    i = mid + 1 
                else:
                    j = mid - 1 
        return -1 
        
if __name__ == "__main__":
    bs = Solution()
    nums = [4,5,6,7,0,1,2]
    print(bs.search(nums,6))
