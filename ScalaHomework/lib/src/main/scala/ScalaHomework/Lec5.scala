package ScalaHomework

import ScalaHomework.DaysOfWeek.WeekDay
import ScalaHomework.one.Nums.{GOUACHE, PENCILS}

//Напишите функцию, которая принимает на вход два значения
// из перечисления (Enumeration)
// и возвращает список всех значений между ними

object one extends App {
  object Nums extends Enumeration {
    type medium = Value
    val GOUACHE = Value(1)
    val WATERCOLOR = Value(2)
    val PENS = Value(3)
    val PENCILS = Value(4)
    val MARKERS = Value(5)

  }

  def between(a: Nums.medium, b: Nums.medium) = {
    val list = Nums.values.toList
    val k: Int = a.id
    val p: Int = b.id
    for (i <- k + 1 until p) print(list(i - 1) + "   ")

  }


  print(between(GOUACHE, PENCILS))
}

//Создайте перечисление (реализовать 2 варианта) дней недели и напишите функцию,
// которая принимает на вход день недели и возвращает следующий за ним день

object DaysOfWeek extends Enumeration {
  type WeekDay = Value
  val Monday = Value(1)
  val Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

object DaysOfWeek2 extends Enumeration {
  type WeekDay2 = Value
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}


object Realization1 extends App {
  def findNext(d: WeekDay) = {
    println(DaysOfWeek(d.id + 1))
  }

  findNext(DaysOfWeek.Tuesday)
}

//Напишите функцию, которая принимает на вход список и возвращает новый список,
// содержащий только уникальные элементы из исходного списка

object OnlySpecial extends App {
  val list1 = List(1, 4, 5, 2, 3, 1, 2, 4)

  def special(l: List[Int]) = {
    l.toSet.filter(i => l.indexOf(i) == l.lastIndexOf(i)).toList
  }

  val list2 = List("Peter", "Peter", "Conni", "Luke", "Luke")

  def special2(l: List[String]) = {
    l.toSet.filter(i => l.indexOf(i) == l.lastIndexOf(i)).toList
  }

  println(special2(list2))
  println(special(list1))
}

//Напишите функцию, которая принимает на вход список Option[Int]
// и возвращает среднее значение чисел (игнорируя None)

object Srednie extends App {
  val lWithOpt: List[Option[Int]] = List(Option(1), None, Option(2))

  def middle(l: List[Option[Int]]) = {
    val ll = l.flatten
    val average: Double = (ll.sum / ll.size).toDouble
    println(average)
  }

  middle(lWithOpt)
}

//Напишите функцию, которая принимает на вход список Option[Int] и возвращает сумму всех значений,
// если они все есть, или None, если хотя бы одно значение отсутствует

object SUmm extends App {
  val lWithOpt: List[Option[Int]] = List(Option(1), None, Option(2))
  val lWithoutOpt: List[Option[Int]] = List(Option(1), Option(2))

  def ssum(l: List[Option[Int]]) = {
    l.reduce((x, y) => {
      if (x.isEmpty || y.isEmpty) None
      else Some(x.get + y.get)
    })
  }

  println(ssum(lWithOpt))
  println(ssum(lWithoutOpt))

}

//Напишите функцию, которая принимает на вход список Option[String]
// и возвращает новый список,
// содержащий только те строки, у которых длина больше 5 символов

object MoreFive extends App {
  val lWithOpt: List[Option[String]] = List(Option("ABCDEG"), None, Option("FDGF"))

  def more(l: List[Option[String]]) = {
    l.flatten.filter(_.length > 5)
  }

  println(more(lWithOpt))
}

//Напишите функцию, которая принимает на вход два списка List[String]
// и возвращает новый список,
// содержащий элементы, которые присутствуют в обоих исходных списках

object InBoth extends App{
  val listOne:List[String]="One"::"Two"::"Three"::"Four"::"Five"::Nil
  val listTwo:List[String]="One"::"Two"::"Five"::"Six"::Nil

  def both(l1:List[String],l2:List[String])={
    println(l1.filter(l2.contains))
  }
  both(listOne,listTwo)
}

//Напишите функцию, которая принимает на вход два списка List[Int]
// и возвращает список из всех возможных комбинаций элементов этих двух списков

object Combine extends App{
  val l1:List[Int]=2::3::4::7::Nil
  val l2:List[Int]=5::2::4::1::3::Nil
  def combinee(l:List[Int],ll:List[Int])={
    l.flatMap(i=>ll.map(k=>List(i,k)))
  }
  println(combinee(l1,l2))
}


