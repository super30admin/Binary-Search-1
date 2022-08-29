# Time Complexity : O(log (n * m) = O(log(n)+ log(m)) where n is toatl number of ele and m is no of time high is multiplying by 2
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (Premium)
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
def searchInfiniteSorted(target):
    low = 0
    high = 1
    while(high < target):
        low = high
        high = 2 * high
    while(low < high):
        mid = low + (high - low) // 2
        if (mid == target):
            return mid
        elif mid > target:
            high = mid - 1
        else:
            low = mid + 1
    return -1