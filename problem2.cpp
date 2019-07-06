#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>

using namespace std;

class Solution{

    public:
        int getIndex(int arr[], int target )
        {
            int index = 0,exp=0;
		while(true) {
			try {
				//check if  element is equal to target or not. if yes return index of  element
				if(arr[index]==target) {
                    cout <<"Index: "<<+index;
					return index;
					//if element is less than target then it means target can be found if we continue to interate array so increase index by 2^exponential and increase exponential by  1.
				}else if(arr[index]<target) {
					index = (int) pow(2,exp);
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
};