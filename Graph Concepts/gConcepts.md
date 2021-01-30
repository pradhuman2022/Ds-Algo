***Order to learn concepts:***

`What ?`

`Where to use + why ?`

`How to implement ?`

`Complexities ?`

*Topological Sort:*

* What ?

  * Topological Sort is just an linear order of vertices of DAG graph where order consider vertices of an edge u -> v like u comes first than v.
  * Topological sort could be implemented if graph is DAG(Directed Acyclic Graph is graph which don't have any cycle).
  * In DAG, there should be at least one node with 0 inorder degree and one node with 0 outdegree.
  * Topo sort start with nodes having zero in-degree and ends with nodes having zero outdegree.
  ex: https://zhu45.org/images/topological-sort-example.png
* Where to use ?

  * Problems where order matters, like while building any software app, it need to build all dependency packages first then we can only build main package. By Topo sort,
  we can get to know in which order will software denpendencies will build.
  * 
