// Time Complexity :O(mn)
// Space Complexity :O(1)
class Matrixd{
	
	public boolean searchMatrix(int [][]matrix,int target) {
		
	int m =matrix.length;
	int n=matrix[0].length;
	
	int l=0; int r =m*n-1;
	int mid= l+(r-l)/2;
	while(left<right) {
		int midelement =matrix[mid/n][mid%n];
		if(target=midelement) {
			return true;
		}
		else {
			if(target<midelement) {
				return r=mid-1;
			}
			else {
				return l=mid+1;
			}
		}
	}
	return false;
		
	}	
}