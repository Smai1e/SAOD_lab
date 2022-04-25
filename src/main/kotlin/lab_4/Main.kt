package lab_4
/*
Сохраните список в массиве А, чьи записи содержат два поля:
data – для элементов и поле position – для позиций (целых чисел) элементов.
Напишите процедуру DELETE(p, L) для удаления элемента в позиции р.
Включите в процедуру все необходимые проверки на «внештатные» ситуации.
 */
import List.myList

fun main() {

    myList.print()

    myList = myList.pushItem(6.6)
    myList.print()

    myList = myList.popItem(2)
    myList.print()

    myList = myList.popItem(-5)
    myList.print()

    myList = myList.popItem(8)
    myList.print()

    myList = myList.pushItem(3.76)
    myList.print()
}

private fun Array<Pair<Int, Number>?>.pushItem(item: Number): Array<Pair<Int, Number>?> {

    val newArray = this.copyOf(this.size + 1)
    newArray[this.size] = this.size to item
    return newArray
}

private fun Array<Pair<Int, Number>?>.popItem(id: Int): Array<Pair<Int, Number>?> {

    var newArray = arrayOfNulls<Pair<Int, Number>?>(this.size)
    if (id >= 0) {

        var i = 0
        var position: Int
        var flag = false

        this.forEach {

            if (it != null) {
                if (id != it.first) {

                    position =
                        if (id < it.first) it.first - 1
                        else it.first
                    newArray[i] = position to it.second
                    ++i
                }
                if (id <= it.first) flag = true
            }
        }

        if (flag && newArray[i] == null)
            newArray = newArray.copyOf(newArray.size - 1)
    } else {
        newArray = this.copyOf()
    }
    return newArray
}

fun Array<Pair<Int, Number>?>.print() {

    var buf = ""
    this.forEach {
        buf += "$it "
    }
    println(buf)
}