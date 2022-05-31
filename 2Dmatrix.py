class Solution:
    def bisearch(self,nums,target)->bool:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+high-low//2
            if nums[mid]==target: return True
            elif nums[mid]>=target:
                high=mid-1
            elif nums[mid]<=target:  
                low=mid+1
        return False
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            low=0
            high=len(matrix[i])-1
            if matrix[i][low]<=target and target<=matrix[i][high]:
                ans=self.bisearch(matrix[i],target)
                return ans