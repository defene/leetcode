class Solution {
public:
    string decodeString(string s) {
        int i = 0;
        string result = decodeString(s, i);
        return result;
    }

private:
    string decodeString(string &s, int &i) {
        string result;
        while (i < s.size() && s[i] != ']') {
            if (!isdigit(s[i])) {
                result.push_back(s[i++]);
            } else {
                int num = 0;
                while (i < s.size() && isdigit(s[i])) {
                    num = num * 10 + (s[i++] - '0');
                }
                i++; 
                string decoded = decodeString(s, i);
                i++;
                while (num--) {
                    result.append(decoded);
                }
            }
        }
        return result;
    }    
};