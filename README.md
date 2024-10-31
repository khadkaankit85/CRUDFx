# JavaFX CRUD Application

## Overview

This is a JavaFX application that provides a simple CRUD (Create, Read, Update, Delete) interface to interact with a MySQL database. The application allows users to manage records through a user-friendly interface built with JavaFX, implementing the Model-View-Controller (MVC) design pattern for better code organization.

## Features
- User-friendly GUI for managing records.
- Implemented CRUD operations for easy data manipulation.
- User authentication using usernames and passwords stored in the MySQL database.
- Utilizes the Data Access Object (DAO) pattern for efficient data management.

## Technologies Used

- Java
- JavaFX
- CSS for styling
- FXML for layout
- MySQL database
- DAO pattern for data handling
- Maven for project management

## Installation

1. Clone the repository:
   ```bash
   git clone "https://github.com/khadkaankit85/CRUDFx.git"
   ```
2. Navigate to the project directory:
   ```bash
   cd CRUDFx
   ```
3. Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
4. Ensure you have JDK 21 and MySQL installed.
5. Run the application:
   ```bash
   mvn javafx:run
   ```

## Screenshots

1. **Login Page**  
   ![Login Page](https://github.com/khadkaankit85/Assets/blob/master/CrudFX/1.png?raw=true)

2. **Logged In Page**  
   ![Main Page](https://github.com/khadkaankit85/Assets/blob/master/CrudFX/3.png?raw=true)

3. **Main Page**  
   ![Delete Page](https://github.com/khadkaankit85/Assets/blob/master/CrudFX/2.png?raw=true)

## Usage

- Launch the application.
- Use the **Login Page** to authenticate with your credentials.
- Navigate through the application to perform CRUD operations on records.
- The **Delete Page** allows you to remove records from the database.

## Learning Outcomes
- Implementing CRUD operations using JavaFX and MySQL.
- Utilizing the DAO pattern for structured data management.
- Applying the MVC architecture for cleaner and maintainable code.