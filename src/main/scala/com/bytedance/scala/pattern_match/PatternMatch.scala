package com.bytedance.scala.pattern_match

object PatternMatch {
  // 字面常量
  val BYTEDANCE = "bytedance.com"

  def foo(s: Any): Unit = {
    s match {
      case a: List[String] => println("ok")
      case _ => println("can not match")
    }
  }

  trait Node
  case class TreeNode(value: String, left: Node, right: Node) extends Node
  case class Tree(root: TreeNode)

  def main(args: Array[String]): Unit = {
    // 常量变量
    val site = "bytedance.com"
    site match {
      case "bytedance.com" => println("ok")
      case _ => println("can not match")
    }

    // 字面常量
    foo("bytedance.com")

    // 通配符模式
    List(1, 2, 3) match {
      case List(_, 2, _) => println("ok")
      case _ => println("can not match")
    }

    val tree = Tree(TreeNode("root", TreeNode("left", null, null), TreeNode("right", null, null)))

    tree.root match {
      case TreeNode(_, TreeNode("left", _, _), TreeNode("right", null, null)) => println("ok")
      case _ => println("can not match")
    }

    tree.root match {
      case TreeNode(_, leftNode@TreeNode("left", _, _), TreeNode("right", null, null)) => println(leftNode.value)
      case _ => println("can not match")
    }
  }
}
