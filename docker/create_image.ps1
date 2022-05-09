cd ../frontend/FlyventasAngular
npm install
ng build --prod --base-href="/new/"
rm -r ../../backend/src/main/resources/static/new
cp -r dist/flyventas-angular/* ../../backend/src/main/resources/static/new
cd ../../docker
docker build -f Dockerfile -t registry.heroku.com/codeurjc-daw-2021-22-webapp2/web ..
docker push registry.heroku.com/codeurjc-daw-2021-22-webapp2/web 