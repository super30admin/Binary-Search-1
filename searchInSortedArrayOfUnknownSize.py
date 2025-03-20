# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. We need to ideantify the search range to apply binary search.
# 2. We start with left = 0 and right = 1, and keep increasing the search space by twice until we find a range which may or may not include the target element.
# 3. Once we find the range, we apply binary search to find the target element.

class SearchSecret:
    def search(self, reader, target):
        # find the search space
        l, r = 0, 1
        # keep doubling the search space until we find the range which may or may not include the target element
        while reader.get(r) < target:
            l = r
            r = r*2
        # apply binary search
        while l <= r:
            mid = l + (r-l)//2
            if reader.get(mid) == target: return mid
            if reader.get(mid) < target:
                l = mid + 1
            else:
                r = mid - 1
        return -1
    
# Please ignore the below comments, if any. Just for my reference.
# It is important to apply binary search to find the search space as well as to find the target element within the search space,
# as it helps in achieving a time complexity of O(log n).
# The time complexity will depend on:
# 1. The number of steps to find the search space: O(log n)
# 2. The number of steps to find the target element within the search space: O(log k), where k is the search space.
# The overall time complexity will be O(log n + log k) = O(log n).
# If we do not apply binary search to find the search space, and take the high pointer as 9999 (as given in the problem statement), the time complexity will be O(log 10000). But what if the secret array size is much less than 10000?
# We will be wasting a lot of time in getting to the search space, reducing in half every time.
# Hence, it is important to apply binary search to find the search space as well.
# Same goes for if we increase the search space by 10 times, instead of 2 times. The time complexity will be O(log n + log (n/10)) = O(log n).