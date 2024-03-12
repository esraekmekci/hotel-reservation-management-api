# Hotel Reservation Management System Api

## Overview
This project is a Hotel Reservation Management System designed to facilitate the booking process for customers and manage reservations efficiently. It provides an API built with Java Spring for backend functionalities, enabling interaction with various entities such as reservations, customers, rooms, features, and services in the database.

## Getting Started
To get started with this project, follow these steps:

1. **Clone the Repository:** Clone this repository to your local machine using git clone

   `git clone https://github.com/esraekmekci/hotel-reservation-management-api.git`

2. **Database Setup:** Configure your database settings in the `application.properties` file located in the `src/main/resources` directory.

3. **Build and Run:** Use Maven or your preferred build tool to build the project. Then, run the application using the provided Spring Boot configuration.


## Features
* **Reservation Management:** Allows admin to create, update, and cancel reservations.
* **Customer Management:** Provides functionalities for managing customer information.
* **Room Management:** Enables adding, updating, and removing rooms from the system.
* **Feature Management:** Supports the addition and modification of features available in rooms.
* **Service Management:** Facilitates the management of additional services offered by the hotel.

## Technologies Used
* Java Spring Framework
* Spring Boot
* Hibernate ORM
* MySQL

## Example API Endpoints
* GET /reservations: Get all reservations.
* GET /reservations?customerId={customerId}&roomId={roomId}: Get all reservations for specific customers and rooms.
* GET /reservations/{id}: Get reservation by ID.
* POST /reservations: Create a new reservation.
* PUT /reservations/{id}: Update an existing reservation.
* DELETE /reservations/{id}: Cancel a reservation.