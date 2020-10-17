# orchid_api

## usage

- preparation
```
$ cp conf/application.sample.conf conf/application.conf
```
Then, edit the file if you need.

- build
```
$ docker-compose build
```
You can add `--no-cache` option when you want to run build the image without cache.

- up
```
$ docker-compose up
```
Now you can use Orchid APIs.

Access to `http://localhost:9000/api/v1/h`, you will get a response with 200.  
Also you can access minio(`http://localhost:9012`).
