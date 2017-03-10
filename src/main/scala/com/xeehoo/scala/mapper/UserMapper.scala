package com.xeehoo.scala.mapper

import org.apache.ibatis.annotations.Param

/**
 * Created by wangzunhui on 2017/3/2.
 */
trait UserMapper {
  def getName(@Param("id")id : Integer) : String;
}
