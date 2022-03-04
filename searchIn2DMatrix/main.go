package main

import "fmt"

/*
   I had done this problem befroe but incorrectly and my approach was
   - loop over m
   - if target is within m[0] && m[len(nested)-1]
   - then binary search on just that nested array

   time: o(m) + o(logN)
   - o(m) because I looked for the row in linear time
   - o(logN) because once I had the row idx, I was able to get stable left and right ptrs to do classic binarySearch with
   - o(m) overall


   but what if we treated this matrix as a 1D array
   - but how would we find the mid of a imaginary 1D array ( which is a matrix )
   - in 1D array we would get mid by = totalSize/2
   - how to get totalSize of this matrix?
       - len(m) x len(m[0])
       - [ [0,0,0], [0,0,0], [0,0,0] ]
       - if we have 3 elements - let that be m
       - and we have 3 elements in each nested array
       - then if we were to flatten it out - the totalLen would be len(m) x len(m[0])
       - 3x3 = 9

   - so in the first input example
   - [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
   - m (number of elements in outter array) = 3
       - how to get this? len(outterArray)
   - n (number of elements in each inner array ) = 4
       - how to get this? len(outterArray[0])
   - so total len of this flattened out would be 3*4 = 12

   - ok we can now get the mid
   - 12/2 = 6
   - but 6 is not accessible ( it will be idx out of bounds ... )
   - we are not going to flatten the array out ( that would increase time and space complx )
   - how can we pretend that this matrix is flattend out and access the 6th idx...
   - we know N % arrayLen gives a number thats within array len
   - so can we do 6%12 ?
       - no that gives me 6...
       - and I need arr[1][2]
       - but 6%n (6%4) gives me 2...
       - and 6/n (6/4) gives me 1....
       - wait lets test this fully....

         0 1 2 3   4  5   6 7.   8. 9  10. 11
       [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
       - access 34 ( idx 10 in imaginary 1D array but arr[2][2])
       - 10%n (10%4) = 2
       - 10/n (10/n) = 2
       - ..... lets try one more...

         0 1 2 3   4  5   6 7.   8. 9  10. 11
       [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
       - access 7 ( idx 3 in imaginary 1D array but arr[0][2])
       - 3%n (3%4) = 3
       - 3/n (3/4) = 0

       -- so %n returns the nested idx if we were to imagine our matrix as 1D
       -- so /n returns the outter idx if we were to imagine our matrix as 1D

   - ok great
   - so we have totalLen ( len(m) * len(m[0]) )
   - left = 0
   - right = totalLen
   - mid = left + ((right-left)/2)

   - ok concrete now..
   - left = 0
   - right = 12
   - mid = 6

   - now lets get the mid idx value
   - nums[mid] -- access via -- arr[$outterIdx][$innerIdx]
   - outterIdx = mid/n = 6/4 = 1
   - innderIdx = mid%n = 6%4 = 2
   - arr[1][2]

   - midVal := arr[1][2]
   - midVal = 16
   - target == mid x
   - now do the rest of the binary search...


   So we learned that we can
   1. Treat a matrix as 1D array
   2. Get the totalLen of a matrix without flattening
       - len(m) * len(m[0])
   3. Get matrix index relative based on a imaginary flattened idx ( for example mid point )
       - outterIdx = n/$innerSize
       - innerIdx = n%$innerSize
*/

func searchMatrix(matrix [][]int, target int) bool {

	if matrix == nil || len(matrix) == 0 {
		return false
	}

	outterSize := len(matrix)
	innerSize := len(matrix[0])
	totalLenOfImaginary1D := outterSize * innerSize

	left := 0
	right := totalLenOfImaginary1D
	for left <= right {
		fmt.Println("left", left)
		fmt.Println("right", right)

		mid := left + ((right - left) / 2)
		outterIdx := mid / innerSize
		innerIdx := mid % innerSize

		// I do not like this way of handling....
		// TODO: find a better clean way to handle- IndexOutOfBounds
		if outterIdx >= outterSize || innerIdx >= innerSize {
			break
		}

		midVal := matrix[outterIdx][innerIdx]
		if target == midVal {
			return true
		} else if target < midVal {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return false
}
