def infiniteArray(reader, target):
	low = 0
	right = 1
	
	while(reader.get(high)<=target):
		low = high
		high = high*2
	
	while(low<=high):
		mid = low+((high-low)//2)
		if(reader.get(mid)==target):
			return mid
		elif(reader.get(mid)>target):
			high = mid-1
		else:
			low = mid+1
	return -1