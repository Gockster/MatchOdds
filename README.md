HOW TO RUN

1. Clone the repository and navigate to the project directory
2. Build the application: mvn clean package
3. Start the containers: docker-compose up -d
4. The API is now running at: http://localhost:8080/api/ (exact endpoints on swagger step 7)
5. Verify everything is working: docker logs matchodds-app-1   
6. The application uses:
   Spring Boot backend
   PostgreSQL database
   Docker containerization
   Port 8080 for the web server
   Port 5432 for the database
7. Swagger: http://localhost:8080/swagger-ui/index.html
   

   

   

