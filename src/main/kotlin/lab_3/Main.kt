package lab_3
/*
Необходимо реализовать мнжество через связный список
 */
fun main() {
    val firstSet: Set = Set()
    val secondSet: Set = Set()
    var thirdSet: Set = Set()

    firstSet.add(1)
    firstSet.add(-3)
    firstSet.add(11)
    firstSet.add(4)
    firstSet.add(9)
    firstSet.add(4)
    firstSet.add(11)
    firstSet.add(11)
    firstSet.add(-7)
    println("first set:")
    firstSet.display()

    secondSet.add(20)
    secondSet.add(-3)
    secondSet.add(2)
    secondSet.add(3)
    secondSet.add(4)
    secondSet.add(18)
    println("second set:")
    secondSet.display()

//    firstSet.contains(9)
//    firstSet.contains(-6)

//======================================

//    firstSet.change(-3, 16)
//    println("after change:")
//    firstSet.display()

//======================================

//    firstSet.remove(1)
//    println("after remove element:")
//    firstSet.display()

//======================================

//    firstSet.clear()
//    println("after clear:")
//    firstSet.display()

//======================================

//    thirdSet = firstSet + secondSet
//    println("after merge")
//    thirdSet.display()

//======================================

//    thirdSet = firstSet.intersection(secondSet)
//    println("intersection: ")
//    thirdSet.display()

//======================================

//    thirdSet = firstSet - secondSet
//    println("After Delete Common Nodes")
//    thirdSet.display()
}