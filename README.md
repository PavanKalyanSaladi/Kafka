# Kafka-Redis-Training

==========================================================================

Step-1: Follow the Kafka_Installation file for Single Node Cluster. <br/>
&emsp; 	We are running in the windows, so use .bat excutable file in 2.12-3.6.1

Step-2: Worked on the 3.6.1v to create a multi node cluster by configuring server.properties as per the broker. <br/>
&emsp; 	Follow the Kafka_Installation (for referrece) need to be done in config/ <br/>
&emsp; 	```>kafka-server-start.bat ..\..\config\server.properties <br/>
&emsp; 	>kafka-server-start.bat ..\..\config\server1.properties	<br/>
&emsp; 	>kafka-server-start.bat ..\..\config\server1.properties	<br/> ```

Step-3: Run the Producer(Sync, Async, FF) and Consumer to understand the streaming.

Step-4: Created my own Producer that produces the WARNING messages package - ProducerTest in kafkaJava. <br/>
	You can consume through console by executing:
	```bin\kafka-console-consumer.bat --bootstrap-server loclahost:9093 --topic topic-name```
