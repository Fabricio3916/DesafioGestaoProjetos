# Sistema de Gestão de Projetos

Sistema de gestão de projetos desenvolvido com Spring Boot 3 e PostgreSQL.

## 📋 Pré-requisitos

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## 🚀 Como executar a aplicação

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Inicie a aplicação com Docker Compose
```bash
docker-compose up -d
```

Este comando irá:
- Baixar as imagens necessárias (PostgreSQL e Java)
- Criar o banco de dados PostgreSQL
- Compilar e executar a aplicação Spring Boot
- Configurar a rede entre os containers

### 3. Acompanhe os logs (opcional)
```bash
docker-compose logs -f
```

Para sair dos logs, pressione `Ctrl + C`.

### 4. Acesse a aplicação

- **API:** http://localhost:8080
- **Documentação Swagger:** http://localhost:8080/swagger/index.html

## 🛑 Parar a aplicação

Para parar os containers:
```bash
docker-compose down
```

Para parar e remover os dados do banco de dados:
```bash
docker-compose down -v
```

## 🔄 Reconstruir a aplicação

Se você fez alterações no código e quer reconstruir:
```bash
docker-compose up -d --build
```

## 🗄️ Banco de Dados

O PostgreSQL estará acessível externamente na porta `5431` com as seguintes credenciais:

- **Host:** localhost
- **Porta:** 5431
- **Database:** SistemaGestao
- **Usuário:** admin
- **Senha:** admin

Você pode conectar usando ferramentas como DBeaver, pgAdmin ou qualquer cliente PostgreSQL.

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.6
- PostgreSQL 17
- Maven
- Docker & Docker Compose
- Swagger/OpenAPI

## 📝 Endpoints da API

A documentação completa dos endpoints está disponível no Swagger UI:

http://localhost:8080/swagger/index.html

## ⚠️ Troubleshooting

### Porta já em uso

Se a porta 8080 ou 5431 já estiver em uso, você pode alterá-las no arquivo `docker-compose.yml`:
```yaml
services:
  postgres:
    ports:
      - "NOVA_PORTA:5432"  # Exemplo: "5433:5432"
  
  app:
    ports:
      - "NOVA_PORTA:8080"  # Exemplo: "9090:8080"
```

### Containers não iniciam

Verifique se o Docker está rodando:
```bash
docker ps
```

Verifique os logs de erros:
```bash
docker-compose logs
```

### Limpar tudo e reiniciar
```bash
docker-compose down -v
docker-compose up -d --build
```

