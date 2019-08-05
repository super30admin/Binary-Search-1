
public class SearchRotatedArray {
	private static int search(int[] arr, int target) {
		int lo = 0, hi = arr.length-1;
		while(lo <= hi) {
			int mid = lo+(hi-lo)/2;
			if(arr[mid] == target) {
				return mid;
			} else if(arr[lo] <= arr[mid]) {
				if(arr[lo] <= target && arr[mid] > target) {
					hi = mid-1;
				} else {
					lo = mid+1;
				}
			} else {
				if(arr[hi] >= target && arr[mid] < target) {
					lo = mid+1;
				} else {
					hi = mid-1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4,5,6,7,0,1,2};
		System.out.println(search(arr, 7));
	}

}
