# Atividade02_1: Servidor de aplicações Java Web.

Instalação e Configuração de Servidor Web:

-   CentOS 7.6
-   TOMCAT 9
-   Oracle Java JDK 1.8
-   PostgreSQL 11.2 (Aceitar conexões remotas, inclusive de root);

Aplicação:

-   Agenda de cadastro (telefones) simples em JSF (de sua autoria), c/ persistência em banco de dados (PostgreSQL).

### Configuração do servidor Web (CentOS 7).

instalação dao JDK na versão 8 (201).

```sh
$ cd /opt/

$ mkdir java && cd java

$ wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.rpm"

$ sudo yum localinstall jdk-8u201-linux-x64.rpm

$java -version
```
