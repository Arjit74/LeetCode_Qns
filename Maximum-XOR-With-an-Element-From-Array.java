1class Solution {
2    private static final int MAX_INTEGER_BITS = Integer.SIZE;
3
4    public int[] maximizeXor(int[] nums, int[][] queries) {
5
6        /******-MY LOYAL GUARDS-**********************/
7        if (queries == null || queries.length == 0)
8            return new int[0];
9        if (nums == null || nums.length == 0) {
10            int[] ans = new int[queries.length];
11            Arrays.fill(ans, -1);
12            return ans;
13        }
14
15        //Left most significant bit may exist in nums or queries so make sure that we check for both
16        int leftMostBitIndex = 0;
17        for (int num : nums)
18            leftMostBitIndex = Math.max(leftMostBitIndex, getLeftMostBitIndex(num));
19
20        //We need the left most significant bit in the query as well
21        for (int[] query : queries)
22            leftMostBitIndex = Math.max(leftMostBitIndex, getLeftMostBitIndex(query[0]));
23
24        /**-MY MINI GUARD-**/
25        if (leftMostBitIndex < 0) {
26            int[] ans = new int[queries.length];
27            Arrays.fill(ans, 0);
28            return ans;
29        }
30
31        //We will be using a wrapper class for this
32        //Because after sorting the array we will miss out the original array position
33        QueryWrapper[] queryWrappers = new QueryWrapper[queries.length];
34        for (int i = 0; i < queries.length; i++)
35            queryWrappers[i] = new QueryWrapper(queries[i][0], queries[i][1], i);
36
37        //After we create that lets sort the queries and the nums
38        //We are sorting because when we are performing the query we will make sure that we are inserting all the numbers <=m1
39        Arrays.sort(nums);
40        Arrays.sort(queryWrappers, Comparator.comparingInt(QueryWrapper::maxAllowed));
41
42        //Now that we have the left most bit, we can create the trie
43        Trie trie = new Trie(leftMostBitIndex);
44
45        /**
46        Now perform the main logic,
47        We are traversing, for each element in queries we make sure that the trie consists of all the elements from num
48        lesser that or equal to m int eh current query
49        This is possible and will give the correct answer as we have sorted the queries and the nums
50         */
51        int[] ans = new int[queryWrappers.length];
52        for (int i = 0, j = 0; i < queryWrappers.length; i++) {
53            //Make sure to insert num, lesser that equal to m
54            while (j < nums.length && nums[j] <= queryWrappers[i].maxAllowed()) {
55                trie.insert(nums[j]);
56                j++;
57            }
58
59            //Nums length will be alwaye greater as we have a guard in the top
60            ans[queryWrappers[i].originalPosition()] = j == 0 ? -1 : trie.getMaxXOR(queryWrappers[i].xorWith());
61        }
62
63        return ans;
64    }
65
66    public int getLeftMostBitIndex(int num) {
67        /**-MY MINI GUARD-***/
68        if (num == 0)
69            return -1;
70
71        for (int bitIndex = MAX_INTEGER_BITS - 1; bitIndex >= 0; bitIndex--)
72            if ((num & (1 << bitIndex)) > 0)
73                return bitIndex;
74
75        return -1;
76    }
77}
78
79//We are strictly following encapsulation for all the classes below
80record QueryWrapper(int xorWith, int maxAllowed, int originalPosition) {
81};
82
83class Trie {
84    private final TrieNode root = new TrieNode();
85    private final int leftMostBit;
86
87    public Trie(int leftMostBit) {
88        this.leftMostBit = leftMostBit;
89    }
90
91    public void insert(int num) {
92        TrieNode current = root;
93        for (int bitIndex = leftMostBit; bitIndex >= 0; bitIndex--) {
94            int bit = ((1 << bitIndex) & num) > 0 ? 1 : 0;
95            current = current.put(bit);
96        }
97    }
98
99    public int getMaxXOR(int num) {
100        TrieNode current = root;
101        int maxXor = 0;
102        for (int bitIndex = leftMostBit; bitIndex >= 0; bitIndex--) {
103            int mask = 1 << bitIndex;
104            int bit = (mask & num) > 0 ? 1 : 0;
105            if (current.contains(bit ^ 1)) {
106                current = current.get(bit ^ 1);
107                maxXor |= mask;
108
109            } else
110                current = current.get(bit);
111        }
112        return maxXor;
113    }
114}
115
116class TrieNode {
117    private final TrieNode[] children;
118
119    public TrieNode() {
120        children = new TrieNode[2];
121    }
122
123    public TrieNode put(int bit) {
124        if (children[bit] == null)
125            children[bit] = new TrieNode();
126
127        return children[bit];
128    }
129
130    public TrieNode get(int bit) {
131        return children[bit];
132    }
133
134    public boolean contains(int bit) {
135        return children[bit] != null;
136    }
137}