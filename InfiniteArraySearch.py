class solution:
	def InfiniteArraySearch(array, target):
		start = 0 
        end = start + 1
		temp = array[0]
		while temp < target:
			low = high
			high = high * 2
			temp = array[high]
		return binarySearch(array, target, low, high)
        
	def binarySearch(arr, target, low, high):
		while start <= end:
            mid = (start + end)/2
            if nums[mid] == target:
                return mid
            if nums[start] <= nums[mid]:
                if target >= nums [start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid -1
        return -1