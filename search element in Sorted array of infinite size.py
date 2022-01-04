# Time Complexity : O(logN)
 # // Space Complexity :O(1)
 # // Did this code successfully run on Leetcode : Yes
class InfiniteArray:
     def __init__(self,reader,target):
         self.reader = reader
         self.target = target

     def search(self):
         low =0
         high =1

         while(self.reader[high]<self.target):
             low=high
             high = 2*high

         while(low<= high):
             mid = low + (high-low)//2
             if(self.reader[mid]==self.target): return mid
             elif(self.reader[mid]>self.target):
                 high=mid-1
             else:
                low = mid+1
         return -1




