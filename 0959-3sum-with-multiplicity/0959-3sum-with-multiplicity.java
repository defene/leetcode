class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int MOD = 1_000_000_007;
        int resultSum = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        resultSum += count * (count - 1) / 2;
                        resultSum %= MOD;
                        break;
                    } else {
                        int leftCount = 1, rightCount = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }
                        resultSum += leftCount * rightCount;
                        resultSum %= MOD;
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultSum;
    }
}