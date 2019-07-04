
//Reference http://www.ardendertat.com/2011/11/21/programming-interview-questions-17-search-unknown-length-array/
class SearchArray{
	//getIndex method to find index of target element in an sorted array of unknown length
	public int getIndex(int[]array, int target) {
		//initializing index and exponential to 0
		int index = 0,exp=0;
		while(true) {
			try {
				//check if  element is equal to target or not. if yes return index of  element
				if(array[index]==target) {
					System.out.println("index is ="+index);
					return index;
					//if element is less than target then it means target can be found if we continue to interate array so increase index by 2^exponential and increase exponential by  1.
				}else if(array[index]<target) {
					index = (int) Math.pow(2,exp);
					exp++;
					//if target element is grater than element in array then come out of loop
				}else break;
				//come out of loop if array index out of bound excpetion occurs
			}catch(ArrayIndexOutOfBoundsException e){
				break;
			}
		}
		//binary search. index is at element larger than target or at last element in array 
		int left=(index/2)+1;
	    int right=index-1;
	   
	    //iterate till left is less than equal to right
		while (left<=right) {
			int mid=left+(right-left)/2;
			  try {
				  //if array[mid] is equal to target return mid
			         if(array[mid]==target) {
			           System.out.println("index is ="+mid);
			               return mid;
			               // array[mid] is grater than target then set right to mid-1
			        }else if (array[mid]>target)
			        	right=mid-1;
			            else left = mid+1; // if array[mid] is less than target then set left to mid+1
			        }catch (Exception e) {
			            right=mid-1;
			        }
		
	}
	
		return -1;
	
}
}

/**
 * @author premal
 *
 */
 class SearchUnknownLengthArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchArray search = new SearchArray();
		
		System.out.println(search.getIndex(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21},20));
		
	}

}
