package scalaproblems

/**
  * Created by borisbondarenko on 25.04.16.
  */
object P46 extends App {

  implicit class BoolOps(a: Boolean) {
    def and (b: Boolean) = a && b
    def or  (b: Boolean) = a || b
    def nand(b: Boolean) = not(a and b)
    def nor (b: Boolean) = not(a or b)
    def equ (b: Boolean) = (a and b) or (not(a) and not(b))
    def xor (b: Boolean) = not(a equ b)
    def impl(b: Boolean) = not(a) or b
  }

  def not(a: Boolean) = !a

  def table2(f: (Boolean, Boolean) => Boolean) : Unit = {
    val bools = Set(true, false)
    println("A\t\tB\t\tRes")
    for {
      a <- bools
      b <- bools
    } println(s"$a\t$b\t" + f(a,b))
  }

  def gray(c: Int): List[String] = {
    def loop(acc: List[String], rest: Int) : List[String] = {
      val nAcc = acc.map { "0" + _ } ::: acc.reverse.map { "1" + _ }
      if(rest == 1) nAcc
      else loop(nAcc, rest - 1)
    }

    loop(List(""), c)
  }


  table2((a: Boolean, b: Boolean) => a and (a or not(b)))

  println(gray(400))
}
