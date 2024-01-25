package ScalaHomework

//Напишите обобщенную функцию,
// которая принимает список элементов любого типа и возвращает первый элемент списка

object FirstElem extends App{
  def returnFirst[T](input:List[T])={
    input.head
  }

  val list=List("First","Hi",35.7,12L)
  println(returnFirst(list))

}

//Напишите обобщенную функцию, которая принимает список элементов типа T
// и возвращает новый список, содержащий только уникальные элементы исходного списка
object OnlyUnique extends App{
  def unique[T](l:List[T])={
    l.toSet.filter(i => l.indexOf(i) == l.lastIndexOf(i)).toList
  }
  val list1=List("Hi","Hello","Hello","Bonjorno","Guten Morgen","Guten Morgen")
  val list2=List(1,2,3,6,2,3,8,90)
  println(unique(list1))
  println(unique(list2))
}

//Напишите обобщенную функцию, которая принимает
// список элементов любого типа и возвращает количество элементов в этом списке
object NumberOfElements extends App{
  def number[T<:Any](l:List[T])={
    l.length
  }
  val list1=List("Hi","Hello","Hello","Bonjorno","Guten Morgen","Guten Morgen")
  val list2=List(1,2,3,6,2,3,8,90)
  val list3=List(Option(3),Option(7),None,Option(30))
  println(number(list1))
  println(number(list2))
  println(number(list3))
}

//Напишите обобщенную функцию, которая принимает список элементов типа T
// и функцию преобразования типа T в тип U, и возвращает список элементов типа U,
// полученных применением этой функции к каждому элементу исходного списка

object OneToAnother extends App{
  def oneToAnother[T,U](l:List[T], f:T => U):List[U]={
    l.map(f)
  }

  val doubleToLong:Double=>Long=(i:Double)=>i.asInstanceOf[Number].longValue()
  val listofDoubles=List(3.24,34.7,32.11)
  println(oneToAnother(listofDoubles, doubleToLong))
}