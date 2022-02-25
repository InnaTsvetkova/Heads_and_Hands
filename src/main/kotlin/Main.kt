import kotlin.random.Random

fun arrayOfArrays(num: Int): Array<IntArray> {
    var randomLength: Int = Random.nextInt(0, 500)
    val arrRandomNum = ArrayList<Int>() //уже существующие размеры массивов

    val output = Array(size = num) {
        //проверка на совпадающие размеры массивов
        while (arrRandomNum.contains(randomLength)) {
            randomLength = Random.nextInt(0, 500)
        }
        arrRandomNum.add(randomLength)

        //создание массивов целых чисел
        val arr = IntArray(size = randomLength) {
            Random.nextInt(-100, 100)
        }
        arr
    }

    //сортировка
    for (i in output.indices) {
        output[i].sort()

        if (i % 2 == 0) {
            output[i].reverse()
        }
    }
    return output
}

fun main(args: Array<String>) {
    println("Введите натуральное число: ")
    var number = readLine()!!.toInt()

    while (number < 0) {
        println("Некорректный ввод. Введите другое число: ")
        number = readLine()!!.toInt()
    }

    val result = arrayOfArrays(number)

    result.forEach{
        println(it.joinToString(separator = " "))
    }

}