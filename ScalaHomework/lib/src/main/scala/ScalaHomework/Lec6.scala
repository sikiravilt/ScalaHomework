package ScalaHomework

//Напишите функцию, которая принимает на вход два множества Set[Int]
// и возвращает их объединение в виде нового множества
object TwoInOne extends App {
  val s1 = Set(2, 3, 4, 5)
  val s2 = Set(12, 13, 14, 15, 16)

  def newSet(s: Set[Int], ss: Set[Int]) = {
    (s ++ ss)
  }

  println(newSet(s1, s2))
}

//Напишите функцию, которая принимает на вход множество Set[Int] и элемент,
// и возвращает новое множество,
// содержащее все элементы из исходного множества, кроме данного элемента

object GetAwayOne extends App {
  val s = Set(2, 3, 4, 5, 1, 6, 45)

  def getOut(set: Set[Int], c: Int) = {
    println(set - c)
  }

  getOut(s, 5)
}

//Напишите функцию, которая принимает на вход два Set[Int]
// и возвращает новое множество, содержащее
// только те элементы, которые присутствуют только в одном из исходных множеств

object OnlyInOne extends App {
  val s1 = Set(2, 3, 4, 5, 1, 6, 45)
  val s2 = Set(2, 3, 1, 77, 4, 33, 22, 788)

  def getOnly(s: Set[Int], ss: Set[Int]) = {
    println((ss -- s) ++ (s -- ss))
  }

  getOnly(s1, s2)
}

//Напишите функцию, которая принимает Map[String, Option[Int]],
// и возвращает Map, где ключ - это строка, а значение - удвоенное значение из Option

object Twice extends App {
  val m: Map[String, Option[Int]] = Map("One" -> Option(1), "Two" -> Option(2), "Three" -> Option(3))

  def mTwice(mm: Map[String, Option[Int]]) = {
    mm.map {
      case (k, v) =>
        val newV = v match {
          case Some(i) => 2 * i
          case None => None
        }
        (k, newV)
    }
  }

  println(mTwice(m))
}

//Напишите функцию, которая принимает на вход Map[String, Int]
// и возвращает новый Map, в котором все значения увеличены на 1

object NewMapp extends App {
  val m: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3)

  def change(mm: Map[String, Int]) = {
    mm.map {
      case (k, v) =>
        (k, v + 1)
    }
  }

  println(change(m))
}

//Напишите функцию, которая принимает на вход Map[String, Int]
// и возвращает Map'ы, в первой ключи > 0, в другой < 0
object TwoMaps extends App {
  val m: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3,"Four" -> -4, "Five" -> -5, "Six" -> -6)
  def differents(mm: Map[String, Int])= {
    println(mm.filter((t) => t._2 > 0).toMap)
    println(mm.filter((t) => t._2 < 0).toMap)
  }

  differents(m)
}

//Напишите функцию, которая принимает на вход два Map[String, Int] и возвращает новый Map,
// содержащий только те ключи, которые есть в обоих исходных Map, а значения складываются
object BothKeys extends App {
  val m1: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3)
  val m2: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3, "Four" -> 4, "Five" -> 5, "Six" -> 6)

  def combine(m: Map[String, Int], mm: Map[String, Int]) = {
    (m.keySet.intersect(mm.keySet)).map { i => (i, m.getOrElse(i, 0) + mm.getOrElse(i, 0)) }.toMap
  }

  println(combine(m1, m2))
}

//Напишите функцию, которая принимает на вход два Map[String, Int] и возвращает новый Map,
// содержащий только те ключи, у которых значения равны
object ElementsEqual extends App {
  val m1: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3, "Four" -> 34, "Five" -> 5, "Six" -> 26)
  val m2: Map[String, Int] = Map("One" -> 1, "Two" -> 2, "Three" -> 3, "Four" -> 4, "Five" -> 5, "Six" -> 6)

  def equall(m: Map[String, Int], mm: Map[String, Int]) = {
    (m ++ mm.map(t => t._1 -> (if(t._2 == m.getOrElse(t._1, 0)) t._2 else -1))).filter((t) => t._2 > 0)
  }
  println(equall(m1,m2))
}