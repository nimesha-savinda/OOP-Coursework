
# Ticket management - Backend

This repository contains the backend service for the Ticketing System, built with Spring Boot. The backend provides a RESTful API for managing tickets, users, and other related data. It serves as the core of the system, ensuring secure, efficient, and scalable operations


## Features

- **RESTful API:** Provides endpoints for CRUD operations on tickets, users, and other resources.
- **Database Integration:** Seamless connection with NoSQL databases.
- **Error handling:** Comprehensive exception management for user-friendly error responses.
- **CLI panel:** a CLI panel to interact with backend even without the front end


## Tech Stack

**Framework:** SpringBoot 3.3.5

**Database:** MongoDB Atlas

**Build Tool:** Maven


## API Reference

#### Create a New Configuration File

```http
  POST /api/config/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Total_number_of_tickets` | `integer` | **Required.** Total number of tickets |
| `Ticket_release_rate` | `integer` | **Required**. Ticket release rate |
| `Retrieval_rate` | `integer` | **Required**. Ticket retrival rate |
| `Maximum_Capacity` | `integer` | **Required**. Maximum capacity of tickets |

#### Get Latest Configuration

```http
  GET /api/config/getLatest
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `None`      | `N/A` | Fetches the most recent configuration entry |

#### Create a New Customer

```http
  POST /api/customer/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Required.** Username for the customer |
| `password` | `string` | **Required**. Password of the customer |


#### Check Customer Details

```http
  GET /api/customer/login/check/${username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. username of customer to fetch |

#### Buy Tickets
  
```http
  PUT /api/customer/${id}/remove-tickets
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. id of customer|
| `ticket_count`      | `integer` | **Required**. ticket amount to buy|


#### Create a New Vendor

```http
  POST /api/vendor/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Required.** Username for the vendor |
| `password` | `string` | **Required**. Password of the vendor |

#### Check Vendor Details

```http
  GET /api/vendor/login/check/${username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. username of vednor to fetch |

#### Add Tickets
  
```http
  PUT /api/vednor/${id}/add-tickets
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. id of vednor|
| `ticket_count`      | `integer` | **Required**. ticket amount to add|

## Run Locally

Clone the project

```bash
  git clone https://github.com/nimesha-savinda/OOP-Coursework.git
```

Go to the project directory

```bash
  cd Backend
```

Build the project

```bash
  mvn clean install
```

The application will be available at

```bash
  http://localhost:8080.
```


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nimesha-dahanayaka-104649265/)


