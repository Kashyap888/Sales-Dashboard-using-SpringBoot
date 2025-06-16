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

## 🖼️ Project Screenshots

<table>
  <tr>
    <td align="center">
      <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Screenshoot/Login.png" alt="Login Page" width="350"/><br>
      <strong>Login Page</strong>
    </td>
    <td align="center">
      <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Screenshoot/sales%20overview%202.png" alt="Sales Overview" width="350"/><br>
      <strong>Sales Overview</strong>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Screenshoot/branch.png" alt="Branch View" width="350"/><br>
      <strong>Branch View</strong>
    </td>
    <td align="center">
      <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Screenshoot/data.png" alt="Data Table" width="350"/><br>
      <strong>Data Table</strong>
    </td>
  </tr>
  <tr>
    <td align="center" colspan="2">
      <img src="https://raw.githubusercontent.com/Kashyap888/Sales-Dashboard-using-SpringBoot/main/Screenshoot/Sales%20overview.png" alt="Total Sales Overview" width="700"/><br>
      <strong>Total Sales Overview</strong>
    </td>
  </tr>
</table>

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
