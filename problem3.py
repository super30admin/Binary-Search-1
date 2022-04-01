
# Search in Infinite sorted array: 

#havent figured out the best way to do it yet

def searchUnknown(nums, target):
    for i, n in nums:
        if(n == target):
            return i
    return -1

