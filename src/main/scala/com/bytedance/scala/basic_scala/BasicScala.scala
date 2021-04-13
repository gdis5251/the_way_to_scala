package com.bytedance.scala.basic_scala

object BasicScala {
  /***
   * 柯里化函数
   * 柯里化：指的是将原来接受两个参数的函数，变成一个新的接受一个参数的函数的过程。新的函数返回一个原有第二个参数为参数的函数。
   */
  def mul(x: Int)(y: Int): Int = x * y

  /***
   * 可变长参数
   */
  def capitalizeAll(args: String*): Unit = {
    // capitalize: 将首字母变成大写
    args.foreach(x => {
      println(x.capitalize)
    })
  }

  def main(args: Array[String]): Unit = {
    // 柯里化函数
    val result = mul(2)_
    println(result(3))
    // end

    // 可变长参数
    capitalizeAll("aaa", "bbb")
    // end


  }
}
