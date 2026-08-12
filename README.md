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