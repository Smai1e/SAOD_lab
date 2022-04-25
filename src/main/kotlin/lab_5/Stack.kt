package lab_5

class StackNode
{
    var element: Double
    var next: StackNode ?
    constructor(element: Double, next: StackNode ? )
    {
        this.element = element
        this.next = next
    }
}

class MyStack
{
    var top: StackNode ?
    var size: Int
    constructor()
    {
        this.top = null
        this.size = 0
    }
    fun push(element: Double)
    {
        this.top = StackNode(element, this.top)
        this.size += 1
    }
    fun isEmpty(): Boolean
    {
        return !(this.size>0 && this.top != null)
    }
    fun pop()
    {
        if (this.size>0 && this.top != null)
        {
            var temp: StackNode ? = this.top
            this.top = temp?.next
            this.size -= 1
        }
    }
    fun peek(): Double
    {
        return this.top!!.element
    }
}