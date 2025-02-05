# Instrucciones para ejecutar el proyecto

Este proyecto utiliza **Java 17** y **Maven 3.9.9**. A continuación, se describen los pasos necesarios para compilar y ejecutar el proyecto correctamente.

# Paso 1: Limpiar y compilar el proyecto

Antes de ejecutar el proyecto, necesitas limpiar y compilar el código. Para ello, abre tu terminal o consola de comandos, accede al directorio del proyecto y ejecuta el siguiente comando:

```bash
mvn clean package

```
# Paso 2: Ejecutar el archivo JAR

Una vez que hayas limpiado y compilado el proyecto con el comando `mvn clean package`, deberás ejecutar el archivo JAR generado. Para ello, usa el siguiente comando en tu terminal:

```bash
java -jar target/retoTecnico-1.0-SNAPSHOT.jar %nombre-del-json%
```

**Nota**
El `%nombre-del-json%` debe ser el nombre del archivo JSON a leer. Por el momento solo existen 2 archivos disponibles:
>
> - `animals.json`
> - `prehistoric-animals.json`
>
> Ejemplo de uso:
> ```bash
> java -jar target/retoTecnico-1.0-SNAPSHOT.jar animals.json
> ```
