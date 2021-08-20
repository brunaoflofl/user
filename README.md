# backend-java-challenge_bruna_lima

# ia-teste-tecnico

<h3>Vamos la..</h3>

<h3>1.</h3> Faça o download

code -> download.zip

<h3>2.</h3> Na IDE de sua preferencia:

file -> import -> existing maven project -> selecione o projeto baixado

espere carregar as dependencias

mvn install

suba o projeto como spring-boot-app

<h3>3.</h3> Vamos testar..

<h4>PARA TESTE INSOMNIA/POSTMAN:</h4> 

URLs: 

#  Login

username: admin, senha: 123; 

username: user, senha: 123;

*Admin tem acesso a pag http://localhost:8080/admin

http://localhost:8080/login Login funcionando!


#  Inserir um usuario:

POST http://localhost:8080/api/users

body: USER

{
  "username": "user2",
  "password": "123",
  "name": "TestUsuario",
  "email": "test@test.com",
  "createdDate": "20/08/2021",
  "enabled": true,
  "roles": [
    {
      "id": 1,
      "role": "USER"
    }
  ]
}

body: ADMIN

 {
    "id": 1,
    "username": "admin",
    "password": "$2a$10$LxUr3WuUqcbua5BXNgwu4.3YtwQtWam7//eTNMtXDBpn5flXm1tIm",
    "name": "TestAdmin",
    "email": "test@test.com",
    "createdDate": "20/08/2021",
    "enabled": true,
    "roles": [
      {
        "id": 2,
        "role": "ADMIN"
      }
    ]
  },


#  Listar todos:

Só consigo acessar as urls abaixo configurando o SecurityConfig com .permitAll().

GET http://localhost:8080/api/users/list

#  Listar usuario especifico:

GET http://localhost:8080/api/users/list/1
(lista usuário de id=1)

#  Alterar dados usuario específico:

PUT http://localhost:8080/api/users/up/1
(altera dados do usuário de id=1)

#  Deletar usuario especifico:

DELETE http://localhost:8080/api/users/1
(exclui usuário de id=1)


<h2>Obrigada!!!</h2>

<h3>INFO: A aplicação não está cumprindo todos os passos solicitados. Como havia conversado com o Kaio, tive um pouco de dor de cabeça com o spring security devido a esses erros de autenticação. Enviei como estava e vou adicionando alterações especificadas no bonus e a mensageria.</h3>

