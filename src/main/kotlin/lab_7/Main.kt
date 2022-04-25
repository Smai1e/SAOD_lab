package lab_7
/*
Во входном файле расположена последовательность целых чисел.
Выяснить есть ли в этой последовательности совпадающие числа. Решить задачу с помощью дерева.
 */
fun main(){
    val bt = BinaryTree()

    bt.add(6)           //                             6
    bt.add(4)           //                           /   \
    bt.add(8)           //                          /     \
    bt.add(7)           //                         4       8
    bt.add(8)           //                       /  \     /  \
    bt.add(8)           //                      3    5   7    9
    bt.add(3)
    bt.add(5)
    bt.add(7)
    bt.add(9)

    println(bt.duplicate)
}

