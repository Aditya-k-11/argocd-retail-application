# Retail Store Sample App - Project Reference Documentation

This document serves as a comprehensive reference of the current state of the `retail-store-sample-app` repository. It is intended to be provided as context to AI coding assistants to understand the architecture, tech stack, and current missing components.

## 1. Overview
The **Retail Store Sample App** is a microservices-based application demonstrating a typical e-commerce platform. It includes a product catalog, shopping cart, checkout orchestration, and order management, exposed via a unified frontend UI. 

Originally, the application was designed to be deployed using GitOps practices on Amazon EKS, but the infrastructure configurations have been stripped down in the current workspace.

## 2. Microservices Architecture
The application consists of 5 main microservices, each located in the `src/` directory.

| Component | Directory | Language/Framework | Dependency Manager | Description |
|---|---|---|---|---|
| **UI** | `src/ui/` | Java (Spring Boot) | Maven (`pom.xml`) | The frontend web interface for the store. |
| **Catalog** | `src/catalog/` | Go | Go Modules (`go.mod`) | Provides the product catalog API. |
| **Cart** | `src/cart/` | Java (Spring Boot) | Maven (`pom.xml`) | Manages the user's shopping cart. |
| **Orders** | `src/orders/` | Java (Spring Boot) | Maven (`pom.xml`) | Handles user order creation and history. |
| **Checkout** | `src/checkout/` | Node.js (NestJS) | Yarn (`package.json`) | Orchestrates the checkout process across services. |

## 3. Project Structure
The current workspace has the following top-level structure:
```text
retail-store-sample-app/
├── docs/                 # Documentation assets (images)
├── src/                  # Source code for all microservices
│   ├── app/              # (Shared/Common code, if any)
│   ├── cart/             # Cart Service
│   ├── catalog/          # Catalog Service
│   ├── checkout/         # Checkout Service
│   ├── orders/           # Orders Service
│   └── ui/               # UI Service
├── .gitignore
├── BRANCHING_STRATEGY.md # Original GitOps branching strategy doc
├── LICENSE
└── README.md             # Original project README
```

## 4. Current State & Missing Components
The current repository only contains the **source code** for the application. To run or deploy this application, several components need to be re-created.

**The following crucial operational files are currently missing from the repository:**

1. **Dockerfiles**: None of the microservices currently have a `Dockerfile` to build their container images.
2. **Kubernetes Manifests / Helm Charts**: The original `chart/` directories inside each service are removed.
3. **CI/CD Pipelines**: The `.github/workflows/` folder for automated builds and deployments is removed.
4. *(Note: AWS-specific infrastructure like `terraform/` configurations were also removed, but are intentionally excluded from this scope).*

## 5. Next Steps for AI Assistant
If you are an AI assistant analyzing this project, your primary next tasks will likely involve:
- Creating multi-stage `Dockerfile`s for each service based on their respective technology stacks (Java, Go, Node.js).
- Generating standard Kubernetes manifests (Deployments, Services, Ingresses) to deploy these containers locally or to a cluster.
- Re-establishing local development orchestration (e.g., `docker-compose.yml`) for testing all services together.
