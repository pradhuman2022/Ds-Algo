class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    
        List<String> outputList = new ArrayList<>();
        List<String> tempLine = new ArrayList<>();
        int currentWidthOfLine = 0;
        
        for (int currentWord = 0; currentWord < words.length; currentWord++){
            //System.out.println(tempLine);
            System.out.println(outputList);
            if (currentWidthOfLine + tempLine.size() + words[currentWord].length() <= maxWidth) {
                currentWidthOfLine += words[currentWord].length();
                tempLine.add(words[currentWord]);
                System.out.println(words[currentWord]);
            } else {
                int spaces;
                StringBuilder currentLine = new StringBuilder();
                if(tempLine.size() == 1) {
                    //we need to add maxWidth - word.length spaces
                    currentLine.append(tempLine.get(0));
                    while(currentLine.length() != maxWidth) {
                        currentLine.append(" ");
                    }
                } else {
                    System.out.println(maxWidth+ " " +currentWidthOfLine);
                    
                    int remainingSpaces = maxWidth - currentWidthOfLine;
                    int inBetweenSpaces = remainingSpaces / (tempLine.size() - 1);
                    int leftSpaces = remainingSpaces % (tempLine.size() - 1);
                    System.out.println(leftSpaces);
                    for (int k = 0; k < tempLine.size(); k++) {
                        if(currentLine.length() != 0) {
                            for (int spaceChar = 0; spaceChar < inBetweenSpaces; spaceChar++){
                                currentLine.append(" ");
                            }
                            if(leftSpaces-- > 0){
                                currentLine.append(" ");
                            }
                        }
                        currentLine.append(tempLine.get(k));
                    }
                }
                outputList.add(currentLine.toString());
                tempLine.clear();
                currentWidthOfLine = 0;
                currentWord--;
            }
        }
        
        StringBuilder newLine = new StringBuilder();
        for (String word : tempLine) {
          if(newLine.length() != 0) {
              newLine.append(" ");
          }  
          newLine.append(word);  
        }
        
        int diff = maxWidth - newLine.length();
        while(newLine.length() < maxWidth) {
            newLine.append(" ");
        }
        outputList.add(newLine.toString());
        
        return outputList;
    }
}
