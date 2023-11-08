# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we devide the problem space into two halves using the mid pointer and discard one half of the problem by chekcing in which half the target value falls in. and update 
# the boundaries of start and end according to which half gets selected. 
left, right = 0, 20000
while left < right:
    mid = (left + right) >> 1
    if reader.get(mid) >= target:
        right = mid
    else:
        left = mid + 1
return left if reader.get(left) == target else -1