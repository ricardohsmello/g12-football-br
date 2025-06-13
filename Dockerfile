FROM quay.io/keycloak/keycloak:24.0.3

# Switch to optimized image
ENV KC_DB=postgres
ENV KC_DB_URL_HOST=postgres_host
ENV KC_DB_URL_DATABASE=postgres_db
ENV KC_DB_USERNAME=postgres_user
ENV KC_DB_PASSWORD=postgres_password

# Admin user 
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123

# Set workdir and start
WORKDIR /opt/keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start"]
