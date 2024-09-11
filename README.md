# Kafka Streaming

==========================================================================

### Kafka-Cluster-Setup

Step-1: Follow the Kafka_Installation file for Single Node Cluster. <br/>
&emsp;&emsp;
		We are running in the windows, so use .bat excutable file in 2.12-3.6.1

Step-2: Worked on the 3.6.1v to create a multi node cluster by configuring server.properties as per the broker. <br/>
&emsp;&emsp;
		Follow the Kafka_Installation (for referrece) need to be done in config/ <br/>
&emsp;&emsp;
		```>bin\windows\zookeeper-server-start.bat config\zookeeper.properties```<br/>
&emsp;&emsp;
		```>bin\windows\kafka-server-start.bat config\server.properties``` <br/>
&emsp;&emsp;
		```>bin\windows\kafka-server-start.bat config\server1.properties``` <br/>
&emsp;&emsp;
		```>bin\windows\kafka-server-start.bat config\server2.properties```

Step-3: Run the Producer(Sync, Async, FF) and Consumer to understand the streaming.

Step-4: Created my own Producer that produces the WARNING messages package - ProducerTest in kafkaJava. <br/>
&emsp;&emsp;	You can consume through console by executing: <br/>
&emsp;&emsp;	```bin\kafka-console-consumer.bat --bootstrap-server localhost:9093 --topic topic-name```



### Kafka-Monitoring

We will use JMX Monitoring

Q) What is Controller?<br/>
&emsp;
   Controller is referred to broker. It's duty is to update the metadata information to all nodes. Only one controller in a cluster. <br/>
&emsp;
   It monitors brokers, metrics, topics, replicas and so on.
   
Q) When Under-Replicated scenario comes?? <br/>
&emsp;
   Only 2 brokers are available in a 3-Node Cluster <br/>
&emsp;
   Each partition will have a Leader. <br/>
&emsp;

Q) When Consumer Lack happens??<br/>
&emsp;
   When the producers are providing 1000ms data, but consumer taking 10ms data. <br/>
&emsp;
   So the period of data retain is 7 days - the data get loss. <br/>
&emsp;
   To solve it - Increase the performance/parallism of consumers. <br/>
&emsp;
	Run the Jconsole from Java/bin folder and check out the running java applications that displays - <br/>
&emsp;&emsp;
		performance/parallism, Usgae, Network, Storage etc.,


### Conductor
This is a monitoring tool where you can observe the kafka streaming, topics, cosumers etc:- <br/>
In windows, download the Conductor.exe file and look into it. <br/>
It is an tool where you can produce data, consume data in any topic available or new one. <br/>
You can change the security functions of particular topic hear. <br/>

Pre-Requirement:- You need an available cluster setup already in the machine.


### Kafka Connect
There are many connectors in kafka:-
1. Source Connector - Ingest/Collect data to databases and stream table updates to kakfa topic.
2. Sink Connector - Deliver data from kafka topic to external systems  such as elasticsearch.

Q) When to use kafka connector, producer & consumer?? <br/>
&emsp;
   Kafka connect is typically used to connect external sources to Kafka <br/>
&emsp;&emsp;
		i.e. to produce/consume to/from external sources from/to Kafka. <br/>
&emsp;
   Readily available Connectors only ease connecting external sources to Kafka <br/>
&emsp;&emsp;
		without requiring the developer to write the low-level code. <br/><br/>

For starting a Connector Worker, you call the start script with a properties file: <br/>
&emsp;
	Windows: - $ bin\windows\connect-distributed.bat config\connect-distributed.properties <br/>
&emsp;
	Linux: - $ bin/connect-distributed.sh config/connect-distributed.properties <br/>


### Practise:-
We are using Alma Linux distribution in Virtual BOX. <br/>
Requirement:-
1. Installation of Virtual BOX, WinScP, ALMA Linux.ova distribution file.
2. Core: 4, Memory: 6GB, Network: Bridged Adapter, Traffic: Allow all <br/>

You can use the VM_BOX folder for files that I have used.
1. Kafka-Connect <br/>
&emsp;	Follow the Apache-Kafka-File-Connect.txt to perform source & sink connectors. <br/>
&emsp;	You can Check by producing & consuming data with source and sink connector.
2. Confluent-KSQL <br/>
&emsp;	Follow the Confluent-Installation-Steps.txt to create a KSQL-server using confluent bin.


### Working on Stateless & Stateful components
Use the Kafka Version - Kafka_2.11-1.1.1 to perform stateless and stateful operations <br/>
Follow the below steps to setup the Single Node cluster:- <br/>
&emsp;
		```>bin\windows\zookeeper-server-start.bat config\zookeeper.properties```<br/>
&emsp;
		```>bin\windows\kafka-server-start.bat config\server.properties``` <br/>
&emsp;
		```>bin\windows\kafka-topics.bat --create --topic wordcount-input --zookeeper localhost:2181 --partitions 1 --replication-factor 1```<br/>
&emsp;
		```>bin\windows\kafka-topics.bat --create --topic wordcount-output --zookeeper localhost:2181 --partitions 1 --replication-factor 1```<br/>
&emsp;
		```>bin\windows\kafka-console-producer.bat --topic wordcount-input --broker-list localhost:9092``` <br/>

