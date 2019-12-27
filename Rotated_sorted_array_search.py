##Written by Ashutosh Upadhye
###Time Complexity:O(Log2(n))
##Space Complexity:O(log2(n)) for recursive implementation

class search_sorted_array:

    def binary_search_sorted(self,array, low, high, target):
        if low > high: #Check whether the bounds passed to the binary search are proper or not.If low > high the algorithm terminates
            return -1

        if low <= high:
            mid = low + (high - low) // 2 #compute mid

            if array[mid] == target: # if mid is the target return mid index
                return mid
            if array[low] <= array[mid]: #Look if left subarray array is sorted
                if target >= array[low] and target <= array[mid]: # Look if key exists inside that subarray or not
                    return search_sorted_array.binary_search_sorted(self,array, low, mid-1, target) #Search the left subarray
                return search_sorted_array.binary_search_sorted(self,array, mid + 1, high, target) # Or search the right subarray
            if target >= array[mid] and target <= array[high]:#If left subarray isnt sorted, assume that right subarray is sorted
                    return search_sorted_array.binary_search_sorted(self,array, mid+1, high, target)  #Search the right subarray
            return search_sorted_array.binary_search_sorted(self,array, low, mid-1, target)#Search the left subarray

    def search(self, nums, target):
        low = 0
        high = len(nums)-1
        index_to_be_found = search_sorted_array.binary_search_sorted(self,nums, low, high, target)
        return index_to_be_found #Return the index to be found


    def main(self):
        array = [3, 4, 5, 6, 7, 8, 9, 10, 1, 2]
        target = 15
        target_found = search_sorted_array.search(self, array, target)
        print(target_found)


Object = search_sorted_array().main()
