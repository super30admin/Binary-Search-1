'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#702. Search in a Sorted Array of Unknown Size
# - Set lower bound = 0 and upper bound = 1 to initialize the window of search
# - Until upper bound element is < target, increase upper bound by factor of 2
# - This reduces the infinite space to a finite search window and reduces the 
#   search space by factor of 2. Feels like LogN
# - Every time you increment the upper bound, set the lower bound to previous
#   upper bound because you know target won't be below the previous upper bound
#   (because array is sorted)

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - 2*logN. 1st logN to find the right window. 2nd for binary search
#------------------
# Space Complexity: 
#------------------
# O(1) - Constant space to store indices and values


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32 ms  (83 %ile)
# Space            :  15.3MB (77.54 %ile)


class Solution:
        
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        low = 0
        high = 1
        while (reader.get(high) < target):
            low = high
            high = high << 1 #Left shift = high * 2 Right shift = high/2


        while low<=high:
            mid = (low + high)//2
            if reader.get(mid) == target:
                return mid
            
            elif reader.get(mid) < target:
                low = mid+1
            
            else:
                high = mid-1

        return -1
