# time complexity => log2N where N is the number of elements
# Space complexity => O(1) we dont require any extra space to search in the array


class solution:
    def __init__(self, array, target):
        self.array = array
        self.target = target
    
    def func(self):
        #initialise pointers for binary search
        first = 0
        second = len(self.array)-1

        while first <= second:
            print(first, second)
            #index of middle element
            mid = (first + second)//2

            if self.array[mid] == self.target:
                return mid
            
            elif self.array[first] == target:
                return first
            
            elif self.array[second] == target:
                return second
            
            # We will come across two kinds of cases
            # 1. where the the first element of the array is greater than the middle element
            # for eg : 6 7 1 2 3 4 <= array_1
            # 2. where the first element of the array if less than the middle element
            # for eg : 3 4 5 6 1 2 <= array_2

            elif self.array[first] >= self.array[mid]:
                # if we come across the first case, 
                # if the target is less than mid , our element exists in the left array  for eg. 1 in array_1
                # if element is greater than mid and also greater than target, our element exists in the left paret. for eg 7 in array_1
                
                if (self.target < self.array[mid]) or \
                   (self.target>self.array[mid] and self.target>self.array[first]):
                   second = mid - 1
                
                # if element is greater than mid but less than first element, the element exits in the right part. eg 3 in array_1
                elif self.target > self.array[mid] and self.target < self.array[first]:
                    first = mid + 1
            
            elif self.array[first] < self.array[mid]:
                #similarly if we come across the second case,
                # if the element is less than mid but greater than the first element, the element lies in the left array. for eg 4 in aray_2

                if self.target < self.array[mid] and self.target > self.array[first]:
                    second = mid - 1
                
                # if the element is less than mid and less than the first element, the element lies the right part, for eg 1 in array_2
                # if the element is greater the mid element, that means the element lies in the right part of the array. for eg 6 in array_2

                elif (self.target < self.array[mid] and \
                    self.target < self.array[first]) or (self.target > self.array[mid]):
                    first = mid + 1 
        return -1

array = [4,5,6,7,0,1,2]
# array = []
target = 0

new = solution(array, target)
print(new.func())

