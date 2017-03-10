package scala.com.xeehoo.scala.test

/**
 * Created by wangzunhui on 2017/3/3.
 */
object ImplictDemo {
  class Type1{
    def func(s: String) = println(s)
  }

  object Conv{
    implicit def conv(t : Type2) = new Type1
  }

  class Type2{

  }

  def main(args: Array[String]){
    import Conv.conv
    //implicit def conv(t : Type2) = new Type1
    val t2 : Type2 = new Type2;
    t2.func("00000")
  }
}
