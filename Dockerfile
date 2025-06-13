# Use the official Keycloak image
FROM quay.io/keycloak/keycloak:latest

# Set environment variables for build
ENV KC_DB=postgres
ENV KC_HTTP_ENABLED=true
ENV KC_PROXY=edge

# Build Keycloak for optimization
RUN /opt/keycloak/bin/kc.sh build

# Expose the port
EXPOSE 8080

# Start Keycloak
CMD ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]