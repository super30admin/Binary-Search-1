#time complexity: O(logmn)
#space complexity: O(1)

class Solution:
    def searchMatrix(self, list1, target):
        self.list1=list1
        self.target=target
        if(list1==None or len(list1)==0):
            return
        
        self.rows=len(self.list1)
        self.columns=len(self.list1[0])
        self.low=0
        self.high=(self.rows*self.columns)-1
    
        while(self.low<=self.high):
            mid=self.low+self.high//2
            print(mid)
            row=(mid//self.columns)
            column=mid%self.columns
            print(row, column)

            if(list1[row][column]==self.target):
                return True
        
            elif(target<list1[row][column]):
                self.high=mid-1
        
            elif(target>list1[row][column]):
                self.low=mid+1
            
        return False
        