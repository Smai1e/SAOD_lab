package lab_5
/*
Разработать программу, с помощью которой можно определить наибольший допустимый
 размер стека с вещественным информационным полем. Найти этот размер (число элементов в стеке).
 */
fun main(){
    val stack = MyStack() // 69 000 000

    for(i in 1..200000000) {
        stack.push(65.7885)
        if(i % 1000000 == 0){
            println(stack.size)
        }
    }
}