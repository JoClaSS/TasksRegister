# TasksRegister 

A Aplicação foi desenvolvida como Java Web com base Jave EE em JavaServer Faces conforme especificado no documento do desafio de desenvolvimento.

Este projeto utiliza o Maven como gerenciador de depências, Java 11 e banco de dados utilizado para a implementação da persistencia de dados foi o Postgresql junto com a framework Hibernate 5.6 mais a API JPA. 

Itens da avaliação:

A - Foi utilizada JSF para a aplicação WEB, no quesito de gerenciamento de dados por meio de um ManagedBean. 

B - Persistencia de dados atingida por meio da framework Hibernate em conjunto com JPA, banco de dados utilizado: Postgres. Os Dados adquiridos pela classe TaskMB que é um ManagedBean são enviados para a classe TaskDAO ao qual tem função de salvar os dados adquiridos, listar, ou deletar, fazendo uso do objeto sessao, da classe Session da framework Hibernate, para o gerenciamento do banco de dados.

C - O Hibernate cuida de toda a parte de gerenciamento do banco de dados da aplicação.
 
D - Foi utilizado Bootstrap 4 para a estilização de toda a página.

Orientações:

Recomendações: Rodar a aplicação no Eclipse EE e o Postgresql na sua versão 42.3.2.

1- Baixar e rodar o script de PostgreSQL fornecido na pasta /database para a criação do banco de dados e tabelas a serem utilizadas no projeto.

2- Abrir o projeto como Maven Project e aguardar a instalação das dependências.

3- Adicionar e configurar usuario/senha do Apache Tomcat 8.5;

4- Adicionar conexão com o banco de dados "Tasks", arquivo de configuração da conexão se encontra em /src/java/resources/hibernate.cfg
