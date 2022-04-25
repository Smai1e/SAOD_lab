package lab_6
/*
Календарь за определенный период представлен в виде дерева (года – месяцы – дни – часы).
Составить программы ежедневник, позволяющую планировать свой рабочий процесс (записывать задания на определенную дату)
 */
fun main() {

    val tree = Tree()

    tree.add(arrayListOf("2022", "March", "5", "17:00", "clean the room" ))
    tree.add(arrayListOf("2022", "March", "5", "18:00", "go to the shop" ))
    tree.add(arrayListOf("2022", "March", "5", "15:00", "go to the shop" ))
    tree.add(arrayListOf("2022", "April", "18", "7:00", "walk the dog" ))
/*
                                    2022
                                   /    \
                              March      April
                               /            \
                              5              18
                           /     \             \
                        17:00   18:00           7:00
                        /           \              \
              clean the room    go to the shop    walk the dog
 */
    return
}