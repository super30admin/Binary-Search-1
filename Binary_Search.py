class Binary_Search:
    def Solution(num:list[int],target:int)->int:
        l,r = 0,len(num)-1
        
        while (l<=r):
            mid = (l+r)//2
            
            if target == num[mid]:
                return mid
            
            elif target < num[mid]:
                r = mid-1
                
            elif target > num[mid]:
                l = mid+1
        return -1        
        
Binary_Search.Solution([1,2,3,4,5,6,7,8,9],6)   
