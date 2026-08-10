class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>();
        for (int x : arr) {
            HashSet<Integer> nxt = new HashSet<>();
            nxt.add(x);
            for (int y : cur) {
                nxt.add(y | x);
            }
            cur = nxt;
            res.addAll(cur);
        }
        return res.size();
    }
}
