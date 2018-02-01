## Project name
### **_Airline_**

## Description
This console application describes an airline company that stores airplanes. 
There are 3 levels of the aircraft hierarchy (abstract airplane, airplanes which belong to concrete producers and concrete airplane implementations).
Supposed, all the airplanes belongs to three logical groups by their flight range (short haul, medium haul, long haul).
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
* [Usage](#usage)
* [Authors](#authors)

## Getting Started

### Prerequisites
To run the project you need installed (according to the documentation): 
  * Java 8 (jre/jdk) or higher version 
  * Apache Maven 3.3.9 or higher version
  * Git (only for development)  
### Installation and running
To install and run the application:
 * Clone or download the project [airline](https://github.com/LiashenkoVitalii/airline) from the GitHub 
 * Compile project to package **_"airline.jar"_**. To do it just execute command "mvn compile clean package assembly:single" from your prompt in the project root directory.
 * execute the command "java -jar airline.jar" from your prompt 
 * Now, if you can see the message "Enter command and press <Enter> ("help" to get help; "exit" to quit)", you are available to use the application
 
## Running the tests
Project has tests which allows you to make big changes to code and check if it still works.
To run them, execute command "mvn test" from your prompt in the project root directory.

## Usage
You can enter any command from the list below to do described actions. For example,
if you enter command "show_models", the application will print on the screen all available airplane models to manipulate.
Whole list of available commands:
* type "exit" to quit from the application
* type "show_models" to get list of available airplane models
* type "add -p airplane_producer_name -m airplane_model_name" to add it to the airline park (use underscores instead of spaces)
* type "rm -serial airplane_serial_number_id" to remove it to the airline park
* type "find  -sort fuel_consumption_degree" to find the airplane in the airline park by fuel consumption degree
* type "show_airplanes" to see the airline park
* type "show_sorted_airplanes -flight_range" to see the airline park sorted by flight range
* type "calculate_capacity" to calculate total and carrying capacity of all airplanes in the airline park
* type "save" to save info on the hard drive

## Authors
Vitalii Liashenko (e-mail: [liashenkovitaliy@gmail.com](mailto:liashenkovitaliy@gmail.com))




