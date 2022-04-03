#Creamos la imagen a partir del fichero Dockerfile y la Pusheamos la imagen creada a la cuenta de dockerHub
docker build -f Dockerfile -t registry.heroku.com/codeurjc-daw-2021-22-webapp2/web ..

docker push registry.heroku.com/codeurjc-daw-2021-22-webapp2/web

heroku container:release web -a codeurjc-daw-2021-22-webapp2

heroku logs --tail -a codeurjc-daw-2021-22-webapp2
