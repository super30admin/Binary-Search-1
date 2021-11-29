
# Time Complexity : O(log(T))  T is index of target
# Space Complexity : 0(1)

# Did this code successfully run on Leetcode : 
# cannot check 

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach


# Leetcode problem ( shared because it is not accessible in leetcode without subscription )

class Solution:
    def search(self, reader, target):
        l=0
        r = 1
        while reader.get(r) <target:
            #l = r  This does not work
            r *=2
        if reader.get(l) == target:
            return l
        if reader.get(r) == target:
            return r        
        while l+1 < r:
            mid = l+(r-l)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) <target:
                l = mid
            else :
                r = mid    


'''
# You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

# returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
# returns 231 - 1 if the i is out of the boundary of the array.
# You are also given an integer target.

# Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

# You must write an algorithm with O(log n) runtime complexity.


# Example 1:

# Input: secret = [-1,0,3,5,9,12], target = 9
# Output: 4
# Explanation: 9 exists in secret and its index is 4.
# Example 2:

# Input: secret = [-1,0,3,5,9,12], target = 2
# Output: -1
# Explanation: 2 does not exist in secret so return -1.


# Constraints:

# 1 <= secret.length <= 104
# -104 <= secret[i], target <= 104
# secret is sorted in a strictly increasing order.
'''