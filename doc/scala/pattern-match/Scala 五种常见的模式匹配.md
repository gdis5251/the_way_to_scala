# Scala 五种常见的模式匹配

## 1. 常量模式

常量模式包含常量变量和常量字面量

```scala
object PatternMatch {
  // 字面常量
  val BYTEDANCE = "bytedance.com"

  def foo(s: String): Unit = {
    s match {
      case BYTEDANCE => println("ok")
      case _ => println("can not match")
    }
  }

  def main(args: Array[String]): Unit = {
    // 常量变量
    val site = "bytedance.com"
    site match {
      case "bytedance.com" => println("ok")
      case _ => println("can not match")
    }

    foo("bytedance.com")
  }
}
```

**常量模式**由于需要匹配固定的字符串或其他类型的值，所以跟 if 判断没有什么区别。

## 2. 变量模式

变量模式没有什么意义，就是把一个变量传给另一个新的变量。

```scala
site match {whateverName => println(whateverName)}
```

这里只是把 site 的值传给了 whateverName 变量，没什么意义。但是变量模式有个约定，在 match 里的变量必须要小写字母开头，否则会被系统当成常量，系统回去尝试寻找该常量，如果没找到，就会报错。

## 3. 通配符模式

通配符使用下划线表示："_"，可以理解成一个占位符，如果学过 go 语言这里就很好理解。

通配符实际没什么用，表示该位置的值可以忽略。

在模式匹配中，通常会在最后一行加上 ```case _ => do something```，相对于其他常见语言就相当于 ``` default: do something```，表示这里任何类型或任何值都可以，是一个兜底方案。

```scala
List(1, 2, 3) match {
  case List(_, 2, _) => println("ok")
  case _ => println("can not match")
}
```

在第一个 case 中的通配符表示，要匹配一个含有三个元素的 list，且第二个元素的值是 2，其他两个元素的值不关注，什么都行。

## 4. 构造器模式

> 构造器模式才是真正能体现出模式匹配威力的地方

首先，先构造出一个二叉树

```scala
trait Node
case class TreeNode(value: String, left: Node, right: Node) extends Node
case class Tree(root: TreeNode)
```

然后构造一个根节点有左右叶子节点的二叉树

```scala
val tree = Tree(TreeNode("root", TreeNode("left", null, null), TreeNode("right", null, null)))
```

这个时候，如果想要匹配，一个根，左子树的值是"left"，右子树的值是"right"且右子树没有子节点

```scala
tree.root match {
  case TreeNode(_, TreeNode("left", _, _), TreeNode("right", null, null)) => println("ok")
  case _ => println("can not match")
}
```

## 5. 类型模式

类型模式就是判断该对象是否是某种类型。

```scala
"hello" match {_: String => println("hello")}
```

需要注意的是，如果使用了泛型，只能检测最外层的类型。

```scala
  def foo(s: Any): Unit = {
    s match {
      case a: List[String] => println("ok")
      case _ => println("can not match")
    }
  }

foo(List(1, 2, 3))
foo(List("A", "B", "C"))
```

这里两个 List 都可以匹配到，所以直接换成

```scala
case a: List[_] => do something
```

## 6. 变量绑定模式

上面二叉树的例子，如果你不仅希望可以匹配到符合要求的二叉树，还可以获取左子树的时候，你可以试试这样

```scala
tree.root match {
  case TreeNode(_, leftNode@TreeNode("left", _, _), TreeNode("right", null, null)) => println(leftNode.value)
  case _ => println("can not match")
}
```

可以在左子树前面加个变量名+ @，在后面就可以使用该变量了。



叮~:bell:

