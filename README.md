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


Vamos subir o serviço externo do redis:

1. docker run --name meu-redis -d -p 6379:6379 redis redis-server
2. docker exec -it meu-redis redis-cli


URLs: 

#  Login

http://localhost:8080/login Login funcionando!

![image](https://user-images.githubusercontent.com/39420860/130431416-4a113f59-2576-4ee7-b776-39dfdd4f0dc3.png)



username: admin, senha: 123; 

![image](https://user-images.githubusercontent.com/39420860/130431136-311fcc18-25c5-4a5d-9484-b75c3045ad5f.png)


username: user, senha: 123;

![image](https://user-images.githubusercontent.com/39420860/130431322-69f62ee2-8e9e-4658-8dee-e918a5ee2aa6.png)


*Admin tem acesso a pag http://localhost:8080/admin

<h4>PARA TESTE INSOMNIA/POSTMAN:</h4> 


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

![image](https://user-images.githubusercontent.com/39420860/130431769-3a158e42-53b9-457a-9a5f-b305d3eaf774.png)


#  Listar todos:

Só consigo acessar as urls abaixo configurando o SecurityConfig com .permitAll().

GET http://localhost:8080/api/users/list

![image](https://user-images.githubusercontent.com/39420860/130431923-159a6117-f246-4953-a526-bfb20c2acaca.png)


#  Listar usuario especifico:

GET http://localhost:8080/api/users/list/3
(lista usuário de id=3)

![image](https://user-images.githubusercontent.com/39420860/130432036-615e377a-4b59-4c7c-97e5-733cf12f78b2.png)


#  Alterar dados usuario específico:

PUT http://localhost:8080/api/users/up/3
(altera dados do usuário de id=3)

![image](https://user-images.githubusercontent.com/39420860/130432288-fe3dd220-43dc-4742-96f9-638d335dbedd.png)


#  Deletar usuario especifico:

DELETE http://localhost:8080/api/users/1
(exclui usuário de id=1)


<h2>Obrigada!!!</h2>

<h3>INFO: A aplicação não está cumprindo todos os passos solicitados. Como havia conversado com o Kaio, tive um pouco de dor de cabeça com o spring security devido a esses erros de autenticação. Enviei como estava e vou adicionando alterações especificadas no bonus e a mensageria.</h3>

