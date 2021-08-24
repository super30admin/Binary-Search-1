package BinarySearch1;

public class SearchUnkownSize {
	  public int search(ArrayReader reader, int target) {
	        int left =0;
	        int right=1;
	        while(reader.get(right)<target){
	            
	            left=right;
	            right=right*2;
	            
	        }
	        int low=left;
	        int high= right;
	        while(left<=right){
	            int mid= left+(right-left)/2;
	            if(reader.get(mid)==target) return mid;
	            else if(reader.get(mid)>target) right= mid-1;
	            else if(reader.get(mid)<target) left=mid+1;
	            
	        }
	       return -1; 
	    }

}
