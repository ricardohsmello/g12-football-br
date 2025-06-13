FROM quay.io/keycloak/keycloak:latest

# Set environment variables for build
ENV KC_DB=postgres
ENV KC_HTTP_ENABLED=true
ENV KC_HOSTNAME_STRICT=false
ENV KC_HOSTNAME_STRICT_HTTPS=false


# Build Keycloak for optimization
RUN /opt/keycloak/bin/kc.sh build

# Expose the port
EXPOSE 8080

# Start Keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start", "--optimized"]