# Time complexity to find the size => approximately log2(target)
# time complexity to find the element if not found before, => log2(size of array)

class solution:
    def __init__(self, array, target):
        self.array = array
        self.target = target
    
    #function giving out the value of the elements, 
    def get_elem(self, i):
        if i < len(self.array):
            return self.array[i]

    def func(self):
        if self.get_elem(0) == 0:
            return -1
        

        # we maintain a difference element that helps us in guessing the size of the array required.
        # we initialise our adder to 1, then we multiply 2 with each iteration  and add to our current size until we find an element greater
        # then the required element. Then we store the size element in a variable and then use binary search in the
        
        left = 0
        right = 0
        size = 0
        diff = 1
        
        while True:
            new_size = size + diff

            elem = self.get_elem(new_size-1)
            if elem == self.target:
                return new_size
            
            if elem == None and diff == 1 or elem >= self.target:
                right = size-1
                print(right)
                break
            
            if elem == None:
                diff = 1
                continue
            
            diff = diff*2
            size = new_size
        
        while left <= right:
            mid = (left + right)//2
            if self.array[mid] == self.target:
                return mid
            elif self.array[mid] < self.target:
                left = mid + 1
            elif self.array[mid] > self.target:
                right = mid - 1
        return -1

array = [1,2,3,4,50,54,67,68,95,100]
target = 95

new = solution(array, target)
print(new.func())
                        


            

