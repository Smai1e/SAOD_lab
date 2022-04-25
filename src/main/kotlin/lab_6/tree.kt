package lab_6

data class Node(
    val value: String?,
    var isLeaf: Boolean,
    val children: MutableMap<String, Node> = mutableMapOf()
)

class Tree(val root: Node = Node(value = null, isLeaf= false)) {

    fun add(values: List<String>) {
        var children = root.children

        values.forEachIndexed { i, value ->
            val isLeaf = i == values.size - 1
            if (!children.contains(value)) {
                val node = Node(value, isLeaf)
                children[value] = node
                children = node.children

            } else {
                val node = children[value]!!
                if (isLeaf) { node.isLeaf = isLeaf }
                children = node.children
            }
        }
    }
}