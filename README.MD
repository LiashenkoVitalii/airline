## Project name
### **_Airline_**

## Description
This console application describes an airline company that stores airplanes. 
There are 3 levels of the aircraft hierarchy.
The application with console menu provides possibility to:
 * calculate total capacity and carrying capacity of all the aircraft in the airline
 * sort the aircrafts by flight range (from smaller to larger) and display them on screen
 * find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour)
 
Besides, user can get list of available models of the airplanes, add (or remove) them to (from) the airline company fleet.
The application has log-directory in its root catalog and stores all changes to your hard drive in the directory **_storage_** in the application root catalog


## Table of Contents
* [Project name](#project-name)
* [Description](#description)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation and running](#installation-and-running)
* [Running the tests](#running-the-tests)  
* [Authors](#authors)

## Getting Started

### Prerequisites
To run the project you need installed (according to the documentation): 
  * Java 8 (jre/jdk) or higher version 
  * Apache Maven 3.3.9 or higher version
  * Git (only for development)  
### Installation and running
To install and run the project on localhost:
 * Clone or download the project [airline](https://github.com/LiashenkoVitalii/airline) from the GitHub 
 * Compile project to package **_"airline.jar"_**. To do it just execute command "mvn compile clean package assembly:single -DskipTests" 
  (build skipping tests, or command "mvn compile clean package assembly:single" if you want to run unit-tests as well)  from your prompt in the project root directory.
 * execute the command "java -jar airline.jar" from your prompt: 
 * Now, if you can see the message "Enter command and press <Enter> ("help" to get help; "exit" to quit).", you are available to use the application
 
## Running the tests
Project has unit tests. They allows you to make big changes to code and check if it still works.
To run the unit-tests, execute command "mvn clean package" from your prompt in the project root directory.

## Authors
Vitalii Liashenko (e-mail: [liashenkovitaliy@gmail.com](mailto:liashenkovitaliy@gmail.com))




