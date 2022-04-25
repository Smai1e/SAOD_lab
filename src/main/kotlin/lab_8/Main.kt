package lab_8
/*
Составьте программу удаления записи из сбалансированного бинарного дерева поиска (АВЛ-дерево)
 и балансировки его в случае необходимости.
 */
fun main()
{
    val tree = AvlTree()
    tree.root = tree.addNode(tree.root, 12)
    tree.root = tree.addNode(tree.root, 7)
    tree.root = tree.addNode(tree.root, 5)
    tree.root = tree.addNode(tree.root, 19)
    tree.root = tree.addNode(tree.root, 17)
    tree.root = tree.addNode(tree.root, 13)
    tree.root = tree.addNode(tree.root, 11)
    tree.root = tree.addNode(tree.root, 3)
    tree.root = tree.addNode(tree.root, 2)
    /*
               12
              /  \
             /    \
            7      17
           / \     / \
          3   11  13  19
         / \
        2   5
    */
    tree.deleteTreeNode(12)
    /*
               13
              /  \
             /    \
            7      17
           / \      \
          3   11     19
         / \
        2   5
    */
    tree.deleteTreeNode(7)
    /*
               13
              /  \
             /    \
            3     17
           / \       \
          2   11     19
             /
            5
    */
    return
}