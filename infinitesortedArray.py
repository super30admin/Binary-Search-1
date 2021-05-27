# Time Complexity : O(logi) i->pos of search ele
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : NO - Code editor locked
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

def BS(arr,left,right,key):
    while(left<=right):
        mid = left+(right-left)//2
    
        if key==arr[mid]:
            return mid
        
        if key>arr[mid]:
            left = mid+1
        else:
            right = mid-1
    return -1

def infinitesortedArray(arr,key):
    #array boundary is not known initialize right to left+1 index
    left = 0
    right = 1
    val = arr[0]

    #increase the end boundary value exponentially until val>key and then call BS for curr left and  right boundaries
    while(val<key):
        left = right
        right = 2*right
        val = arr[right]

    return BS(arr,left,right,key)
            

#obj = Solution()
arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170]
print(infinitesortedArray(arr,130))