package com.producertest;

import java.util.*;

import org.apache.kafka.clients.producer.*;

public class ProducerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String topicName = "logs";
		
		Dictionary<String, String> dict= new Hashtable<>();
		dict.put("INFO1", "This is a message with content");
		dict.put("INFO2", "This is a some other message");
		dict.put("INFO3", "Sample message one more time");
		dict.put("WARN1", "You have unused variables in your code");
		dict.put("ERROR1", "Something bad happened");
		dict.put("ERROR2", "NoClassDefFound Exception thrown");
		dict.put("WARN2", "More details about the error");
		dict.put("INFO4", "Back to normal");
		dict.put("INFO5", "This is a message with content");
		dict.put("ERROR3", "Something bad happened");
		
		Properties props = new Properties();
		
	    props.put("bootstrap.servers", "localhost:9092,localhost:9093");
	    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("batch.size", 20480);
	    props.put("linger.ms", 1000);
	    
	    Producer<String, String> producer = new KafkaProducer <>(props);				  		   
		  
	      System.out.println("Starting KafkaProducerTest ...");
	      
		  try { 
			  Enumeration<String> k = dict.keys();
		      while (k.hasMoreElements()) {
		    	  String key = k.nextElement();
		          producer.send(new ProducerRecord<>(topicName, key + " : "+ dict.get(key)));
		          System.out.println("Key: " + key + ", Value: "+ dict.get(key));
		      }
		      System.out.println("Production Completed...");
		  }
		  catch (Exception e) { 
			  e.printStackTrace();
		  } 		  
		  producer.close();
	    
	}

}
