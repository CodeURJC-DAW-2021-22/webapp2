#Creamos la imagen a partir del fichero Dockerfile
docker build -t njhvfm014/codeurjc-daw-2021-22-webapp2 .

#Pusheamos la imagen creada a la cuenta de dockerHub
docker push njhvfm014/codeurjc-daw-2021-22-webapp2
