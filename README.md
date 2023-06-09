# Tasks manger application

## Feature 1
## Feature 2
## Feature 3
## Feature 4

## Description
Tasks manger application

## Work environment
+ Java (JDK) 8
+ NodeJS 12.13.0 or later 2
+ Google Chrome browser

## Run project
1. Build the project - ``gradlew clean build``
2. Start the database - ``gradlew startDatabase``
3. Clean and add new data to database - ``gradlew dropTables createTables addTestData`` or ``gradlew refreshData``
4. Start the API-application - ``gradlew bootRun``

## Stop project
1. Stop the project - ``Ctrl + C``
2. Start the database - ``gradlew stopDatabase`` or ``Ctrl + C``

## Some master commit

## Database commands
``gradlew startDatabase`` - start database

``gradlew createTables`` - create database tables

``gradlew addTestData`` - add test data in database

``gradlew dropTables`` - drop all tables from database

``gradlew stopDatabase`` - stop database

``gradlew refreshData`` - run dropTables, createTables, addTestData
