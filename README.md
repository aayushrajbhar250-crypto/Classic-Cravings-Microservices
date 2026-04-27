# 🍔 ClassicCravings Microservices Backend

A scalable and fault-tolerant food delivery backend system built using Spring Boot and Spring Cloud microservices architecture.

---

## 🚀 Features

- 🧩 Microservices architecture (Order, Payment, Delivery, Review services)
- 🌐 API Gateway using Spring Cloud Gateway
- 🔗 Inter-service communication using Feign Client
- 🛡️ Fault tolerance using Resilience4j (Circuit Breaker, Retry, Rate Limiter)
- 📡 Event-driven architecture using Apache Kafka
- 🔍 Distributed tracing using Zipkin
- ⚙️ Centralized configuration using Spring Cloud Config Server
- 🔐 Security using OAuth2 and JWT

---

## 📚 Concepts Covered

### 🔹 Microservices Fundamentals
- Introduction to Microservices
- Microservices Architecture
- Benefits and Challenges
- Breaking monolith into microservices

---

### 🔹 Inter-Service Communication
- REST Template (Synchronous communication)
- WebClient
- Feign Client (Declarative REST client)

---

### 🔹 Service Discovery
- Eureka Server & Client
- Service registration and discovery
- Load balancing with Eureka

---

### 🔹 API Gateway
- Spring Cloud Gateway setup
- Routing and filtering
- Centralized request handling

---

### 🔹 Event-Driven Architecture
- Introduction to Event-Driven Systems
- Kafka-based communication
- Message brokers (Kafka, RabbitMQ)
- Asynchronous communication between services

---

### 🔹 Fault Tolerance (Resilience4j)
- Circuit Breaker pattern
- Retry mechanism
- Rate Limiter
- Handling service failures gracefully

---

### 🔹 Distributed Tracing & Monitoring
- Spring Boot Actuator
- Monitoring application health
- Zipkin for distributed tracing

---

### 🔹 Configuration Management
- Config Server setup
- Externalized configurations
- Managing configs across environments

---

### 🔹 Security
- OAuth2 authentication
- JWT-based authorization
- Securing microservices communication

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Gateway, Eureka, Config)
- OpenFeign
- Resilience4j
- Apache Kafka
- Zipkin
- Maven

---

## 🏗️ Architecture Overview

Client → API Gateway → Microservices  
                 ↓  
        Kafka (Event Streaming)  
                 ↓  
        Zipkin (Tracing & Monitoring)
        
        ----------
        
