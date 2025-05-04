# VetCareBE

VetCareBE is the backend service for the VetCare veterinary management system. It is built using Java and Spring Boot, providing a RESTful API to support the VetCareUI frontend. The service handles CRUD operations for entities such as customers, doctors, pets, appointments, and vaccines.

## 🚀 Features

* RESTful API for managing veterinary clinic data
* Entities include Customer, Doctor, Animal, Appointment, and Vaccine
* Cross-Origin Resource Sharing (CORS) enabled for frontend integration
* Deployed on [Render](https://render.com)

## 🛠 Tech Stack

* Java 17+
* Spring Boot
* Maven
* Spring Data JPA
* PostgreSQL (via cloud or local DB)

## 📂 Project Structure

```
VetCareBE/
├── src/
│   ├── main/
│   │   ├── java/com/vetcare/...       # Controllers, services, models, repos
│   │   └── resources/
│   │       └── application.properties
├── pom.xml                           # Project dependencies
```

## ⚙️ Configuration

Edit `src/main/resources/application.properties` to configure the database and port.

Example for local development:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vetcare
spring.datasource.username=your_db_user
spring.datasource.password=your_db_pass
server.port=8080
```

## 🧪 Running Locally

### Prerequisites:

* Java 17+
* Maven
* PostgreSQL running locally

### Steps:

```bash
git clone https://github.com/ayseerarslan/VetCareBE.git
cd VetCareBE
mvn clean install
mvn spring-boot:run
```

Backend will run at `http://localhost:8080`.

## 🌐 Deployment

VetCareBE is deployed on [Render](https://vetcarebe.onrender.com) and exposed publicly for use with VetCareUI.

---

## 📫 API Access

The API base URL is:

```
https://vetcarebe.onrender.com
```

All endpoints follow the REST naming pattern. Example:

```
GET /v1/customers/all
POST /v1/appointments/save
DELETE /v1/vaccines/delete/{id}
```

For full API details, please refer to the controller classes under `src/main/java/com/vetcare/controller/`.

