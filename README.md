# 📊 Sales Dashboard using Spring Boot

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)

A **Sales Dashboard** web application built using **Spring Boot (Java)** for the backend and **HTML, CSS, JavaScript** for the frontend. This dashboard displays visualized sales metrics and customer data.

---

## 🚀 Features

- 📈 Interactive Sales Charts
- 📊 Daily and Monthly Sales Summary
- 👨‍💼 Customer & Product Overview
- 🔄 REST API Integration
- 💾 MySQL Database Support
- 💡 Responsive Design

---

## 🖼️ Project Output

> 📸 Here’s what the final dashboard looks like:

<p align="center">
  <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Sales%20Dashboard%20Output.png" alt="Dashboard Output" width="700"/>
</p>

---

## ⚙️ Tech Stack

**Frontend:**
- HTML5, CSS3, JavaScript

**Backend:**
- Java
- Spring Boot
- RESTful APIs

**Database:**
- MySQL  
  > 🔧 **Note:** You must configure your own MySQL database in `application.properties`.

**Build Tool:**
- Maven

---

## 🛠️ How to Run This Project

### 1. Clone the Repository

```bash
git clone https://github.com/Kashyap888/Sales-Dashboard-using-SpringBoot.git
cd Sales-Dashboard-using-SpringBoot
```
2. Setup MySQL Database
Create a database named sales_dashboard (or any name of your choice)

Edit the following file:

```css
backend/src/main/resources/application.properties
```
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sales_dashboard
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```
3. Run Backend with Spring Boot
On Linux/macOS:

```bash
cd backend
./mvnw spring-boot:run
```
On Windows:

```bash
cd backend
mvnw.cmd spring-boot:run
```
📌 Future Improvements
- Add login & authentication

- Export reports as PDF/Excel

- Real-time chart updates

- Deploy frontend/backend to cloud

## 🙋‍♂️ Author

**Kashyap K R**  
📍 [GitHub](https://github.com/Kashyap888)  
🔗 [LinkedIn](https://linkedin.com/in/kashyap-k-r-b6b764266)
