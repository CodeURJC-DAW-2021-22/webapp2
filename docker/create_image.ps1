#Creamos la imagen a partir del fichero Dockerfile
docker build -t njhvfm014 .

#Pusheamos la imagen creada a la cuenta de dockerHub
docker push njhvfm014
