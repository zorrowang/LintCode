public class Solution {
  /**
   * @param pid: the process id
   * @param ppid: the parent process id
   * @param kill: a PID you want to kill
   * @return: a list of PIDs of processes that will be killed in the end
   */
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      // Write your code here
      Map<Integer, LinkedList<Integer>> map = new HashMap<>();
      for (int i=0; i<ppid.size(); i++) {
          int id = ppid.get(i);
          if (map.containsKey(id)) {
              LinkedList<Integer> l = map.get(id);
              l.push(pid.get(i));
          } else {
              LinkedList<Integer> l = new LinkedList<>();
              l.push(pid.get(i));
              map.put(id, l);
          }
      }
      
      List<Integer> ret = new ArrayList<>();
      ret.add(kill);
      LinkedList<Integer> pids = map.getOrDefault(kill, new LinkedList<Integer>());
      while (!pids.isEmpty()) {
          int id = pids.pop();
          ret.add(id);
          pids.addAll(map.getOrDefault(id, new LinkedList<Integer>()));
      }
      return ret;
  }
}