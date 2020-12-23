class Solution:
    def search(self, A: List[int], x: int) -> int:
        low=0
        high=len(A)-1
        while low<=high:
            mid=(low+high)//2
            if x==A[mid]:
                return mid
            elif A[mid]<A[high]:##mid lies in vcthe right half!!
                if x<=A[high] and x>A[mid]:
                    #go towards right and now search here 
                    low=mid+1
                else:
                    high=mid-1
            else:
                if x>=A[low] and x<A[mid]:
                    #go towards right and now search here 
                    high=mid-1
                else:
                    low=mid+1
        return -1
