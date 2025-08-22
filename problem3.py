"""
Space Complexity: O(1): No extra memory to store the elements, we just use the reader class to get the data 
Time Complexity: O(log(n)): We search by increasing the search space by twice, which is binary search. Hence, the complexity is logarithmic. 
"""
low = 0
high = 1

while reader.get(high) < target:
    low = high
    high = 2 * high

while low <= high:
    mid = low + (high - low) // 2
    if reader.get(mid) == target:
        return mid
    elif reader.get(mid) > target:
        high = mid - 1
    else:
        low = mid + 1

return -1

