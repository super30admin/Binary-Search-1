#Sorted infinite array and target is given.
#Considered infinite array and the target is compared for every 10th element in the array
#Linear search is performed.
#Time complexity is O(n)
class Solution:
    def InfiniteSortedArray(self, array: List[int],target: int)-> int:
        low=0
        while(array[low+10]<=target):
            low=low+10
        high=low+10
        while(low<=high):
            try:
                array[low]
            except IndexError:
                array[low]=0
            if(array[low]==0):
                return -1
            if(array[low]==target):
                return low
            low=low+1
        return -1
                    
