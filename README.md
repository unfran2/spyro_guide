#Introducción:
Se trata de una actualización de una aplicación ya existente. En concreto se le añade un tutorial para que el usuario aprenda cómo usar la aplicación la primera vez.

#Características principales:
La aplicación cuanta con una MainActivity, la cual aloja un contenedor de fragmentos y un BottomNavigation a través del cual se puede navegar entre los fragmentos.
Éstos fragmentos son en concreto tres y todos están compuestos por un recyclerView que se infla con varios Cardview. Esto sirve para mostrar los personajes, mundos y coleccionables del juego Spyro.
Lo añadido en esta actualización es simplemente un tutorial que utiliza transiciones, sonidos y animaciones para hacer más vistoso el aprendizaje de uso de la aplicación.

#Tecnologías utilizadas:
Principalmente se usa un DialogFragment que alberga un contenedor de fragmentos para poder superponer fragmentos con transparencias a los ya existentes. 
Además, conviven en la aplicación dos grafos de navegación con sus correspondientes acciones y el uso de NavHostFragment y Navigation en general. Esto facilita a su vez el uso de las transiciones,
ya que prácticamente sólo hay que crear la transición en xml y asignarla a la acción de navegación ya existente.

#Conclusiones:
Con esta unidad he usado por primera vez un DialogFragment como tal. Además, he descubierto que se pueden mostrar dos fragmentos al mismo tiempo y navegar al mismo tiempo en
dos niveles dentro de la aplicación.
