class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
          Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;
        Set<String> visited = new HashSet<>();

        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            visited.addAll(currentLevel);

            for (String word : currentLevel) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chs[i] = c;
                        String nextWord = new String(chs);

                        if (dict.contains(nextWord) && !visited.contains(nextWord)) {
                            graph.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);
                            nextLevel.add(nextWord);

                            if (nextWord.equals(endWord)) found = true;
                        }
                    }

                    chs[i] = old;
                }
            }

            currentLevel = nextLevel;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, graph, path, res);
        }

        return res;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> graph, List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            res.add(validPath);
            return;
        }

        if (!graph.containsKey(word)) return;

        for (String parent : graph.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, graph, path, res);
            path.remove(path.size() - 1);
        }
    }
}