# Etapa 1: build da aplicação Angular
FROM node:18 AS builder

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build --configuration production

# Etapa 2: Nginx para servir os arquivos estáticos
FROM nginx:alpine

# Remove os arquivos padrão do nginx
RUN rm -rf /usr/share/nginx/html/*

# Copia os arquivos gerados pelo Angular diretamente
COPY --from=builder /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]