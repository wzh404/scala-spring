package com.xeehoo.scala.test

/**
 * Created by wangzunhui on 2017/3/7.
 */
object VarianceDemo{

  def main(args : Array[String]): Unit ={
    val t : Temp[Super] = new Temp[Sub]
    println(t.toString)
    Library.print(f2)
    Library.print2(f1)
    Library.print3(f1, f2)
  }

  object Library {
    def print(info: Super => Sub): Unit = {
      println(info.isInstanceOf[Function1[_, _]])
    }

    def print2(info: Sub => Super): Unit = {
      println(info.isInstanceOf[Function1[_, _]])
    }

    def print3(f1: Sub => Super, f2: Super => Sub): Unit = {

      println(f1.asInstanceOf[f2.type]);
    }
  }

  class Temp[+A]{}

  class Super

  class Sub extends Super

  def f1(s : Sub) : Super = {
    return new Super
  }

  def f2(s : Super) : Sub = {
    return new Sub
  }

}
