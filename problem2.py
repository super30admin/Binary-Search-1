#Time complexity is O(logn) where n is the size of the array
#Space complexity: O(1)
#Since this require premium license I didn't ran on leetcode
#No rpoblem faced while coding

class Solution():
    def search(self,reader,target):
        #initialising the left and right values
        self.left=0
        #Since the lenght of the array is hidden, I am using len() method to find the length
        self.right=len(reader)-1

        #checking if the array is empty or not
        if(len(reader)==0):
            return
        else:
            while(self.left<=self.right):
                #calculating the mid value
                self.mid=(self.left+self.right)//2
                #if the mid value is equal to target, we return that
                if(reader[self.mid]==target):
                    return self.mid
                #if the mif value is less than target, we change left value
                elif(reader[self.mid]<target):
                    self.left=self.mid+1
                #in the last case we change right value
                else:
                    self.right=self.mid-1
            #if the value is not found, we return -1
            return -1

