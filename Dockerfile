FROM quay.io/keycloak/keycloak:24.0.3

# Copia todos os arquivos do Keycloak gerados pelo builder
COPY --from=builder /opt/keycloak/lib/ /opt/keycloak/lib/
COPY --from=builder /opt/keycloak/providers/ /opt/keycloak/providers/
COPY --from=builder /opt/keycloak/conf/ /opt/keycloak/conf/
COPY --from=builder /opt/keycloak/themes/ /opt/keycloak/themes/
COPY --from=builder /opt/keycloak/lib/main/ /opt/keycloak/lib/main/
COPY --from=builder /opt/keycloak/boot/ /opt/keycloak/boot/
COPY --from=builder /opt/keycloak/bin/ /opt/keycloak/bin/

# Admin e banco
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123

ENV KC_DB=postgres
ENV KC_DB_URL_HOST=RENDER_DB_HOST
ENV KC_DB_URL_DATABASE=RENDER_DB_NAME
ENV KC_DB_USERNAME=RENDER_DB_USER
ENV KC_DB_PASSWORD=RENDER_DB_PASSWORD

# Keystore e HTTPS
ENV KC_HTTPS_KEY_STORE_FILE=conf/server.keystore
ENV KC_HTTPS_KEY_STORE_PASSWORD=password

# Inicializa
CMD ["start", "--optimized", "--hostname-strict=false", "--http-port=8080", "--http-host=0.0.0.0"]