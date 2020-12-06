class Solution(object):
    
  
# Find h to do binary search 
    def findPos(self,a, key): 
        def binary_search(arr,l,r,x): 
            while r >= l: 
                mid = l+(r-l)/2
                if arr[mid] == x: 
                    return mid 
                elif arr[mid] > x: 
                    r=mid-1
                else:
                    l=mid+1
            return -1
        #consider h as 1
        l, h = 0, 1
        while arr[h]< key: 
            l = h            #store previous high so that even low indice increases and we rduce the compute range
            h = 2*h          #double high index 
                
        # at this point we have updated low and high indices, 
        # thus use binary search between them 
        return binary_search(a, l, h, key) 
  
# Driver function 
arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170] 
ans = Solution().findPos(arr,10) 
print(ans)

#O(logN)
#O(1)

  