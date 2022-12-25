# Time Complexity :O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :NA - Dont have leetcode premium       
# Any problem you faced while coding this :No

#Approch:- Keep increasing the pointer 2 times untill the pointer points to element which is greter than or equal to element which we search for. then we apply Binary Search.

def binary_search(arr,l,r,x):
    if r >= l:
        mid = l+(r-l)//2
 
        if arr[mid] == x:
            return mid
 
        if arr[mid] > x:
            return binary_search(arr,l,mid-1,x)
 
        return binary_search(arr,mid+1,r,x)
 
    return -1
def findPos(a, key):
 
    l, h, val = 0, 1, arr[0]
    while val < key:
        l = h            
        h = 2*h          
        val = arr[h]       
