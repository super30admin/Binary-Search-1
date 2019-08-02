class SearchInfiniteArray_BS:
	def findPos(self, arr, target):
		l = 0
		h = 2
		try:
			while(arr[h] < target):
				l = h 
				h *= 2
		except Exception as e:
			try:
				h = l + 1
				while(arr[h] < target):
					l = h
					h *= 2
			except Exception as e1:
				pass
		return self.BSearch(arr, target, l, h)

	def BSearch(self, arr, target, low, high):
		while(low <= high):
			mid = low + (high - low)//2
			if arr[mid] == target:
				return mid
			elif arr[mid] > target:
				high = mid - 1
			else:
				low = mid + 1
		return -1

if __name__ == "__main__":
	SIA = SearchInfiniteArray_BS()
	print(SIA.findPos([2,4,5,11,15,17,18,19,20,23,24,26,28,30], 29))