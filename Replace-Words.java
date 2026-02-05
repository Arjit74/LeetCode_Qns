1class Solution {
2    class Trie {
3        class Node {
4            Node[] child = new Node[26];
5            boolean isTerminal;
6        }
7
8        Node root = new Node();
9
10        void insert(String word) {
11            Node curr = root;
12            for (int i = 0; i < word.length(); i++) {
13                int idx = word.charAt(i) - 'a';
14                if (curr.child[idx] == null) {
15                    curr.child[idx] = new Node();
16                }
17                curr = curr.child[idx];
18            }
19            curr.isTerminal = true;
20        }
21
22        String getRoot(String word) {
23            Node curr = root;
24            StringBuilder sb = new StringBuilder();
25            for (int i = 0; i < word.length(); i++) {
26                int idx = word.charAt(i) - 'a';
27                if (curr.child[idx] == null) return word;
28                sb.append(word.charAt(i));
29                curr = curr.child[idx];
30                if (curr.isTerminal) return sb.toString();
31            }
32            return word;
33        }
34    }
35
36    public String replaceWords(List<String> dictionary, String sentence) {
37        Trie trie = new Trie();
38        for (String s : dictionary) trie.insert(s);
39
40        String[] words = sentence.split(" ");
41        StringBuilder ans = new StringBuilder();
42
43        for (int i = 0; i < words.length; i++) {
44            ans.append(trie.getRoot(words[i]));
45            if (i != words.length - 1) ans.append(" ");
46        }
47
48        return ans.toString();
49    }
50}
51