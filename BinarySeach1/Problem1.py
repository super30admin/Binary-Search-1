#Time Complexity: O(log(n))
#Space Complexity: O(1)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:
#ITERATIVE SOLUTION
def search(self, nums: List[int], target: int) -> int:
    #once we found the sorted part, we check if it's in here
    #and do normal binary search
    #if not we just take the unsorted part and redo the loop
    #until it is in a sorted part and we can find it
    low=0
    high=len(nums)-1
    while high>=low:
        mid=int(low+(high-low)/2)
        if nums[mid]==target:
            return mid
        if (nums[low]<=nums[mid]):
            #left side is sorted
            if target>=nums[low] and target<nums[mid]:
                high=mid-1
            else:
                low=mid+1
        else:
            #right side is sorted
            if target>nums[mid] and target<=nums[high]:
                low=mid+1
            else:
                high=mid-1
    return -1
    #time complexity O(log(n)), space O(1)
