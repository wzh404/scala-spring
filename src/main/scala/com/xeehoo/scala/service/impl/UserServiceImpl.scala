package com.xeehoo.scala.service.impl

import com.xeehoo.scala.mapper.UserMapper
import com.xeehoo.scala.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by wangzunhui on 2017/3/2.
 */
@Service("userService")
class UserServiceImpl extends UserService{
  @Autowired
  var userMapper : UserMapper = null;

  override def getName(id: Integer) = {
    userMapper.getName(id)
  }
}
