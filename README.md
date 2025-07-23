# 🚗 Aluguel de Carros

Sistema completo desenvolvido com **Spring Boot** para gerenciamento de **carros e motoristas**. A aplicação conta com uma API RESTful documentada com **Swagger**, persistência em banco de dados **PostgreSQL** via Docker, e estrutura organizada em camadas (Controller, Service, Repository, DTOs e Models).

---

## 📦 Recursos da Aplicação

- Cadastro de carros com modelo, marca, cor, placa, ano, imagem e associação com motorista
- Cadastro de motoristas com nome, e-mail, CPF, data de nascimento e imagem
- Associações 1:1 entre carro e motorista (um carro só pode estar com um motorista)
- API RESTful com CRUD completo
- Documentação interativa via Swagger UI
- Interface com Docker e uso de variáveis genéricas via `.env`
- Imagem Docker pronta para uso via Docker Compose
- **Imagem publicada no Docker Hub**: [lucasaita/aluguel-de-carros](https://hub.docker.com/repository/docker/lucasaita/aluguel-de-carros/general)

---

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - spring-boot-starter-validation
- **PostgreSQL (via Docker Compose)**
- **Flyway** (migrações do banco)
- **Lombok**
- **Swagger / SpringDoc OpenAPI**
- **Docker & Docker Compose**
- **Maven**

---

## 🐘 Banco de Dados com Docker

A aplicação está configurada para utilizar um banco **PostgreSQL containerizado**, pronto para ser executado com Docker Compose.

### 🔧 Como subir o banco:

```bash
docker compose up -d
```

Certifique-se de ter um arquivo `.env` com as variáveis de conexão (não incluído no repositório por segurança):

```env
# Para a aplicação Spring Boot
DATABASE_URL=jdbc:postgresql://localhost:5432/aluguel_de_carros
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha

# Para o container PostgreSQL
POSTGRES_DB=aluguel_de_carros
POSTGRES_USER=seu_usuario
POSTGRES_PASSWORD=sua_senha
```

> 📦 A imagem do banco de dados pode ser baixada automaticamente no primeiro `up`, sem necessidade de instalar o PostgreSQL localmente.

---

## 🔌 Endpoints REST Principais

### 🔸 Carros

- `POST /carros/criar`
- `GET /carros/listar`
- `GET /carros/listar/{id}`
- `PUT /carros/editar/{id}`
- `DELETE /carros/deletar/{id}`

### 🔸 Motoristas

- `POST /motorista/criar`
- `GET /motorista/listar`
- `GET /motorista/listar/{id}`
- `PUT /motorista/editar/{id}`
- `DELETE /motorista/deletar/{id}`

---

## 🧪 JSONs de Exemplo

### 🔸 Motorista

```json
{
  "imgUrl": "https://exemplo.com/perfil.jpg",
  "nomeCompleto": "Lucas Aita",
  "cpf": "12345678901",
  "dataDeNascimento": "2001-06-09",
  "email": "lucas@email.com"
}
```
- CPF e E-mails devem ser ÚNICOS 
- Data de nascimento precisa resultar em +18 (caso contrário será lançado uma exception proibindo)

### 🔸 Carro

```json
{
  "modelo": "Civic",
  "marca": "Honda",
  "cor": "Preto",
  "placa": "ABC1D23",
  "ano": 2022,
  "imgUrl": "https://exemplo.com/civic.jpg",
  "motoristaId": 1
}
```
- A placa do carro deve ser ÚNICA para qualquer carro que for criado
- Ano só é permitido acima de 2010 (caso contrário será lançado uma exception proibindo)
---

## 🚀 Como Rodar a Aplicação

### 1. Clonar o repositório

```bash
git clone https://github.com/lucasaita1/AluguelDeCarros.git
cd AluguelDeCarros
```

### 2. Subir o banco de dados com Docker

```bash
docker compose up -d
```

### 3. Rodar a aplicação Spring Boot

```bash
./mvnw spring-boot:run
```

---

## 📄 Documentação Swagger

Após iniciar a aplicação, acesse:

📚 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📌 Melhorias Futuras

- Upload de imagem de perfil via Multipart
- Deploy em nuvem (Render, Fly.io, etc.)
- Front-end simples com Thymeleaf
- Autenticação com Spring Security e JWT
- Testes unitários com JUnit e Mockito
- Uso de mensagerias para controle de notificações/eventos (RabbitMQ, Kafka)
- Lógica de aluguel com controle de tempo, cálculo de valor e status
- Monitoramento e logging (Micrometer, Prometheus, Grafana)
- Integração com serviços AWS (como S3, RDS ou EC2)

---

## 👨‍💻 Autor

**Lucas Prates Aita**\
📧 [lucasaita4000@gmail.com](mailto\:lucasaita4000@gmail.com)\
🔗 [GitHub - lucasaita1](https://github.com/lucasaita1)

---

> ⭐ Projeto acadêmico com fins didáticos, focado em boas práticas com Java e Spring Boot.
