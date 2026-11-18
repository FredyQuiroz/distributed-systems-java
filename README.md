# Sistemas distribuidos en Java / Distributed systems in Java

[Español](#español) · [English](#english)

## Español

Ejercicios para entender cómo se comunican dos programas. Cada ejemplo divide el trabajo entre un programa que pide algo y otro que responde.

### Qué puedes hacer

- Envía y recibe mensajes mediante una conexión TCP.
- Compara la comunicación por mensajes independientes mediante UDP.
- Consulta una lista de figuras mediante una llamada remota con RMI.

### Ejemplo

Envía «Hola» a tu propio equipo con el ejemplo TCP. La dirección `127.0.0.1` permite practicar con dos terminales en la misma máquina.

### Cómo empezar

Instala un JDK y empieza en la clase principal de la edición que quieras explorar.

Puntos de entrada en el código. [`Linux/1/UDPCliente.java`](Linux/1/UDPCliente.java), [`Linux/1/UDPServidor.java`](Linux/1/UDPServidor.java), [`Linux/2/TCPCliente.java`](Linux/2/TCPCliente.java), [`Linux/2/TCPServidor.java`](Linux/2/TCPServidor.java).

En PowerShell desde la raíz del repositorio.

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding windows-1252 -d out Linux/2/TCPCliente.java Linux/2/TCPServidor.java
java -cp out Servidor.TCPServidor
```

En una segunda terminal, ejecuta `java -cp out Cliente.TCPCliente "Hola" 127.0.0.1`. Detén el servidor de prueba con Ctrl+C.

Las fechas del historial se apoyan en Git o en la evidencia disponible de los respaldos. Las fechas reconstruidas a partir de archivos sin zona horaria usan las 12:00 UTC como referencia.

## English

Exercises for learning how two programs communicate. Each example divides the work between a requesting program and a responding program.

### What you can do

- Send and receive messages using a TCP connection.
- Compare communication using standalone UDP datagrams.
- Request a list of shapes using a remote method call through RMI.

### Example

Send “Hola” to your own machine with the TCP example. The address `127.0.0.1` lets you use two terminals on the same computer.

### Getting started

Install a JDK and start with the main class of the edition you want to explore.

Entry points in the source. [`Linux/1/UDPCliente.java`](Linux/1/UDPCliente.java), [`Linux/1/UDPServidor.java`](Linux/1/UDPServidor.java), [`Linux/2/TCPCliente.java`](Linux/2/TCPCliente.java), [`Linux/2/TCPServidor.java`](Linux/2/TCPServidor.java).

In PowerShell from the repository root.

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding windows-1252 -d out Linux/2/TCPCliente.java Linux/2/TCPServidor.java
java -cp out Servidor.TCPServidor
```

In a second terminal, run `java -cp out Cliente.TCPCliente "Hola" 127.0.0.1`. Stop the test server with Ctrl+C.

History dates come from Git or available backup evidence. Reconstructed dates from files with no time zone use 12:00 UTC as a reference.
