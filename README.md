# java-servlet-simple
Simple Java Servlet application to create an invoice

# Steps
1. Include servlet-api.jar from apache tomcat in your classpath
2. Compile the java files
- javac -cp ${CLASSPATH} Products.java
- javac -cp ${CLASSPATH} Summary.java
- javac -cp ${CLASSPATH} Invoice.java
3. Transfer files into respective tomcat folders
- ./transfer.sh ProductPage.html
- ./transfer.sh Products.class
- ./transfer.sh Summary.class
- ./transfer.sh Invoice.class
4. Start the tomcat server and navigate to
- localhost:8080/Servlets/ProductPage.html

# Screenshots
![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/sources.png?raw=true)

![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/tomcat.png?raw=true)

![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/productpage.png?raw=true)

![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/orderpage.png?raw=true)

![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/summarypage.png?raw=true)

![alt text](https://github.com/aashishwagle55/java-servlet-simple/blob/main/images/invoicepage.png?raw=true)
