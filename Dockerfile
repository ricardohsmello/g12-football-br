FROM quay.io/keycloak/keycloak:24.0.3

ENV KC_DB=postgres
ENV KC_DB_URL_HOST=seu-db-host
ENV KC_DB_URL_DATABASE=seu-db-name
ENV KC_DB_USERNAME=seu-usuario
ENV KC_DB_PASSWORD=sua-senha

ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123

WORKDIR /opt/keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=8080", "--http-host=0.0.0.0", "--hostname-strict=false"]