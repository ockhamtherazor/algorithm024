# Week 1 学习笔记

## 数组Array

Java实现
ArrayList：增加元素时检查空间是否足够，不够直接创建一个2倍大小的新数组，然后copy。删除元素时，新建一个缩小了大小的新数组，然后copy。  
<http://developer.classpath.org/doc/java/util/ArrayList-source.html>

基本操作
查询：O(1)。可以随机访问。
插入：O(n)。需要移位。
删除：O(n)。需要移位。

---

## 链表Linked List

Java实现
LinkedList无法随机访问其中任意元素，但可以直接访问头结点和尾结点，因此可以作为Stack和Queue的实现。它既有next指针也有previous指针，实际是一个双向链表。   
<http://developer.classpath.org/doc/java/util/LinkedList-source.html>

基本操作
查询：O(n)。需要遍历。
插入：O(1)。修改指针即可。
删除：O(1)。修改指针即可。

---

## 跳表Skip List

实现概念
本质是一个有索引的链表。利用每层数量指数递减的多层索引减少查询时间。

基本操作
查询：O(logn)。根据多层索引查询。
插入：O(nlogn)。需要更新索引。
删除：O(nlogn)。需要更新索引。

应用
Redis中采用的数据结构

---

## 栈Stack

Java实现
Stack由Vector实现（线程安全）。  
<http://developer.classpath.org/doc/java/util/Stack-source.html>

基本操作
查询：O(n)。
插入：O(1)。
删除：O(1)。

应用
解决“最近相关性”问题时应该考虑使用栈的肯能行。

---

## 队列Queue

Java实现
Queue本身是一个Interface，根据不同情况选择不同实现。
双端队列Deque：需要FILO和FIFO的数据结构都可以直接使用Deque。也是一个Interface，根据具体情况选择实现。  
<http://fuseyism.com/classpath/doc/java/util/Queue-source.html>

基本操作
查询：O(n)。
插入：O(1)。
删除：O(1)。

应用
解决“先来后到”类问题。