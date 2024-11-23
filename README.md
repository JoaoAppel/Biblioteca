Esse projeto é uma API funcional que foi projetada para gerenciar uma biblioteca escolar, oferecendo funcionalidades externas para cadastro e controle de alunos, autores, bibliotecarios, emprestimos e livros.

Para utilizá-la, siga os passos abaixo:

Faça o download do repositório.
Instale o pgAdmin 4 (PostgreSQL).
Crie um banco de dados com o nome "biblioteca" no pgAdmin 4.

Dentro do projeto Biblioteca:

Localize o arquivo "application.properties".
Altere as linhas 3 e 4 conforme abaixo:
spring.datasource.username=postgres 
spring.datasource.password=987456

Substitua:

"postgres" pelo nome do usuário cadastrado no pgAdmin 4.
"987456" pela senha correspondente.
Com essas configurações, você estará pronto para utilizar a API Biblioteca.

Para testar voce pode estar utilizando Swagger.
A aplicação estará disponível em: `http://localhost:8080`.

A ordem para inserir os dados nas tabelas são respectivamente Aluno, Emprestimo, Livro, Autor e Bibliotecario.

Abaixo scripts que podem ser usados para inserir dados para testar utilzando o Swagger:

Tabela Aluno: { "nome": "Joao", "anoNascimento": "2004", "status": "Ativo"}

Tabela Emprestimo: {"dataEmprestimo": "2024-11-23T01:13:44.557Z", "datadevolucao": "2024-11-23T01:13:44.557Z", "status": "Ativo"}

Tabela Livro: { "titulo": "Joao", "anoPublicacao": "11/11/1978" }

Tabela Autor: { "nome": "Joao", "nacionalidade": "Brasil", "dataNascimento": "2024-11-23T01:41:59.352Z" }

Tabela Bibliotecario: { "nome": "Joao", "cpf": "12345678912", "email": "exemplo123@gmail.com", "telefone": "46999123456" }
