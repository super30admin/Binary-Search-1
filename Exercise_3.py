"""
Time Complexity:    O(n)
Space Complexity:   O(1)
Cant tell if it ran or not, Couldnt do it in O(logn)

Approach - My approach is pretty simple, keep running the while loop until target is found.
"""

class Solution:
    def search(self, reader, target):
        i = 0
        while True:
            v = reader.get(i)
            if v == 2147483647:
                return -1
            if v == target:
                return i
            i += 1
        return -1
