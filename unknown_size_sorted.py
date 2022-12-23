# Time Complexity :
# O(log N)

# Space Complexity :
# O(1) - we do not store any values

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Get the first element and check if it's the target
        elem = reader.get(0)
        if elem == 2**32 - 1 or elem > target:
            return -1
        if elem == target :
            return 0
        i = 1
        while (elem != 2**31- 1):
            # Get the element at location i and check if it's the target
            if elem == target :
                return i
            #If the element at location i is greater than target, then the target must be in 
            #position i/2 to i
            if elem > target:
                return self.binary_search(reader, int(i/2),i,target)
            # if element is greater than target, then we search in (i - 2*i)
            if elem < target :
                i *= 2
                elem = reader.get(i)
        search_loc =  self.binary_search(reader, int(i/2),i,target)
        return search_loc

    def binary_search(self,reader,start_loc,end_loc,target) -> int:
        #Binray search - called when we know target must be in between loc start and end 
        #or does not exist
        #Base condition
        if end_loc - start_loc == 1 :
            single_value = reader.get(start_loc)
            if single_value == target:
                return start_loc
            else :
                return -1

        #Checking middle element and calling the binary search on appropriate set of elements
        middle_value = reader.get(int((start_loc+end_loc)/2))
        if middle_value == target:
            return int((start_loc+end_loc)/2)
        if middle_value  == 2**31 -1 or middle_value > target :
            return self.binary_search(reader,start_loc,int((start_loc+end_loc)/2),target)
        if middle_value < target :
            return self.binary_search(reader,int((start_loc+end_loc)/2),end_loc,target)
        return -1
