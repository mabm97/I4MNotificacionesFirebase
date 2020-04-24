# I4MNotificacionesFirebase
<p>Este es un proyecto de prueba de concepto para la utilización de notificaciónes firebase.</p>
<br>
<p>El proyecto cuenta con 2 packages que se describen a continuación:</p>
<ol>
  <li>firebasenotificationscloud</li>
    <ul>
      <li>notificacionjava-firebase-adminsdk-taj5y-c801350b26.js</li>
      <li>FirebaseNotificationsCloud.java</li>
    </ul>
  <li>libs</li>
    <ul>
      <li>Jars/Librerias que son necesarias.</li>
    </ul>
  <li>frontEnd</li>
  <ul>
      <li>Archivos que ejemplifican la obtencion de la notificacion por front-end.</li>
  </ul>
</ol>

<h3>notificacionjava-firebase-adminsdk-taj5y-c801350b26.js</h3>
<p>Es un archivo de tipo JSON que se descarga desde la consola de "Firebase Console", la cual contiene las  APIKEY del proyecto que son necesarias para el envio.</p>


<h3>FirebaseNotificationsCloud.java</h3>
<p>Contiene el ejemplo de las funciones que deben d eimplementarse del lado <b>backend (Java) </b>  para hacer el envio de la informacion que contendra la notificacion.</p>

<h3>frontEnd</h3>
<h5>manifest.json</h5>
<p>Este archivo es obligatorio y su contenido es estandar/equanime en cualquier tipo de proyecto.</p>
<h5>firebase-messaging.sw.js</h5>
<p>Este archivo es el que tiene el objetivo de realizar la recepcion de la informacion que sera mostrada en la notificacion, realizar la accion al hacer click en la notificacion, todo esto ha menera de ejecucion en segundo plano.</p>
<h5>index.html</h5>
<p>Contiene código de ejemplo de como solicitar los permisos de solicitud, realizar el muestreo de la notificación y las APIKEY que tendra el proyecto relacionadas.</p>

