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

Q) What is Controller?
   Controller is referred to broker. It's duty is to update the metadata information to all nodes. Only one controller in a cluster.
   It monitors brokers, metrics, topics, replicas and so on.
   
Q) When Under-Replicated scenario comes??
   Only 2 brokers are available in a 3-Node Cluster
   Each partition will have a Leader.

Q) When Consumer Lack happens??
   When the producers are providing 1000ms data, but consumer taking 10ms data.
   So the period of data retain is 7 days - the data get loss.
   To solve it - Increase the performance/parallism of consumers.

	Run the Jconsole from Java/bin folder and check out the running java applications that displays -
		performance/parallism, Usgae, Network, Storage etc.,


### Conductor
This is a monitoring tool where you can observe the kafka streaming, topics, cosumers etc:-
In windows, download the Conductor.exe file and look into it.
It is an tool where you can produce data, consume data in any topic available or new one.
You can change the security functions of particular topic hear.

Pre-Requirement:- You need an available cluster setup already in the machine.


### Kafka Connect
There are many connectors in kafka:-
1. Source Connector - Ingest/Collect data to databases and stream table updates to kakfa topic.
2. Sink Connector - Deliver data from kafka topic to external systems  such as elasticsearch.

Q) When to use kafka connector, producer & consumer??
   Kafka connect is typically used to connect external sources to Kafka 
		i.e. to produce/consume to/from external sources from/to Kafka.
   Readily available Connectors only ease connecting external sources to Kafka 
		without requiring the developer to write the low-level code.

For starting a Connector Worker, you call the start script with a properties file:
	Windows: - $ bin\windows\connect-distributed.bat config\connect-distributed.properties
	Linux: - $ bin/connect-distributed.sh config/connect-distributed.properties


### Practise:-
We are using Alma Linux distribution in Virtual BOX.
Requirement:-
1. Installation of Virtual BOX, WinScP, ALMA Linux.ova distribution file.
2. Core: 4, Memory: 6GB, Network: Bridged Adapter, Traffic: Allow all
You can use the VM_BOX folder for files that I have used.