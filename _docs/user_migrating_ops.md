---
title: "Migrating from Messaging Toolkit"
permalink: /docs/user/migration/
excerpt: "How to use this toolkit."
last_modified_at: 2019-05-07T13:38:00+01:00
redirect_from:
   - /theme-setup/
sidebar:
   nav: "userdocs"
---
{% include toc %}
{%include editme %}


## Migrating from JMS operators of the Messaging toolkit

The following information will help you to easily migrate from the JMS operators
of the [Messaging toolkit](https://github.com/IBMStreams/streamsx.messaging) to
the appropriate operators in the JMS toolkit.


### Migrating JMSSource operators

To migrate your application's JMSSource operator, do the following:

- Use com.ibm.streamsx.jms instead of com.ibm.streamsx.messaging.
- If you used parameter **messageIDOutAttrName**, use the parameter's new name **jmsMessageIDOutAttrName** now.

#### Other changes

The operator now uses the annotation method to generate the operator model XML file,
thus you may encounter the following changes:

- The operator now re-uses the **initDelay** parameter of the base class
- The code template has been removed, as it seems the annotation method does not provide
a mechanism to define code templates anymore:
```XML
<codeTemplate name="JMSSource">
	<description>Basic JMSSource template</description>
       <template>
       		stream&lt;${streamType}&gt; ${streamName} = JMSSource() {
       			param
       				connection : &quot;${ConnectionSpecificationName}&quot;;
       				access : &quot;${AccessSpecificationName}&quot;;
       		}
       </template>
</codeTemplate>
```

### Migrating JMSSink operators
 
To migrate your application's JMSSink operator, do the following:

- Use com.ibm.streamsx.jms instead of com.ibm.streamsx.messaging

#### Other changes

The operator now uses the annotation method to generate the operator model XML file,
thus you may encounter the following changes:

- The code template has been removed, as it seems the annotation method does not provide
a mechanism to define code templates anymore:
```XML
<codeTemplate name="JMSSink">
	<description>Basic JMSSink template</description>
	<template>
		() as ${sinkPrefix}Sink = JMSSink(${inputStream})   {
			param
				connection : &quot;${ConnectionSpecificationName}&quot;;
                access : &quot;${AccessSpecificationName}&quot;;
        }
    </template>
</codeTemplate>
```


