// space complexity - o(1)
	//time - o(log(n))
  //Ran on leeetcode successfully : Yes
  // Problem faced  : No
	//Approach : FFind range b/w which target ie by increment the high index by poer of 2

class Solution {
    public int search(ArrayReader reader, int target) {

        int lowIndex = 0;
        int highIndex = 0;

        double i = 0.0;
        while(reader.get(highIndex) < target && highIndex <= 10000){
            lowIndex = highIndex;
            highIndex = (int)Math.pow(2.0, i);
            i++;
        }
        int mid = lowIndex + (highIndex - lowIndex)/2;
        while(lowIndex<=highIndex){
            mid = lowIndex + (highIndex - lowIndex)/2;
            int midVal = reader.get(mid);
            if(midVal == target){
                return mid;
            }
            else if(midVal < target){
                lowIndex = mid +1;
            }
            else{
                highIndex = mid-1;
            }

        }

        return -1;

    }
}
