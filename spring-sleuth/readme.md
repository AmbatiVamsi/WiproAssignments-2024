1. Create microservice 1
2. Create microservice 2
3. Add the following in application.properties in both microservice
   management.tracing.sampling.probability=1
    spring.application.name=testzipkin.ws
 4. Download and setup zipkin as per your enviornment: https://zipkin.io/pages/quickstart
 5. Open the zipking - http://localhost:9192
 6. Execute the both endpoint
 7. refesh the zipkin 
