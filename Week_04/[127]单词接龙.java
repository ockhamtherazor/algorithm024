//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 705 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        wordList.add(beginWord);

        // 用两个队列分别装两端，两个哈希表存两端遍历过的节点
        Queue<String> queueStart = new LinkedList<>();
        Queue<String> queueEnd = new LinkedList<>();
        Set<String> visitedStart = new HashSet<>();
        Set<String> visitedEnd = new HashSet<>();
        queueStart.offer(beginWord);
        queueEnd.offer(endWord);
        visitedStart.add(beginWord);
        visitedEnd.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {
            count++;
            if (queueStart.size() > queueEnd.size()) {
                Queue<String> tmp = queueStart;
                queueStart = queueEnd;
                queueEnd = tmp;
                Set<String> t = visitedStart;
                visitedStart = visitedEnd;
                visitedEnd = t;
            }
            int size1 = queueStart.size();
            while (size1-- > 0) {
                String s = queueStart.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        if (visitedStart.contains(newString)) {
                            continue;
                        }
                        if (visitedEnd.contains(newString)) {
                            return count + 1;
                        }
                        if (allWordSet.contains(newString)) {
                            queueStart.offer(newString);
                            visitedStart.add(newString);
                        }
                    }
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }
}

//class Solution {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord))
//            return 0;
//
//        HashSet<String> wordSet = new HashSet<>(wordList);
//        Queue<WordNode> queue = new LinkedList<>();
//        queue.add(new WordNode(beginWord, 1));
//        while (!queue.isEmpty()) {
//            WordNode wn = queue.poll();
//            if (wn.word.equals(endWord))
//                return wn.step;
//            wordSet.remove(wn.word);
//            for (String w : wordSet) {
//                if (isTransformValid(w, wn.word))
//                    queue.add(new WordNode(w, wn.step + 1));
//            }
//        }
//
//        return 0;
//    }
//
//    private boolean isTransformValid(String s1, String s2) {
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i))
//                count++;
//            if (count > 1)
//                return false;
//        }
//        return true;
//    }
//}
//
//class WordNode {
//    String word;
//    int step;
//
//    WordNode(String w, int s) {
//        word = w;
//        step = s;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
