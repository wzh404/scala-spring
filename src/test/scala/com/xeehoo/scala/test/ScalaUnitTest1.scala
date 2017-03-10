package com.xeehoo.scala.test

import org.scalatest.FunSuite

/**
 * Created by wangzunhui on 2017/3/3.
 */
class ScalaUnitTest1 extends FunSuite{
  test("implicit-parameter"){
    def calc(amount: Float)(implicit rate: Float): Float = amount * rate
    implicit val r : Float = 0.5F
    val tax = calc(8000F)
    assert(tax == 4000F)
  }

  test("implicit-convert-type"){
    implicit def conv(f : Float) = f.toInt
    val i : Int = 4.3F

    assert(i == 4)
  }

  class Type1{
    def func(s: String) = println(s)
  }

  object Conv{
    implicit def conv(t : Type2) = new Type1
  }

  class Type2{

  }

  test("implicit-method-call"){
    import Conv.conv
    val t2 : Type2 = new Type2;
    t2.func("00000")
  }
}
