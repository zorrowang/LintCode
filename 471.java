public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    class WordFrequency {
        String word;
        int count;
        WordFrequency(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        String[] ret = new String[k];
        if (k == 0) return ret;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<WordFrequency> queue = new PriorityQueue<>(
            (w1, w2) -> w1.count==w2.count ? w2.word.compareTo(w1.word) : w1.count - w2.count
        );
        for (String word: map.keySet()) {
            if (queue.size()<k)
                queue.offer(new WordFrequency(word, map.get(word)));
            else if (queue.peek().count < map.get(word) || (queue.peek().count == map.get(word) && queue.peek().word.compareTo(word) > 0)) {
                queue.poll();
                queue.offer(new WordFrequency(word, map.get(word)));
            }
        }
        
        int i=k-1;
        while(!queue.isEmpty()) {
            ret[i--] = queue.poll().word;
        }
        return ret;
    }
}