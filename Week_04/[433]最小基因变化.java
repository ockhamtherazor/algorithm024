//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意： 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 
//
// 示例 1： 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2： 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3： 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 67 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank)); // bank装入HashSet方便查询
        Queue<Pair> queue = new LinkedList<>();

        // 基因库里没有结果就不用查了
        if (!bankSet.contains(end))
            return -1;

        // 找到基因库里和当前序列差一次变化的序列加入队列，并从基因库里删除，直到找到结果序列或没有符合条件的序列。
        queue.add(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.gene.equals(end))
                return p.step;
            bankSet.remove(p.gene);
            for (String str : bankSet) {
                if (isValid(p.gene, str))
                    queue.add(new Pair(str, p.step + 1));
            }
        }

        return -1;
    }

    // 辅助函数，判断两个序列是否只差一个字母
    private boolean isValid(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }

        return true;
    }
}

// 辅助类
class Pair {
    String gene;
    int step;

    Pair(String g, int s) {
        gene = g;
        step = s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
