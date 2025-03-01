class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = n;

        while (cur != 1) {
            if (set.contains(cur)) {
                return false;
            }
            set.add(cur);
            cur = helper(cur);
        }

        return true;
    }

    private int helper(int n) {
        int result = 0;

        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }

        return result;
    }
}