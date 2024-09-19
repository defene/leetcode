class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int size = nums.length;
        boolean alreadyRepeat = false;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                if (alreadyRepeat) {
                    size--;
                } else {
                    alreadyRepeat = true;
                    nums[i++] = nums[j];
                }

                continue;
            }

            alreadyRepeat = false;
            nums[i++] = nums[j];
        }

        return size;
    }
}