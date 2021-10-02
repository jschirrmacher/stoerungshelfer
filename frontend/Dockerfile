FROM node:16
WORKDIR /app

ADD . /app/

RUN npm install -g http-server &&\
    npm ci &&\
    npm run build &&\
    mv dist stoerungshelfer &&\
    mkdir dist &&\
    mv stoerungshelfer dist/

EXPOSE 8080
CMD [ "http-server", "dist" ]
