public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand;
    
    public RandomizedSet() {
        // do intialization if necessary
        this.nums = new ArrayList<>();
        this.locs = new HashMap<>();
        this.rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (locs.containsKey(val)) return false;
        nums.add(val);
        locs.put(val, nums.size()-1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val);
        if (loc < nums.size()-1) {
            nums.set(loc, nums.get(nums.size()-1));
            locs.put(nums.get(loc), loc);
        }
        nums.remove(nums.size()-1);
        locs.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */