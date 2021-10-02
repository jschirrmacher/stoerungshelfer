FROM node:16
WORKDIR /app

ADD . /app/

RUN npm install -g http-server &&\
    npm run build

EXPOSE 8080
CMD [ "http-server", "dist" ]
