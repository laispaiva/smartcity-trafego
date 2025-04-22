# SmartCity Tráfego 🚦

Aplicação Java + Spring Boot para monitoramento inteligente de tráfego urbano, com API RESTful, containerização via Docker e deploy automatizado no Azure.

---

## ✅ Pré-requisitos

Para rodar e desenvolver localmente, é necessário ter:

- Java 21
- Git
- Docker e Docker Compose
- Maven (ou use o wrapper `./mvnw` já incluído)

---

## ⚙️ Build e Execução

Clone o repositório e execute:

```sh
docker compose up --build
```

Isso irá:
- Construir o projeto com Maven (`mvn clean package`)
- Subir a aplicação + banco de dados MySQL em containers Docker

---

## 🧪 Testes unitários

Execute os testes com:

```sh
./mvnw test
```

---

## 💡 Pipeline de CI/CD

O pipeline de Integração Contínua e Entrega Contínua (CI/CD) foi configurado com **GitHub Actions**, automatizando desde o build até o deploy no Azure Web App.

### Etapas

#### ✅ Build
- **Ferramenta**: GitHub Actions  
- **Ação**: `docker/build-push-action@v3`  
- **Descrição**: O código é empacotado com Maven, construído como imagem Docker e enviado para o Docker Hub.

#### 🔐 Autenticação
- **Secrets**:
  - `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN` (Docker Hub)
  - `AZURE_CREDENTIALS`, `AZURE_PROFILE` (Azure)

#### 📦 Push da Imagem
- A imagem Docker é enviada para o Docker Hub com a tag do SHA do commit.

#### 🚀 Deploy
- **Ação**: Azure CLI  
- Atualiza automaticamente o Web App no Azure após cada `push` na branch `develop`.

---

## 📦 Estratégia de Containerização

Tecnologia: **Docker**

### Arquivos importantes
- `Dockerfile`: define o ambiente da aplicação
- `compose.yaml`: orquestra a aplicação e o banco MySQL

### Serviços
- `db`: banco de dados MySQL
- `api`: aplicação Java Spring Boot

---

## 🚀 Acesso à aplicação

### Local:
- Swagger UI: [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)
- Interfaces:
  - [`/sensor.html`](http://localhost:8080/sensor.html)
  - [`/veiculo.html`](http://localhost:8080/veiculo.html)
  - [`/registro-trafego.html`](http://localhost:8080/registro-trafego.html)
  - [`/registro-ocorrencia.html`](http://localhost:8080/registro-ocorrencia.html)

### Produção (Azure Web App):
- [`https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net)
  - [`/swagger-ui/index.html`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net/swagger-ui/index.html)
  - [`/sensor.html`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net/swagger-ui/sensor.html)
  - [`/veiculo.html`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net/swagger-ui/veiculo.html)
  - [`/registro-trafego.html`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net/swagger-ui/registro-trafego.html)
  - [`/registro-ocorrencia.html`](https://smartcity-trafego-a3bua2aue5hnbzfd.eastus2-01.azurewebsites.net/swagger-ui/registro-ocorrencia.html)

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2
- Docker + Docker Compose
- GitHub Actions
- Azure Web App (Linux + Docker)
- Bootstrap 5.3
- Swagger UI
- MySQL 8.x

---

Desenvolvido por: **Lais Paiva**  
[GitHub](https://github.com/laispaiva)
