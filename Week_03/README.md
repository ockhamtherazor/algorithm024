# 递归（Recursion）

## 递归要点

- 可以用数学归纳法寻找相关性，但必须抵制人肉递归。
- 找到最近可重复子问题。

## 递归的代码模板

先写模板再填充内容有助于避免疏漏。

```java
public void recursion(int level, int param) {
    // 先写终止条件，排除边界情况 
    if (level > MAX_LEVEL) { 
        processResult(); // 结果处理
    	return; 
    } 
    
    // 对当前节点进行操作
	process(level, param); 
  
    // 递归下钻
  	recursion(level + 1, newParam); 

  	// 如果有需要的话，保存当前状态 
}
```

---

# 分治（Divide and Conquer）和回溯（Backtracking）

## 分治的代码模板

```
def divide_conquer(problem, param1, param2, ...):  
	// recursion terminator  
	if problem is None:  
  print_result  
  return  
	// prepare data  
	data = prepare_data(problem)  
	subproblems = split_problem(problem, data)  
	// conquer subproblems  
	subresult1 = self.divide_conquer(subproblems[0], p1, ...)  
	subresult2 = self.divide_conquer(subproblems[1], p1, ...)  
	subresult3 = self.divide_conquer(subproblems[2], p1, ...)  
	// process and generate the final result  
	result = process_result(subresult1, subresult2, subresult3, …)
	// revert the current level states
```

## 回溯的思想

在搜索中，发现已经不满足求解条件时，就返回，尝试其他路径。回溯是一种对搜索的优化。   
对于递归而言，回溯就是在某一层发现无法满足条件时，退回上一层。