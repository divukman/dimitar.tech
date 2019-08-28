# SpringBoot 2 -  Remote debugging 

This is a showcase of how to use remote debugging with SpringBoot application and IntelliJ.

## Resources

[SpringBoot docs for maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/examples/run-debug.html)



## Usage

```
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
			<configuration>
				<jvmArguments>-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005</jvmArguments>
			</configuration>
		</plugin>
	</plugins>
</build>
```

Or pass the VM arguments via command line:
```
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)