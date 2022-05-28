# time complexity to search the target is o(log(n))
# space complexity o(1)
def infiniteArray(reader, target):
    low = 0
    high = 1
    while(reader.get(high) <= target):
       low = high
       high = 2*high
    while(low <= high):
        mid = low + (high - low)//2
        if(reader.get(mid) == target):
            return mid
        elif(reader.get(mid) < target):
            low = mid + 1
        else:
            high = mid - 1
    return -1