//Problem : Search in Sparse Array
//TC: Amortized: O(logn), Wors Case: O(N)
//SC: O(1)

class SearchInSparseArray {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		String arr[] = {"for", "geeks", "", "", "", "", "ide",  
                    "practice", "", "", "", "quiz"};
		
	//	String arr[] = {"for","", "", "", "quiz"};
        String target = "ide";
        
        System.out.println("Target Elem index "+binarySearch(arr,target));
		
	}
	
	
  private static int binarySearch(String[] arr,String target){
    
    int start = 0;
    int end   = arr.length-1;
    
    while(start<=end){
        
        int mid = start + (end-start)/2;

        //If mid is empty find the non empty mid
        if(arr[mid].isEmpty()){
           int left  = mid-1;
           int right = mid+1;
           mid = getNonEmptyMid(arr,left,right,start,end);//Finding where the non empty string is available so that target can be compared , means finging closest non empty string
        }
        
        if(mid==-1) return mid;
        
        if(arr[mid].equals(target)){
            return mid;
        }
        
        if(target.compareTo(arr[mid])>0){//target greater than arr[mid]
            start =  mid+1;
        }else{
            end = mid-1;
        }
        
    }
    
    return -1;
}
   private static int getNonEmptyMid(String[] arr, int left, int right, int start, int end){
       
       while(true){
            if(left<start && right>end){
                return -1;
            }else if(left>=start && !arr[left].isEmpty()){//otherwise left will go beyond start
                return left;
            }else if(right<=end && !arr[right].isEmpty()){
                return right;
            }
            
            left--;
            right++;
       }
       
       //return -1;
   }
		
}