# A Basic AWS Lambda Function in Java

This project contains a very basic function implemented in Java
that can be deployed as an AWS Lambda function.

The project was created initially using `gradle init`, and then entries
where added to the `build.gradle` file for the AWS dependencies. The steps
in "[Creating a ZIP Deployment Package for a Java Function](https://docs.aws.amazon.com/lambda/latest/dg/create-deployment-pkg-zip-java.html)"
were followed to create a ZIP file whenever the project was built
with `gradlew build`.

In addition, "[Using the SDK with Gradle](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/setup-project-gradle.html)" was followed
to add the Java SDK, version 2, to the `build.gradle` file.

## Building the project

To create a ZIP archive that is suitable for uploading to S3 or through
the console, use the following command:

``` bash
$ ./gradlew build
```

The build task will automatically create a ZIP archive in the `build/distributions` folder, the exact name of which depends on the name and version
of your project.

## Modifying the code

This example contains one sample handler, the *MyFunctionHandler* class, which implements the *RequestHandler* inteface. It's single method, *handleRequest()*, returns a simple string that says, "Hello, World!".

You can modify this class or create a similar one. The class
name and method needs to be set for the AWS Lambda function.

The sample class is listed here:

``` java
package com.magenic.nathan;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        return "Hello, World!";
    }
}

```

## Re-packaging the changes

After you have made changes to the class, you can test (because you 
wrote tests, right?) and re-build the ZIP archive by using the command:

``` bash
$ ./gradlew build
```

Follow the AWS instructions to upload a new version of the ZIP file, 
versioning the function if it is appropriate to do so.

