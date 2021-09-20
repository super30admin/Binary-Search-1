"""
#Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
# Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence.
# If it isn’t present, return -1.

# we will expand our range by multyping high by factor of 2 and set low as high in each iteration. and find the low and high range

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Didn't try
// Any problem you faced while coding this :  Yes, in finding the Time Complexity  and the range of array
 """
class Solution:
    def Search_Infinite(self,nums,target):
        low=0   # intialise low as 0
        high=2   # high as 2
        try:     #The try block lets you test a block of code for errors. The except block lets you handle the error.
            while nums[high]<target:   # if target is less than nums[high] we got to except part
                low=high
                high=high*2
        except Exception as e:
            try:        #
                high=low+1
                while nums[high] < target:
                    low=high
                    high=high*2
            except:
                pass
        return self.BS(nums,target,low,high)

    def BS(self,nums,target,low,high):     # normal BS
        while low <= high:
            mid=low+(high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high=mid-1
            else:
                low=mid+1
        return -1

if __name__ == '__main__':
    binary=Solution()
    print(binary.Search_Infinite([2,4,5,11,15,17,18,19,20,23,24,26,28,30], 28))
    print(binary)
















