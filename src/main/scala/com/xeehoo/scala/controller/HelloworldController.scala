package com.xeehoo.scala.controller

import java.util

import com.xeehoo.scala.kafka.AKafkaProducer
import com.xeehoo.scala.service.UserService
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody}

/**
 * Created by wangzunhui on 2017/3/2.
 */

@Controller
class HelloworldController {
  val logger : Logger = LoggerFactory.getLogger(classOf[HelloworldController]);

  @Autowired
  var userService: UserService = null;

  @RequestMapping(value = Array("/scala/index"), method = Array(RequestMethod.GET))
  @ResponseBody
  def index (model: Model) = {
    logger.info("------------test-------");
    val p = new AKafkaProducer("119.254.84.20:9092", "neowave");
    p.send("hello kafka");

    val map = new util.HashMap[String, Object]();
    map.put("result", userService.getName(26));
    map
  }
}
