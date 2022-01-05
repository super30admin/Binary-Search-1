class Solution:
    def binarySearch(self, array, low, high, target):
        mid = (low+high)//2
        if target == array[mid]:
            return mid
        elif target>array[mid]:
            return self.binarySearch(array, mid+1, high, target)
        elif target<array[mid]:
            return self.binarySearch(array, low, mid-1, target)
            
    def search_infiniteSortedList(self,array, target):
        l, h = 0,1
        while target>array[h]:
            l=h
            h =h*2
        
        return self.binarySearch(array, l , h, target)

if __name__ == "__main__":
    a=[]
    for i in range(1,1000):
        a.append(i)
    
    obj = Solution()
    print(obj.search_infiniteSortedList(a,40))