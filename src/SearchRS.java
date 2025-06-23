
public class SearchRS {
	
	
	public int search(int []nums,int target) {
		int n =nums.length();
		int l;int r =n-1;
		while(l<r) {
			int mid= l+(r-l)/2;
			if(nums[mid]>r) {
				return l=mid+1;
			}
			else {
				return r=mid-1;
			}
		}
		
		int values = binarySearch(int []nums,0,left-1,target);
		if (values!=-1) {
			return values;
		}
		return binarySearch(int []nums,left,n-1,target);
		
		public int binarySearch (int []nums,left,right,target) {
			
        {
	        int l = left, r = right;
	        while (l <= r) {
	            int mid = (l + r) / 2;
	            if (nums[mid] == target) {
	                return mid;
	            } else if (nums[mid] > target) {
	                r = mid - 1;
	            } else {
	                l = mid + 1;
	            }
	        }
	        return -1;
			
			
		}
		
		
		
		
	}

}
