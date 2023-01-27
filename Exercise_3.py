# Time Complexity : O(logN), N being the index of the target.
# Space Complexity : O(1), because not allocating new space in the functions, input and 
# output do not count. 
# Did this code successfully run on Leetcode : No, I do not have premium. 
# Any problem you faced while coding this : I had an issue in the beginning with the 
# infinity length and how not to get an error if I don't know the length. I wasn't sure
# about the problem statement. 


# Your code here along with comments explaining your approach in three sentences only
'''Used binary search, multiplying left and right indices by two, to find the range target
falls under. Then, use binary search to search through the range. 
'''

# Problem: Given a sorted array of unknown length and a number to search for, return the 
# index of the number in the array. Accessing an element out of bounds throws exception. 
# If the number occurs multiple times, return the index of any occurrence. If it isn’t 
# present, return -1.

class Solution: 
    # basic binary search. 
    def binarySearch(self, nums, target, left, right):
        mid = int((left+right)/2)
        if (right-left)<=1:
            if nums[left]==target:
                return left
            elif nums[right]==target:
                return right
            else:
                return -1
        else:
            if nums[left]<=target and nums[mid]>=target:
                return self.binarySearch(nums, target, left, mid)
            else:
                return self.binarySearch(nums, target, mid+1, right)

    def searchInfiniteArray(self, nums, target):
        #find the left and right values where target would fall between 
        # by doubling the right index. 
        left = 0
        right = 0
        while(not (nums[left]<=target and target<=nums[right])):
            left = right
            right = (1+right)*2-1
        # basic binary search with left and right values. 
        result = self.binarySearch(nums, target, left, right)
        print(result)

            

s = Solution()
a = [1,2,5,8,11,13,18, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
s.searchInfiniteArray(a, 11)       