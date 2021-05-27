"""
time: O(logn)
space: O(1)
Leet : Problem not from leetcode
Problems faced: No problems.
"""
def infiniteBinary(nums,target):
    slow = 0
    fast = 1
    try:
        while nums[fast] < target:  #find the region where target might exist
            slow = fast #this eliminates unnecessary checking as we know for sure that this element is smaller
            fast *= 2 
    except KeyError:
        try:
            while(True): #apply linear search only on certain area
                if nums[slow]==target:
                    return slow
        except KeyError:
            return None
        

    if nums[fast] == target:
        return fast
    return binSearch(nums,slow,fast,target) #apply binary search if region is known

    def binSearch(arr,low,high,target): 

        while low<=high:
            mid = (low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
