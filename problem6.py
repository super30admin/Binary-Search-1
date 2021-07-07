 def search(self, reader, target):
        
        left = 0
        right= 1
        while target>reader.get(right):
            left = right
            right<<=1
            
        while left<=right:
            mid = (left+right)//2
            num = reader.get(mid)
            if num == target:
                return mid
            if num>target:
                right = mid-1
                
            else:
                left = mid+1
        return -1
        
        # o(X) time complexity where X is targets index, o(1) space complexity
            
         
