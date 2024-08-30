package com.producertest;

import java.util.*;

import java.io.*;

import org.apache.kafka.clients.producer.*;

public class ProducerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String topicName = "logs";
		
		// Mention the File path where you have placed
		String filePath = "C:/Kafka_Training_Files/kafkajava/KafkaJava/serverlog-sample-1.txt";
		
		Properties props = new Properties();
		
	    props.put("bootstrap.servers", "localhost:9092,localhost:9093");
	    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("batch.size", 20480);
	    props.put("linger.ms", 1000);
	    
	    Producer<String, String> producer = new KafkaProducer <>(props);				  		   
		  
	    System.out.println("Starting KafkaProducerTest ...");

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
	            // Check if the line starts with "WARN"
	            if (line.startsWith("WARN") || line.startsWith("ERROR")) {
	            	
	                String content[] = line.split(" ");
	                
	                String key = content[0];
	                
	                // Remove "WARN" from the start of the line and trim any leading/trailing whitespace
	                String value = line.substring(5).trim();
	                
	                producer.send(new ProducerRecord<>(topicName, key, value));
                    System.out.println("Key: " + key + ", Value: " + value);
	            }
	        }
	        System.out.println("Production Completed...");
	    }		  
		catch (Exception e) { 
			e.printStackTrace();
		} 		  
		producer.close();
	    
	}

}
