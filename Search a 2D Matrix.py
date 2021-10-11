class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        for i in range(len(matrix)):
            if target<=matrix[i][len(matrix[0])-1]:
                for j in range(len(matrix[0])):
                    start=0
                    end=len(matrix[0])-1
                    while(start<=end):
                        mid=(start+end)//2
                        if matrix[i][mid]>target:
                            end=mid-1
                        elif matrix[i][mid]==target:
                            return True
                        elif matrix[i][mid]<target:
                            start=mid+1
        return False

#Space complexity: O(1)
# Time complexity: O(m+log(n))