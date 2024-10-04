
# MySQL Docker Project

This project sets up a MySQL database using Docker. It includes a customizable `Dockerfile` and an optional SQL initialization script.

## Prerequisites

Before you begin, make sure you have the following installed:

- [Docker](https://www.docker.com/get-started)

## Project Structure

```
.
├── .idea/                    # IDE configuration files
│   ├── misc.xml
│   ├── modules.xml
│   ├── vcs.xml
│   └── workspace.xml
├── lib/                      # Contains MySQL connector JAR
│   └── mysql-connector-j-9.0.0.jar
├── out/                      # Build output folder
│   └── production/
│       └── db-demo/
│           └── Main
├── sql/                      # SQL initialization scripts
│   └── init.sql
├── src/                      # Java source code
│   └── Main
├── .gitignore                # Git ignore file
├── db-demo.iml               # IDE module file
├── Dockerfile                # Docker setup for MySQL
└── README.md                 # Project documentation
```

## How to Run the Project

### Step 1: Build the Docker Image

First, you need to build the Docker image from the `Dockerfile`. Open a terminal in the project directory and run:

```bash
docker build -t my_mysql .
```

This will create a Docker image with the name `my_mysql`.

### Step 2: Run the Docker Container

After building the image, run the following command to start the MySQL container:

```bash
docker run -d -p 3306:3306 --name mysql_container my_mysql
```

This command runs the container in detached mode (`-d`) and maps the MySQL default port 3306 to your local machine.

### Step 3: Access the MySQL Server

Once the container is running, you can access the MySQL server:

- Using the MySQL command-line client:
  ```bash
  mysql -h 127.0.0.1 -P 3306 -u my_user -p
  ```

- Using a GUI tool like MySQL Workbench or DBeaver, connect with the following credentials:
  - Host: `127.0.0.1`
  - Port: `3306`
  - Username: `my_user`
  - Password: `my_password`

### Step 4: Check Initialization Script (Optional)

If you included an initialization script (`init.sql`), it will run automatically the first time the container starts. You can verify this by running:

```sql
USE my_database;
SELECT * FROM users;
```

You should see the sample data inserted by the script.

## Stopping the Container

To stop the running MySQL container, use:

```bash
docker stop mysql_container
```

## Removing the Container

To remove the container completely:

```bash
docker rm mysql_container
```

## Troubleshooting

- **Port Conflicts**: If port 3306 is already in use, you can map to a different port (e.g., 3307):
  ```bash
  docker run -d -p 3307:3306 --name mysql_container my_mysql
  ```

- **Access Denied**: Ensure that the credentials used in the `docker run` command match the environment variables defined in the `Dockerfile`.

---

Happy coding! 🎉
