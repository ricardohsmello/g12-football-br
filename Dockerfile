# Use the official Keycloak image
FROM quay.io/keycloak/keycloak:latest

USER root

RUN cat > /opt/keycloak/start.sh << 'EOF'
#!/bin/bash


# Make the startup script executable
RUN chmod +x /opt/keycloak/start.sh

# Switch back to keycloak user for security
USER keycloak

# Set the working directory
WORKDIR /opt/keycloak

# Expose the port that Keycloak will run on
EXPOSE 8080

# Health check to ensure Keycloak is running properly
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/health/ready || exit 1

# Use the startup script as the entry point
ENTRYPOINT ["/opt/keycloak/start.sh"]

ENV KC_DB=postgres
ENV KC_DB_URL=<DBURL>
ENV KC_DB_USERNAME=<DBUSERNAME>
ENV KC_DB_PASSWORD=<DBPASSWORD>
ENV KC_HOSTNAME=localhost
 

