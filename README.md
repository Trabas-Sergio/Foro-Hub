# :speech_balloon: Foro Hub

![Static Badge](https://img.shields.io/badge/STATUS-IN_DEVELOPMENT-green)

Este proyecto consiste en una aplicación de foro web desarrollada utilizando Spring Boot, un marco de trabajo popular para la creación de aplicaciones Java.  La aplicación permite a los usuarios crear, leer, actualizar y eliminar topicos en un foro. Este proyecto busca proporcionar una plataforma fácil de usar y escalable para fomentar la interacción entre usuarios en un entorno controlado y moderado. Además, sirve como una excelente práctica para el desarrollo de aplicaciones web con Spring Boot y la integración de diversas tecnologías para ofrecer una experiencia completa de usuario.

## :hammer:Funcionalidades del proyecto

### 📉 **Gestion de publicaciones** 
Los usuarios pueden crear nuevas publicaciones, editar las existentes y eliminar las que ya no sean relevantes. Además, pueden ver las publicaciones ordenadas por fecha o popularidad.

### 🔐 **Autenticación y Autorización**  
- **Acceso restringido a ciertas funcionalidades según el rol del usuario**:  
  - **Administradores**:  
    - Pueden crear, actualizar usuarios.  
    - Tienen control total sobre las cuentas de usuario y sus roles.  
    - Pueden gestionar, actualizar y eliminar cualquier tópico, respuesta y curso.  
  - **Usuarios**:  
    - Pueden crear, leer, actualizar y eliminar solo los tópicos y respuestas que hayan creado.  
    - No tienen acceso a la gestión de usuarios ni a la eliminación de contenido ajeno.  
    - Pueden consultar los cursos y ver sus detalles, pero no pueden modificarlos ni eliminarlos.

### ✅ **Validaciones**  
- **Validaciones específicas basadas en reglas de negocio**:  
  - Se validan los datos de usuarios (como correo electrónico y contraseña).  
  - Se validan las publicaciones (tópicos, respuestas, y cursos) para asegurar que se cumplan con las normas del foro.  
  - Solo los administradores pueden realizar acciones como la eliminación de usuarios y contenido.

### 💾 **Persistencia**  
- **Almacenamiento de datos en una base de datos relacional**:  
  - Todos los datos (usuarios, tópicos, respuestas, cursos) se almacenan en una base de datos relacional (por ejemplo, MySQL).  
  - Esto asegura que la información se maneje de forma eficiente y coherente.

### 📖 **Documentación Automática**  
- **Swagger para exponer la documentación interactiva de la API**:  
  - Se utiliza Swagger para generar una documentación interactiva de la API, donde los desarrolladores pueden ver y probar las rutas disponibles de manera visual.  
  - La documentación también incluye detalles sobre los roles de usuario y los permisos asociados a cada funcionalidad.
 
## 🛠️ Ejecución del proyecto 

  1. Clon Repository
     
     ```bash
     git clone https://github.com/Trabas-Sergio/Foro-Hub
     cd Foro-Hub
  2. Configure enviroment or edit application.properties for you database connection

     ```yaml
      spring.datasource.url=jdbc:postgresql://localhost:5432/foro_db
      spring.datasource.username=user
      spring.datasource.password=password
      spring.jpa.hibernate.ddl-auto=update

  3. Compile and run project

     ```bash
     mvn clean install
     mvn spring-boot:run
     
  4. Open `http:localhost:8080` in your browser to test the API.

 ## ✅ Tecnologias Utilizadas

 ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
 
 ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
 
 ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
 
 ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

 ## Autor
- **Desarrollado por**: Sergio Vilchez