Ex:- Stateful Application <br/>
Now we are producing data from console and the java application com.tekcrux.kafka.streams <br/>
The WordCount.java streams the data from producer to consumer based on the date transmission. <br/>
The WordCountConsumer.java is to consume the data that is streaming from producer. <br/>
Run the WordCountConsumer.java & WordCount.java applications and produce the date from producer(console) like <br/>
&emsp;&emsp; hadoop hadOOP HadooP <br/>
&emsp;&emsp; kafka KAFKA Kafka <br/>
&emsp;&emsp; Hadoop HADOOP <br/>
######Output:- <br/>
key= hadoop | value = 3		<br/>
key= kafka | value = 3		<br/>
key= hadoop | value = 5		<br/>


### Working on KSQL-DB
Start the VM created (Confluent-KSQL) and run the follawing again to make it up <br/>
&emsp;
		```>bin\windows\zookeeper-server-start.bat config\zookeeper.properties```<br/>
&emsp;
		```>bin\windows\kafka-server-start.bat config\server.properties``` <br/>
'Referrece File - Ksql_Notes.txt'										  <br/>
Create a shell file and run this (root) whenever new terminal opens:- <br/>
'#!/bin/bash										<br/>
 export CONFLUENT_HOME=/opt/confluent				<br/>
 export PATH=${PATH}:$CONFLUENT_HOME/bin			<br/>
 confluent											<br/>
 confluent local services ksql-server status		<br/>
 confluent local services ksql-server start			<br/>
'
Now let's perform streaming using topic
1. Create a topic to stream it in KSQL				<br/>
&emsp; ```kafka-topics --create --zookeeper localhost:2181 --topic sample --partitions 1 --replication-factor 1``` <br/>
&emsp; 
	You can produce some data by running producer	<br/>
&emsp;
	```kafka-console-producer --bootstrap-server localhost:9092 --topic sample```
2. Now connect to DB by running []# ksql				<br/>
&emsp;
	```>show topics;```				<br/>
&emsp;
	Run the below command to check the data that is produced to topic	<br/>
&emsp;
	```>print 'sample';``` 			<br/>
&emsp;
	You can view the data in key, value from producer.		<br/>
Now let's create a stream in KSQL and observer the data from it.	<br/>
1. Create a stream in KSQL			<br/>
&emsp;
	```create stream user_stream(name varchar, countrycode varchar) with (kafka_topic='sample', value_format='DELIMITED');``` <br/>
&emsp;
	```show streams;``` <br/>
&emsp;
	```select * from USER_STREAM emit changes;```
2. Now the data you produced from sample topics it is getting streamed. <br/>
&emsp;
	```kafka-console-producer --broker-list localhost:9092 --topic sample``` <br/>
&emsp;
	```>Neeraj, India``` <br/>
&emsp;
	```>Stephen Curry, France``` <br/>
&emsp;
	```>ABCD, ``` <br/>

Exercise:- Follow the Ksql_Notes.txt file and practise the rest commands


### Kraft Cluster
Follow the steps mentioned in the kraft folder and	<br/>
&emsp;	use the kraft properties in kafka_2.12-3.6.1-pk/config/kraft


### Prometheus & Grafana
Bring up a single node cluster using P & G Setup.txt	<br/>
Requiremens: -	<br/>
```Java 11```	<br/>
```Kafka 2.12_3.6.1```	<br/>
Follow the steps mentioned in P & G Setup.txt and setup Prometheus & Grafana.	<br/>
Use the ID:- ```11962``` to use the metrix template while creating a new dashboard in Grafana.


### Kafka security
Trust Store - It will remain the same for both client and server.	<br/>
KeyStore - It will be different to both client and server also it varies on client ans server. 
It is like a private key	<br/>

Steps Invoved for SSL:
1. Encryption	-	Encrypting the data that can't be understandable.
2. Authentication	-	Verifying the client with jks & jts.
3. Authorization	-	Permitting the user to read/write/liat and so on.

Files created are listed below - for both client and user:-		<br/>
```-rw-r--r-- 1 root root 1830 Sep 10 15:36 ca-key```   <br/>
```-rw-r--r-- 1 root root 1830 Sep 10 15:36 ca-cert```  <br/>
```-rw-r--r-- 1 root root 1093 Sep 10 15:48 veer-request.csr``` <br/>
```-rw-r--r-- 1 root root 1464 Sep 10 15:51 veer-signed.crt```  <br/>
```-rw-r--r-- 1 root root 5686 Sep 10 15:54 veer.keystore.jks```    <br/>
```-rw-r--r-- 1 root root 1670 Sep 10 15:57 veer.truststore.jts```  <br/>
```-rw-r--r-- 1 root root 1368 Sep 10 16:08 offset.truststore.jts```    <br/>
```-rw-r--r-- 1 root root  973 Sep 10 16:27 client-request.csr```   <br/>
```drwxrwxrwx 2 root root 4096 Sep 10 16:27 .```    <br/>
```-rw-r--r-- 1 root root   41 Sep 10 16:27 ca-cert.srl```  <br/>
```-rw-r--r-- 1 root root 1346 Sep 10 16:27 client-signed.crt```    <br/>
```-rw-r--r-- 1 root root 4960 Sep 10 16:28 offset.keystore.jks```  <br/>
