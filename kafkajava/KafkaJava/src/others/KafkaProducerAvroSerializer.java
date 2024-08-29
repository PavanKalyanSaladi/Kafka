package others;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import com.tekcrux.kafka.*;

public class KafkaProducerAvroSerializer {

	public static void main(String[] args) throws InterruptedException {
		
		String topicName = "avrotopic";
		
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.0.112:9092");
        props.put("acks", "1");  //"0" -No ack, "1" only Leader ,"all" ALL
        props.put("retries", 0);  // "0" doesn't re try ; positive value will retry
        props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "192.168.0.112:8081");

        Producer<String, Student> producer = new KafkaProducer<String, Student>(props);
        for (int i = 0; i < 10; i++) {
            Student s = new Student(i, "Student Name " + i);
            ProducerRecord<String, Student> record = new ProducerRecord<String, Student>(topicName, "my-key" + i, s);
            producer.send(record);
            Thread.sleep(500);
        }

        producer.close();
        System.out.println("message published");
    }
}



