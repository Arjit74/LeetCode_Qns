class Solution {
    class Trie {
        class Node {
            Node[] child = new Node[26];
            boolean isTerminal;
        }

        Node root = new Node();

        void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
            }
            curr.isTerminal = true;
        }

        String getRoot(String word) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.child[idx] == null) return word;
                sb.append(word.charAt(i));
                curr = curr.child[idx];
                if (curr.isTerminal) return sb.toString();
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) trie.insert(s);

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            ans.append(trie.getRoot(words[i]));
            if (i != words.length - 1) ans.append(" ");
        }

        return ans.toString();
    }
}
