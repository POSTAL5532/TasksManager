# Tasks manger application

# SOME FEATURE 1

# SOME FEATURE 2

## Description
Tasks manger application

## Work environment
+ Java (JDK) 8
+ NodeJS 12.13.0 or later
+ Google Chrome browser

## MASTER FEATURE

## SOME FEATURE2 1

## Run project
1. Build the project - ``gradlew clean build``
2. Start the database - ``gradlew startDatabase``
3. Clean and add new data to database - ``gradlew dropTables createTables addTestData`` or ``gradlew refreshData``
4. Start the API-application - ``gradlew bootRun``

## Stop project
1. Stop the project - ``Ctrl + C``
2. Start the database - ``gradlew stopDatabase`` or ``Ctrl + C``

## Database commands
``gradlew startDatabase`` - start database

``gradlew createTables`` - create database tables

``gradlew addTestData`` - add test data in database

``gradlew dropTables`` - drop all tables from database

``gradlew stopDatabase`` - stop database

``gradlew refreshData`` - run dropTables, createTables, addTestData
