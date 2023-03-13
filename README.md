# My Kowel API

The My Kowel API is one of the main parts of the overall My Kowel project. This API contains important business logic that makes it possible to ensure the stable operation of the entire project system.

This API implements all possible options for requests that allow you to organize stable functionality of the project, such as - GET, POST, PUT, DELETE.

The following links allow you to work with database information:

    - User`s data (Need a token):
        - [GET] https://mykowel.pp.ua:8000/user/get
        - [UPDATE] https://mykowel.pp.ua:8000/user/update
        - [DELETE] https://mykowel.pp.ua:8000/user/delete

        For Authorization (need full user`s data or login + password):
        - [POST] https://mykowel.pp.ua:8000/login
        - [POST] https://mykowel.pp.ua:8000/logout
        - [POST] https://mykowel.pp.ua:8000/register

    - Contact`s data (Need an owner, id or full contact`s info)
        - [GET] https://mykowel.pp.ua:8000/contacts/get
        - [GET] https://mykowel.pp.ua:8000/contacts/get/owner/?value=
        - [GET] https://mykowel.pp.ua:8000/contacts/get/id/?value=
        - [POST] https://mykowel.pp.ua:8000/contacts/add
        - [PUT] https://mykowel.pp.ua:8000/contacts/update
        - [DELETE] https://mykowel.pp.ua:8000/contacts/delete (need a token)

    - Event`s data (Need an id or full event`s info)
        - [GET] https://mykowel.pp.ua:8000/events/get
        - [POST] https://mykowel.pp.ua:8000/events/add (need a token)
        - [DELETE] https://mykowel.pp.ua:8000/events/delete (need a token)

    -  Market`s data (Need an id or full market`s info)
        - [GET] https://mykowel.pp.ua:8000/market/get
        - [GET] https://mykowel.pp.ua:8000/market/get/title/?value=
        - [GET] https://mykowel.pp.ua:8000/market/get/category/?value=
        - [POST] https://mykowel.pp.ua:8000/market/add
        - [PUT] https://mykowel.pp.ua:8000/market/update
        - [DELETE] https://mykowel.pp.ua:8000/market/delete (need a token)