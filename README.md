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

<style data-styled="true" data-styled-version="5.3.0">
.lbhBhk {
    outline: 0px;
    color: inherit;
    width: 100%;
    text-align: left;
    cursor: pointer;
    padding: 10px 30px 10px 20px;
    border-radius: 4px 4px 0px 0px;
    background-color: rgb(21, 23, 25);
    display: flex;
    white-space: nowrap;
    -webkit-box-align: center;
    align-items: center;
    border-width: 1px 1px 0px;
    border-top-style: solid;
    border-right-style: solid;
    border-left-style: solid;
    border-top-color: transparent;
    border-right-color: transparent;
    border-left-color: transparent;
    border-image: initial;
    border-bottom-style: initial;
    border-bottom-color: initial;
    transition: border-color 0.25s ease 0s;
}.egQuEZ{width:calc(100% - 40%);padding:0 40px;}/*!sc*/
@media print,screen and (max-width:75rem){.egQuEZ{width:100%;padding:40px 40px;}}/*!sc*/
.dmghQN{width:calc(100% - 40%);padding:0 40px;}/*!sc*/
@media print,screen and (max-width:75rem){.dmghQN{width:100%;padding:0px 40px;}}/*!sc*/
data-styled.g4[id="sc-hKFxyN"]{content:"egQuEZ,dmghQN,"}/*!sc*/
.fxZJZV{padding:40px 0;}/*!sc*/
.fxZJZV:last-child{min-height:calc(100vh + 1px);}/*!sc*/
.sc-eCApnc > .sc-eCApnc:last-child{min-height:initial;}/*!sc*/
@media print,screen and (max-width:75rem){.fxZJZV{padding:0;}}/*!sc*/
.bJnWIW{padding:40px 0;position:relative;}/*!sc*/
.bJnWIW:last-child{min-height:calc(100vh + 1px);}/*!sc*/
.sc-eCApnc > .sc-eCApnc:last-child{min-height:initial;}/*!sc*/
@media print,screen and (max-width:75rem){.bJnWIW{padding:0;}}/*!sc*/
.bJnWIW:not(:last-of-type):after{position:absolute;bottom:0;width:100%;display:block;content:'';border-bottom:1px solid rgba(0,0,0,0.2);}/*!sc*/
data-styled.g5[id="sc-eCApnc"]{content:"fxZJZV,bJnWIW,"}/*!sc*/
.cYosil{width:40%;color:#fefefe;background-color:#2d3134;padding:0 40px;}/*!sc*/
@media print,screen and (max-width:75rem){.cYosil{width:100%;padding:40px 40px;}}/*!sc*/
data-styled.g6[id="sc-jSFjdj"]{content:"cYosil,"}/*!sc*/
.fgDDdP{background-color:#2d3134;}/*!sc*/
data-styled.g7[id="sc-gKAaRy"]{content:"fgDDdP,"}/*!sc*/
.KWWXd{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;width:100%;padding:0;}/*!sc*/
@media print,screen and (max-width:75rem){.KWWXd{-webkit-flex-direction:column;-ms-flex-direction:column;flex-direction:column;}}/*!sc*/
data-styled.g8[id="sc-iCoGMd"]{content:"KWWXd,"}/*!sc*/
.dLPLNt{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.85714em;line-height:1em;color:#2d3134;}/*!sc*/
data-styled.g9[id="sc-fujyAs"]{content:"dLPLNt,"}/*!sc*/
.ka-DfuM{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.57143em;line-height:1em;color:black;}/*!sc*/
data-styled.g10[id="sc-pNWdM"]{content:"ka-DfuM,"}/*!sc*/
.hwmPAW{color:#fefefe;}/*!sc*/
data-styled.g12[id="sc-kEqXSa"]{content:"hwmPAW,"}/*!sc*/
.eONCmm{border-bottom:1px solid rgba(38,50,56,0.3);margin:1em 0 1em 0;color:rgba(38,50,56,0.5);font-weight:normal;text-transform:uppercase;font-size:0.929em;line-height:20px;}/*!sc*/
data-styled.g13[id="sc-iqAclL"]{content:"eONCmm,"}/*!sc*/
.iUxAWq{cursor:pointer;margin-left:-20px;padding:0;line-height:1;width:20px;display:inline-block;outline:0;}/*!sc*/
.iUxAWq:before{content:'';width:15px;height:15px;background-size:contain;background-image:url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZlcnNpb249IjEuMSIgeD0iMCIgeT0iMCIgd2lkdGg9IjUxMiIgaGVpZ2h0PSI1MTIiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cGF0aCBmaWxsPSIjMDEwMTAxIiBkPSJNNDU5LjcgMjMzLjRsLTkwLjUgOTAuNWMtNTAgNTAtMTMxIDUwLTE4MSAwIC03LjktNy44LTE0LTE2LjctMTkuNC0yNS44bDQyLjEtNDIuMWMyLTIgNC41LTMuMiA2LjgtNC41IDIuOSA5LjkgOCAxOS4zIDE1LjggMjcuMiAyNSAyNSA2NS42IDI0LjkgOTAuNSAwbDkwLjUtOTAuNWMyNS0yNSAyNS02NS42IDAtOTAuNSAtMjQuOS0yNS02NS41LTI1LTkwLjUgMGwtMzIuMiAzMi4yYy0yNi4xLTEwLjItNTQuMi0xMi45LTgxLjYtOC45bDY4LjYtNjguNmM1MC01MCAxMzEtNTAgMTgxIDBDNTA5LjYgMTAyLjMgNTA5LjYgMTgzLjQgNDU5LjcgMjMzLjR6TTIyMC4zIDM4Mi4ybC0zMi4yIDMyLjJjLTI1IDI0LjktNjUuNiAyNC45LTkwLjUgMCAtMjUtMjUtMjUtNjUuNiAwLTkwLjVsOTAuNS05MC41YzI1LTI1IDY1LjUtMjUgOTAuNSAwIDcuOCA3LjggMTIuOSAxNy4yIDE1LjggMjcuMSAyLjQtMS40IDQuOC0yLjUgNi44LTQuNWw0Mi4xLTQyYy01LjQtOS4yLTExLjYtMTgtMTkuNC0yNS44IC01MC01MC0xMzEtNTAtMTgxIDBsLTkwLjUgOTAuNWMtNTAgNTAtNTAgMTMxIDAgMTgxIDUwIDUwIDEzMSA1MCAxODEgMGw2OC42LTY4LjZDMjc0LjYgMzk1LjEgMjQ2LjQgMzkyLjMgMjIwLjMgMzgyLjJ6Ii8+PC9zdmc+Cg==');opacity:0.5;visibility:hidden;display:inline-block;vertical-align:middle;}/*!sc*/
h1:hover > .sc-crzoAE::before,h2:hover > .iUxAWq::before,.iUxAWq:hover::before{visibility:visible;}/*!sc*/
data-styled.g14[id="sc-crzoAE"]{content:"iUxAWq,"}/*!sc*/
.gmNZmS{height:18px;width:18px;vertical-align:middle;float:right;-webkit-transition:-webkit-transform 0.2s ease-out;-webkit-transition:transform 0.2s ease-out;transition:transform 0.2s ease-out;-webkit-transform:rotateZ(-90deg);-ms-transform:rotateZ(-90deg);transform:rotateZ(-90deg);}/*!sc*/
.hFtmaj{height:1.5em;width:1.5em;vertical-align:middle;float:left;-webkit-transition:-webkit-transform 0.2s ease-out;-webkit-transition:transform 0.2s ease-out;transition:transform 0.2s ease-out;-webkit-transform:rotateZ(-90deg);-ms-transform:rotateZ(-90deg);transform:rotateZ(-90deg);}/*!sc*/
.hFtmaj polygon{fill:rgba(28,184,65,1);}/*!sc*/
.gGvkZD{height:20px;width:20px;vertical-align:middle;float:right;-webkit-transition:-webkit-transform 0.2s ease-out;-webkit-transition:transform 0.2s ease-out;transition:transform 0.2s ease-out;-webkit-transform:rotateZ(0);-ms-transform:rotateZ(0);transform:rotateZ(0);}/*!sc*/
.gGvkZD polygon{fill:white;}/*!sc*/
data-styled.g15[id="sc-dIsUp"]{content:"gmNZmS,hFtmaj,gGvkZD,"}/*!sc*/
.guuWON{border-left:1px solid #646464;box-sizing:border-box;position:relative;padding:10px 10px 10px 0;}/*!sc*/
@media screen and (max-width:50rem){.guuWON{display:block;overflow:hidden;}}/*!sc*/
tr:first-of-type > .sc-hBMUJo,tr.last > .guuWON{border-left-width:0;background-position:top left;background-repeat:no-repeat;background-size:1px 100%;}/*!sc*/
tr:first-of-type > .sc-hBMUJo{background-image:linear-gradient( to bottom, transparent 0%, transparent 22px, #646464 22px, #646464 100% );}/*!sc*/
tr.last > .sc-hBMUJo{background-image:linear-gradient( to bottom, #646464 0%, #646464 22px, transparent 22px, transparent 100% );}/*!sc*/
tr.last + tr > .sc-hBMUJo{border-left-color:transparent;}/*!sc*/
tr.last:first-child > .sc-hBMUJo{background:none;border-left-color:transparent;}/*!sc*/
data-styled.g18[id="sc-hBMUJo"]{content:"guuWON,"}/*!sc*/
.eQzShU{vertical-align:top;line-height:20px;white-space:nowrap;font-size:13px;font-family:Courier,monospace;}/*!sc*/
.eQzShU.deprecated{-webkit-text-decoration:line-through;text-decoration:line-through;color:#707070;}/*!sc*/
data-styled.g20[id="sc-fFSPTT"]{content:"eQzShU,"}/*!sc*/
.dBOkKB{border-bottom:1px solid #9fb4be;padding:10px 0;width:75%;box-sizing:border-box;}/*!sc*/
tr.expanded .sc-bkbkJK{border-bottom:none;}/*!sc*/
@media screen and (max-width:50rem){.dBOkKB{padding:0 20px;border-bottom:none;border-left:1px solid #646464;}tr.last > .sc-bkbkJK{border-left:none;}}/*!sc*/
data-styled.g21[id="sc-bkbkJK"]{content:"dBOkKB,"}/*!sc*/
.xJRVh{color:#646464;font-family:Courier,monospace;margin-right:10px;}/*!sc*/
.xJRVh::before{content:'';display:inline-block;vertical-align:middle;width:10px;height:1px;background:#646464;}/*!sc*/
.xJRVh::after{content:'';display:inline-block;vertical-align:middle;width:1px;background:#646464;height:7px;}/*!sc*/
data-styled.g22[id="sc-iemWCZ"]{content:"xJRVh,"}/*!sc*/
.szXZz{border-collapse:separate;border-radius:3px;font-size:16px;border-spacing:0;width:100%;}/*!sc*/
.szXZz > tr{vertical-align:middle;}/*!sc*/
@media screen and (max-width:50rem){.szXZz{display:block;}.szXZz > tr,.szXZz > tbody > tr{display:block;}}/*!sc*/
@media screen and (max-width:50rem) and (-ms-high-contrast:none){.szXZz td{float:left;width:100%;}}/*!sc*/
.szXZz .sc-dIvrsQ,.szXZz .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ,.szXZz .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ{margin:1em;margin-right:0;background:#fafafa;}/*!sc*/
.szXZz .sc-dIvrsQ .sc-dIvrsQ,.szXZz .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ,.szXZz .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ .sc-dIvrsQ{background:#ffffff;}/*!sc*/
data-styled.g24[id="sc-hHEiqL"]{content:"szXZz,"}/*!sc*/
.joKODG{margin-left:10px;text-transform:none;font-size:0.929em;color:black;}/*!sc*/
data-styled.g43[id="sc-jcwpoC"]{content:"joKODG,"}/*!sc*/
.fBANYA > ul{list-style:none;padding:0;margin:0;margin:0 -5px;}/*!sc*/
.fBANYA > ul > li{padding:5px 10px;display:inline-block;background-color:#151719;border-bottom:1px solid rgba(0,0,0,0.5);cursor:pointer;text-align:center;outline:none;color:#cbcbcb;margin:0 5px 5px 5px;border:1px solid #090a0b;border-radius:5px;min-width:60px;font-size:0.9em;font-weight:bold;}/*!sc*/
.fBANYA > ul > li.react-tabs__tab--selected{color:#2d3134;background:#fefefe;}/*!sc*/
.fBANYA > ul > li.react-tabs__tab--selected:focus{outline:auto;}/*!sc*/
.fBANYA > ul > li:only-child{-webkit-flex:none;-ms-flex:none;flex:none;min-width:100px;}/*!sc*/
.fBANYA > ul > li.tab-success{color:rgba(28,184,65,1);}/*!sc*/
.fBANYA > ul > li.tab-redirect{color:#ffa500;}/*!sc*/
.fBANYA > ul > li.tab-info{color:#87ceeb;}/*!sc*/
.fBANYA > ul > li.tab-error{color:#d41f1c;}/*!sc*/
.fBANYA > .react-tabs__tab-panel{background:#151719;}/*!sc*/
.fBANYA > .react-tabs__tab-panel > div,.fBANYA > .react-tabs__tab-panel > pre{padding:20px;margin:0;}/*!sc*/
.fBANYA > .react-tabs__tab-panel > div > pre{padding:0;}/*!sc*/
data-styled.g44[id="sc-carFqZ"]{content:"fBANYA,"}/*!sc*/
.dFWqin code[class*='language-'],.dFWqin pre[class*='language-']{text-shadow:0 -0.1em 0.2em black;text-align:left;white-space:pre;word-spacing:normal;word-break:normal;word-wrap:normal;line-height:1.5;-moz-tab-size:4;-o-tab-size:4;tab-size:4;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;hyphens:none;}/*!sc*/
@media print{.dFWqin code[class*='language-'],.dFWqin pre[class*='language-']{text-shadow:none;}}/*!sc*/
.dFWqin pre[class*='language-']{padding:1em;margin:0.5em 0;overflow:auto;}/*!sc*/
.dFWqin .token.comment,.dFWqin .token.prolog,.dFWqin .token.doctype,.dFWqin .token.cdata{color:hsl(30,20%,50%);}/*!sc*/
.dFWqin .token.punctuation{opacity:0.7;}/*!sc*/
.dFWqin .namespace{opacity:0.7;}/*!sc*/
.dFWqin .token.property,.dFWqin .token.tag,.dFWqin .token.number,.dFWqin .token.constant,.dFWqin .token.symbol{color:#4a8bb3;}/*!sc*/
.dFWqin .token.boolean{color:#e64441;}/*!sc*/
.dFWqin .token.selector,.dFWqin .token.attr-name,.dFWqin .token.string,.dFWqin .token.char,.dFWqin .token.builtin,.dFWqin .token.inserted{color:#a0fbaa;}/*!sc*/
.dFWqin .token.selector + a,.dFWqin .token.attr-name + a,.dFWqin .token.string + a,.dFWqin .token.char + a,.dFWqin .token.builtin + a,.dFWqin .token.inserted + a,.dFWqin .token.selector + a:visited,.dFWqin .token.attr-name + a:visited,.dFWqin .token.string + a:visited,.dFWqin .token.char + a:visited,.dFWqin .token.builtin + a:visited,.dFWqin .token.inserted + a:visited{color:#4ed2ba;-webkit-text-decoration:underline;text-decoration:underline;}/*!sc*/
.dFWqin .token.property.string{color:white;}/*!sc*/
.dFWqin .token.operator,.dFWqin .token.entity,.dFWqin .token.url,.dFWqin .token.variable{color:hsl(40,90%,60%);}/*!sc*/
.dFWqin .token.atrule,.dFWqin .token.attr-value,.dFWqin .token.keyword{color:hsl(350,40%,70%);}/*!sc*/
.dFWqin .token.regex,.dFWqin .token.important{color:#e90;}/*!sc*/
.dFWqin .token.important,.dFWqin .token.bold{font-weight:bold;}/*!sc*/
.dFWqin .token.italic{font-style:italic;}/*!sc*/
.dFWqin .token.entity{cursor:help;}/*!sc*/
.dFWqin .token.deleted{color:red;}/*!sc*/
data-styled.g46[id="sc-iBzEeX"]{content:"dFWqin,"}/*!sc*/
.jgqseF{opacity:0.7;-webkit-transition:opacity 0.3s ease;transition:opacity 0.3s ease;text-align:right;}/*!sc*/
.jgqseF:focus-within{opacity:1;}/*!sc*/
.jgqseF > button{background-color:transparent;border:0;color:inherit;padding:2px 10px;font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;font-size:16px;line-height:1.5em;cursor:pointer;outline:0;}/*!sc*/
.jgqseF > button:hover,.jgqseF > button:focus{background:rgba(255,255,255,0.1);}/*!sc*/
data-styled.g47[id="sc-efHYUO"]{content:"jgqseF,"}/*!sc*/
.ps{overflow:hidden !important;overflow-anchor:none;-ms-overflow-style:none;touch-action:auto;-ms-touch-action:auto;}/*!sc*/
.ps__rail-x{display:none;opacity:0;-webkit-transition:background-color .2s linear,opacity .2s linear;transition:background-color .2s linear,opacity .2s linear;-webkit-transition:background-color .2s linear,opacity .2s linear;height:15px;bottom:0px;position:absolute;}/*!sc*/
.ps__rail-y{display:none;opacity:0;-webkit-transition:background-color .2s linear,opacity .2s linear;transition:background-color .2s linear,opacity .2s linear;-webkit-transition:background-color .2s linear,opacity .2s linear;width:15px;right:0;position:absolute;}/*!sc*/
.ps--active-x > .ps__rail-x,.ps--active-y > .ps__rail-y{display:block;background-color:transparent;}/*!sc*/
.ps:hover > .ps__rail-x,.ps:hover > .ps__rail-y,.ps--focus > .ps__rail-x,.ps--focus > .ps__rail-y,.ps--scrolling-x > .ps__rail-x,.ps--scrolling-y > .ps__rail-y{opacity:0.6;}/*!sc*/
.ps .ps__rail-x:hover,.ps .ps__rail-y:hover,.ps .ps__rail-x:focus,.ps .ps__rail-y:focus,.ps .ps__rail-x.ps--clicking,.ps .ps__rail-y.ps--clicking{background-color:#eee;opacity:0.9;}/*!sc*/
.ps__thumb-x{background-color:#aaa;border-radius:6px;-webkit-transition:background-color .2s linear,height .2s ease-in-out;transition:background-color .2s linear,height .2s ease-in-out;-webkit-transition:background-color .2s linear,height .2s ease-in-out;height:6px;bottom:2px;position:absolute;}/*!sc*/
.ps__thumb-y{background-color:#aaa;border-radius:6px;-webkit-transition:background-color .2s linear,width .2s ease-in-out;transition:background-color .2s linear,width .2s ease-in-out;-webkit-transition:background-color .2s linear,width .2s ease-in-out;width:6px;right:2px;position:absolute;}/*!sc*/
.ps__rail-x:hover > .ps__thumb-x,.ps__rail-x:focus > .ps__thumb-x,.ps__rail-x.ps--clicking .ps__thumb-x{background-color:#999;height:11px;}/*!sc*/
.ps__rail-y:hover > .ps__thumb-y,.ps__rail-y:focus > .ps__thumb-y,.ps__rail-y.ps--clicking .ps__thumb-y{background-color:#999;width:11px;}/*!sc*/
@supports (-ms-overflow-style:none){.ps{overflow:auto !important;}}/*!sc*/
@media screen and (-ms-high-contrast:active),(-ms-high-contrast:none){.ps{overflow:auto !important;}}/*!sc*/
data-styled.g51[id="sc-global-kjwiXH1"]{content:"sc-global-kjwiXH1,"}/*!sc*/
.bIbZvd{position:relative;}/*!sc*/
data-styled.g52[id="sc-bBjRSN"]{content:"bIbZvd,"}/*!sc*/
.dWRQLc{font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;font-weight:400;line-height:1.5em;}/*!sc*/
.dWRQLc p:last-child{margin-bottom:0;}/*!sc*/
.dWRQLc h1{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.85714em;line-height:1em;color:#2d3134;margin-top:0;}/*!sc*/
.dWRQLc h2{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.57143em;line-height:1em;color:#2d3134;}/*!sc*/
.dWRQLc code{color:#e53935;background-color:rgba(38,50,56,0.05);font-family:Courier,monospace;border-radius:2px;border:1px solid rgba(38,50,56,0.1);padding:0 5px;font-size:13px;font-weight:400;word-break:break-word;}/*!sc*/
.dWRQLc pre{font-family:Courier,monospace;white-space:pre;background-color:#151719;color:white;padding:20px;overflow-x:auto;line-height:normal;border-radius:0px;border:1px solid rgba(38,50,56,0.1);}/*!sc*/
.dWRQLc pre code{background-color:transparent;color:white;padding:0;}/*!sc*/
.dWRQLc pre code:before,.dWRQLc pre code:after{content:none;}/*!sc*/
.dWRQLc blockquote{margin:0;margin-bottom:1em;padding:0 15px;color:#777;border-left:4px solid #ddd;}/*!sc*/
.dWRQLc img{max-width:100%;box-sizing:content-box;}/*!sc*/
.dWRQLc ul,.dWRQLc ol{padding-left:2em;margin:0;margin-bottom:1em;}/*!sc*/
.dWRQLc ul ul,.dWRQLc ol ul,.dWRQLc ul ol,.dWRQLc ol ol{margin-bottom:0;margin-top:0;}/*!sc*/
.dWRQLc table{display:block;width:100%;overflow:auto;word-break:normal;word-break:keep-all;border-collapse:collapse;border-spacing:0;margin-top:1.5em;margin-bottom:1.5em;}/*!sc*/
.dWRQLc table tr{background-color:#fff;border-top:1px solid #ccc;}/*!sc*/
.dWRQLc table tr:nth-child(2n){background-color:#fafafa;}/*!sc*/
.dWRQLc table th,.dWRQLc table td{padding:6px 13px;border:1px solid #ddd;}/*!sc*/
.dWRQLc table th{text-align:left;font-weight:bold;}/*!sc*/
.dWRQLc .share-link{cursor:pointer;margin-left:-20px;padding:0;line-height:1;width:20px;display:inline-block;outline:0;}/*!sc*/
.dWRQLc .share-link:before{content:'';width:15px;height:15px;background-size:contain;background-image:url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZlcnNpb249IjEuMSIgeD0iMCIgeT0iMCIgd2lkdGg9IjUxMiIgaGVpZ2h0PSI1MTIiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cGF0aCBmaWxsPSIjMDEwMTAxIiBkPSJNNDU5LjcgMjMzLjRsLTkwLjUgOTAuNWMtNTAgNTAtMTMxIDUwLTE4MSAwIC03LjktNy44LTE0LTE2LjctMTkuNC0yNS44bDQyLjEtNDIuMWMyLTIgNC41LTMuMiA2LjgtNC41IDIuOSA5LjkgOCAxOS4zIDE1LjggMjcuMiAyNSAyNSA2NS42IDI0LjkgOTAuNSAwbDkwLjUtOTAuNWMyNS0yNSAyNS02NS42IDAtOTAuNSAtMjQuOS0yNS02NS41LTI1LTkwLjUgMGwtMzIuMiAzMi4yYy0yNi4xLTEwLjItNTQuMi0xMi45LTgxLjYtOC45bDY4LjYtNjguNmM1MC01MCAxMzEtNTAgMTgxIDBDNTA5LjYgMTAyLjMgNTA5LjYgMTgzLjQgNDU5LjcgMjMzLjR6TTIyMC4zIDM4Mi4ybC0zMi4yIDMyLjJjLTI1IDI0LjktNjUuNiAyNC45LTkwLjUgMCAtMjUtMjUtMjUtNjUuNiAwLTkwLjVsOTAuNS05MC41YzI1LTI1IDY1LjUtMjUgOTAuNSAwIDcuOCA3LjggMTIuOSAxNy4yIDE1LjggMjcuMSAyLjQtMS40IDQuOC0yLjUgNi44LTQuNWw0Mi4xLTQyYy01LjQtOS4yLTExLjYtMTgtMTkuNC0yNS44IC01MC01MC0xMzEtNTAtMTgxIDBsLTkwLjUgOTAuNWMtNTAgNTAtNTAgMTMxIDAgMTgxIDUwIDUwIDEzMSA1MCAxODEgMGw2OC42LTY4LjZDMjc0LjYgMzk1LjEgMjQ2LjQgMzkyLjMgMjIwLjMgMzgyLjJ6Ii8+PC9zdmc+Cg==');opacity:0.5;visibility:hidden;display:inline-block;vertical-align:middle;}/*!sc*/
.dWRQLc h1:hover > .share-link::before,.dWRQLc h2:hover > .share-link::before,.dWRQLc .share-link:hover::before{visibility:visible;}/*!sc*/
.dWRQLc a{-webkit-text-decoration:none;text-decoration:none;color:rgba(246,20,63,1);}/*!sc*/
.dWRQLc a:visited{color:rgba(246,20,63,1);}/*!sc*/
.dWRQLc a:hover{color:#fa768f;}/*!sc*/
.bLuoRC{font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;font-weight:400;line-height:1.5em;}/*!sc*/
.bLuoRC p:last-child{margin-bottom:0;}/*!sc*/
.bLuoRC p:first-child{margin-top:0;}/*!sc*/
.bLuoRC p:last-child{margin-bottom:0;}/*!sc*/
.bLuoRC h1{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.85714em;line-height:1em;color:#2d3134;margin-top:0;}/*!sc*/
.bLuoRC h2{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.57143em;line-height:1em;color:#2d3134;}/*!sc*/
.bLuoRC code{color:#e53935;background-color:rgba(38,50,56,0.05);font-family:Courier,monospace;border-radius:2px;border:1px solid rgba(38,50,56,0.1);padding:0 5px;font-size:13px;font-weight:400;word-break:break-word;}/*!sc*/
.bLuoRC pre{font-family:Courier,monospace;white-space:pre;background-color:#151719;color:white;padding:20px;overflow-x:auto;line-height:normal;border-radius:0px;border:1px solid rgba(38,50,56,0.1);}/*!sc*/
.bLuoRC pre code{background-color:transparent;color:white;padding:0;}/*!sc*/
.bLuoRC pre code:before,.bLuoRC pre code:after{content:none;}/*!sc*/
.bLuoRC blockquote{margin:0;margin-bottom:1em;padding:0 15px;color:#777;border-left:4px solid #ddd;}/*!sc*/
.bLuoRC img{max-width:100%;box-sizing:content-box;}/*!sc*/
.bLuoRC ul,.bLuoRC ol{padding-left:2em;margin:0;margin-bottom:1em;}/*!sc*/
.bLuoRC ul ul,.bLuoRC ol ul,.bLuoRC ul ol,.bLuoRC ol ol{margin-bottom:0;margin-top:0;}/*!sc*/
.bLuoRC table{display:block;width:100%;overflow:auto;word-break:normal;word-break:keep-all;border-collapse:collapse;border-spacing:0;margin-top:1.5em;margin-bottom:1.5em;}/*!sc*/
.bLuoRC table tr{background-color:#fff;border-top:1px solid #ccc;}/*!sc*/
.bLuoRC table tr:nth-child(2n){background-color:#fafafa;}/*!sc*/
.bLuoRC table th,.bLuoRC table td{padding:6px 13px;border:1px solid #ddd;}/*!sc*/
.bLuoRC table th{text-align:left;font-weight:bold;}/*!sc*/
.bLuoRC .share-link{cursor:pointer;margin-left:-20px;padding:0;line-height:1;width:20px;display:inline-block;outline:0;}/*!sc*/
.bLuoRC .share-link:before{content:'';width:15px;height:15px;background-size:contain;background-image:url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZlcnNpb249IjEuMSIgeD0iMCIgeT0iMCIgd2lkdGg9IjUxMiIgaGVpZ2h0PSI1MTIiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cGF0aCBmaWxsPSIjMDEwMTAxIiBkPSJNNDU5LjcgMjMzLjRsLTkwLjUgOTAuNWMtNTAgNTAtMTMxIDUwLTE4MSAwIC03LjktNy44LTE0LTE2LjctMTkuNC0yNS44bDQyLjEtNDIuMWMyLTIgNC41LTMuMiA2LjgtNC41IDIuOSA5LjkgOCAxOS4zIDE1LjggMjcuMiAyNSAyNSA2NS42IDI0LjkgOTAuNSAwbDkwLjUtOTAuNWMyNS0yNSAyNS02NS42IDAtOTAuNSAtMjQuOS0yNS02NS41LTI1LTkwLjUgMGwtMzIuMiAzMi4yYy0yNi4xLTEwLjItNTQuMi0xMi45LTgxLjYtOC45bDY4LjYtNjguNmM1MC01MCAxMzEtNTAgMTgxIDBDNTA5LjYgMTAyLjMgNTA5LjYgMTgzLjQgNDU5LjcgMjMzLjR6TTIyMC4zIDM4Mi4ybC0zMi4yIDMyLjJjLTI1IDI0LjktNjUuNiAyNC45LTkwLjUgMCAtMjUtMjUtMjUtNjUuNiAwLTkwLjVsOTAuNS05MC41YzI1LTI1IDY1LjUtMjUgOTAuNSAwIDcuOCA3LjggMTIuOSAxNy4yIDE1LjggMjcuMSAyLjQtMS40IDQuOC0yLjUgNi44LTQuNWw0Mi4xLTQyYy01LjQtOS4yLTExLjYtMTgtMTkuNC0yNS44IC01MC01MC0xMzEtNTAtMTgxIDBsLTkwLjUgOTAuNWMtNTAgNTAtNTAgMTMxIDAgMTgxIDUwIDUwIDEzMSA1MCAxODEgMGw2OC42LTY4LjZDMjc0LjYgMzk1LjEgMjQ2LjQgMzkyLjMgMjIwLjMgMzgyLjJ6Ii8+PC9zdmc+Cg==');opacity:0.5;visibility:hidden;display:inline-block;vertical-align:middle;}/*!sc*/
.bLuoRC h1:hover > .share-link::before,.bLuoRC h2:hover > .share-link::before,.bLuoRC .share-link:hover::before{visibility:visible;}/*!sc*/
.bLuoRC a{-webkit-text-decoration:none;text-decoration:none;color:rgba(246,20,63,1);}/*!sc*/
.bLuoRC a:visited{color:rgba(246,20,63,1);}/*!sc*/
.bLuoRC a:hover{color:#fa768f;}/*!sc*/
data-styled.g53[id="sc-cOifOu"]{content:"dWRQLc,bLuoRC,"}/*!sc*/
.hBzUso{font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;font-weight:400;line-height:1.5em;}/*!sc*/
.hBzUso p:last-child{margin-bottom:0;}/*!sc*/
.hBzUso p:first-child{margin-top:0;}/*!sc*/
.hBzUso p:last-child{margin-bottom:0;}/*!sc*/
.hBzUso p{display:inline-block;}/*!sc*/
.hBzUso h1{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.85714em;line-height:1em;color:#2d3134;margin-top:0;}/*!sc*/
.hBzUso h2{font-family:Montserrat,sans-serif;font-weight:bold;font-size:1.57143em;line-height:1em;color:#2d3134;}/*!sc*/
.hBzUso code{color:#e53935;background-color:rgba(38,50,56,0.05);font-family:Courier,monospace;border-radius:2px;border:1px solid rgba(38,50,56,0.1);padding:0 5px;font-size:13px;font-weight:400;word-break:break-word;}/*!sc*/
.hBzUso pre{font-family:Courier,monospace;white-space:pre;background-color:#151719;color:white;padding:20px;overflow-x:auto;line-height:normal;border-radius:0px;border:1px solid rgba(38,50,56,0.1);}/*!sc*/
.hBzUso pre code{background-color:transparent;color:white;padding:0;}/*!sc*/
.hBzUso pre code:before,.hBzUso pre code:after{content:none;}/*!sc*/
.hBzUso blockquote{margin:0;margin-bottom:1em;padding:0 15px;color:#777;border-left:4px solid #ddd;}/*!sc*/
.hBzUso img{max-width:100%;box-sizing:content-box;}/*!sc*/
.hBzUso ul,.hBzUso ol{padding-left:2em;margin:0;margin-bottom:1em;}/*!sc*/
.hBzUso ul ul,.hBzUso ol ul,.hBzUso ul ol,.hBzUso ol ol{margin-bottom:0;margin-top:0;}/*!sc*/
.hBzUso table{display:block;width:100%;overflow:auto;word-break:normal;word-break:keep-all;border-collapse:collapse;border-spacing:0;margin-top:1.5em;margin-bottom:1.5em;}/*!sc*/
.hBzUso table tr{background-color:#fff;border-top:1px solid #ccc;}/*!sc*/
.hBzUso table tr:nth-child(2n){background-color:#fafafa;}/*!sc*/
.hBzUso table th,.hBzUso table td{padding:6px 13px;border:1px solid #ddd;}/*!sc*/
.hBzUso table th{text-align:left;font-weight:bold;}/*!sc*/
.hBzUso .share-link{cursor:pointer;margin-left:-20px;padding:0;line-height:1;width:20px;display:inline-block;outline:0;}/*!sc*/
.hBzUso .share-link:before{content:'';width:15px;height:15px;background-size:contain;background-image:url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZlcnNpb249IjEuMSIgeD0iMCIgeT0iMCIgd2lkdGg9IjUxMiIgaGVpZ2h0PSI1MTIiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cGF0aCBmaWxsPSIjMDEwMTAxIiBkPSJNNDU5LjcgMjMzLjRsLTkwLjUgOTAuNWMtNTAgNTAtMTMxIDUwLTE4MSAwIC03LjktNy44LTE0LTE2LjctMTkuNC0yNS44bDQyLjEtNDIuMWMyLTIgNC41LTMuMiA2LjgtNC41IDIuOSA5LjkgOCAxOS4zIDE1LjggMjcuMiAyNSAyNSA2NS42IDI0LjkgOTAuNSAwbDkwLjUtOTAuNWMyNS0yNSAyNS02NS42IDAtOTAuNSAtMjQuOS0yNS02NS41LTI1LTkwLjUgMGwtMzIuMiAzMi4yYy0yNi4xLTEwLjItNTQuMi0xMi45LTgxLjYtOC45bDY4LjYtNjguNmM1MC01MCAxMzEtNTAgMTgxIDBDNTA5LjYgMTAyLjMgNTA5LjYgMTgzLjQgNDU5LjcgMjMzLjR6TTIyMC4zIDM4Mi4ybC0zMi4yIDMyLjJjLTI1IDI0LjktNjUuNiAyNC45LTkwLjUgMCAtMjUtMjUtMjUtNjUuNiAwLTkwLjVsOTAuNS05MC41YzI1LTI1IDY1LjUtMjUgOTAuNSAwIDcuOCA3LjggMTIuOSAxNy4yIDE1LjggMjcuMSAyLjQtMS40IDQuOC0yLjUgNi44LTQuNWw0Mi4xLTQyYy01LjQtOS4yLTExLjYtMTgtMTkuNC0yNS44IC01MC01MC0xMzEtNTAtMTgxIDBsLTkwLjUgOTAuNWMtNTAgNTAtNTAgMTMxIDAgMTgxIDUwIDUwIDEzMSA1MCAxODEgMGw2OC42LTY4LjZDMjc0LjYgMzk1LjEgMjQ2LjQgMzkyLjMgMjIwLjMgMzgyLjJ6Ii8+PC9zdmc+Cg==');opacity:0.5;visibility:hidden;display:inline-block;vertical-align:middle;}/*!sc*/
.hBzUso h1:hover > .share-link::before,.hBzUso h2:hover > .share-link::before,.hBzUso .share-link:hover::before{visibility:visible;}/*!sc*/
.hBzUso a{-webkit-text-decoration:none;text-decoration:none;color:rgba(246,20,63,1);}/*!sc*/
.hBzUso a:visited{color:rgba(246,20,63,1);}/*!sc*/
.hBzUso a:hover{color:#fa768f;}/*!sc*/
data-styled.g54[id="sc-Arkif"]{content:"hBzUso,"}/*!sc*/
.llGFDD{position:relative;}/*!sc*/
data-styled.g55[id="sc-khIgEk"]{content:"llGFDD,"}/*!sc*/
.cVHUjN:hover > .sc-efHYUO{opacity:1;}/*!sc*/
data-styled.g60[id="sc-iNiQyp"]{content:"cVHUjN,"}/*!sc*/
.fqzhkP{font-family:Courier,monospace;font-size:13px;white-space:pre;contain:content;overflow-x:auto;}/*!sc*/
.fqzhkP .redoc-json code > .collapser{display:none;pointer-events:none;}/*!sc*/
.fqzhkP .callback-function{color:gray;}/*!sc*/
.fqzhkP .collapser:after{content:'-';cursor:pointer;}/*!sc*/
.fqzhkP .collapsed > .collapser:after{content:'+';cursor:pointer;}/*!sc*/
.fqzhkP .ellipsis:after{content:' … ';}/*!sc*/
.fqzhkP .collapsible{margin-left:2em;}/*!sc*/
.fqzhkP .hoverable{padding-top:1px;padding-bottom:1px;padding-left:2px;padding-right:2px;border-radius:2px;}/*!sc*/
.fqzhkP .hovered{background-color:rgba(235,238,249,1);}/*!sc*/
.fqzhkP .collapser{background-color:transparent;border:0;color:#fff;font-family:Courier,monospace;font-size:13px;padding-right:6px;padding-left:6px;padding-top:0;padding-bottom:0;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-align-items:center;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:center;-webkit-justify-content:center;-ms-flex-pack:center;justify-content:center;width:15px;height:15px;position:absolute;top:4px;left:-1.5em;cursor:default;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;-webkit-user-select:none;padding:2px;}/*!sc*/
.fqzhkP .collapser:focus{outline-color:#fff;outline-style:dotted;outline-width:1px;}/*!sc*/
.fqzhkP ul{list-style-type:none;padding:0px;margin:0px 0px 0px 26px;}/*!sc*/
.fqzhkP li{position:relative;display:block;}/*!sc*/
.fqzhkP .hoverable{display:inline-block;}/*!sc*/
.fqzhkP .selected{outline-style:solid;outline-width:1px;outline-style:dotted;}/*!sc*/
.fqzhkP .collapsed > .collapsible{display:none;}/*!sc*/
.fqzhkP .ellipsis{display:none;}/*!sc*/
.fqzhkP .collapsed > .ellipsis{display:inherit;}/*!sc*/
data-styled.g61[id="sc-jffHpj"]{content:"fqzhkP,"}/*!sc*/
.fGHngE{padding:0.9em;background-color:rgba(45,49,52,0.4);margin:0 0 10px 0;display:block;font-family:Montserrat,sans-serif;font-size:0.929em;line-height:1.5em;}/*!sc*/
data-styled.g62[id="sc-eJocfa"]{content:"fGHngE,"}/*!sc*/
.iSvCgq{font-family:Montserrat,sans-serif;font-size:12px;position:absolute;z-index:1;top:-11px;left:12px;font-weight:600;color:rgba(254,254,254,0.7);}/*!sc*/
data-styled.g63[id="sc-oeezt"]{content:"iSvCgq,"}/*!sc*/
.lhdonw{position:relative;}/*!sc*/
data-styled.g64[id="sc-hhIiOg"]{content:"lhdonw,"}/*!sc*/
.hINeXe{margin-top:15px;}/*!sc*/
data-styled.g67[id="sc-gGLxEB"]{content:"hINeXe,"}/*!sc*/
.CMpTe{vertical-align:middle;font-size:13px;line-height:20px;}/*!sc*/
data-styled.g69[id="sc-fbIWvP"]{content:"CMpTe,"}/*!sc*/
.bbVlWa{color:rgba(77,77,77,0.9);}/*!sc*/
data-styled.g70[id="sc-FRrlG"]{content:"bbVlWa,"}/*!sc*/
.cqluXw{color:#4d4d4d;}/*!sc*/
data-styled.g71[id="sc-fXazdy"]{content:"cqluXw,"}/*!sc*/
.hUSnpT{vertical-align:middle;font-size:13px;line-height:20px;}/*!sc*/
data-styled.g73[id="sc-TtZnY"]{content:"hUSnpT,"}/*!sc*/
.bsGeIE{color:#d41f1c;font-size:0.9em;font-weight:normal;margin-left:20px;line-height:1;}/*!sc*/
data-styled.g74[id="sc-jHNicF"]{content:"bsGeIE,"}/*!sc*/
.kqbJtP{border-radius:2px;background-color:rgba(45,49,52,0.05);color:rgba(45,49,52,0.9);padding:0 5px;border:1px solid rgba(45,49,52,0.1);font-family:Courier,monospace;}/*!sc*/
.sc-hmbstg + .sc-hmbstg{margin-left:0;}/*!sc*/
data-styled.g77[id="sc-hmbstg"]{content:"kqbJtP,"}/*!sc*/
.ikafbi{margin-top:0;margin-bottom:0.5em;}/*!sc*/
data-styled.g87[id="sc-fcmMJX"]{content:"ikafbi,"}/*!sc*/
.PShUg{max-height:300px;max-width:300px;padding:2px;width:100%;display:block;}/*!sc*/
data-styled.g92[id="sc-csTbgd"]{content:"PShUg,"}/*!sc*/
.hNMhDm{text-align:center;}/*!sc*/
data-styled.g93[id="sc-dFRpbK"]{content:"hNMhDm,"}/*!sc*/
.fkLeMg{width:9ex;display:inline-block;height:13px;line-height:13px;background-color:#333;border-radius:3px;background-repeat:no-repeat;background-position:6px 4px;font-size:7px;font-family:Verdana,sans-serif;color:white;text-transform:uppercase;text-align:center;font-weight:bold;vertical-align:middle;margin-right:6px;margin-top:2px;}/*!sc*/
.fkLeMg.get{background-color:rgba(0,200,219,1);}/*!sc*/
.fkLeMg.post{background-color:rgba(28,184,65,1);}/*!sc*/
.fkLeMg.put{background-color:rgba(255,187,0,1);}/*!sc*/
.fkLeMg.options{background-color:#947014;}/*!sc*/
.fkLeMg.patch{background-color:#bf581d;}/*!sc*/
.fkLeMg.delete{background-color:rgba(254,39,35,1);}/*!sc*/
.fkLeMg.basic{background-color:#707070;}/*!sc*/
.fkLeMg.link{background-color:#07818F;}/*!sc*/
.fkLeMg.head{background-color:#A23DAD;}/*!sc*/
.fkLeMg.hook{background-color:#2d3134;}/*!sc*/
data-styled.g95[id="sc-gIvpjk"]{content:"fkLeMg,"}/*!sc*/
.jxJlxZ{margin:0;padding:0;}/*!sc*/
.sc-euEtCV .sc-euEtCV{font-size:0.929em;}/*!sc*/
.gaEEuU{margin:0;padding:0;display:none;}/*!sc*/
.sc-euEtCV .sc-euEtCV{font-size:0.929em;}/*!sc*/
data-styled.g96[id="sc-euEtCV"]{content:"jxJlxZ,gaEEuU,"}/*!sc*/
.cTzVOd{list-style:none inside none;overflow:hidden;text-overflow:ellipsis;padding:0;}/*!sc*/
data-styled.g97[id="sc-fHCHyC"]{content:"cTzVOd,"}/*!sc*/
.bzrFBB{cursor:pointer;color:#4a5055;margin:0;padding:12.5px 20px;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-webkit-justify-content:space-between;-ms-flex-pack:justify;justify-content:space-between;font-family:Montserrat,sans-serif;font-size:0.929em;text-transform:none;}/*!sc*/
.bzrFBB:hover{color:#4a5055;}/*!sc*/
.bzrFBB:hover{background-color:#e4e7eb;}/*!sc*/
.bzrFBB .sc-dIsUp{height:1.5em;width:1.5em;}/*!sc*/
.bzrFBB .sc-dIsUp polygon{fill:#4a5055;}/*!sc*/
.kAmGim{cursor:pointer;color:#4a5055;margin:0;padding:12.5px 20px;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-webkit-justify-content:space-between;-ms-flex-pack:justify;justify-content:space-between;font-family:Montserrat,sans-serif;color:#4a5055;}/*!sc*/
.kAmGim:hover{background-color:#d6d9e0;}/*!sc*/
.kAmGim .sc-dIsUp{height:1.5em;width:1.5em;}/*!sc*/
.kAmGim .sc-dIsUp polygon{fill:#4a5055;}/*!sc*/
data-styled.g98[id="sc-dtLLSn"]{content:"bzrFBB,kAmGim,"}/*!sc*/
.hHRjJL{display:inline-block;vertical-align:middle;width:auto;overflow:hidden;text-overflow:ellipsis;}/*!sc*/
.ipvKNC{display:inline-block;vertical-align:middle;width:calc(100% - 38px);overflow:hidden;text-overflow:ellipsis;}/*!sc*/
data-styled.g99[id="sc-dkQUaI"]{content:"hHRjJL,ipvKNC,"}/*!sc*/
.fWzLSR{font-size:0.8em;margin-top:10px;padding:0 20px;text-align:left;opacity:0.7;}/*!sc*/
.fWzLSR a,.fWzLSR a:visited,.fWzLSR a:hover{color:#4a5055 !important;border-top:1px solid #d6d9e0;padding:5px 0;display:block;}/*!sc*/
data-styled.g100[id="sc-WZYut"]{content:"fWzLSR,"}/*!sc*/
.jdCbTS{cursor:pointer;position:relative;margin-bottom:5px;}/*!sc*/
data-styled.g106[id="sc-kYPZxB"]{content:"jdCbTS,"}/*!sc*/
.jRjoAh{font-family:Courier,monospace;margin-left:10px;-webkit-flex:1;-ms-flex:1;flex:1;overflow-x:hidden;text-overflow:ellipsis;}/*!sc*/
data-styled.g107[id="sc-xGAEC"]{content:"jRjoAh,"}/*!sc*/
.bEfEgL{outline:0;color:inherit;width:100%;text-align:left;cursor:pointer;padding:10px 30px 10px 20px;border-radius:4px 4px 0 0;background-color:#151719;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;white-space:nowrap;-webkit-align-items:center;-webkit-box-align:center;-ms-flex-align:center;align-items:center;border:1px solid transparent;border-bottom:0;-webkit-transition:border-color 0.25s ease;transition:border-color 0.25s ease;}/*!sc*/
.bEfEgL ..sc-xGAEC{color:#ffffff;}/*!sc*/
.bEfEgL:focus{box-shadow:inset 0 2px 2px rgba(0,0,0,0.45),0 2px 0 rgba(128,128,128,0.25);}/*!sc*/
data-styled.g108[id="sc-dWBRfb"]{content:"bEfEgL,"}/*!sc*/
.fWlJmy{font-size:0.929em;line-height:20px;background-color:rgba(0,200,219,1);color:#ffffff;padding:3px 10px;text-transform:uppercase;font-family:Montserrat,sans-serif;margin:0;}/*!sc*/
.dwkpAC{font-size:0.929em;line-height:20px;background-color:rgba(28,184,65,1);color:#ffffff;padding:3px 10px;text-transform:uppercase;font-family:Montserrat,sans-serif;margin:0;}/*!sc*/
data-styled.g109[id="sc-jHcXXw"]{content:"fWlJmy,dwkpAC,"}/*!sc*/
.gBwOdz{position:absolute;width:100%;z-index:100;background:#fafafa;color:#263238;box-sizing:border-box;box-shadow:0px 0px 6px rgba(0,0,0,0.33);overflow:hidden;border-bottom-left-radius:4px;border-bottom-right-radius:4px;-webkit-transition:all 0.25s ease;transition:all 0.25s ease;visibility:hidden;-webkit-transform:translateY(-50%) scaleY(0);-ms-transform:translateY(-50%) scaleY(0);transform:translateY(-50%) scaleY(0);}/*!sc*/
data-styled.g110[id="sc-bQCEYZ"]{content:"gBwOdz,"}/*!sc*/
.fKFAhr{padding:10px;}/*!sc*/
data-styled.g111[id="sc-fXgAZx"]{content:"fKFAhr,"}/*!sc*/
.hbEpxm{padding:5px;border:1px solid #ccc;background:#fff;word-break:break-all;color:#2d3134;}/*!sc*/
.hbEpxm > span{color:#2d3134;}/*!sc*/
data-styled.g112[id="sc-EZqKI"]{content:"hbEpxm,"}/*!sc*/
.fsMzU{display:block;border:0;width:100%;text-align:left;padding:10px;border-radius:2px;margin-bottom:4px;line-height:1.5em;background-color:#f2f2f2;cursor:pointer;color:rgba(28,184,65,1);background-color:rgba(28,184,65,0.07);}/*!sc*/
.fsMzU:focus{outline:auto;outline-color:rgba(28,184,65,1);}/*!sc*/
.gzxVda{display:block;border:0;width:100%;text-align:left;padding:10px;border-radius:2px;margin-bottom:4px;line-height:1.5em;background-color:#f2f2f2;cursor:pointer;color:rgba(28,184,65,1);background-color:rgba(28,184,65,0.07);cursor:default;}/*!sc*/
.gzxVda:focus{outline:auto;outline-color:rgba(28,184,65,1);}/*!sc*/
.gzxVda::before{content:"—";font-weight:bold;width:1.5em;text-align:center;display:inline-block;vertical-align:top;}/*!sc*/
.gzxVda:focus{outline:0;}/*!sc*/
data-styled.g113[id="sc-jXcxbT"]{content:"fsMzU,gzxVda,"}/*!sc*/
.jSPrUM{vertical-align:top;}/*!sc*/
data-styled.g117[id="sc-jlZJtj"]{content:"jSPrUM,"}/*!sc*/
.hzeDni{font-size:1.3em;padding:0.2em 0;margin:3em 0 1.1em;color:#2d3134;font-weight:normal;}/*!sc*/
data-styled.g118[id="sc-dTSzeu"]{content:"hzeDni,"}/*!sc*/
.kBgcMI{-webkit-backface-visibility:hidden;backface-visibility:hidden;contain:content;overflow:hidden;}/*!sc*/
data-styled.g130[id="sc-irKDMX"]{content:"kBgcMI,"}/*!sc*/
.eUdCtG{margin-bottom:30px;}/*!sc*/
data-styled.g131[id="sc-eWnToP"]{content:"eUdCtG,"}/*!sc*/
.eFLSaK{-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;width:20px;height:20px;-webkit-align-self:center;-ms-flex-item-align:center;align-self:center;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-flex-direction:column;-ms-flex-direction:column;flex-direction:column;color:#2d3134;}/*!sc*/
data-styled.g132[id="sc-kTCsyW"]{content:"eFLSaK,"}/*!sc*/
.bnNJLB{width:300px;background-color:#f3f4f6;overflow:hidden;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-flex-direction:column;-ms-flex-direction:column;flex-direction:column;-webkit-backface-visibility:hidden;backface-visibility:hidden;height:100vh;position:-webkit-sticky;position:sticky;position:-webkit-sticky;top:0;}/*!sc*/
@media screen and (max-width:50rem){.bnNJLB{position:fixed;z-index:20;width:100%;background:#f3f4f6;display:none;}}/*!sc*/
@media print{.bnNJLB{display:none;}}/*!sc*/
data-styled.g133[id="sc-dvUynV"]{content:"bnNJLB,"}/*!sc*/
.evdqdw{outline:none;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;background-color:#f2f2f2;color:#2d3134;display:none;cursor:pointer;position:fixed;right:20px;z-index:100;border-radius:50%;box-shadow:0 0 20px rgba(0,0,0,0.3);bottom:44px;width:60px;height:60px;padding:0 20px;}/*!sc*/
@media screen and (max-width:50rem){.evdqdw{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;}}/*!sc*/
@media print{.evdqdw{display:none;}}/*!sc*/
data-styled.g134[id="sc-jtiXyc"]{content:"evdqdw,"}/*!sc*/
.dcUhBM{font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;font-size:16px;font-weight:400;line-height:1.5em;color:#2d3134;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;position:relative;text-align:left;-webkit-font-smoothing:antialiased;font-smoothing:antialiased;text-rendering:optimizeSpeed !important;tap-highlight-color:rgba(0,0,0,0);-webkit-text-size-adjust:100%;text-size-adjust:100%;}/*!sc*/
.dcUhBM *{box-sizing:border-box;-webkit-tap-highlight-color:rgba(255,255,255,0);}/*!sc*/
data-styled.g135[id="sc-ellfGf"]{content:"dcUhBM,"}/*!sc*/
.fxEJmF{z-index:1;position:relative;overflow:hidden;width:calc(100% - 300px);contain:layout;}/*!sc*/
@media print,screen and (max-width:50rem){.fxEJmF{width:100%;}}/*!sc*/
data-styled.g136[id="sc-kizEQm"]{content:"fxEJmF,"}/*!sc*/
.jXpMha{background:#2d3134;position:absolute;top:0;bottom:0;right:0;width:calc((100% - 300px) * 0.4);}/*!sc*/
@media print,screen and (max-width:75rem){.jXpMha{display:none;}}/*!sc*/
data-styled.g137[id="sc-cKRKFl"]{content:"jXpMha,"}/*!sc*/
</style>
<style data-styled="true" data-styled-version="5.3.0">

.JwytR {
    position: absolute;
    width: 100%;
    z-index: 100;
    background: rgb(250, 250, 250);
    color: rgb(38, 50, 56);
    box-sizing: border-box;
    box-shadow: rgba(0, 0, 0, 0.33) 0px 0px 6px;
    overflow: hidden;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
    transition: all 0.25s ease 0s;
    transform: translateY(-50%) scaleY(0);
}
.bLuoRC {
    font-family: "Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;
    font-weight: 400;
    line-height: 1.5em;
}
.dcUhBM * {
    box-sizing: border-box;
    -webkit-tap-highlight-color: rgba(255,255,255,0);
}

.hbEpxm {
    padding: 5px;
    border: 1px solid #ccc;
    background: #fff;
    word-break: break-all;
    color: #2d3134;
}

/**
 * Tabs
 */
.tabs {
  display: flex;
  flex-wrap: wrap; // make sure it wraps
}
.tabs label {
  order: 1; // Put the labels first
  display: block;
  padding: 1rem 2rem;
  margin-right: 0.2rem;
  cursor: pointer;
  background: #fff;
  color: #000;
  font-weight: bold;
  transition: background ease 0.2s;
}
.tabs .tab {
  order: 99; // Put the tabs last
  flex-grow: 1;
  width: 100%;
  display: none;
  padding: 1rem;
  background: #000;
}
.tabs input[type="radio"] {
  display: none;
}
.tabs input[type="radio"]:checked + label {
  background: #000;
color: #fff;
}
.tabs input[type="radio"]:checked + label + .tab {
  display: block;
}

@media (max-width: 45em) {
  .tabs .tab,
  .tabs label {
    order: initial;
  }
  .tabs label {
    width: 100%;
    margin-right: 0;
    margin-top: 0.2rem;
  }
}
</style>
<link href="chrome-extension://cjdnfmjmdligcpfcekfmenlhiopehjkd/web_resources/modal/modal.css" rel="stylesheet" id="__tmpStyle">





<div style="font-size: 18px">
This documentation provides more details about API and it`s requests and responses. In this documantation you can get infromation about endpoints and their responses for future front-end building. If u have some guestions/problems/bug-reports, u can write it on <a href="https://github.com/off-the-az/MyKowelAPI/issues">"ISSUE"</a> section.
</div>




# Base API endpoints:

<div class="tabs">
<!--                                                           USER                                                              -->
<input type="radio" name="tabs" id="user" checked="checked">
<label for="user">User`s Requests</label>
<div class="tab">

<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/user/get/</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting user`s full information from DB. If u want get information u must send 2 request params in Request-Headers.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Headers:
    - token: (ex.) u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301
    - admin: 0 (or 1)
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "id": 22,
    "login": "TEST",
    "name": "USER",
    "email": "username@gmail.com",
    "phone": "+380000000000",
    "password": "i5YoL5fbmnteeBT_9l4G1A==",
    "token": "u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301",
    "is_admin": "1"
  }
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">PUT</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/user/update/</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Updating user`s information in DB. U can update 1 and more informations in order of situation. If u want update information u must send 1 request params in Request-Headers and some request params using "multipart/form-data".
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Headers:
    - token: (ex.) u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301
Body ("multipart/form-data"):
    - (optional choise) login / name / email / phone / password / is_admin
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "id": 22,
    "login": "TEST_UPDATE",
    "name": "USER",
    "email": "username@gmail.com",
    "phone": "+380000000001",
    "password": "i5YoL5fbmnteeBT_9l4G1A==",
    "token": "u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301",
    "is_admin": "1"
  }
]
```
</span>
</button>


<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">delete</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/user/delete/</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Delete user`s information from DB. If u want delete information u must send 1 request param in Request-Headers.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Headers:
    - token: (ex.) u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```text
"User deleted"
```
</span>
</button>

</div>
<!--                                                           AUTH                                                              -->
<input type="radio" name="tabs" id="auth" checked="checked">
<label for="auth">Authorization`s Requests</label>
<div class="tab">


<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">post</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/login</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Register user in auth session and generate session-token. If u want login user u must sent with general request login and password params using "multipart/form-data".
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Body ("multipart/form-data"):
    - login: (ex.) TEST
    - password: (ex.) 123456789
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "id": 22,
    "login": "TEST",
    "name": "USER",
    "email": "username@gmail.com",
    "phone": "+380000000000",
    "password": "i5YoL5fbmnteeBT_9l4G1A==",
    "token": "u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301",
    "is_admin": "1"
  }
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">post</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/register</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Register new user in auth session and generate session-token. If u want register new user u must sent with general request some request params using "multipart/form-data".
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Body ("multipart/form-data"):
    - login: (ex.) TEST
    - password: (ex.) 123456789
    - name: (ex.) USER
    - email: (ex.) username@gmail.com
    - phone: (ex.) +380000000000 or <empty-field>
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```text
"User had been creating"
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">post</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/logout</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Finish user`s auth session and delete session-token. If u want finish aut session u must send token as request param using Request-Headers.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Headers :
    - token: (ex.) u3AulkpZFI1lIuGsik6vuPsVWqN7GoWs6o_MO2sdf301
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "id": 22,
    "login": "TEST",
    "name": "USER",
    "email": "username@gmail.com",
    "phone": "+380000000000",
    "password": "i5YoL5fbmnteeBT_9l4G1A==",
    "token": " ",
    "is_admin": "1"
  }
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">post</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/reset-request</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Orginize SMTP protocol with mail sending for future helping in reseting password. If u want send reset request u must send username as a request param using "multipart/form-data" 
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Headers :
    - username: (ex.) USER
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```text
"Password reset request sended!"
```
</span>
</button>
</div>
<!--                                                           CONTACTS                                                              -->
<input type="radio" name="tabs" id="contact" checked="checked">
<label for="contact" >Contact`s Requests</label>
<div class="tab">


<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/contacts/get</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting full list of contacts. U don`t need any request params for getting list of information.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
None
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
    {
        "pnumber": "+380000000000",
        "owner": "OWNER",
        "id": 0
    },
    {
        "pnumber": "+380000000001",
        "owner": "OWNER",
        "id": 1
    },
    {
        "pnumber": "+380000000002",
        "owner": "OWNER",
        "id": 2
    },
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/contacts/get/owner?value=</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting full list of contacts starts with value from request path. If u want find some inforamtion using owner param u must add data after `?value=` section. For example mykowel.pp.ua:8000/contacts/get/owner?value=OWNER.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Path variable:
    - value: (ex.) OWNER
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
    {
        "pnumber": "+380000000000",
        "owner": "OWNER",
        "id": 0
    },
    {
        "pnumber": "+380000000001",
        "owner": "OWNER",
        "id": 1
    },
    {
        "pnumber": "+380000000002",
        "owner": "OWNER",
        "id": 2
    },
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/contacts/get/id?value=</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting current contact by static value from request path. If u want find some inforamtion using id param u must add data after `?value=` section. For example mykowel.pp.ua:8000/contacts/get/id?value=0.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Path variable:
    - value: (ex.) 0
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
    {
        "pnumber": "+380000000000",
        "owner": "OWNER",
        "id": 0
    }
]
```
</span>
</button>



<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">post</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/contacts/add</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting current contact by static value from request path. If u want find some inforamtion using id param u must add data after `?value=` section. For example mykowel.pp.ua:8000/contacts/get/id?value=0.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
Path variable:
    - value: (ex.) 0
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
    {
        "pnumber": "+380000000000",
        "owner": "OWNER",
        "id": 0
    }
]
```
</span>
</button>
</div>
<!--                                                           MARKET                                                              -->
<input type="radio" name="tabs" id="market" checked="checked">
<label for="market">Market`s Requests</label>
<div class="tab">


<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/market/get</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting full list of items from market. U don`t need any request params for getting list of information.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
None
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "id": 26,
    "title": "testt",
    "description": "etse",
    "price": 39,
    "category": "0755",
    "pnumber": "948494949",
    "owner": 20,
    "photo": "http://mykowel.pp.ua:8000/downloadFile/market/20-IMG_20230428_155458.jpg",
    "checked": 0,
    "sold": 0
  },
  {
    "id": 25,
    "title": "testt",
    "description": "etse",
    "price": 39,
    "category": "0755",
    "pnumber": "948494949",
    "owner": 20,
    "photo": "http://mykowel.pp.ua:8000/downloadFile/market/20-IMG_20230428_155458.jpg",
    "checked": 0,
    "sold": 0
  },
  {
    "id": 24,
    "title": "testt",
    "description": "etse",
    "price": 39,
    "category": "0755",
    "pnumber": "948494949",
    "owner": 20,
    "photo": "http://mykowel.pp.ua:8000/downloadFile/market/20-IMG_20230428_155458.jpg",
    "checked": 0,
    "sold": 0
  },
]
```
</span>
</button>



</div>
<!--                                                           EVENTS                                                              -->
<input type="radio" name="tabs" id="events" checked="checked">
<label for="events">Events`s Requests</label>
<div class="tab">


<button class="sc-dWBRfb lbhBhk"><button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">get</span><span class="sc-xGAEC jRjoAh">mykowel.pp.ua:8000/events/get</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh"><span class="sc-xGAEC jRjoAh">
Getting full list of events. U don`t need any request params for getting list of information.
</span></span></button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Params</span>

```
None
```
</span>
</button>
<button class="sc-dWBRfb lbhBhk"><span class="sc-xGAEC jRjoAh">
<span style="pointer-events: none; background-color: #ff4343; color: white" type="get" class="sc-jHcXXw fWlJmy http-verb get">Result</span>

```json
[
  {
    "title": "MK Fest",
    "place": "Online",
    "date": "2023-07-06 00:00:00",
    "id": 1
  }
]
```
</span>
</button>

</div>

</div>

