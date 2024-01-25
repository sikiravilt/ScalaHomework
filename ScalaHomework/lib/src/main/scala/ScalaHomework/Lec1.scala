package ScalaHomework

import scala.math.sqrt

//напишите функцию для возведения числа в квадрат,
// вывести в консоль три примера вида "число - квадрат"

object Qudrat extends App {
  def square(x:Int):Int= x*x

  println("2 - "+ square(2))
  println("4 - "+square(4))
  println("6 - "+square(6))
}

//Напишите функцию,
// которая будет принимать на вход радиус окружности
// и возвращать её площадь, вывести в консоль.

object Rad extends App{
  def radius(r:Double)= r*r*3.14
  println(radius(5))
}

//Напишите функцию,
// которая будет принимать на вход температуру в градусах Цельсия
// и выводить её эквивалент в градусах Фаренгейта, вывести в консоль.

object Far extends App{
  def faringate(c:Int)= c*1.8+32
  println("5 Celsius in Faringates= "+faringate(5))
}

//Напишите функцию,
// которая будет принимать на вход строку и возвращать её длину, вывести в консоль.

object Stroka extends App{
  def str(str:String)=str.length
  println(str("ABCDEFG"))
}

//Напишите функцию,
// которая будет вычислять расстояние между 2 точками, вывести в консоль.


object Distance extends App{

  def distance(x1:Int, x2:Int,y1:Int,y2:Int)= {
    val d1= (x2*x2-2*x2*x1+x1*x1)+(y2*y2-2*y2*y1+y1*y1)
    sqrt(d1)
  }
  println(distance(3,7,2,8))
}