# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach



class Solution(object):

    def search(self,nums,target):
        low = 0
        high = 1
        value = nums[0]
        while value < target:
            low = high
            high = 2*high
            value = nums[high]
            

        return self.binarysearch(nums,target,low,high)
    
    def binarysearch(self,nums,target,low,high):
        
        while low<=high:
            mid = (low+high)//2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
        return -1

def main():
    nums = [1,2,3,4,5,6]
    target  = 5
    result = Solution().search(nums,target)
    print(result)

if __name__ == "__main__":
    main()