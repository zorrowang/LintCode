public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        String[] comps = time.split(":");
        int hour = Integer.parseInt(comps[0]);
        int min = Integer.parseInt(comps[1]);
        String ret = "";
        boolean suc = false;
        while(!suc) {
            if (++min == 60) {
                min = 0;
                if (++hour == 24)
                    hour = 0;
            }
            ret = String.format("%02d", hour) + ":" + String.format("%02d", min);
            suc = true;
            for (int i=0; i<5; i++) {
                if (time.indexOf(ret.charAt(i)) < 0) {
                    suc = false;
                    break;
                }
            }
        }
        return ret;
    }
}

public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        String ret = "";
        Set<Character> set = new HashSet<>();
        for(int i=0; i<time.length(); i++) {
            if (Character.isDigit(time.charAt(i)))
                set.add(time.charAt(i));
        }
        
        ArrayList<String> strs = new ArrayList<>();
        for(Character ch : set) {
            for(Character c : set) {
                char[] array = new char[2];
                array[0]= ch;
                array[1]= c;
                strs.add(new String(array));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            for (String s : strs) {
                String cur = str+":"+s;
                if (cur.equals(time) || cur.charAt(0)>'2' || (cur.charAt(0)=='2' && cur.charAt(1)>'3') || cur.charAt(3)>'5')
                    continue;
                int diff = diff(time, cur);
                if (diff < min) {
                    min = diff;
                    ret = cur;
                }
            }
        }
        
        return ret.length()==0?time:ret;
    }
    
    // Diff from t1 to t2
    private int diff(String t1, String t2) {
        int n1 = convert(t1);
        int n2 = convert(t2);
        
        if (n2 >= n1)   return n2-n1;
        else return 24*60-n1+n2;
    }
    
    private int convert(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0])*60 + Integer.parseInt(hm[1]);
    }
}