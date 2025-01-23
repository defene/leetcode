class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        List<String> candidates = new ArrayList<>();
        int curLength = words[0].length();
        candidates.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (curLength + word.length() + 1 <= maxWidth) {
                curLength += word.length() + 1;
                candidates.add(word);
            } else {
                String newLine;
                if (candidates.size() == 1) {
                    newLine = getLastline(candidates, curLength, maxWidth);
                } else {
                    newLine = getNewLine(candidates, curLength, maxWidth);
                }

                result.add(newLine);

                curLength = word.length();
                candidates.clear();
                candidates.add(word);
            }
        }

        String lastLine = getLastline(candidates, curLength, maxWidth);
        result.add(lastLine);

        return result;
    }

    private String getNewLine(List<String> candidates, int curLength, int maxWidth) {
        int spaceNum = (candidates.size() - 1) + (maxWidth - curLength);
        List<String> spaces = getSpaces(candidates.size(), spaceNum);

        StringBuilder sb = new StringBuilder();
        sb.append(candidates.get(0));
        for (int i = 1; i < candidates.size(); i++) {
            sb.append(spaces.get(i - 1));
            sb.append(candidates.get(i));
        }

        return sb.toString();
    }

    private String getLastline(List<String> candidates, int curLength, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(candidates.get(0));
        
        if (candidates.size() > 1) {
            for (int i = 1; i < candidates.size(); i++) {
                sb.append(' ');
                sb.append(candidates.get(i));
            }
        }
        
        int spaceNum = maxWidth - curLength;
        for (int i = 0; i < spaceNum; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    private List<String> getSpaces(int wordNum, int spaceNum) {
        int average = spaceNum / (wordNum - 1);
        int remain = spaceNum % (wordNum - 1);

        List<String> spaces = new ArrayList<>();
        for (int i = 0; i < wordNum - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < average; j++) {
                sb.append(' ');
            }
            
            if (remain > 0) {
                sb.append(' ');
                remain--;
            }

            spaces.add(sb.toString());
        }

        return spaces;
    }
}
