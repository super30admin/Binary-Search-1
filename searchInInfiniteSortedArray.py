# Exercise_3: Search in Infinite Sorted Array
# Time Complexity: O(log(N)), where N is the index of the target
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
# Challenges: None

# Coding Approach:
# If the array is empty, return -1
# Set low to 0 and high to 1 (since the array is infinite)
# While the value at the high index is less than the target, set low to high and high to high * 2 (increase the search space)
# While low is less than or equal to high, compute the mid index
# If the value at the mid index is equal to the target, return mid
# If the value at the mid index is greater than the target, set high to mid - 1 (search left since all values to the right are greater)
# If the value at the mid index is less than the target, set low to mid + 1 (search right since all values to the left are lesser)
# Return -1 if the target is not found

def search(reader, target):
    if reader == None:
        return -1
    low = 0
    high = 1
    while reader.get(high) < target:
        low = high
        high = high * 2
    while low <= high:
        mid = low + (high - low)//2
        if reader.get(mid) == target:
            return mid
        elif reader.get(mid) > target:
            high = mid - 1
        else:
            low = mid + 1
    return -1

