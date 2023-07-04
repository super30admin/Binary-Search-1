# Time: O(log(mn))
# Space: O(1)
# Did this problme run sussceesfully on leetcode: yes
# approach:
# binary search on the rows to find out the potential row.
# then binary search in that row.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rl, rr = 0, len(matrix) - 1
        while rl <= rr:
            rm = (rl + rr) // 2
            if target < matrix[rm][0]:
                rr = rm - 1
            elif target > matrix[rm][-1]:
                rl = rm + 1
            else:
                cl, cr = 0, len(matrix[0]) - 1
                while cl <= cr:
                    cm = (cl + cr) // 2
                    if target == matrix[rm][cm]:
                        return True
                    elif target > matrix[rm][cm]:
                        cl = cm + 1
                    else:
                        cr = cm - 1
                return False