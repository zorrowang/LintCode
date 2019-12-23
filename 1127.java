public class Solution {
    /**
     * @param s: a string
     * @param dict: a list of strings
     * @return: return a string
     */
    class Interval {
        int start, end;
        Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public String addBoldTag(String s, String[] dict) {
        // write your code here
        ArrayList<Interval> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            String str = s.substring(i);
            for (String d : dict) {
                int index = str.indexOf(d);
                if (index>=0)    
                    list.add(new Interval(index+i, index+i+d.length()-1));
            }
        }
        Collections.sort(list, (i1, i2) -> i1.start - i2.start);
        list = merge(list);
        Set<Integer> starts = new HashSet<>();
        Set<Integer> ends = new HashSet<>();
        for (Interval i : list) {
            starts.add(i.start);
            ends.add(i.end);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (starts.contains(i)) {
                sb.append("<b>");
                sb.append(s.charAt(i));
            }
            else if (ends.contains(i)) {
                sb.append(s.charAt(i));
                sb.append("</b>");
            } else 
                sb.append(s.charAt(i));
        }
        if(list.get(list.size()-1).end >= sb.length())
            sb.append("</b>");
        return sb.toString();
    }
    
    private ArrayList<Interval> merge(ArrayList<Interval> list) {
        ArrayList<Interval> ret = new ArrayList<>();
        Interval cur = list.get(0);
        for (int i=1; i<list.size(); i++) {
            Interval in = list.get(i);
            if (in.start > cur.end+1 || cur.start > in.end+1) {
                ret.add(cur);
                cur = in;
            } else {
                cur.start = Math.min(cur.start, in.start);
                cur.end = Math.max(cur.end, in.end);
            }
        }
        ret.add(cur);
        return ret;
    }
}