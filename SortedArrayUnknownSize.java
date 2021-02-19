class Solution{
	public int search(ArrayReader reader, int target){
		int high = 1, low = 0;
		while(reader.get(high) != Integer.MAX_VALUE){
			if(reader.get(low) < target){
				low = high;
			}
			if(reader.get(high) <= target){
				high *=2;
			}
			
		}
		return binarySearch(reader, target, low, high);
	}
	public int binarySearch(ArrayReader reader, int target, int low, int high){
		int mid = 0;
		while(low <= high){
			mid = low + (high-low)/2;
			if(reader.get(mid) == target){
				return mid;
			}else if(reader.get(mid) < target){
				low = mid +1;
			}else{
				high = mid - 1;
			}
		}
		return -1;
	}
}

//Time Complexity - BigO(2log(n)) ~ BigO(log(n)).