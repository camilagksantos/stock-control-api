# 🔧 Stock Control API

REST API for a complete stock control system, built with Spring Boot 3.

## 🚀 Technologies

- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- H2 Database (development)
- Maven
- Lombok

## 📋 Prerequisites

- JDK 17 or higher
- Maven 3.8+
- Docker (optional)

## 🏃 Running the application

### Local
```bash
# Clone the repository
git clone https://github.com/seu-usuario/stock-control-api.git
cd stock-control-api

# Run with Maven
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

### With Docker
```bash
# Build the image
docker build -t stock-control-api .

# Run the container
docker run -p 8080:8080 stock-control-api
```

## 📡 API Endpoints

### Products
- `GET /api/products` - List all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Stock
- `GET /api/stock` - List stock items
- `POST /api/stock/entry` - Register stock entry
- `POST /api/stock/exit` - Register stock exit

## 📚 Documentation

After running the application, access the Swagger documentation at:
`http://localhost:8080/swagger-ui.html`

## 🧪 Tests
```bash
# Run all tests
./mvnw test

# Run with coverage
./mvnw test jacoco:report
```

## 🔗 Frontend

This API is consumed by the [Stock Control Frontend](https://github.com/seu-usuario/stock-control) built with Angular 15.

## 📝 License

This project is under MIT license.