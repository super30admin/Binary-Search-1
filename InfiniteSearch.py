# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def search(self, nums, target):
        if not nums:
            return -1 
        i = 0 
        j = 1 
        val = nums[0]
        while val < target:
            i = j 
            j = j * 2
            val = nums[j]    

        return self.binarySearch(i,j,nums,target)

    # Iterative
    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # def binarySearch(self,i,j,nums,target):
    #     while i <= j:
    #         mid = (i+j)//2
    #         if nums[mid] == target:
    #             return mid 
    #         elif nums[mid] < target:
    #             i = mid + 1 
    #         else:
    #             j = mid - 1
    #     return -1 

    # Recursive 
    # Time Complexity : O(n)
    # Space Complexity : O(n)
    def binarySearch(self,i,j,nums,target):
        if i > j:
            return -1 
        
        mid = (i+j)//2
        if nums[mid] == target:
            return mid 
        elif nums[mid] < target:
            return self.binarySearch(mid+1,j,nums,target)
        else:
            return self.binarySearch(i,mid-1,nums,target)
        
if __name__ == "__main__":
    bs = Solution()
    nums = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170] 
    print(bs.search(nums,10))
