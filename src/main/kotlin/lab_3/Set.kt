package lab_3

class LinkNode(var data: Int) {
    var next: LinkNode? = null
}

class Set(
    private var head: LinkNode? = null,
    private var tail: LinkNode? = null
) {
    fun add(element: Int) {
        val node = LinkNode(element)

        if (this.head == null ||
            this.head!!.data >= element) {
            node.next = this.head
            this.head = node
        } else {
            var temp: LinkNode? = this.head
            var temp2: LinkNode? = this.head

            while (temp?.next != null && temp.next!!.data < element) {
                temp = temp.next
            }
            if (temp?.next == null) {
                this.tail?.next = node
                this.tail = node
                temp2 = temp?.next
                node.next = temp2?.next
                temp?.next = node

            } else if (node.data != temp.next!!.data) {
                node.next = temp.next
                temp.next = node

            } else if (node.data == temp.next!!.data) {
                temp2 = temp.next
                node.next = temp2?.next
                temp.next = node
            }
        }
    }

    operator fun plus(other: Set): Set {
        if (other.head == null) {
            return this
        } else if (this.head == null) {
            this.head = other.head
            this.tail = other.tail
        } else {
            var n1: LinkNode ? = this.head
            var n2: LinkNode ? = other.head
            var auxiliary: LinkNode?
            this.head = null
            this.tail = null
            while (n1 != null || n2 != null) {

                if (n1 != null && n2 != null) {
                    if (n1.data <= n2.data) {
                        auxiliary = n1
                        n1 = n1.next
                    } else {
                        auxiliary = n2
                        n2 = n2.next
                    }
                } else if (n1 != null) {
                    auxiliary = n1
                    n1 = n1.next
                } else {
                    auxiliary = n2
                    n2 = n2?.next
                }

                if (this.head == null) {
                    this.head = auxiliary
                    this.tail = auxiliary
                } else {
                    this.tail?.next = auxiliary
                    this.tail = auxiliary
                }
            }
        }
        other.head = null
        other.tail = null
        deleteDuplicate()
        return this
    }

    operator fun minus(other: Set): Set {
        var node: LinkNode? = this.head
        var prev: LinkNode? = null
        var key: Int

        while (node != null) {
            key = node.data
            if (other.remove(key)) {
                this.remove(key)
                node = if (prev != null) {
                    prev.next;
                } else {
                    this.head;
                }
            } else {
                prev = node
                node = node.next
            }
        }
        return this
    }

    private fun deleteDuplicate() {
        if (this.head == null) {
            return
        } else {
            var temp: LinkNode? = this.head?.next
            var current: LinkNode? = this.head
            var hold: LinkNode? = null

            while (temp != null) {
                if (current!!.data == temp.data) {
                    hold = temp
                } else {
                    current = temp
                }
                temp = temp.next
                if (hold != null) {
                    current.next = temp
                    hold = null
                }
            }
        }
    }

    fun display() {
        print("[")
        if (this.head == null) {
            print(" ]")
            return
        }
        var temp: LinkNode? = this.head
        while (temp != null) {
            print(""+ temp.data + " ")
            temp = temp.next
        }
        println("]")
    }

    fun remove(element: Int): Boolean {
        var node: LinkNode? = this.head
        var prev: LinkNode? = null
        var temp: LinkNode? = null
        var result = false
        while (node != null) {
            if (node.data == element) {
                result = true
                temp = node
            }
            if (temp == null) {
                prev = node
            }
            node = node.next
            if (temp != null) {
                if (temp == this.head) {
                    this.head = node
                }
                if (temp == this.tail) {
                    this.tail = prev
                }
                if (prev != null) {
                    prev.next = node
                }
                temp.next = null
                temp = null
            }
        }
        return result
    }

    fun intersection(other: Set): Set {
        val tempSet = Set()
        if (this.head == null || other.head == null) {
            return tempSet;
        } else {
            var a: LinkNode? = this.head
            var b: LinkNode? = other.head
            while (a != null && b != null) {
                if (a.data == b.data) {
                    tempSet.add(a.data)
                    a = a.next
                    b = b.next
                } else if (a.data > b.data) {
                    b = b.next
                } else {
                    a = a.next
                }
            }
        }
        return tempSet
    }

    fun change(elementI: Int, elementJ: Int) {
        this.remove(elementI)
        this.add(elementJ)
    }

    fun contains(element: Int) {
        var temp: LinkNode ? = this.head
        while (temp != null) {
            if(temp.data == element) {
                println(true)
                return
            }
            temp = temp.next
        }
        println(false)
    }

    fun clear() {
        this.head = this.tail?.next
    }
}