#Creamos la imagen a partir del fichero Dockerfile y la Pusheamos la imagen creada a la cuenta de dockerHub
cd ../frontend/FlyventasAngular
npm install
npm build --prod --base-href="/new/"
cp -r dist/flyventas-angular/* ../backend/src/main/resources/public/new
cd ../../docker
docker build -f Dockerfile -t registry.heroku.com/codeurjc-daw-2021-22-webapp2/web ../backend
docker push registry.heroku.com/codeurjc-daw-2021-22-webapp2/web 





