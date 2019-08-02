class RecursiveRotatedSortedArray:
	def Search(self, nums, target):
		return self.BSearch(nums, 0, len(nums) - 1, target)

	def BSearch(self, nums, low, high, target):
		# base case
		if low > high:
			return -1
		mid = low + (high - low)//2
		if nums[mid] == target:
			return mid
		elif nums[low] <= nums[mid]:
			if nums[low] <= target and target <= nums[mid]:
				high = mid - 1
			else:
				low = mid + 1
		else:
			if nums[mid] <= target and target <= nums[high]:
				low = mid + 1
			else:
				high = mid - 1
		return self.BSearch(nums, low, high, target)

if __name__ == "__main__":
	rrsa = RecursiveRotatedSortedArray()
	print(rrsa.Search([4,5,6,7,0,1,2], 0))