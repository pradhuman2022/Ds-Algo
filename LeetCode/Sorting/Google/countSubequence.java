class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<Character, TreeSet<Integer>> indexMap = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
	if (!indexMap.containsKey(s.charAt(index)))
		indexMap.put(s.charAt(index), new TreeSet<Integer>());
            
       	indexMap.get(s.charAt(index)).add(index);
       }    
        
       int ans = 0 ;
       for  (String word: words) 
if (isSubsequence(word, indexMap))
	ans++;
              
return ans;
    }

    private boolean isSubsequence(String word, 
HashMap<Character, TreeSet<Integer>> indexMap)  {

	int currentIndex = -1;
	for (char letter: word.toCharArray()) {
if (!indexMap.containsKey(letter))
		return false;
SortedSet<Integer> tailSet = indexMap.get(letter).tailSet(currentIndex + 1);
if (tailSet.isEmpty()) 
return false;
 	currentIndex = tailSet.first();
    }

	return true;
}
 
}


/**

s
words
b b c d
previousCharIndex = -1

previousCharIndex = 1

previousCharIndex = 2

c b b c b d e

b a b c d e

b a b d c e

a -> c -> d
a -> 0
c -> 3
d -> 4


a c d
a -> c -> d

string should contain all chars of words first
then store index of every char of a string

iterate through a word from front
and check if we have a char what is 



**/
