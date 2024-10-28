Here's the complete README you can copy and paste into your project:

```markdown
# Hotelz Reservation System

## Overview
Hotelz is a comprehensive hotel reservation system designed to streamline the booking process for users while providing robust functionalities for hotel management. This application allows users to check room availability, make reservations, and receive notifications via email, all while ensuring secure access through token-based authentication.

## Features
- **User Authentication**: Secure login and validation using token-based authentication.
- **Room Availability Check**: Users can check the availability of rooms for selected dates.
- **Reservation Management**: Users can create reservations and receive email notifications.
- **Error Handling**: The system provides appropriate feedback for unsuccessful reservation attempts, such as room unavailability or authentication errors.

## Technologies Used
- Java
- Spring Boot
- Jakarta EE
- JWT
- OpenFeign
- RESTful API
- MySQL/PostgreSQL (for database)
- HTML/CSS/JavaScript (for frontend)

## Installation
1. Clone the repository:
   ```bash
   git clone  https://github.com/AnderDEVTrying/Booking-Service.git
   ```
2. Navigate to the project directory:
   ```bash
   cd hotelz
   ```
3. Set up your database (MySQL/PostgreSQL) and update the application properties with your database credentials.
4. Build the project:
   ```bash
   ./mvnw clean install
   ```
5. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Usage
- Access the API at `http://localhost:8081/hotelz`.
- Use tools like Postman or CURL to interact with the endpoints:
  - **POST /reservation**: Create a new reservation by providing reservation details in JSON format.

## Contribution
Contributions are welcome! Please open an issue or submit a pull request for any features or improvements.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For inquiries, please reach out to azango94@gmail.com 
```
