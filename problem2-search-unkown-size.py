# Time Complexity : O(Log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

def search(self, reader, target):
    left = 0
    right = 10 ** 4 # MAX
    while left <= right:
        middle = (left + right) // 2
        number = reader.get(middle)
        if number == target:
            return middle
        # [1,2,3,4,5,6]
        elif number < target:
            left = middle + 1
        else:
            right = middle - 1
    return -1
