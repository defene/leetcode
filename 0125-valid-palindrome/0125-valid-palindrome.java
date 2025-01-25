class Solution {
    public boolean isPalindrome(String s) {
        String sLowerCase = s.toLowerCase();
        char[] arr = sLowerCase.toCharArray();

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(arr[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[j])) {
                j--;
                continue;
            }

            if (i < j && arr[i] != arr[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}