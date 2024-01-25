package ScalaHomework

import java.util.concurrent.Executors
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}
//Напишите функцию, которая принимает список строк
// и возвращает список Future, каждый из которых содержит длину соответствующей строки

object FutureLenght extends App {
  val pool = Executors.newFixedThreadPool(2)
  implicit val executionContext = ExecutionContext.fromExecutor(pool)

  def futureLenght(l: List[String]): List[Future[Int]] = {
    l.map(i => Future(i.length))
  }

  val listOfStrings = List("AA", "BBB", "CCCC")
  val result = futureLenght(listOfStrings).map(f => Await.result(f, Duration.Inf))
  println(result)
  pool.shutdown()
}
//Напишите функцию, которая принимает список Future[Int]
// и возвращает Future[Int], представляющий сумму всех значений в этих Future

object SumOfFuture extends App {
  val pool = Executors.newFixedThreadPool(2)
  implicit val executionContext = ExecutionContext.fromExecutor(pool)

  def sumFuture(list: List[Future[Int]]): Future[Int] = {
    Future.sequence(list).map(_.sum)
  }

  val futureList: List[Future[Int]] = (1 to 10).toList.map(fl => Future.successful(fl))
  println(futureList)
  println(Await.result(sumFuture(futureList), Duration.Inf))
  pool.shutdown()
}



//Напишите функцию, которая принимает список Future[String]
// и возвращает Future[List[String]], содержащий все значения из исходного списка,
// преобразованные в верхний регистр

object FutureToUpperCase extends App {
  val pool = Executors.newFixedThreadPool(2)
  implicit val executionContext = ExecutionContext.fromExecutor(pool)

  def futureUpperCase(str: List[Future[String]]): Future[List[String]] = {
    Future.sequence(str.map(_.map(_.toUpperCase)))
  }

  val listOfFuture = List(Future.successful("hi"), Future.successful("ola"), Future.successful("bonjorno"))
  println(Await.result(futureUpperCase(listOfFuture), Duration.Inf))
  pool.shutdown()
}
//Напишите функцию, которая асинхронно вызывает две функции,
// возвращающие Future[Int], и выводит на экран результат их суммы

object Summ extends App {
  val pool = Executors.newFixedThreadPool(2)
  implicit val executionContext = ExecutionContext.fromExecutor(pool)

  def func1(x: Int): Future[Int] = {
    Future {
      Thread.sleep(3000)
      x * 2
    }
  }

  def func2(x: Int): Future[Int] = {
    Future {
      Thread.sleep(1000)
      x - 2
    }
  }

  def SumOfTwoFunc = {
    for {
      f1 <- func1(3)
      f2 <- func2(7)
    } yield f1 + f2
  }

  SumOfTwoFunc.onComplete {
    case Failure(exception) => println(exception.getMessage)
    case Success(value)=>println(value)
  }
  Await.result(SumOfTwoFunc,Duration.Inf)
  pool.shutdown()
}
