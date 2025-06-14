FROM quay.io/keycloak/keycloak:latest

# Set environment variables for build

ENV KC_HTTP_ENABLED=true
ENV KC_HOSTNAME_STRICT=false
ENV KC_HOSTNAME_STRICT_HTTPS=false
ENV KC_PROXY=edge
ENV KC_SPI_COOKIE_SAMESITE=None

ENV KC_DB=postgres
ENV KC_DB_PASSWORD=
ENV KC_DB_URL_DATABASE=
ENV KC_DB_URL_HOST=
ENV KC_DB_USERNAME=
ENV KC_HOSTNAME=
ENV KEYCLOAK_ADMIN_PASSWORD=
ENV KEYCLOAK_ADMIN=
ENV KC_HTTP_HOST=0.0.0.0

# Build Keycloak for optimization
RUN /opt/keycloak/bin/kc.sh build --db=postgres

# Expose the port
EXPOSE 8080

# Start Keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start", "--optimized", "--http-host=0.0.0.0", "--hostname-strict=false"]