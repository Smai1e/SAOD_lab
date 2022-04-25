package lab_7

class BinaryTree {
    private var root: Node? = null
    val duplicate: MutableSet<Int> = mutableSetOf()

    fun add(value: Int) {
        root = addRecursive(root, value)
    }

    private fun addRecursive(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value)
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value)
        } else if (value == current.value) {
            duplicate.add(value)
        }
        return current
    }

    inner class Node(var value: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}