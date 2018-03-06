# Notes App

This is a simple app developed using kotlin and the Anko SQLite library for database interaction.

The idea of this project is to serve as guide for everyone wanting to use Anko SQLite in their android Kotlin projects.

As for the benefits of using Anko-SQLite I can mention its ease of use and how natural, using beautiful Kotlin programing style, it allows you to integrate with you application's database.

The app implements basic CRUD operations for a simple Note model. The access to the database operation is rightly available as part of the application context, thanks to Kotlin's ability to extend classes/modules by adding new functions to them, in the scope of the application.

Feel free to fork, use, reuse, share, etc. as you'd like!

## Stack

The following libraries are being used in this application, with the indicated versions:

* Kotlin 1.2.21
* Anko SQLite 0.10.4
* Timber 4.6.1

`Note: Please note that Anko provides several libraries to ease android development application. But in this example, only Anko-SQLite subset is used`

## Application overview

The below is an overview of how the application works:

<img src="images/notes_app_usage.gif" width="200" height="400" />

## License

Copyright 2018 Thiago Santana (thilux).

Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.