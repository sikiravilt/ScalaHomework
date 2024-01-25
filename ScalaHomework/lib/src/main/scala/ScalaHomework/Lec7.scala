package ScalaHomework

//Напишите функцию, которая принимает список функций и значение,
// а затем возвращает список результатов применения каждой функции к этому значению.
object Func1 extends App {
  def quad(i: Int) = i * i

  def plusTwo(i: Int) = i + 2

  def double(i: Int) = i * 2

  val fnList: List[Int => Int] = List(quad _, plusTwo _, double _)

  def functionOne(i: Int, list: List[Int => Int]) = {
    list.map(x => x(i))
  }

  println(functionOne(4, fnList))
}

//Напишите функцию высшего порядка, которая принимает список функций
// и возвращает новую функцию, которая применяет каждую функцию из списка
// к результату предыдущей функции.
// Например, если дан список функций List((x: Int) => x + 1, (x: Int) => x * 2),
// то результирующая функция должна выполнять следующее: f(x) = (x + 1) * 2

object Two extends App {
  def quad(i: Int) = i * i

  def plusTwo(i: Int) = i + 4

  def double(i: Int) = i * 2

  val fnList: List[Int => Int] = List(quad _, plusTwo _, double _)

  def hof1(f: List[Int => Int]): Int => Int = a => f.foldLeft(a) { (prev, f) => f(prev) }

  val res1 = hof1(fnList)
  val res2 = res1(3)
  println(res2)
}

//Напишите функцию, которая принимает другую функцию двух аргументов
// и возвращает каррированную версию этой функции (т.е. функцию,
// которая принимает первый аргумент и возвращает функцию, принимающую второй аргумент)

object Three extends App {
  def multiply(x: Int)(y: Int): Int = x * y

  def mylpiCurry: Int => Int = multiply(3)

  println(mylpiCurry(5))
}

//Напишите функцию, которая принимает три аргумента (String, Int, Double)
// и объединяет их в одну строку через пробел. Затем преобразуйте эту функцию
// в каррированную версию,
// которая принимает первый аргумент и возвращает функцию, принимающую оставшиеся два аргумента

object Four extends App {
  def intoLine(s: String, i: Int, d: Double) = {
    println(s"$s $i $d")
  }

  intoLine("Hi", 23, 5.3)

  def curryInLine = intoLine("Str", _, _)

  print(curryInLine(35, 46.7))
}

//Напишите частичную функцию, которая принимает список целых чисел и возвращает новый список,
// содержащий только те числа, которые являются квадратами других чисел

object Five extends App {

  //  def square:PartialFunction[List[Int],List[Int]]={
  //   case x if (for(i<-x) Math.sqrt(i)) ==x=>x
  //
  //  }
  //  val list=List(16,3,1,7,10,4)
  //  println(square(list))
  //

}

//Создайте implicit class для Int,
// который добавляет метод для умножения числа на определенное значение.
// Например, метод для умножения числа на 10

object Six extends App {
  implicit class MultipltByFive(x: Int) {
    def multi = x * 5
  }

  println(3.multi)
}

//Создайте implicit class для Int, который добавляет метод для проверки, является ли число четным

object Seven extends App {
  implicit class EvenOrNot(x: Int) {
    def even = {
      if (x % 2 == 0) "even" else "not even"
    }
  }

  println(3.even)
  println(6.even)
}

//Напишите implicit val для хранения значения курса обмена валюты (например, USD to RUB)
// и используйте его для функции конвертации суммы денег из одной валюты в другую
object Eight extends App {
  implicit val dollar = 89

  def convert(rub: Int)(implicit currency: Int) = {
    rub * currency
  }

  println(convert(2))
}

//Создайте case class Person с полями name:String и age:Int.
// Затем определите implicit val для объекта типа Ordering[Person],
// который сравнивает объекты Person по возрасту. Создайте List[Person],
// заполненный какими-либо экземплярами класса Person, напечатайте его на консоль,
// отсортируйте список и напечатайте отсортированный список на консоль

object Nine extends App {
  case class Person(name:String,age:Int)

  implicit val order:Ordering[Person]=Ordering.by(_.age)


  val list:List[Person]=List(new Person("Carl",12),new Person("Killian",10),new Person("Piter",16),new Person("Amanda",40))

  println(list)
  println(list.sorted)

}


