# time complexity - O(log(N))
# 2 pointer approach to find target in infinite length array.
# First we assign low as 0 index and high as 1, then double the high everytime and move the low to high until the
# target is less than selected high.
# then will perform normal binary search to find the element.
def BinarySearch(arr, target, low, high):
    while low <= high: # until all the elements are checked.
        mid = low + (high-low)//2 # mmid is calculated this way so as to avoid integer overflow(usually happens in java).
        # 3 conditions to verify if the target is greater than, less than or equal to the number at mid.
        # If equals return mid , if greater => low = mid +1, if lesser => high = mid - 1
        if target == arr[mid]:
            return mid
        elif target > arr[mid]:
            low = mid+1
        else: high = mid + 1
    return -1
def ModifiedBinarySearch(arr, target):
    low = 0
    high = low + 1 # So as to avoid zeros for high ( if low and high at 0 , high *2 gives zero again)
    temp = arr[0]
    while temp < target:
        low = high
        high = high * 2
        temp = arr[high]
    # once the low and high are found where the target is in between those 2 markers, we will perform
    # normal binary search to find the index of target.
    return BinarySearch(arr, target, low, high)


mbs = ModifiedBinarySearch([2,5,6,8,9,12,14,15,17], 15)
print(mbs)

