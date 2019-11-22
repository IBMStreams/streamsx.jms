# The JMS SSL Sample

This example implements a simple message exchange using the JMSSink and
JMSSource operators of IBM Streams' JMS toolkit. A small amount of messages
is read in and JMSSink posts them to an ActiveMQ broker that runs locally.

You can [download ActiveMQ](https://activemq.apache.org/components/classic/download/) and
extract it to a directory of your choosing.


**TODO:** Environment variable or **classLibs** parameter?


## Preparing the Active MQ broker

The ActiveMQ documentation introduces you to [SSL](https://activemq.apache.org/ssl-transport-reference)
and describes [how to use it with an ActiveMQ broker](https://activemq.apache.org/how-do-i-use-ssl).



