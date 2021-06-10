This is a sample app demonstrating java sdk integration with CF 

## To use this application, follow the steps as below ##

1) Create a project in Harness with Feature-flags module enabled
2) Create an environment within your project
3) Create a server-side sdk key in your environment **COPY the value from the Admin Console to your clipboard since this value will only be displayed once**
4) Create a boolean feature-flag in the admin console
5) Import the maven project in an IDE such as [IntelliJ](https://www.jetbrains.com/idea/)
6) Replace the values for SDK Key and feature-flag identifier in the example program from step 3 and 4
7) Run the program from the IDE

We are using the java sdk jar as dependency for this sample program
``` 
            <dependency>
                <groupId>io.harness</groupId>
                <artifactId>ff-java-server-sdk</artifactId>
                <version>0.0.9.1</version>
            </dependency>
```

