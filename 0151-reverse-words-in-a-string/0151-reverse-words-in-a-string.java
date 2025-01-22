class Solution {
    public String reverseWords(String s) {
        String inputCorrectSpace = deleteSpace(s);
        char[] arr = inputCorrectSpace.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int slow = 0;
        for (int fast = 0; fast <= arr.length; fast++) {
            if (fast == arr.length || arr[fast] == ' ') { 
                reverse(arr, slow, fast - 1);
                slow = fast + 1; 
            }
        }

        return new String(arr);            
    }

    private String deleteSpace(String s) {   
        char[] arr = s.toCharArray();
        
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != ' ') {
                arr[slow++] = arr[fast]; 
            } else if (fast > 0 && arr[fast - 1] != ' ') {
                arr[slow++] = ' ';
            }
        }

        if (arr[slow - 1] == ' ') slow--;

        return new String(arr, 0, slow);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    } 
}