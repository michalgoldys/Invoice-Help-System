FROM openjdk:8
ADD target/InvoiceHelpSystem-0.0.1-SNAPSHOT.jar .
EXPOSE 23654:8080
CMD java -jar InvoiceHelpSystem-0.0.1-SNAPSHOT.jar