<br>
<div align="center">
  <img src="https://watchmoviesreview.wordpress.com/wp-content/uploads/2020/01/february2020_wide_releases.jpg" alt="Image Description">
</div>

# Movie Management Systtem

In this project, we have built a movie management system focusing on three main actors: admin, staff and customers. This system was built using Java Swing, MicrosoftSQl server, and different dependencies, techniques with real time managing booking movie ticket to prevent booking overlapped. The key features in the system will be presented for the upcoming sessions

## Table of Contents

- [1. Introduction](#introduction)
- [2. Features](#features)
- [3. Set up](#setup)
- [4. Technical Details](#technicaldetails)
- [5. Contributors](#contributors)
- [6. Contribution](#contribution)


## Introduction
This Movie Management System was built for three 

## Features
### 1. Customers

Account Management: Register, log in, and log out.
Movie Browsing: View detailed movie information (trailers, genres, duration, etc.).
Ticket Booking: Book tickets by selecting a movie, schedule, and seat.
Booking History: View past bookings and details.
Notifications: Receive updates about bookings, cancellations, and promotions.
Secure Payments: Support for multiple payment methods.\
### 2. Admins

Movie Management: Add, update, and delete movie details.
Schedule Management: Create, update, and delete showtimes.
Revenue Management: View transaction history and generate financial reports.
Ticket Pricing: Set and update ticket prices.
Notification System: Send updates to users about bookings, payments, and promotions.
Cancellation Requests: Approve or disapprove refund requests.
### 3. Staff

Customer Support: Assist customers with queries and ticket booking issues.
Booking Management: Confirm, verify, and manage ticket bookings.
Schedule Monitoring: Access information about movie schedules and showtimes.
System Features

Real-Time Seat Availability: Display available seats for each schedule.
Reporting Tools: Generate detailed revenue reports.
Notifications: Automated notifications for booking confirmations, cancellations, and transactions.
## Set up

You will first run all the SQL statements within the SetUpSQL folder to build your database. Then, within the Database.java file of 'database' package, replace your user name, password and database name as you have set up on MicrosoftSQL Server. Finally, you just need to run the MainView in the app

## Technical Details

### 1.Development Environment

Programming Language: Java
Database: SQL Server (connected via JDBC)
IDE: NetBeans & IntelliJ IDEA Ultimate
UI Framework: Java Swing
### 2.System Architecture

Object-Oriented Design: Implements principles like encapsulation, inheritance, and polymorphism. Besides, we mainly use Pattern MVC to separate UI logic and Backend logic which enables better code debugging and maintaining!
Use Case Diagram: Visualizes system interactions for actors (Admins, Customers, Staff).
ER Diagram: Defines database relationships for movies, schedules, tickets, and users.


## Contributors

Special thanks to the following contributors for their valuable contributions to this project:

- [Hoang Mai Duc Kien](https://github.com/ndrhmdk)
- [Tran Bao Nhi](https://github.com/nhi220915)



## Contribution
- This project can be enhanced by adding features such as promotion for customer, handling delay during UI loading or allowing staff to view their selling ticket history. Your creativity and contribution would be valuable to our project!!!



