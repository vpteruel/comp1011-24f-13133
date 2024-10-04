# Use the official MySQL image as a base
FROM mysql:8.0

# Set environment variables (you can customize these)
ENV MYSQL_ROOT_PASSWORD=123
ENV MYSQL_DATABASE=my_database
ENV MYSQL_USER=my_user
ENV MYSQL_PASSWORD=123

# Add custom configuration files (optional)
# COPY ./my.cnf /etc/mysql/my.cnf

# Copy initialization scripts to the container (optional)
# These SQL scripts will be executed when the container is started.
COPY ./sql/init.sql /docker-entrypoint-initdb.d/

# Expose the MySQL port
EXPOSE 3306

# Define a volume to persist data
VOLUME ["/var/lib/mysql"]

# Set the command to run MySQL server
CMD ["mysqld"]
