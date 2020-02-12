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


### Step One: Using SSL 

To debug the SSL connection let the ACTIVEMQ_SSL_OPTS environment variable contain "-Djav... =ssl" or "-Djav... =all" 


In <ATIVEMQ_HOME>/conf/activemq.xml change the openWire protocol from using "tcp://..." to use "ssl://..."


If you encounter SSL handshake problems checking Active MQ's log <ACTIVEMQ_HOME>/data/activemq.log may contain useful hints.

If you need to check the available ciphers, you may use 'openssl ciphers' command.

If you need to install more or other ciphers ...



### Step Two: Using SSL, keystore, and truststore

To use the keystore data let the ACTIVEMQ_SSL_OPTS environment variable contain "-Djav... =path/to/keystore -Djav... =keystorePassword"





