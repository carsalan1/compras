# Aplicación de Compras

## Descripción
Esta es una aplicación de compras en Java que permite al usuario realizar compras mientras mantiene un registro de las mismas y muestra un resumen al finalizar.

## Funcionalidades
- **Interfaz gráfica de usuario (GUI):** Utiliza componentes de Swing para crear una interfaz de usuario intuitiva y fácil de usar.
- **Validación de entrada:** Se realizan validaciones de entrada para asegurarse de que el usuario ingrese valores válidos para la descripción y el valor de la compra.
- **Registro de compras:** Mantiene un registro de todas las compras realizadas, mostrándolas en un área de texto junto con el saldo restante.
- **Resumen de compras:** Al finalizar, se muestra un resumen ordenado de todas las compras realizadas, junto con el saldo final, en un cuadro de diálogo.
- **Formato de moneda:** Los valores de las compras y el saldo se muestran en formato de moneda utilizando la clase `DecimalFormat`.
- **Clase `Compra`:** Se define una clase `Compra` para representar cada compra individualmente, lo que ayuda a mantener un registro organizado de las compras.
- **Manejo de eventos:** Se implementa el método `actionPerformed` de la interfaz `ActionListener` para manejar las acciones realizadas por el usuario, como hacer clic en botones.
- **Ventana colorida:** Se muestra una ventana colorida al iniciar la aplicación, lo que agrega un aspecto visual atractivo.

## Uso
1. Al iniciar la aplicación, se solicita al usuario que ingrese el límite de su tarjeta.
2. Después de ingresar el límite de la tarjeta, se abre una nueva ventana donde el usuario puede realizar compras.
3. El usuario puede ingresar la descripción y el valor de la compra y luego hacer clic en el botón "Comprar" para agregar la compra.
4. Después de cada compra, se actualiza un área de texto que muestra las compras realizadas y el saldo restante.
5. Cuando el usuario decide finalizar, se muestra un resumen de todas las compras realizadas en un cuadro de diálogo, ordenadas por cantidad, junto con el saldo final.

## Ejecución
Para ejecutar la aplicación, sigue estos pasos:
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de Java preferido.
3. Ejecuta la clase `AplicacionCompras.java`.
4. Sigue las instrucciones en la ventana de la aplicación para utilizarla.

## Autor
Juan Carlos Salgado Andrade
