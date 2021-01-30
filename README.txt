			  		Procesamiento Digital de Imágenes: Tarea 1
						  Giselt G. Parra V.
						    V-266.09.640



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CARGA DE IMAGENES %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Para la subida de imagenes al programa puede optar por una de las opciones predeterminadas y de muestra para cada formato con solo
darle click al los botones en el menubar o ingresar la ruta absoluta del archivo que desee cargar. Una vez copiada la ruta en el campo
de texto, debe proceder a dar click en los botones de la derecha dependiendo del formato que del archivo a cargar

Debe seleccionar la opción 'Cargar Netpbm' para archivos con extensión .ppm, .pgm o .pbm. En el caso contrario, si el archivo contiene 
otro formato, pulse la opción 'Cargar'.



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CONVOLUCIONES %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

La estrategia para las convoluciones está basado en el recorido completo de la imagen acotando
el kernel del filtro con respecto al la posición correspondiente del pivote en la matriz. Para
una descripción más clara se ejemplifica de este modo

Sea el kernel a aplicar con pivote 'p'

	K =	| k | k | k | p |
		| k | k | k | k |

y la imagen representada en la matriz

	I =	| i | i | i |
		| i | i | i |
		| i | i | i |

Para cada borde de la imagen se tomará solo la submatriz de K que se adapte a la posición

	k k k k |p*i| i | i | 
        k k k k |k*i| i | i |
                | i | i | i |  I(0,0) = (p*i + k*i)/(p+k)
      

	  k k k |k*i|p*i| i | 
          k k k |k*i|k*i| i |
                | i | i | i |  I(0,0) = (p*i + k*i + k*i + k*i)/(p+k+k+k)	 

por lo cual, no se cosidera el resto del kernel que sale del rango entre 0 y el ancho o alto de la imagen.  
Nota: cada elemento 'k' y 'i' mostrados en el ejemplo anterior no representan el mismo valor, sólo se representó
así por simplesa del ejemplo.



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% APLICACION DE FILTROS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Cada filtro posee del lado izquierdo de donde lo indica el programa, un conjunto de sliders que le permitirán escoger el
tamaño que desee para el kernel a operar en la imagen. A medida que el valor de las dimensiones varie, la imagen mostrará
la convolusión hecha con esos valores sin guardarse. Si desea conservar los cambios hechos por los filtros, pulse la imagen
donde se indica cuál filtro está aplicando y así continuar la edición de su imagen.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% AJUSTES DE LA IMAGEN %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Cada transformación aplicada a la imagen será acumulativa a excepción de los ajustes de la imagen (los sliders al lateral 
izquierda de la ventana) que dado a que los cambios realizados pueden cambiar mucho la imagen, se tenga la comodidad de que 
se puede visualizar la umbralizacion de una imagen sin conservar este cambio.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ALMACENAMIENTO CON MENOR NRO DE BITS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Para realizar la conversión, se tomó en cuenta el número único de colores así como el comportamiento de los histogramas de cada canal.
Si los colores en los histogramas poseen las misma frecuencia para los mismos valores en el eje x (los colores) se puede inturir que
la imagen está en escala de grises y se puede almacenar como tal sin mayor perdida de colores. Si el color unico de la imagen es igual 
a dos entonces la conversión correspondiente es a formato pbm-









