Run the below commands (If you were looking to compile the .jar itself, go to Compiling Jar)
---
* javac -cp /usr/lib/senor/utilities.jar $JAVA_FILE
  * (or import /usr/lib/senor/utilities.jar into Eclipse and compiling Java File)

Compiling Jar
---
* javac $(find | grep "\.java")
* jar cf utilities.jar $(find | grep "\.class")
* To create Debian Repo, goto Creating Repo

Creating Repo
---
* Follow instructions in build-debian-package.md
* If you are me, senor, then goto Pushing to Repo

Pushing to Repo
---
* (You may have to reinstall packagecloud gem)
  * sudo gem install package_cloud
  * (You will obviously need you key (~/.packagecloud)
    * You key can be regenerated by your credentials
* package_cloud push SenorContento/software/debian/jessie $DEBIAN-ARCHIVE