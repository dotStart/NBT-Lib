Java NBT Library [![Build Status](http://assets.evil-co.com/build/NBTLIB-MASTER.png)](http://www.evil-co.com/ci/browse/NBTLIB-MASTER)
===============
The NBT Java library provides a simple read and write API for Minecraft NBT files and streams.

Examples
--------

You can find basic usage examples for the library in the ```src/test/java``` directory.

Bug Reporting
-------------

Please report bugs in our [Bugtracker](https://evilco.atlassian.net/browse/NBTLIB/). If you don't want to wait for them to
fixed by one of our project members you can also submit a bugfix on GitHub with the pull request feature (please refer
to the contribution section for more information and notices).

Compiling
---------

You need to have Maven installed (http://maven.apache.org). Once installed,
simply run:

	mvn clean install

Maven will automatically download dependencies for you. Note: For that to work,
be sure to add Maven to your "PATH".

Maven
-----

You can include this library into your projects easily by adding the following repository and dependency
to your project:

	<!- ... -->

	<repository>
		<id>evil-co</id>
		<url>http://nexus.evil-co.org/content/repositories/free/</url>
	</repository>

	<!- ... -->

	<dependency>
		<groupId>com.evilco.mc</groupId>
		<artifactId>nbt</artifactId>
		<version>1.0.2</version>
	</dependency>

	<!- ... -->

Contributing
------------

We happily accept contributions. The best way to do this is to fork the project
on GitHub, add your changes, and then submit a pull request. We'll look at it,
make comments, and merge it into the project if everything works out.

By submitting code, you agree to license your code under the Apache 2.0 License.