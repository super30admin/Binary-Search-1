def binary_search(list,l,r,x): 
  
    if l <= r: 
        mid = l+(r-l)/2
  
        if list[mid] == x: 
            return mid 
  
        if list[mid] > x: 
            return binary_search(list,l,mid-1,x) 
  
        return binary_search(list,mid+1,r,x) 
  
    return -1
  
def findPos(list, key): 
  
    l, h, val = 0, 1, list[0] 
  
    while val < key: 
        l = h             
        h = 2*h           
        val = list[h]      
  
    return binary_search(a, l, h, key) 