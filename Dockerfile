# Etapa 1: builder com build otimizado
FROM quay.io/keycloak/keycloak:24.0.3 as builder

ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

# Banco de dados
ENV KC_DB=postgres

RUN keytool -genkeypair \
    -storepass password \
    -storetype PKCS12 \
    -keyalg RSA \
    -keysize 2048 \
    -dname "CN=localhost" \
    -alias server \
    -ext "SAN:c=DNS:localhost,IP:127.0.0.1" \
    -keystore /opt/keycloak/conf/server.keystore

# Build otimizado
RUN /opt/keycloak/bin/kc.sh build

# Etapa 2: imagem final leve com Keycloak pronto
FROM quay.io/keycloak/keycloak:24.0.3

# Copia os arquivos buildados do builder
COPY --from=builder /opt/keycloak /opt/keycloak

# Copia o keystore criado no builder para o lugar certo
COPY --from=builder /opt/keycloak/conf/server.keystore /opt/keycloak/conf/server.keystore

# Configuração de ambiente
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123

ENV KC_DB=postgres
ENV KC_DB_URL_HOST=RENDER_DB_HOST
ENV KC_DB_URL_DATABASE=RENDER_DB_NAME
ENV KC_DB_USERNAME=RENDER_DB_USER
ENV KC_DB_PASSWORD=RENDER_DB_PASSWORD

ENV KC_HTTPS_KEY_STORE_FILE=conf/server.keystore
ENV KC_HTTPS_KEY_STORE_PASSWORD=password

CMD ["start", "--optimized", "--hostname-strict=false", "--http-port=8080", "--http-host=0.0.0.0"]
