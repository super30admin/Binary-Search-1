class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        #If Array reader is empty return null
        if not reader:
            return 0

        low = 0
        high =1

        #Loop over the value from array if less than target make low as high and move forward high index
        while reader.get(high) < target:
            low = high
            high = high *2

        #Using Binary search
        while low <= high:
            #finding the pivot value by subdivision into two parts
            pivot = low + ((high - low) //2)
            
            #getting the array value at pivot position
            num = reader.get(pivot)
            if num == target :
                return pivot
            if num > target:
                high = pivot - 1
            else:
                low = pivot + 1 

        #No element present matches
        return -1


#Searching in an infinite sorted array using binary search taking time complexity of O(logn)
