Specification Heading
=====================
Created by testinium on 25.08.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Post Deneme
----------------
* Create Json
* Add to json "name" : "hasusd"
* Add to json "email" : "askfjasjjd.sajasd@gjasfj.com"
* Add to json "gender" : "female"
* Add to json "status" : "active"
* Send "POST" request to "users"
* Check is response status "201"
* Print out body

Get Deneme
----------------
* Send "GET" request to "users"
* Check is response status "200"
* Print out body

Get Specific User
----------------
* Send "GET" request to "users/3999"
* Check is response status "200"
* Print out body

Put Deneme
----------------
* Create Json
* Add to json "name" : "gashdjasfj"
* Add to json "email" : "yajksnfjkasda@gjasfj.com"
* Add to json "gender" : "female"
* Add to json "status" : "active"
* Send "PUT" request to "users/3942"
* Check is response status "200"
* Print out body

Delete Deneme
----------------
* Send "DELETE" request to "users/3917"
* Check is response status "204"
* Print out body

Gender Degistirme Deneme
----------------
* Create Json
* Add to json "gender" : "male"
* Send "PUT" request to "users/3999"
* Check is response status "200"
* Print out body