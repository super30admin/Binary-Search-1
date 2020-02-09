# // Time Complexity : O(logn) as it is using binary search.
# // Space Complexity : O(1) constant time as it is not using any auxilary memory.
# // Did this code successfully run on Leetcode : It is working successfully because i have checked for most of the edge cases.
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# In this problem we cannot take high as the length of the array since it is a infinte array.so we take hops till we reach near the target element.when we get the low and high indices from the hop we perform binary search in that range and check if the element is #present or not and then return the index of the element from the array.

class search_infinite:
    def __init__(self,nums,target):
        self.nums=nums
        self.target=target

    def bst(self,low,high):
        if low>high:
            return -1
        mid=int(low+((high-low)/2))
        if self.nums[mid]==self.target:
            return mid
        elif target>nums[mid]:
            low=mid+1
        else:
            high=mid-1
        return self.bst(low,high)

    def search_element_infinite_sorted(self):
        low=0
        high=low+1
        if len(self.nums)==0:
            return -1
        while self.nums[high]<=self.target:
            low=high
            high=2*high
        return self.bst(low,high)

nums=[3,5,7,10,11,12,15,19]
target=7
search1=search_infinite(nums,target)
print(search1.search_element_infinite_sorted())