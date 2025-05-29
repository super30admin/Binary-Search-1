class Solution:
    def searchUnknownLengthArray(self,getElement,target):
        low,high=0,1
        while True:
            try:
                val=getElement(high)
                if val>=target:
                    break
                low=high
                high*=2
            except IndexError:
                break
        
        while low<=high:
            mid=(low+high)//2
            try:
                val=getElement(mid)
                if val==target:
                    return mid
                elif val<target:
                    low=mid+1
                else:
                    high=mid-1
            except IndexError:
                high=mid-1

        return -1

arr=[-1,0,3,5,9,12]
def getElement(index):
    if index>=len(arr):
        raise IndexError()
    return arr[index]

sol=Solution()
print(sol.searchUnknownLengthArray(getElement, target = 9))
print(sol.searchUnknownLengthArray(getElement, target = 2))



