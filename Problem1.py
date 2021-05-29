# Time Complexity : O(logm) + O(logn) m is rows and n is columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took sometime to solve

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        fr = []
        for i in matrix:
            fr.append(i[0])
        print(fr)
        a = self.approximateBinarySearch(target,fr,0,len(fr)-1)
        print(a)
        if a == -1:
            return False
        b = self.binarySearch(target,matrix[a],0,len(matrix[a])-1)
        if b == -1:
            return False
        return True
    def binarySearch(self,target,a,l,r):
        if l > r:
            return -1
        else:
            mid = (l + r) // 2
            if a[mid] == target:
                return mid
            elif a[mid] > target:
                return self.binarySearch(target,a,l,mid-1)
            else:
                return self.binarySearch(target,a,mid+1,r)
    
    def approximateBinarySearch(self,target,a,l,r):
        print(l,r)
        if l == r:
            if a[l] <= target:
                return l
            elif a[l] > target:
                return l-1
        if l > r:
            if a[l] > target:
                return l-1
            else:
                return -1
        mid = (l+r)//2
        if a[mid] == target:
            return mid
        elif a[mid] > target:
            return self.approximateBinarySearch(target,a,l,mid-1)
        else:
            return self.approximateBinarySearch(target,a,mid+1,r)
        
        