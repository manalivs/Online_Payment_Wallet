# Payment Wallet Application 💸💼

### Overview

This is a **Full Stack** Development project that provides users with a intuitive interface to manage their virtual wallet. Users can create, delete, and view account details, as well as perform core functionalities like adding/withdrawing money from their bank account, and sending/receiving payments. The application ensures efficient money management for customers while maintaining a clean, user-friendly design.

### Tools & Technologies Used 🔧:
- **Languages**: 
  - Frontend: Angular ⚡ <br>
  - Backend: Java ☕ <br>
- **Frameworks**: 
  - Spring Boot 🚀 (Backend) <br>
  - Angular 🅰️ (Frontend) <br>
- **Database**: MySQL 🗄️ <br>
- **Testing**: JUnit ✅ (Unit testing for backend services)

### Architecture
This project follows a **three-tier architecture**:

- **Frontend (Presentation Layer)**: Built using **Angular**, the frontend provides a responsive user interface that interacts with backend services through API calls.
- **Backend (Business Logic Layer)**: Developed with **Java** and **Spring Boot**, the backend handles user authentication, transactions, and communication with the database.
- **Database (Data Layer)**: The **MySQL** database stores user information, transaction history, and account balances securely.

### API Endpoints 📡
- **/createAccount**: Endpoint for creating a new wallet.
- **/deleteAccount**: Endpoint to delete a user’s account.
- **/sendMoney**: For transferring funds to another user.
- **/withdrawMoney**: To withdraw money from the user’s wallet.
- **/viewAccount**: Retrieve account details and transaction history.

### Testing 🧪
Unit tests were developed for the backend using JUnit to ensure the accuracy of business logic and the robustness of the API endpoints. Each method handling the core functionalities, like transactions and account management, is tested to guarantee security and efficiency.
