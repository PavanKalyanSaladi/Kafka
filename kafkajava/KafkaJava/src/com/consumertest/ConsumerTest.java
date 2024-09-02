package com.consumertest;

import java.util.*;

import org.apache.kafka.clients.consumer.*;

public class ConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String topicName = "logs";

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "false");
		props.put("auto_offset_reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		// create a KafkaConsumer instance with the specified configuration
		Consumer<String, String> consumer = new KafkaConsumer<>(props);

		// subscribe to the topic
		consumer.subscribe(Arrays.asList(topicName));

		System.out.println("Starting KafkaConsumer");

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("topic = %s, partition = %s,offset = %d, key = %s, value = %s\n", record.topic(),
						record.partition(), record.offset(), record.key(), record.value());
			}
			consumer.commitAsync();	
		}
	}

}
