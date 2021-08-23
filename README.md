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

![image](https://user-images.githubusercontent.com/39420860/130433049-98605cfd-7136-4fe0-bde8-5660e4eba32b.png)

Vamos acompanhar a sessão após o login


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
    "username": "admin2",
    "password": "123",
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

Alterado

![image](https://user-images.githubusercontent.com/39420860/130432512-25b9a2f6-fa94-464a-a896-da7b90379ffb.png)



#  Deletar usuario especifico:

DELETE http://localhost:8080/api/users/3
(exclui usuário de id=3)

![image](https://user-images.githubusercontent.com/39420860/130432598-141e188c-46d0-4f8f-b1f5-34c40d428fe5.png)

Usuario 3 deletado

![image](https://user-images.githubusercontent.com/39420860/130432739-31b77e83-7709-4189-b113-b9b76bbfa54f.png)

<h1>Redis</h1>

Rode Keys * e listará as sessões:
  
  ![image](https://user-images.githubusercontent.com/39420860/130433251-b88c37e5-c994-41b7-b469-192affdfb3ed.png)
  
  Está listando as sessões que realizei o login:
  
  ![image](https://user-images.githubusercontent.com/39420860/130433525-f7e5fe47-bb2f-459c-b8a4-a4885472c01b.png)
  
  
  ![image](https://user-images.githubusercontent.com/39420860/130433956-0aad3957-e121-446e-81f8-4c3d007fcd12.png)


<h1>RabbitMQ</h1>

Vamos enviar o email: 

http://localhost:8080/email

Body:

{
  "idEmail": "1",
  "email": "email enviado"
}

![image](https://user-images.githubusercontent.com/39420860/130434062-19506690-bac8-4528-9789-74867dfc24a9.png)


![image](https://user-images.githubusercontent.com/39420860/130434319-7fd516b8-3404-4b40-9476-2fde1fb272d1.png)

![image](https://user-images.githubusercontent.com/39420860/130434486-5d9e44c7-165d-4292-a217-20b51f607082.png)

![image](https://user-images.githubusercontent.com/39420860/130434866-7c75b1dd-8f6e-4ee0-88e1-471ebb97f47b.png)




<h2>Obrigada!!!</h2>



