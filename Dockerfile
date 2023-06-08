FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# Construir imagen docker y subir al Hub
# docker build -t faunavalapi:1.0 .
# docker tag app carolatn/faunavalapi:1.0
# docker push carolatn/faunavalapi:1.0

# Cambiar plataforma
# docker buildx create --name elbuilder
# docker buildx use elbuilder
# docker buildx inspect --bootstrap
# docker buildx build --push --tag carolatn/faunavalapi:1.1 -o type=image --platform=linux/arm64,linux/amd64/v3 .

# Conectar con instancia EC2
# ssh -i "ssh-key/faunaval-api.pem" ubuntu@ec2-3-95-21-11.compute-1.amazonaws.com

# Descargar y actualizar contenedor en servidor
# docker run -p 8080 --name springapp -d -t faunavalapi:1.0

# https://desarrolloweb.com/faq/solucionar-problema-the-requested-images-platform-does-not-match-en-docker
