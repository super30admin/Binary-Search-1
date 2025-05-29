# Time Complexity : O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Tied it locally
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach in three sentences only
    # Start with a high pointer at 1st index
    # If high is less than target double it everytime as soon as high is greater than target we have a range
    # Then just perform binary search using low and high


def func(reader,target):
    low = 0
    high = 1
    while reader[high] < target:
        low = high
        high = high * 2
    while low <= high:
        mid = low + (high - low)//2
        if reader[mid] == target:
            print(mid)
            return
        elif reader[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    if reader[low] == target:
        print(low)
    print(-1)
    return


reader = [1, 3, 5, 7, 9, 12, 15, 20]
target = 8 
func(reader,target)