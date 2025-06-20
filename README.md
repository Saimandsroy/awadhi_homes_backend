# Spring Boot Image Backend

This project is a Spring Boot application that supports image upload and analysis, integrated with MongoDB. It provides a well-structured REST API for handling image-related operations.

## Features

- Upload images with metadata (title, description, analysis type).
- Retrieve all uploaded images or a specific image by ID.
- Delete images from the database.
- MongoDB integration for storing image data.

## Project Structure

```
springboot-image-backend
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── imagebackend
│   │   │               ├── ImageBackendApplication.java
│   │   │               ├── controller
│   │   │               │   └── ImageController.java
│   │   │               ├── service
│   │   │               │   └── ImageService.java
│   │   │               ├── repository
│   │   │               │   └── ImageRepository.java
│   │   │               └── model
│   │   │                   └── Image.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── imagebackend
│                       └── ImageBackendApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd springboot-image-backend
   ```

2. **Configure MongoDB:**
   Update the `application.properties` file with your MongoDB connection URI.

3. **Build the project:**
   ```
   mvn clean install
   ```

4. **Run the application:**
   ```
   mvn spring-boot:run
   ```

## API Usage

### Upload Image

- **Endpoint:** `POST /api/images/upload`
- **Parameters:**
  - `file`: The image file to upload.
  - `title`: Title of the image.
  - `description`: Description of the image (optional).
  - `analysisType`: Type of analysis to perform on the image.

### Get All Images

- **Endpoint:** `GET /api/images`
- **Response:** List of all uploaded images.

### Get Image by ID

- **Endpoint:** `GET /api/images/{id}`
- **Response:** Details of the image with the specified ID.

### Delete Image

- **Endpoint:** `DELETE /api/images/{id}`
- **Response:** Confirmation of deletion.

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data MongoDB
- Spring Boot Starter Validation
- Springfox Swagger for API documentation
- SLF4J for logging

## License

This project is licensed under the MIT License.#   a w a d h i _ h o m e s _ b a c k e n d  
 