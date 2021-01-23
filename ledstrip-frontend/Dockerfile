FROM nginx:1.19.6

ENV TZ=Europe/Amsterdam

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo $TZ > /etc/timezone

RUN mkdir -p /var/cache/nginx

COPY dist/ledstrip-frontend/ /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
