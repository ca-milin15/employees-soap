Documentación para ejecutar aplicacion.

1. Clonar proyecto ubicado en el repositorio: 
- https://github.com/ca-milin15/employees-soap
- https://github.com/ca-milin15/employees-soap.git

2. Ubicarse en la raíz del proyecto clonado. 
Ejemplo: "cd C:\Users\camilo.rivera\Documents\Personal\employees-soap".

3. Asegurarse que la aplicación de escritorio de Docker esta ejecutandose.

4. Ejecutar el comando: "docker compose up".
Este comando ejecutará los contenedores correspondientes a la DB y el API externa: "calculator".

5. Ejecutar el comando: "docker ps" para confirmar que ambos contenedores esten en ejecución:
- container-registry.oracle.com/database/express:latest
- ccamilorrivera/calculator-ws

6. En la raíz del proyecto ejecutar el comando: "gradlew bootRun"

7. En el momento que el proyecto terminó de ejecutarse, acceder a la URL: 
- "http://localhost:8080/ws/employee.wsdl" para obtener el WSDL y poder ejecutar las peticiones desde el cliente(SOAP UI).

*NOTA*:
- No es necesario ejecutarse script de DB, ya que el proyecto está configurado para que cree la tabla en la DB en el momento en que SpringBoot inicia.

- Puede ejecutar el comando: "gradle test" para ejecutar los test unitarios y de integración para confirmar correcto funcionamiento.

*ACLARACIÓN*
Al momento de consulta la API propuesta en el ejercicio, se menciona el repositorio: "https://github.com/l2x6/calculator-ws", sin embargo, no fue posible ejecutar el proyecto en la maquina local para generar la imagen, para luego ser almacenada en DockerHub y ser administrada por Docker compose; por lo tanto, yo desarrollé otro servicio WEB SOAP para poder llevar a cabo la integración entre aplicaciones.
Comparto URL de DockerHub donde estan almacenadas las imagenes:
- https://hub.docker.com/repository/docker/ccamilorrivera/employees-soap/general (Proyecto principal)
- https://hub.docker.com/repository/docker/ccamilorrivera/calculator-ws/general (Proyecto secundario [calculadora-ws])
