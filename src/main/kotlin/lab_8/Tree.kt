package lab_8
class Node(var data: Int) {
    var height: Int = 1
    var left: Node? = null
    var right: Node? = null
}

class AvlTree() {
    var root: Node? = null

    private fun getHeight(node: Node? ): Int {
        if (node == null) {
            return 0
        }
        return node.height
    }
    private fun maxHeight(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    private fun rightRotate(node: Node? ): Node? {
        val leftNode: Node? = node?.left
        val rightSubtree: Node? = leftNode?.right
        leftNode?.right = node
        node?.left = rightSubtree
        node!!.height = this.maxHeight(
            this.getHeight(node.left),
            this.getHeight(node.right)) + 1
        leftNode!!.height = this.maxHeight(
            this.getHeight(leftNode.left),
            this.getHeight(leftNode.right)
        ) + 1
        return leftNode
    }

    private fun leftRotate(node: Node? ): Node? {
        val rightNode: Node? = node?.right
        val leftSubtree: Node? = rightNode?.left
        rightNode?.left = node
        node?.right = leftSubtree
        node!!.height = this.maxHeight(
            this.getHeight(node.left),
            this.getHeight(node.right)) + 1

        rightNode!!.height = this.maxHeight(
            this.getHeight(rightNode.left),
            this.getHeight(rightNode.right)
        ) + 1
        return rightNode
    }
    private fun getBalanceFactor(node: Node? ): Int {
        if (node == null) {
            return 0
        }
        return this.getHeight(node.left) - this.getHeight(node.right)
    }

    fun addNode(node: Node? , data : Int): Node? {
        if (node == null) {
            return Node(data)
        }
        if (data < node.data) {
            node.left = this.addNode(node.left, data)
        } else if (data > node.data) {
            node.right = this.addNode(node.right, data)
        } else {
            return node
        }

        node.height = 1 + this.maxHeight(
            this.getHeight(node.left), this.getHeight(node.right))
        val factor: Int = this.getBalanceFactor(node)
        if (factor > 1 && data < node.left!!.data) {
            return this.rightRotate(node)
        }
        if (factor < -1 && data > node.right!!.data) {
            return this.leftRotate(node)
        }
        if (factor > 1 && data > node.left!!.data) {
            node.left = this.leftRotate(node.left)
            return this.rightRotate(node)
        }
        if (factor < -1 && data < node.right!!.data) {
            node.right = this.rightRotate(node.right)
            return this.leftRotate(node)
        }
        return node
    }
    private fun preorder(node: Node ? ) {
        if (node != null) {
            print("  " + node.data)
            this.preorder(node.left)
            this.preorder(node.right)
        }
    }

    private fun minKeyNode(node: Node? ): Node? {
        var result: Node? = node
        while (result?.left != null) {
            result = result.left
        }
        return result
    }

    private fun deleteNode(head: Node? , data : Int): Node? {
        var node = head
        if (node == null) {
            return node
        }
        if (data < node.data) {
            node.left = this.deleteNode(node.left, data)
        } else if (data > node.data) {
            node.right = this.deleteNode(node.right, data)
        } else {
            if ((node.left == null) || (node.right == null)) {
                var temp: Node? = null
                if (node.left != null) {
                    temp = node.left
                } else if (node.right != null) {
                    temp = node.right
                }
                node = temp
            } else {
                var temp: Node? = this.minKeyNode(node.right)
                node.data = temp!!.data
                node.right = this.deleteNode(node.right, temp.data)
            }
        }
        if (node == null) {
            return node
        }
        node.height = 1 + this.maxHeight(
            this.getHeight(node.left), this.getHeight(node.right))

        val balance: Int = this.getBalanceFactor(node)

        if (balance > 1 && this.getBalanceFactor(node.left) >= 0) {
            return this.rightRotate(node)
        }
        if (balance > 1 && this.getBalanceFactor(node.left) < 0) {
            node.left = this.leftRotate(node.left);
            return this.rightRotate(node)
        }
        if (balance < -1 && this.getBalanceFactor(node.right) <= 0) {
            return this.leftRotate(node)
        }
        if (balance < -1 && this.getBalanceFactor(node.right) > 0) {
            node.right = this.rightRotate(node.right)
            return this.leftRotate(node)
        }
        return node
    }

    private fun nodeExist(node: Node? , data : Int): Boolean {
        if (node == null) {
            return false
        } else {
            if (node.data == data) {
                return true
            }
            return (this.nodeExist(
                node.left, data) || this.nodeExist(node.right, data))
        }
    }

    fun deleteTreeNode(data: Int) {
        if (this.root != null && this.nodeExist(this.root, data)) {
            println("\n Before Delete node $data element")
            this.preorder(this.root)
            this.root = this.deleteNode(this.root, data)
            println("\n After Delete node $data element")
            this.preorder(this.root)
        } else {
            println("\n Deleted node $data is not found")
            this.preorder(this.root)
        }
    }
}