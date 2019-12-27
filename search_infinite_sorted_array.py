##Written by AShutosh Upadhye
##Time Complexity:O(Log2(n))
##Space Complexity:O(log2(n)) for recursive implementation



class search_infinite_sorted_array:
#Here the idea is to keep the array infinite just to test the algorithm, but we need to keep just the array size larger.
#We assume no duplicates in the array.

    def search(self, nums, target):
#Keep low at first position and high at the second.
#Keep a value for comparison.Firstly at first element of the array.
        low = 0
        high = 1
        value = nums[0]
#If the target is greater than the value,transfer the high to low and  increase the high by 2 times.
#The increment by 2 times is done because 2^x operations can be broken down to log(2)x time complexity.
        try:
            while value < target:
                low = high
                high = 2 * high
                value = nums[high]
#If value is greater than target, then at the last step we compute the binary search for the last array.
        except: pass

        print(low)
        print(high)
        return search_infinite_sorted_array.binary_search(self, nums, low, high, target)

    def binary_search(self, nums, low, high, target):

        if low > high:
            return -1
        try:
            if low <= high:
                mid = low + (high - low) // 2

                if nums[mid] == target:
                    return mid
                if target < nums[mid]:
                    return search_infinite_sorted_array.binary_search(self, nums, low, mid-1, target)
                if target > nums[mid]:
                    return search_infinite_sorted_array.binary_search(self, nums, mid+1, high, target)

        except:
            pass

    def main(self):
        array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
        length = len(array)-1
        target = 30
        found = search_infinite_sorted_array.search(self, array, target)
        #found = search_infinite_sorted_array.binary_search(self, array, 0, length, target)
        print(found)

object = search_infinite_sorted_array().main()