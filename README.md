# g12-football-br
A full-stack application for managing football betting pools, featuring an Angular frontend and a Java Spring Boot backend. Authentication is handled via Keycloak.

# Features
- User registration and authentication
- Bet placement and management
- Real-time score updates
- Leaderboard and rankings
- Admin panel for managing users and bets

# Technologies Used
- Frontend: Angular
- Backend: Java Spring Boot
- Database: MongoDB
- Authentication: Keycloak

# Getting Started
## Keycloak Setup
1. Start Keycloak using Docker Compose:

````
docker-compose up -d keycloak
````

2. Access the Keycloak admin console at http://localhost:8081/
3. Create a new realm for the application.
   - name: g12
4. Create a new client with the following settings:
   - Client ID: frontend
   - Root URL: http://localhost:4200/
   - Valid Redirect URIs: http://localhost:4200/*

5. Create user roles and assign them to users as needed.

## Backend Setup
Navigate to the backend directory:

````
mvn clean install
````
Then navigate to infrastructure directory:

````
export MONGODB_URI="<YOUR_CONNECTION_STRING>"
mvn spring-boot:run
````

## Frontend Setup
Navigate to the frontend directory:

````
npm install
npm start
````

