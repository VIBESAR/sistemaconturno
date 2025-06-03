Documentacion estructuras de datos utilizadas y su impacto.
Proyecto: Sistema de Atención al Cliente con Turnos Automatizados
Armando Miguel Enrique Santos Salguero
0905-23-5034

Estructuras de datos utilizadas y su impacto.
Durante el desarrollo del proyecto pude aplicar varias estructuras de datos que normalmente uno ve en teoria en clases pero esta vez las use para resolver cosas reales en el sistema de turnos que hice use colas pilas listas y arboles cada una sirvio para una parte diferente y fueron clave para que todo funcione bien.

Cola de turnos fifo
Para manejar los turnos en el orden que llegan use una cola fifo esto sirve para simular como los clientes son atendidos en lugares como bancos o clinicas la use para separar la logica del turno de la base de datos asi pude simular bien la atencion.

Impacto
Ayudo a que los turnos se atendieran en orden sin complicaciones como pasa en la vida real

Pila de acciones
Para que el usuario pueda deshacer lo ultimo que hizo use una pila ahi se guarda lo que se va haciendo como crear editar o eliminar y si uno comete un error se puede deshacer sin tanta complicacion.

Impacto
Le dio al sistema una forma facil de corregir cosas sin hacer todo otra vez.

Lista de historial
El historial lo maneje con una lista donde voy guardando los turnos que ya fueron atendidos con la fecha y otros datos aunque eso tambien va a la base de datos me sirvio para probar cosas rapido.

Impacto
Sirvio para llevar control de lo que ya se atendio sin tener que estar preguntando a la base de datos todo el tiempo.

Arbol de servicios
Para organizar los servicios por categoria use un arbol cada nodo representa un servicio o subcategoria como salud odontologia limpieza aunque aun no lo meti en produccion lo hice como base para seguir mejorando.

Impacto
Este arbol me ayuda a tener jerarquia de servicios sirve por si despues quiero poner filtros o mostrar todo ordenado

Conclusion de este proyecto.

Usar estas estructuras me ayudó a reforzar lo que aprendí en programación estructurada siento que ahora entiendo mejor cómo se usan en la práctica no solo aprendí a usar un poco mejor Spring Boot sino que también vi cómo aplicar estructuras que ya conocía para resolver problemas reales en sistemas se complico mucho muchas veces pero inviertiendo tiempo y esfuerzo se logro.

