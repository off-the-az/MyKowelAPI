# My Kowel API

The My Kowel API is one of the main parts of the overall My Kowel project. This API contains important business logic that makes it possible to ensure the stable operation of the entire project system.

This API implements all possible options for requests that allow you to organize stable functionality of the project, such as - GET, POST, PUT, DELETE.

The following links allow you to work with database information:

    - User`s data (Need a token):
        - [GET] http://mykowel.pp.ua:8000/user/get
        - [UPDATE] http://mykowel.pp.ua:8000/user/update
        - [DELETE] http://mykowel.pp.ua:8000/user/delete

        For Authorization (need full user`s data or login + password):
        - [POST] http://mykowel.pp.ua:8000/login
        - [POST] http://mykowel.pp.ua:8000/logout
        - [POST] http://mykowel.pp.ua:8000/register
        - [POST] http://mykowel.pp.ua:8000/reset-request (need a login)

    - Contact`s data (Need an owner, id or full contact`s info)
        - [GET] http://mykowel.pp.ua:8000/contacts/get
        - [GET] http://mykowel.pp.ua:8000/contacts/get/owner/?value=
        - [GET] http://mykowel.pp.ua:8000/contacts/get/id/?value=
        - [POST] http://mykowel.pp.ua:8000/contacts/add
        - [PUT] http://mykowel.pp.ua:8000/contacts/update
        - [DELETE] http://mykowel.pp.ua:8000/contacts/delete (need a token)

    - Event`s data (Need an id or full event`s info)
        - [GET] http://mykowel.pp.ua:8000/events/get
        - [POST] http://mykowel.pp.ua:8000/events/add (need a token)
        - [DELETE] http://mykowel.pp.ua:8000/events/delete (need a token)

    -  Market`s data (Need an id or full market`s info)
        - [GET] http://mykowel.pp.ua:8000/market/get
        - [GET] http://mykowel.pp.ua:8000/market/get/title/?value=
        - [GET] http://mykowel.pp.ua:8000/market/get/category/?value=
        - [GET] http://mykowel.pp.ua:8000/market/get/username/?value=
        - [POST] http://mykowel.pp.ua:8000/market/add
        - [PUT] http://mykowel.pp.ua:8000/market/update
        - [DELETE] http://mykowel.pp.ua:8000/market/delete (need a token)

For more information and examples check - <a href="#my-kowel-api-documentation">MK API Documentation</a>

# How to use this API

If you want to use this API in your application you need to fetch code to your server(local or remote):

```bash

> git clone https://github.com/off-the-az/MyKowelAPI.git

```

Next, you need to install MyKowelAPI project dependencies:

```bash

> ./mvnw install

```

After you have installed you need to run following project:

```bash

> ./mvnw spring-boot:run

```

<b>REMEMBER:</b> You need to setup configuration in application.properties using the following example in application.properties.example file.


After setup and configure you can use the following API in your application!) Enjoy!)

# My Kowel API Documentation

<div style="font-size: 18px">
This documentation provides more details about API and it`s requests and responses. In this documantation you can get infromation about endpoints and their responses for future front-end building. If u have some guestions/problems/bug-reports, u can write it on <a href="https://github.com/off-the-az/MyKowelAPI/issues">"ISSUE"</a> section.
</div>




# Base API endpoints:

![](./endpoints.svg)