package com.bytedance.scala

/**
 * Hello world!
 *
 */
object App {
  println( "Hello World!" )
  def test(a: Int = 1): Unit = {
    println(a)
  }

  def main(args: Array[String]): Unit = {
    test()
  }
}
