# Etapa 1: build da aplicação Angular
FROM node:18 AS builder

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build -- --configuration production --project=g12-football-bet

# Etapa 2: Nginx para servir os arquivos estáticos
FROM nginx:alpine

# Remove os arquivos padrão do nginx
RUN rm -rf /usr/share/nginx/html/*

# Copia os arquivos gerados pelo Angular diretamente
COPY --from=builder /app/dist /usr/share/nginx/html
COPY /nginx.conf  /etc/nginx/conf.d/default.conf
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

### STAGE 1:BUILD ###

# FROM node:18 AS builder
# # Create a Virtual directory inside the docker image
# WORKDIR /dist/src/app
# # Copy files to virtual directory
# # COPY package.json package-lock.json ./
# # Run command in Virtual directory
# RUN npm cache clean --force
# # Copy files from local machine to virtual directory in docker image
# COPY . .
# RUN npm install
# RUN npm run build -- --configuration production --project=g12-football-bet


# ### STAGE 2:RUN ###
# # Defining nginx image to be used
# FROM nginx:latest AS ngi
# # Copying compiled code and nginx config to different folder
# # NOTE: This path may change according to your project's output folder 
# COPY --from=build /dist/src/app/dist/g12-football-bet /usr/share/nginx/html
# COPY /nginx.conf  /etc/nginx/conf.d/default.conf
# # Exposing a port, here it means that inside the container 
# # the app will be using Port 80 while running
# EXPOSE 80