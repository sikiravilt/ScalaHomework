package ScalaHomework

//Создайте класс Book с полями "заголовок", "автор" и "год издания". Создайте companion object для этого класса,
// в котором будет метод createBook, принимающий название,
// автора и год выпуска, и возвращающий объект Book с этими значениями
object BookInfo extends App{
  class Book( name:String, author:String, year:Int)
  object Book{
    def createBook(name:String, author:String, year:Int)={
      val book:Book=new Book(name, author, year)
    }
  }
  Book.createBook("Master and Margarita","Bulgakov",1966)
}

//Создайте кейс-классы для представления геометрических фигур: "круг", "прямоугольник",
// "квадрат", с необходимыми им параметрами. Отнаследуйте их от трейта "фигура",
// с методом расчета площади.
// Реализуйте метод расчета площади в каждом из наследников

object Geometric extends App{
  trait Figure{
    def area:Double
  }

  case class Circle(r:Int) extends Figure {
    override def area: Double = r*scala.math.Pi
  }

  case class Rectangle(a:Int,b:Int) extends Figure {
    override def area: Double = a*b
  }

  case class Square(a:Int) extends Figure {
    override def area: Double = a*a
  }

  val circle=new Circle(5)
  print("Area of Circle is= "+ circle.area+"\n")

  val rectangle=new Rectangle(4,5)
  print("Area of Circle is= "+ rectangle.area+"\n")
  val square=new Square(5)
  print("Area of Circle is= "+ square.area+"\n")
}