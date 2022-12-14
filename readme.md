# TEKO Kotlin VueJS Finance Tool ðª

## Description ðï¸

This Project provides a neat little financial software, where you can input your incomes and expenses.  
The whole Project is an assignment by Gregor von FlÃ¼e under TEKO Olten for the school subject OOP.

## Tech-Stack âï¸

- [JAVA 18](https://openjdk.org/projects/jdk/18/)
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [Vue 3](https://vuejs.org/)
- [tailwindcss](https://tailwindcss.com/)
- [daisyui](https://daisyui.com/)
- [Vite (as bundler)](https://vitejs.dev/)
- [Gradle Build Tool](https://gradle.org/)
- [Docker](https://docker.com)

## Roadmap ðºï¸

- [x] Create Class-Diagram and Database Schema
- [x] Spring Boot Backend
- [x] Install Database
- [x] Create REST-Endpoints
- [x] Write some tests
- [x] Install VueJS
- [x] Install tailwindcss & daisyui
- [x] Build Frontend
- [x] Consume API
- [x] Gradle Build with Node Integration
- [x] Create Docker Image
- [x] Migrate to TypeScript
- [ ] Get a good grade!

## Database Diagram

![DatabaseDiagram](/.github/images/DatabaseDiagram.png)

## Backend Class Diagram

![BackendClassDiagram](/.github/images/BackendClassDiagram.png)

## Frontend Class Diagram

![FrontendClassDiagram](/.github/images/FrontendClassDiagram.png)

## Installation and Start ð

Make sure you have installed docker and the docker-compose plugin on your machine

Clone the public repository to your local machine

```sh
git clone https://github.com/ThopQ/TEKO_OOP_Project.git
```

Copy the .env example and fill in your desired config

```sh
cp .env.example .env
```

Run Docker Compose to start the application

```sh
docker-compose up -d
```

After the container has been started, you can visit the project on _http://localhost_

## Tips for Docker and Development ð¡

1. If you want to develop on your local machine, make sure you have installed **nodejs** (and obviously JDK).
2. If you build the application **without Docker**, you have to set the database connection **manually** (default is per .env file)... But consider using Docker like any other decent human being you hereticð.
3. The Docker-Volume **kotlin-vue-finance_h2db-data** will keep your database persistent, as long as you use the same username and password inside the .env file.
4. Else the Database will be stored under ~/kotlin-vue-finance/db.mv.db (The user home folder).

## Contact ð§ð½

> ### GitHub
>
> Thomas Iseli - [@ThopQ](https://github.com/ThopQ)
>
> Martin Bock - [@bocknm](https://github.com/bocknm)
>
> Dario Eng - [@darioeng](https://github.com/darioeng)

Project-Link: [https://github.com/ThopQ/TEKO_OOP_Project](https://github.com/ThopQ/TEKO_OOP_Project)
