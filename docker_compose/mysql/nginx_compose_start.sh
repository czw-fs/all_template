# 静态文件
if [ ! -d "./mysql_compose/html" ]; then
  mkdir -p ./mysql_compose/html
fi

# 日志
if [ ! -d "./nginx_compose/logs" ]; then
  mkdir -p ./nginx_compose/logs
fi

# 存放 SSL/TLS 证书和私钥
if [ ! -d "./nginx_compose/cert" ]; then
  mkdir -p ./nginx_compose/cert
fi

# 所有网站对应的配置文件
if [ ! -d "./nginx_compose/conf.d" ]; then
  mkdir -p ./nginx_compose/conf.d
fi

sudo chmod 755 ./nginx_compose
sudo chmod 755 ./nginx_compose/logs
cd ./nginx_compose

touch docker-compose.yml
touch nginx.conf

cat > docker-compose.yml << __EOF__
version: '3'
services:
  nginx:
    restart: always
    container_name: nginx
    image: nginx
    ports:
      - 80:80
      - 443:443
    volumes:
      - ./html:/usr/share/nginx/html
      - ./logs:/var/log/nginx
      # 有可能会出现不能挂载，这个时候用手动拷贝配置文件就行
      - ./nginx.conf:/etc/nginx/nginx.conf
      - ./cert:/etc/nginx/cert
      - ./conf.d:/etc/nginx/conf.d
    environment:
      - NGINX_PORT=80
      - TZ=Asia/Shanghai
#    privileged: true
__EOF__

cat > nginx.conf << __EOF__
user  nginx;
worker_processes  auto;

error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;

events {
    worker_connections  1024;
}

http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    #ssl_certificate /etc/nginx/cert/example.crt;
    #ssl_certificate_key /etc/nginx/cert/example.key;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    # 注意要添加这一行(包含所有网站的配置)
    include /etc/nginx/conf.d/*.conf;
}
__EOF__

cd ./conf.d
touch default.conf

cat > default.conf << __EOF__
server {
    listen 80;
    server_name localhost;
    charset utf-8;

    location / {
        root /usr/share/nginx/html;
        try_files \$uri \$uri/ /index.html;
    }

    error_page 404 /index.html;
}
__EOF__

cd ../html
touch index.html


cat > index.html << __EOF__
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>hello success!!!!</h1>
</body>
</html>
__EOF__

sudo docker-compose up -d