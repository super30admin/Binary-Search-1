def binarySearch(reader,target,low,high):
    while low <=high:
        mid = low + (high-low)//2
        if reader.get(mid) == target:
            return mid
        elif target > reader.get(mid):
            low = mid + 1
        else:
            high = mid - 1
    return -1
def searchInInfiniteArray(reader,target):
    # Tc: O(log n)
    # SC: O(1)
    low,high = 0,1
    while reader.get(high) < target:
        low = high
        high = high *2
    if reader.get(high) == target:
        return high
    return binarySearch(reader,target,low,high)