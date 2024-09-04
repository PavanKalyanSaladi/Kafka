# Kafka-Redis-Training

==========================================================================

### Kafka-Cluster-Setup

Step-1: Follow the Kafka_Installation file for Single Node Cluster. <br/>
&emsp;&emsp;
		We are running in the windows, so use .bat excutable file in 2.12-3.6.1

Step-2: Worked on the 3.6.1v to create a multi node cluster by configuring server.properties as per the broker. <br/>
&emsp;&emsp;
		Follow the Kafka_Installation (for referrece) need to be done in config/ <br/>
&emsp;&emsp;
		```>kafka-server-start.bat ..\..\config\server.properties``` <br/>
&emsp;&emsp;
		```>kafka-server-start.bat ..\..\config\server1.properties``` <br/>
&emsp;&emsp;
		```>kafka-server-start.bat ..\..\config\server1.properties```

Step-3: Run the Producer(Sync, Async, FF) and Consumer to understand the streaming.

Step-4: Created my own Producer that produces the WARNING messages package - ProducerTest in kafkaJava. <br/>
&emsp;&emsp;	You can consume through console by executing: <br/>
&emsp;&emsp;	```bin\kafka-console-consumer.bat --bootstrap-server loclahost:9093 --topic topic-name```



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