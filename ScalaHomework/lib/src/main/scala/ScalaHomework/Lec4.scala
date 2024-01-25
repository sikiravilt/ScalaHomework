package ScalaHomework

import scala.util.Try


  //Напишите функцию, для вычисления площади каждой фигуры
  object Figures extends App{
    trait Figure

    case class Circle(r:Int) extends Figure
    case class Square(a:Int) extends Figure
    case class Rectangle(a:Int,b:Int) extends Figure
    case class Triangle(a:Int,h:Int) extends Figure

    def processFigure(ac:Figure)={
      ac match {
        case Circle(r)=> println(r*r*scala.math.Pi)
        case Square(a)=>println(a*a)
        case Rectangle(a,b)=>println(a*b)
        case Triangle(a,h)=>println(a*h*0.5)
        case _=> println("uknown figure")
      }
    }
    processFigure(Circle(5))
    processFigure(Square(4))
    processFigure(Rectangle(3,4))
    processFigure(Triangle(2,3))

  }

  //Напишите функцию, которая проверяет, содержит ли Option[String] определенное слово.
  // Если содержит,  то программа должна вывести "Слово найдено", иначе "Слово не найдено"

  object OpteionCheck extends App{
    def check(word:Option[String])=word match {
      case Some(w:String)=>println("Word found")
      case None=>println("Word is not found")
    }
    val word=Map("Class"->"Class","Pitch"->"Pitch")
    check(word.get("Class"))
    check(word.get("Mutiple"))
  }

  //Напишите функцию, которая принимает на вход Option[Int] с возрастом человека
  // и выводит категорию возраста (ребенок, подросток, взрослый и т. д.)

  object Person extends App{

    def age(age:Option[Int])={
      age match {
        case Some(n) if n<10&n>0=> println("Child")
        case Some(n) if (n>10&n<19)=> println("teen")
        case Some(n) if n>18=> println("adult")
        case None => println("no age found")
      }
    }
    val person = age(Some(12))
    val person1=age(Some(8))
    val person2=age(Some(55))
  }

  //Напишите функцию, которая делит числа a на число b.
  // Сделать 3 реализации, через Option, Try и Either

  object Delim extends App{
    def del1(a:Int,b:Int):Option[Int]={
      Some(a/b)
    }
    println(del1(6,3))

    def del2(a:Int,b:Int):Try[Int]={
      Try(a/b)

    }
    println(del2(6,3))
    println(del2(1,0))

    def del3(a:Int,b:Int):Either[String,Int]={
      if(b==0) Left("can't divide by zero")
      else Right(a/b)
    }
    println(del3(4,0))
    println(del3(6,3))
  }




