# Hospital Appointment System — Backend

Java 21 / Spring Boot REST API with CRUD and an embedded H2 database (no MySQL installation required).

## Run locally

Install Java JDK 21 and Apache Maven 3.9+. Open a terminal in this backend folder and run:

```bash
mvn spring-boot:run
```

API: `http://localhost:8080/api/appointments`

Endpoints: `GET /api/appointments`, `GET /api/appointments/{id}`, `POST /api/appointments`, `PUT /api/appointments/{id}`, `DELETE /api/appointments/{id}`.

Sample POST JSON:

```json
{"patientName":"Asha","age":25,"gender":"Female","phone":"9876543210","doctorName":"Dr Rao","department":"General Medicine","appointmentDate":"2026-11-01","appointmentTime":"10:30","reason":"Routine checkup","status":"Scheduled"}
```

## Render deployment

Create a Web Service from this backend repository. Use Java runtime if available, or Docker with the included Dockerfile. For Docker: no custom build/start command needed. The app listens on the `PORT` environment variable.

**Persistence warning:** H2 stores records in a local `data/` folder. On hosts with ephemeral storage such as Render's free web service, data may disappear on restart/redeploy. For real deployment use a managed persistent database, authentication, access controls, and privacy/security review. This is a classroom demonstration, not a production medical system. Use fictional sample patient details only.
