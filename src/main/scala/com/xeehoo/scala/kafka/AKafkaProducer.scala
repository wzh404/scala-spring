package com.xeehoo.scala.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{RecordMetadata, Callback, KafkaProducer, ProducerRecord}


/**
 * Created by wangzunhui on 2017/3/6.
 */
class AKafkaProducer(brokerList : String, topic : String) {
  private val props = new Properties()
  private var key : Int = 1

  props.put("bootstrap.servers", this.brokerList)
  props.put("request.required.acks", "1")
  props.put("producer.type", "async")
  props.put("client.id", "DemoProducer")
  props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  private val producer = new KafkaProducer[Int, String](this.props)

  def send(message : String): Unit ={
    val record = new ProducerRecord[Int, String](topic, key, message)
    producer.send(record, new Callback() {
      override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = {
        System.out.println("offset is  " + metadata.partition() + ":" + metadata.offset())
      }
    })
    key = key + 1
  }
}
