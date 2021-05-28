class Solution {
	public int search(ArrayReader reader, int target){
		int low=0; int high = 1; int mid;
		while(reader.get(high) < target){
			low = high;
			high = high * 2;
		}
		return binarySearch(reader, low, high, target);

		private int binarySearch(ArrayReader reader, int low, int high, int target){
			while(low <= high){
				mid = low + (high -low)/2;
				if(reader.get(mid) == target) return mid;
				if(reader.get(mid) < target){
					low = mid + 1;
				}
				else {
					high = mid - 1; 
				}
			}
			return -1;
		}
	}
}