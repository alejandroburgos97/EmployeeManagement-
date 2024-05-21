# EmployeeManagement Web Application
## Descripción
Este proyecto es una aplicación web para administrar empleados y departamentos. Utiliza una arquitectura empresarial multinivel con JBOSS y está construido con las siguientes tecnologías:

* **WebServer:** WildFly
* **Java:** 17 o superior
* **Interfaz gráfica:** JSF y PrimeFaces (versión 11)
* **Base de datos en memoria:** H2
* **Persistencia:** Hibernate/JPA 
* **Gestión de dependencias:** Maven

El modelo de dominio consta de departamentos y empleados. Cada departamento puede tener muchos empleados y un empleado puede pertenecer a un solo departamento.

## Requisitos
* Java 17 o superior
* Apache Maven
* WildFly Application Server

## Instalación y Configuración
### 1. Descargar e instalar WildFly
   1. Descargue la última versión de WildFly.
   2. Extraiga el archivo descargado en una ubicación de su preferencia.
### 2. Configurar WildFly
   1. Ingrese al directorio donde quedó instalado WildFly.
   2. Inicie el servidor ejecutando el siguiente comando:

```
bin/standalone.bat
```
   Esto iniciará el servidor WildFly en el puerto 8080 por defecto.

### 3. Configurar el proyecto
   1. Clone este repositorio en su máquina local y navegue al directorio del proyecto clonado

### 4. Construir y desplegar la aplicación
   1. Construya el proyecto utilizando Maven:
```
mvn clean install
```
   2. Despliegue la aplicación en el servidor WildFly utilizando el plugin de Maven WildFly:

```
mvn wildfly:deploy
```
### 5. Acceder a la aplicación
   Abra su navegador web e ingrese la siguiente URL para acceder a la aplicación:

http://127.0.0.1:8080/EmployeeManagement/index.jsf

## Funcionalidades
### Departamentos
 * Crear: Permite crear nuevos departamentos.
 * Ver: Muestra una lista de todos los departamentos.
 * Editar: Permite actualizar la información de un departamento existente.
Borrar: Permite eliminar un departamento existente.
### Empleados
  * Crear: Permite crear nuevos empleados.
  * Ver: Muestra una lista de todos los empleados.
  * Editar: Permite actualizar la información de un empleado existente.
  * Borrar: Permite eliminar un empleado existente.
### Modelo de Dominio
#### Departamentos
  * id (autoincremental, deshabilitado en el formulario)
  * departamento_codigo
  * departamento_nombre
  * fecha_hora_crea (Solo visual)
  * fecha_hora_modifica (Solo visual)
#### Empleados
  * id (autoincremental, deshabilitado en el formulario)
  * documento_tipo (RC, TI, CC, CE)
  * documento_numero
  * nombres
  * apellidos
  * departamentos_id (Relación)
  * ciudad
  * dirección
  * correo_electrónico
  * telefono
  * fecha_hora_crea (Solo visual)
  * fecha_hora_modifica (Solo visual)