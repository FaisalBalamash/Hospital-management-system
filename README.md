# Hospital Management Application

This Java Swing-based application facilitates hospital management tasks by offering dedicated screens for Customers, Delivery Men, and Admin, each tailored to specific functionalities. The application also integrates with an SQL database to store and retrieve information related to departments, employees, rooms, doctors, patients, and their interactions.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [User Roles and Features](#user-roles-and-features)
- [Contributing](#contributing)
- 
## Getting Started

To get started, follow these steps to clone the repository and compile the Java source code:

    git clone https://github.com/FaisalBalamash/hospital-management-application.git
    cd hospital-management-app
    javac Main.java
    java Main

Prerequisites

    Java Development Kit (JDK) 8 or higher.
    An integrated development environment (IDE) like Eclipse or IntelliJ IDEA is recommended for development.
    An SQL database management system (e.g., Oracle, MySQL) installed and configured.

Database Setup

To set up the SQL database, execute the following SQL commands to create tables and insert sample data:

sql

-- SQL commands to create tables and insert sample data go here
-- (Use the provided SQL script or adapt it to your database system)

User Roles and Features
Customer

    Make Order: Place new delivery orders, specifying delivery details and items.
    Change Password: Update account password for security.
    View Order: Review the status and details of previously placed orders.

Admin

    Add Delivery: Add new delivery drivers to the system.
    Add Product: Manage the product catalog by adding new items.
    View Customers: Access a list of registered customers for administrative purposes.
    View Delivery: Monitor the status and performance of delivery drivers.
    View Food: Browse and manage the food items available for delivery.

Delivery Man

    View Orders: Access a list of pending delivery orders.
    Accept Order: Accept or decline delivery orders.
    Change Password: Update account password for security.

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

    Fork the repository.
    Create a new branch for your feature or bug fix.
    Make your changes and commit them with descriptive messages.
    Push your changes to your fork.
    Create a pull request to this repository's main branch.

License
