package com.pengshuai.school.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Created by YangPeng on 2020/2/5.
 */
public class ProduceMsg {

    private static Logger logger = Logger.getLogger(ProduceMsg.class);

    //序列化类
    private static final String SERIALIZER_CLASS = "org.apache.kafka.common.serialization.StringSerializer";
    //broker地址和端口
    private static final String BROKER_LIST = "127.0.0.1:9092";
    //创建的topic
    private static final String TOPIC = "test";

    private static Producer<String,String> buildProducer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", BROKER_LIST);
        props.put("acks","all");
        props.put("retries",0);
        props.put("batch.size",16384);
        props.put("buffer.memory",33554432);
        props.put("key.serializer",SERIALIZER_CLASS);
        props.put("value.serializer",SERIALIZER_CLASS);
        Producer<String,String> producer = new KafkaProducer<String, String>(props);
        return producer;
    }

    /**
     * 异步发送,不管消息是否发送成功
     */
    private static void asyncSend(){
        Producer<String,String> producer = buildProducer();
        for(int i= 0; i<10000;i++){
            producer.send(new ProducerRecord<String,String>(TOPIC,Integer.toString(i),"这条消息是：" + i));
        }
        producer.close();
    }

    /**
     * 同步发送，发送之后调用get()方法即可获得发送结果
     */
    private static void syncSend(){
        Producer<String,String> producer = buildProducer();
        for(int i= 0; i<10000;i++){
            try {
                RecordMetadata recordMetadata = producer.send(new ProducerRecord<String,String>(TOPIC,Integer.toString(i),"这条消息是：" + i)).get();
                logger.info("topic="+recordMetadata.topic()
                        +";offset="+recordMetadata.offset()
                        +";partition="+recordMetadata.partition()
                        +";timestamp="+recordMetadata.timestamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }

    private static void asyncSendByCallback(){
        Producer<String,String> producer = buildProducer();
        for(int i= 0; i<10000;i++){
            producer.send(new ProducerRecord<String,String>(TOPIC,Integer.toString(i),"这条消息是：" + i),new SendCallBack());
        }
        producer.close();
    }


    private static class SendCallBack implements Callback{
        @Override
        //recordMetadata和e只会一个有值，正常时recordMetadata有值，异常时e有值
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if(null != recordMetadata){
                logger.info("topic="+recordMetadata.topic()
                        +";offset="+recordMetadata.offset()
                        +";partition="+recordMetadata.partition()
                        +";timestamp="+recordMetadata.timestamp());
            }else{
                logger.error("发送异常" + e);
            }
        }
    }

    public static void main(String args[]){
//        asyncSend();
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

    }
}
