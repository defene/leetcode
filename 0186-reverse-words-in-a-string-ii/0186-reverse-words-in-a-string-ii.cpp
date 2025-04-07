class Solution {
public:
    void reverseWords(vector<char>& s) {
        reverse(s, 0, s.size() - 1);

        int wordLeft = 0;
        for (int wordRight = 0; wordRight < s.size(); wordRight++) {
            if (s[wordRight] == ' ') {
                reverse(s, wordLeft, wordRight - 1);
                wordLeft = wordRight + 1;
            }
        }
        reverse(s, wordLeft, s.size() - 1);
    }

private:
    void reverse(vector<char>& s, int left, int right) {
        while (left < right) {
            swap(s[left++], s[right--]);
        }
    }
};