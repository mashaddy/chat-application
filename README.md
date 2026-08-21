Here we are building a chat application 

architecture 
react web app -> rest + websockets -> springboot backend -> mysql, redis , storage -> 

backend : 
java 
springboot
spring mvc
spring security
jwt
web socket
jpa/hibernate
mysql
redis
rest APIs
STOMP

frontend : 
react
react router
axios
state management
web socket client
authentication
chat ui

devops :
git 
docker
docker compose
ci/cd
jenkins
deployment

day 1 : 
create spring boot project and add user entity.

This is the database design

                                                    ┌─────────────────┐
                                                    │      users      │
                                                    ├─────────────────┤
                                                    │ id              │
                                                    │ username        │
                                                    │ email           │
                                                    │ password        │
                                                    │ created_at      │
                                                    │ last_seen       │
                                                    └────────┬────────┘
                                                            │
                                                        1    │    many
                                                            │
                                                            ▼
                                                ┌─────────────────────────┐
                                                │ conversation_participants│
                                                ├─────────────────────────┤
                                                │ id                      │
                                                │ conversation_id         │
                                                │ user_id                 │
                                                └────────────┬────────────┘
                                                            │
                                                        many │    1
                                                            ▼
                                                    ┌─────────────────┐
                                                    │  conversations  │
                                                    ├─────────────────┤
                                                    │ id              │
                                                    │ created_at      │
                                                    └────────┬────────┘
                                                            │
                                                        1    │    many
                                                            │
                                                            ▼
                                                    ┌─────────────────┐
                                                    │     messages    │
                                                    ├─────────────────┤
                                                    │ id              │
                                                    │ conversation_id │
                                                    │ sender_id       │
                                                    │ content         │
                                                    │ created_at      │
                                                    └─────────────────┘

Https status code :

200 success
409 confict
403 forbidden
500 internal server error
404 error


day 2 : 
database layer created
repository layer created
service layer created


1.Handling the scenario where the duplicate emails are entered.

2.Securing the password by using Bcrypt.
    The flow will be like : controller -> service -> Password Encoder -> repository -> MySql

Process : Add spring security dependency, create password encoder bean, add this method to the service class.

3.implementing dto for registration
    we use dto so that we are not exposing the entire entity to the user through thr api endpooint.
    

4.Password is hashed before storage.
Duplicate emails are rejected with 409 Conflict.
Password is not returned in the API response.
Database-specific fields aren't exposed through the registration request.

5.implementing the validation for the registration.

