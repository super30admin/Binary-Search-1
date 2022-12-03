// Time Complexity : O(logn) Binary search
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class solution{
public static int findNumber(int arr[], int findNo) {
	if(arr == null) 
        return -1;
	// initializing indexes
	int low = 0, last = 1, mid = 0;
	do {
		mid = (low + last )/2;
		try {
			if(arr[mid] == findNo) 
				return mid;
		}catch(ArrayIndexOutOfBoundsException e) {
			last = mid-1;
			continue;
		}
		
		if(arr[mid] < findNo) {
			low = mid + 1;
			try {
				if(arr[last]>findNo)
					last--;
				else
					last = last*2;
			}catch(ArrayIndexOutOfBoundsException e) {
				last--;
			}
		}else {
			last = mid - 1;
		}
	}while(low<=last);
	return -1;
}
}
