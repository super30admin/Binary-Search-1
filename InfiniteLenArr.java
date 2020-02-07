class InfiniteLenArr {

public int search (int arr[], int target){

  if(arr==null){return -1;} 

  int low =0;
  int high = 1;

  while(arr[high]<target){
      
       low = high;
      high = 2*(high);
  }
while(low<=high){

    int mid = low + (high-low)/2;
    if(arr[mid]==target){return mid;}

    if(arr[low]<=arr[mid]){
         if(arr[low]<= target && target <= arr[mid]){
             high = mid -1;
         }
         else {
             low = mid +1;
         }
    }
    else {
        if(arr[mid]<= target && target <= arr[high]){
            low = mid+1;
        }
        else 
            high = mid -1;
    }

}
    return -1;
}

 public static void main(String[] args) {
     
    InfiniteLenArr ila = new InfiniteLenArr();
    int [] arr = {1,2,3,4,5,6,7,8,9,10};
     System.out.println(ila.search(arr, 9 ));
    
}

}