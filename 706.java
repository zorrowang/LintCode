public class Solution {
    /**
     * @param num: the number of "1"s on a given timetable
     * @return: all possible time
     */
    public List<String> binaryTime(int num) {
        // Write your code here
        ArrayList<String> ret = new ArrayList<>();
        for (int i=0; i<12; i++) {
            for (int j=0; j<60; j++) {
                if (Integer.bitCount(i*64 + j) == num)
                    ret.add(String.format("%d:%02d", i, j));
            }
        }
        return ret;
    }
}