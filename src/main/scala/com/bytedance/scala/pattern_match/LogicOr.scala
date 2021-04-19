package com.bytedance.scala.pattern_match

object LogicOr {
  case class A(p1: String, p2: String)
  case class B(p1: Int, p2: Int)
  case class C(p1: String, p2: Int)

  def foo(msg: Any): Unit = {
    msg match {
      case _: A | _: B => println("match")
      case _ => println("can not match")
    }
  }

  def main(args: Array[String]): Unit = {
    foo(B(1, 2))
    foo(A("a", "b"))
    foo(C("1", 2))
  }
}
