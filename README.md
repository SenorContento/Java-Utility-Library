Use
---
* Follow Instructions in Either Compile or Install First
* Follow Instructions in Run

Compile
---
* First, follow compilation instructions in compile.md

Install
---
* Import the below repos into your sources.list or sources.list.d
  * deb https://packagecloud.io/SenorContento/Software/debian/ jessie main
  * deb-src https://packagecloud.io/SenorContento/Software/debian/ jessie main
* and then Run the following command to import the gpg key
  * curl -L https://packagecloud.io/SenorContento/Software/gpgkey | sudo apt-key add -
* OR Run the following command (Instead of manually importing into sources.list and importing the gpg key)
  * curl -s https://packagecloud.io/install/repositories/SenorContento/Software/script.deb.sh | sudo bash
* Run a command such as sudo apt-get install sc-utility-jar

Run
---
* If using java to run, follow the below command
  * Use a command similar to java -cp '.:/usr/lib/senor/utilities.jar' $CLASS_FILE
* If using eclipse, import the jar, utilities.jar, located at /usr/lib/senor/
  * Run your project
