class Binary_Search_Rotated_Array:
    def search(num:list[int],target:int) -> int:
        l,r =0, len(num) -1
        while l <=r:
            mid = (l+r)//2
            
            if target == num[mid]:
                return mid
            
            #left side sorted
            if num[l] <=num[mid]:
                if target > num[mid] or target < num[l]:
                    l = mid+1
                else:
                    r = mid-1
            #right side sorted
            else: 
                if target < num[mid] or target > num[r]:
                    r = mid-1
                else:
                    l=mid+1
        return -1  

Binary_Search_Rotated_Array.search([4,5,6,7,0,1,2],0)          
