#Problem 3
#Using binary search method.
#T: O(log k), where k is the index of target.
#S: O(1)


class Solution(object):
    def search(self, reader, target):
        l, r = 0, 1
        while reader.get(r) < target:
            l = r
            r = 2 * r

        while l <= r:
            m = (l + r) // 2
            if reader.get(m) < target:
                l = m + 1
            elif reader.get(m) > target:
                r = m - 1
            else:
                return m

        return -1
