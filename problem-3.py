# SEARCH IN INFINITE SORTED ARRAY
# TIME COMPLEXITY: O(log N) where N is the number of elements we get when
# high > target occure
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this : Had a clear idea on the concept its just that 
# given its a LC Premium question was not able to give it a dry run referred the video 
# and S30 page where the question and constrains were written


class Solution:
    def search(self, reader:'ArrayReader', target:int)->int:
        low=0
        high=1

        while reader.get(high)<target:
            low=high
            high=high*3

        while low<=high:
            mid=(low+high)//2
            if reader.get(min)==target:
                return mid
            elif reader.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
        
        return -1
    
secret=[-1,0,3,5,9,12]
target=9