# Quotes 

## Lab08 - OO Design and GSON

In this lab, I've used bufferedreader to read a JSON file and then, parse the JSON file using GSON and convert it to a java class to get the data of quote's author and text.

### Overview

* Using GSON library to parse the json file.
* Create a Quotes class and a quotes constructor:
   1. String author
   2. String text
* **BufferedReader** : to read file data line by line


## Lab09 - Web requests

### Overview

Working with API to get the random quote online, with taking in consideration the case of having error with connecting to the internet, so the quote will be taken from the JSON file.

### Methods 

* Creating a QuotesAPI class which represents the structure of data will be gotten from the API (Quote and Author) .
* Create a new quote to store the data will be gotten from the API and then append it to the JSON file using Writer method .
* Using the quotes file if the app has errors in connecting to the Internet, it will  display a random quote from the file instead .
