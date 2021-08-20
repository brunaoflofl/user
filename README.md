# backend-java-challenge_bruna_lima

# ia-teste-tecnico

<h3>Vamos la..</h3>

<h3>1.</h3> No terminal:

git clone https://github.com/brunaoflofl/ia-teste-tecnico.git

INFO: O git adicionou uma mudança de segurança. Agora precisa criar um token e passar seu token na solicitação.

exemplo:  git clone https://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@github.com/Instituto-Atlantico/backend-java-challenge_bruna_lima.git

https://_SEU_TOKEN_@github.com/Instituto-Atlantico/backend-java-challenge_bruna_lima.git

<h3>2.</h3> Na IDE de sua preferencia:

file -> import -> existing maven project -> user-app

selecione o projeto clonado
espere carregar as dependencias

mvn install

suba o projeto como spring-boot-app

<h3>3.</h3> Vamos testar..

<h4>PARA TESTE INSOMNIA/POSTMAN:</h4> 

URLs: 

#  Inserir um usuario:

POST http://localhost:8080/api/users

body: 

{
	"username": "teste2",
	"password": "123",
	"name": "teste atualizando usuario",
	"email": "test@email.com",
	"permissao": false 
}

Permissao retorna USER ou ADMIN.


#  Login

username: teste2, senha: 123;

http://localhost:8080/login  Login não autentica.



#  Listar todos:

Só consigo acessar as urls abaixo configurando o SecurityConfig com .permitAll().

GET http://localhost:8080/api/users

#  Listar usuario especifico:

GET http://localhost:8080/api/users/1
(lista usuário de id=1)

#  Alterar dados usuario específico:

PUT http://localhost:8080/api/users/1
(altera dados do usuário de id=1)

#  Deletar usuario especifico:

DELETE http://localhost:8080/api/users/1
(exclui usuário de id=1)


<h2>Obrigada!!!</h2>

<h3>INFO: A aplicação não está cumprindo todos os passos solicitados. Como havia conversado com o Kaio, tive um pouco de dor de cabeça com o spring security devido a esses erros de autenticação. Enviei como estava e vou adicionando alterações especificadas no bonus e a mensageria.</h3>

