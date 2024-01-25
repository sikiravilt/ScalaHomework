package ScalaHomework

//Напишите функцию для проверки числа на четность/нечетность,
// вывести в консоль 3 примера, вида "число - чет/нечет"

object Odd extends App {
  def evenOrOdd(n: Int) = {
    if (n % 2 == 0) println("even")
    else println("Odd")
  }

  evenOrOdd(3)
  evenOrOdd(6)
}

//Напишите функцию, которая будет принимать на вход число и проверять,
// является ли оно положительным, отрицательным или нулём,
// вывести в консоль ответ.
object Check extends App {
  def posOrNegOrZero(n: Int) = {
    if (n > 0) println("positive")
    else if (n < 0) println("negative")
    else println("zero")
  }

  posOrNegOrZero(4)
  posOrNegOrZero(0)
  posOrNegOrZero(-8)
}

//Напишите 2 функции, которые с помощью цикла for выведет в консоль
// числа от 1 до 10 (включая и не включая 10).

object ToTen extends App {
  def including = {
    for {i <- 1 until 10}
      print(i + "  ")
  }

  def excluding = {
    for {i <- 1 to 10}
      print(i + "  ")
  }

  including
  println
  excluding
}

//Напишите функцию, которая с помощью цикла for
// выведет в консоль таблицу умножения на 5 до 10.

object Multiplication extends App {
  def multi = {
    for {i <- 1 to 10} {
      println(i + "*5=" + i * 5 + "  ")
    }
  }

  multi
}

//Написать функцию для вычисления чисел Фибоначчи(рекурсия и хвостовая рекурсия),
// вывести в консоль первые 10 чисел

object Fibonacci extends App {
  def tenFIbbonacci(n: Int): Int = {


    if (n <= 1) 0
    else if (n == 2) 1
    else tenFIbbonacci(n - 1) + tenFIbbonacci(n - 2)
  }

  for {i <- 1 to 10}
    print(tenFIbbonacci(i) + "  ")
}