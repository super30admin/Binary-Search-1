//Time Complexity = O(logN)
//Space Complexity = O(N)
//Leetcode = Cannot find link on leetcode for this problem
//This problem seems okay as far as understanding is concerned.
 
 
class Main {
  static int binary_search(int[] arr,int l, int r, int val){
   int mid = (int) Math.floor((l + r)/2);
   if(l > r)
       return -1;
 
   if(arr[mid] == val)
       return mid;
   if(l < r){
          
           if(arr[mid] > val) {
       return binary_search(arr,l,mid,val);
     }else {
       return binary_search(arr,mid + 1,r,val);
     }
   }
     return -1;
 }
 
 public static int search_infinite_array(int[] input,int value,int left_index,int right_index){
    
   /*Since, the list is sorted it means we can do binary search starting from index 0 to next possible index which will give us logarithmic time.*/
 
   //Now, various ways to do this indexing
   //Increment in linear steps {10,20,30....} 
  
   //Binary Search using these values
   if(right_index == 0)
         return -1; //Empty Infinite Array
 
   if(left_index < right_index){
     int output = binary_search(input,left_index,right_index,value);
     if(output != -1)
         return output; //Index of the found element
 
     return(search_infinite_array(input, value, right_index + 1, (int)Math.pow(right_index,2)));
   } 
   return -1;
 }
 
 public static void main(String[] args) {
   int[] input = new int[10000];
   for(int i=0;i<input.length; i++){
     input[i] = i+1;
   }
   int val = 56; //Random number to find
   //Assign right_index = 1
   int left_index = 0;
   int right_index = 0;
   try{
       //To check array has minimum size = 2
       int zero_index  = input[0];
       int first_index = input [1];
       right_index = 2;
   }catch(Exception e){
     System.out.println("Arrays out of bound exceptions");
   }
   final int result = search_infinite_array(input,val,left_index,right_index);
 }
}

