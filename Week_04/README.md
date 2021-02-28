# 深度优先搜索（Depth First Search）

从根开始，先遍历左子树节点，再遍历右子树节点。
-> 因此适合递归写法。

```java
public List<List<Integer>> levelOrder(TreeNode root) {        
    List<List<Integer>> allResults = new ArrayList<>();        
    if(root==null) {
        return allResults;
    }
    travel(root,0,allResults);
    return allResults;
}

private void travel(TreeNode root,int level,List<List<Integer>> results) {
    if(results.size()==level) {
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left!=null) {
        travel(root.left,level+1,results);
    }
    if(root.right!=null) {
        travel(root.right,level+1,results);
    }
}
```

# 广度优先遍历（Breadth First Search）

从根开始，依次遍历当前层级的所有节点，然后再下探到下一层级重复操作。
-> 通常的做法是维护一个队列，把节点按层装入队列，都出队之后再装入下一层。

```java
public List<List<Integer>> levelOrder(TreeNode root) 
{
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

# 贪心算法（Greedy）

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优的选择，而希望全局是最好或最优的算法。
动态规划则是保存以前的结果，根据以前的结果对当前进行选择。
-> 关键是证明每一步都选择最优能导致全局最优。这种情况下贪心只是自然而然的结果。

# 二分查找（Binary Search）

## 二分查找的条件

- 随机访问时间复杂度为O(1)：即，支持通过索引进行访问。所以通常用于数组。
- 有序性：具有单调性。没有的话，可以先排序。
- 有界性：存在上下界。

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } 
        else if (array[mid] > target) {
            right = mid - 1;
        } 
        else {
            left = mid + 1;
        }
    }
    return -1;
}
```
