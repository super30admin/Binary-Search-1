
# Search in Infinite sorted array: 


# // Time Complexity :O(Log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :couldnt find the optimal solution first, but we went over in the class and it was very clear


def searchUnknown(nums, target):
    low=0
    high=1
    value = nums[0]
    while(value < target):
        low=high                                    #set low to the old high 
        high=high*2                                 #keep increasing the high value by *2 so that you get logn time and also cover the array fast
        value=nums[high]
    return binary_search(nums, target, low, high)       #once you find the range, then you can do a regular binary search

def binary_search(nums, target, low, high):
    while(low<=high):
        mid=low+(high-low)//2
        if (nums[mid]==target):
            return mid
        elif(nums[mid]<target):
            low=mid+1
        else:
            high=mid-1
    return -1


print(searchUnknown([2,4,6,7,8,9,12,15,17,19], 8))  #returns 4
        


