# Atividade02_1: Servidor de aplicações Java Web.

Instalação e Configuração de Servidor Web:

-   CentOS 7.6
-   TOMCAT 9
-   Oracle Java JDK 1.8
-   PostgreSQL 11.2 (Aceitar conexões remotas, inclusive de root);

Aplicação:

-   Agenda de cadastro (telefones) simples em JSF (de sua autoria), c/ persistência em banco de dados (PostgreSQL).

---

## Configuração do servidor Web (CentOS 7).

## **instalação do JDK na versão 8 (201).**

```sh
$ cd /opt/

$ mkdir java && cd java

# downlaod do java 8 direto do site da oracle
$ wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.rpm"

# instalação do pacote
$ sudo yum localinstall jdk-8u201-linux-x64.rpm

#verificação da versão instaçada
$java -version
```

## **instalação do tomcat 9**

```sh
#donwload do tomcat
$ wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-9/v9.0.16/bin/apache-tomcat-9.0.16.tar.gz

$ tar xzf apache-tomcat-9.0.16.tar.gz

$ sudo mv apache-tomcat-9.0.16 /usr/local/tomcat9

# criar a variavel de ambiente para o tomcat
$ echo "export CATALINA_HOME="/usr/local/tomcat9"" >> ~/.bashrc

$ source ~/.bashrc
```

Configurando o acesso externo ao servidor do tomcat

```sh
#configuração do acesso extermo ao tomcat
$ systemctl start firewalldsystemctl enable firewalld

$ firewall-cmd --zone=public --permanent --add-port=8080/tcp

$ firewall-cmd --reload
```

iniciando o servidor do apache

```sh
#iniciar o tomcat
$ bash /usr/local/tomcat9/bin/startup.sh

## saida esperada
#> Using CATALINA_BASE: /usr/local/tomcat9</br>
#> Using CATALINA_HOME: /usr/local/tomcat9</br>
#> Using CATALINA_TMPDIR: /usr/local/tomcat9/temp</br>
#> Using JRE_HOME: /usr</br>
#> Using CLASSPATH: /usr/local/tomcat9/bin/bootstrap.jar:/usr/local/tomcat9/bin/</br>
#> tomcat-juli.jar</br>
#> Tomcat started.</br>
```

configurando tomcat para iniciar com o sistema

```sh
# adicionando o diretorio tomcat9 ao grupo tomcat
$ sudo chown -R tomcat: /usr/local/tomcat9

#criando o arquivo de serviço
$ sudo vi /etc/systemd/system/tomcat.service
```

cole o seguinte codigo:

```
[Unit]
Description=Tomcat 9 servlet container
After=network.target

[Service]
Type=forking

User=tomcat
Group=tomcat

Environment="CATALINA_BASE=/usr/local/tomcat9"
Environment="CATALINA_HOME=/usr/local/tomcat9"

ExecStart=/usr/local/tomcat9/bin/startup.sh
ExecStop=/usr/local/tomcat9/bin/shutdown.sh

[Install]
WantedBy=multi-user.target
```

habilite o serviço do tomcat

```sh
# habilitar
$ sudo systemctl enable tomcat

# iniciar
$ sudo systemctl start tomcat

#verificar status
$ sudo systemctl status tomcat -l
```

## **instalação do PostgreSQL**

```sh
#adicionando repositorio do postgre
$ yum install https://download.postgresql.org/pub/repos/yum/11/redhat/rhel-7-x86_64/pgdg-centos11-11-2.noarch.rpm

#instalação do cliente
$ yum install postgresql11

#instalação dos servidor
$ yum install postgresql11-server
```

configurando postgre para iniciar com o sistema

```sh
$ /usr/pgsql-11/bin/postgresql-11-setup initdb

$ systemctl enable postgresql-11

$ systemctl start postgresql-11
```

configurando postgre para aceitar conexões remotas

```sh
$ sudo vi /var/lib/pgsql/data/postgresql.conf
```

Com o editor de texto aberto edite na parte area de `CONNECTIONS AND AUTHENTICATION`, troque o `localhost` por `*`.

```
#------------------------------------------------------------------------------
# CONNECTIONS AND AUTHENTICATION
#------------------------------------------------------------------------------

# - Connection Settings -

listen_addresses = '*'     # what IP address(es) to listen on;
```

salve o arquivo e reinicie o serviço do postgre

```sh
$ sudo systemctl restart postgresql
```
