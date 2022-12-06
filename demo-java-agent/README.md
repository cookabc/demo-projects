```shell
# build app
cd java-app
mvn clean install

# run app
cd ..
java -jar java-app/target/java-app-1.0-SNAPSHOT.jar
```

```shell
# build agent
cd java-agent
mvn clean install

# run app with agent
cd ..
java -javaagent:java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar -jar java-app/target/java-app-1.0-SNAPSHOT.jar
```