# directory structure


log4j
├── src
│   ├── main
│   │   ├── java
│   │   │   └──Test.java(This is the entry program for constructing the call graph.)       
├── source(This is the directory containing the source code compiled from the analyzed program.)   
├── versions(Here is the source code of the analyzed program.) 
└── lib(These are the JAR files on which the analyzed program depends for execution.)
​

Running `src\main\java\Test.java` in the IDEA environment analyzes the project in the `source` directory, with the entry point being the `main` function in the `org.apache.log4j.TestThrowableStrRep` class.

# Error message

```
WARNING: java_runtime_dir null in wala.properties is invalid.  Using boot class path instead.
762 classes
Exception in thread "main" java.lang.IllegalStateException: Could not create a entrypoint callsites: 1. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ClassValue$ClassValueMap> No superclass found for <Primordial,Ljava/lang/ClassValue$ClassValueMap> Superclass name Ljava/util/WeakHashMap
2. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessBuilder$NullInputStream> No superclass found for <Primordial,Ljava/lang/ProcessBuilder$NullInputStream> Superclass name Ljava/io/InputStream
3. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessBuilder$NullOutputStream> No superclass found for <Primordial,Ljava/lang/ProcessBuilder$NullOutputStream> Superclass name Ljava/io/OutputStream
4. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessEnvironment$CheckedEntrySet> No superclass found for <Primordial,Ljava/lang/ProcessEnvironment$CheckedEntrySet> Superclass name Ljava/util/AbstractSet
5. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessEnvironment$CheckedKeySet> No superclass found for <Primordial,Ljava/lang/ProcessEnvironment$CheckedKeySet> Superclass name Ljava/util/AbstractSet
6. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessEnvironment$CheckedValues> No superclass found for <Primordial,Ljava/lang/ProcessEnvironment$CheckedValues> Superclass name Ljava/util/AbstractCollection
7. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/ProcessEnvironment> No superclass found for <Primordial,Ljava/lang/ProcessEnvironment> Superclass name Ljava/util/HashMap
8. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/RuntimePermission> No superclass found for <Primordial,Ljava/lang/RuntimePermission> Superclass name Ljava/security/BasicPermission
9. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/invoke/InnerClassLambdaMetafactory$ForwardingMethodGenerator> No superclass found for <Primordial,Ljava/lang/invoke/TypeConvertingMethodAdapter> Superclass name Ljdk/internal/org/objectweb/asm/MethodVisitor
10. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/invoke/TypeConvertingMethodAdapter> No superclass found for <Primordial,Ljava/lang/invoke/TypeConvertingMethodAdapter> Superclass name Ljdk/internal/org/objectweb/asm/MethodVisitor
11. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/management/ManagementPermission> No superclass found for <Primordial,Ljava/lang/management/ManagementPermission> Superclass name Ljava/security/BasicPermission
12. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/lang/reflect/ReflectPermission> No superclass found for <Primordial,Ljava/lang/reflect/ReflectPermission> Superclass name Ljava/security/BasicPermission
13. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Ljava/time/format/DateTimeFormatter$ClassicFormat> No superclass found for <Primordial,Ljava/time/format/DateTimeFormatter$ClassicFormat> Superclass name Ljava/text/Format
14. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/ActiveRecordingEvent> No superclass found for <Primordial,Loracle/jrockit/jfr/ActiveRecordingEvent> Superclass name Lcom/oracle/jrockit/jfr/InstantEvent
15. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/ActiveSettingEvent> No superclass found for <Primordial,Loracle/jrockit/jfr/ActiveSettingEvent> Superclass name Lcom/oracle/jrockit/jfr/InstantEvent
16. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/FlightRecorder> No superclass found for <Primordial,Loracle/jrockit/jfr/FlightRecorder> Superclass name Ljavax/management/StandardMBean
17. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/FlightRecording> No superclass found for <Primordial,Loracle/jrockit/jfr/FlightRecording> Superclass name Ljavax/management/StandardMBean
18. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/Recording$1> No superclass found for <Primordial,Loracle/jrockit/jfr/Recording$1> Superclass name Ljava/util/TimerTask
19. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/Recording$2> No superclass found for <Primordial,Loracle/jrockit/jfr/Recording$2> Superclass name Ljava/util/TimerTask
20. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/StringConstantPool$1> No superclass found for <Primordial,Loracle/jrockit/jfr/StringConstantPool$1> Superclass name Ljava/io/OutputStream
21. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/events/EventHandlerCreator$EventInfoClassLoader> No superclass found for <Primordial,Loracle/jrockit/jfr/events/EventHandlerCreator$EventInfoClassLoader> Superclass name Ljava/security/SecureClassLoader
22. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/events/EventHandlerImpl$1> No superclass found for <Primordial,Loracle/jrockit/jfr/events/EventHandlerImpl$1> Superclass name Ljava/util/TimerTask
23. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/jdkevents/throwabletransform/ConstructorTracerWriter> No superclass found for <Primordial,Loracle/jrockit/jfr/jdkevents/throwabletransform/ConstructorTracerWriter> Superclass name Ljdk/internal/org/objectweb/asm/ClassVisitor
24. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/jdkevents/throwabletransform/ConstructorWriter> No superclass found for <Primordial,Loracle/jrockit/jfr/jdkevents/throwabletransform/ConstructorWriter> Superclass name Ljdk/internal/org/objectweb/asm/MethodVisitor
25. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/openmbean/LazyImmutableJFRMBeanType$ImmutableCompositeData> No superclass found for <Primordial,Loracle/jrockit/jfr/openmbean/LazyImmutableJFRMBeanType$ImmutableCompositeData> Superclass name Lsun/management/LazyCompositeData
26. [Moderate] class com.ibm.wala.ipa.cha.ClassHierarchy$ClassExclusion : <Primordial,Loracle/jrockit/jfr/settings/JFCParser$ConfigurationHandler> No superclass found for <Primordial,Loracle/jrockit/jfr/settings/JFCParser$ConfigurationHandler> Superclass name Lorg/xml/sax/helpers/DefaultHandler
	...
	at com.ibm.wala.ipa.callgraph.propagation.PropagationCallGraphBuilder.makeCallGraph(PropagationCallGraphBuilder.java:241)
	at Test.main(Test.java:65)
```
