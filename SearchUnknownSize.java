
class SearchUnknownSize {
    public int search(ArrayReader reader, int target) {
        int LARGEST = 2147483647;
        int LEFT = 0;
        int RIGHT = 10;
        int factor = 5;
        int MID;
        //first find RIGHT
        while (reader.get(RIGHT) < target) {
            if (reader.get(RIGHT) == LARGEST) {
                break;
            }
            LEFT = RIGHT;
            RIGHT = RIGHT * factor;
        }
        // Use left and right to find the mid
        while (LEFT < RIGHT) {
            MID = (LEFT + RIGHT + 1)/2;
            if (reader.get(MID) == target) {
                return MID;
            }
            if (reader.get(MID) > target) {
                RIGHT = MID - 1;
            } else {
                LEFT = MID;
            }
        }

        return reader.get(LEFT)  == target ? LEFT : -1;

    }
}