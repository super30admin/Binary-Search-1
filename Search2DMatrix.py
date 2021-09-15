"""
Time Complexity:
O(m) + O(logn)
Space Complexity:
O(1)
"""

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        ml = 0
        mr = len(matrix)-1
        while ml <= mr:
            print(ml,mr)
            mmid = int((ml + mr)/2)
            if matrix[mmid][0] == target:
                return True
            elif matrix[mmid][0] < target:
                check = matrix[mmid]
                print(check)
                l = 0
                r = len(matrix[mmid]) - 1
                while l <= r:
                    print(l,r)
                    mid = int((l + r)/2)
                    if check[mid] == target:
                        return True
                    elif check[mid] > target:
                        r = mid - 1
                    else:
                        l = mid + 1
                print(l,r)
                ml = mmid + 1
            else:
                mr = mmid -  1
        return False
        
        