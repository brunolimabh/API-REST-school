# API REST School


A API REST School é um projeto desenvolvido como parte de uma atividade proposta pela instituição de ensino SPTech, visando praticar relacionamento bidirecional e introdução a nested class .

## 📃 Dependências: 
- **Spring Web:** https://mvnrepository.com/artifact/org.springframework/spring-web
- **Spring Data JPA:** https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
- **H2 Database:** https://mvnrepository.com/artifact/com.h2database/h2
- **Validation:** https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api
- **Lombok:** https://mvnrepository.com/artifact/org.projectlombok/lombok
<br></br>

## 📃 Valores inseridos p/ testes: 
**Pasta:** src/main/resources/data.sql
```sql
INSERT INTO Teacher
    (name)
VALUES
    ('Jonas'),
    ('Josias'),
    ('Luzia');

INSERT INTO Student
    (name, ra, teacher_id)
VALUES
    ('Bruno', '123', 1),
    ('Paulo', '321', 1),
    ('Caio', '456', 2),
    ('João', '564', 3);
```

## 📃 Postman collection: 
- **Link** https://github.com/brunolimabh/API-REST-school/blob/main/API%20REST%20school.postman_collection.json

#### 🟨 Endpoint para criar professor
- **Método HTTP:** POST
- **URL:** `http://localhost:8080/teachers`

#### Body da Requisição (JSON):
```json
{
    "name": "Carlos"
}
```

#### 🟩 Endpoint para listas todos os professores
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/teachers`

#### 🟩 Endpoint para listar um professor pelo id
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/teachers/{id}`

#### 🟥 Endpoint para remover um professor pelo id
- **Método HTTP:** DELETE
- **URL:** `http://localhost:8080/teachers/{id}`

- #### 🟨 Endpoint para criar aluno
- **Método HTTP:** POST
- **URL:** `http://localhost:8080/students`

#### Body da Requisição (JSON):
```json
{
    "name": "Lucas",
    "ra": "987",
    "professorId": 4
}
```

#### 🟩 Endpoint para listas todos os alunos
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/students`

#### 🟩 Endpoint para listar um aluno pelo id
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/students/{id}`

#### 🟥 Endpoint para remover um aluno pelo id
- **Método HTTP:** DELETE
- **URL:** `http://localhost:8080/students/{id}`

Todos esses endpoints estão dentro do arquivo PostmanCollection.json


