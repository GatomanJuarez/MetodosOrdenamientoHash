package Main;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 * @author By Gatoman
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    //Variable global que guardara el valor limite que nos dara el usuario.
    int max;
    //Vector auxiliar que tendra como el limite el valor anterior.
    int aux[] = new int[max];
    //Para contar las interaciones.
    int pasadas = 0;

    //Clase para llenar el vector con numeros random.
    private int[] llenar(int maximo) {
        //Vector para guardar los datos.
        int Vector[] = new int[maximo];
        //Con ayuda de un ciclo llenaremos los vectores.
        for (byte i = 0; i < maximo; i++) {
            //Asi llenaremos el vector, tendra o generara numeros como limite el parametro que le pasemos.
            Vector[i] = (int) Math.round(Math.random() * maximo);
        }
        //Retornara el vector para su posterior uso.
        return Vector;
    }

    //Metodo de ordenación.
    private void Burbuja(int vector[]) {
        //Declaramos una variable auxiliar.
        int auxN;
        //Para que no borre lo que hay en nuestra area.
        Areatext1.append("---------Procedimento-----------\n");
        //Este primer ciclo nos asegurara que recorra todo el ciclo.
        for (byte j = 0; j < vector.length - 1; j++) {
            //Recorre el ciclo una vez.
            for (byte k = 0; k < vector.length - 1; k++) {
                //Con esta condición buscamos si el numero siguiente es menor que en el que estamos.
                if (vector[k + 1] < vector[k]) {
                    //En caso de ser cierto, el numero siguiente lo guardamos en una variable.
                    auxN = vector[k + 1];
                    //El valor siguiente lo asignamos al valor en que estamos.
                    vector[k + 1] = vector[k];
                    //Y el valor actual es el valor siguiente que guardamos anteriormente.
                    vector[k] = auxN;
                    pasadas++;
                }
                Areatext1.append(vector[k] + "\n");
            }
            Areatext1.append("------------------------\n");
        }
        jLabel10.setText(pasadas + "");
    }

    //Clase para mostrar los vectores, que recibira un parametro.
    private void mostrar(int vector[]) {
        //Limpia nuestra area de texto.
        AreaText2.setText("");
        //Para que no borre lo que hay en nuestra area.
        AreaText2.append("---------Numeros generados al azar---------\n");
        //Ciclo para imprimir el vector.
        for (byte n = 0; n < vector.length; n++) {
            //System.out.println(vector[n] + "\n");
            AreaText2.append(vector[n] + "\n");
        }
        AreaText2.append("--------------------------------------------\n");
    }

    //Clase para mostrar los vectores ordenados, que recibira un parametro.
    private void mostrarVector(int vector[]) {
        //Limpia nuestra area de texto.
        Areatext.setText("");
        //Para que no borre lo que hay en nuestra area.
        Areatext.append("---------Numeros ordenados---------\n");
        //Ciclo para imprimir el vector.
        for (byte n = 0; n < vector.length; n++) {
            Areatext.append(vector[n] + "\n");
            //System.out.println(vector[n] + "\n");
        }
        Areatext.append("--------------------------------------------\n");
    }

    //Método de ordenación.
    private void insercion(int vector[]) {
        //Declaramos nuestras variables.
        int aux;
        //Ciclo para recorrer todo el vector.
        for (byte x = 1; x < vector.length; x++) {
            //Guardamos la poscición del vector.
            aux = vector[x];
            //Ciclo para recorrer a la izquierda y comparar los numeros.
            for (int y = x - 1; y >= 0 && vector[y] > aux; y--) {
                //Si el valor de la posición siguiente será igual al de la posición actual.
                vector[y + 1] = vector[y];
                //Guardamos este valor en nuestro auxiliar.
                vector[y] = aux;
                pasadas++;
                //Ciclo para ver el procedimiento del mismo.
                for (byte w = 0; w < vector.length; w++) {
                    Areatext1.append(vector[w] + "\n");
                }
                Areatext1.append("--------------\n");
            }
        }
        //Imprimimos las pasadas y/o iteraciones.
        jLabel10.setText(pasadas + "");
    }

    //Método de ordenación.
    private void casilleros(int vector[]) {
        int promedio, suma = 0;
        for (byte w = 0; w < vector.length; w++) {
            suma += vector[w];
        }
        promedio = suma / vector.length;
        System.out.println(promedio);
    }

    //Método de ordenación.
    private void seleccion(int vector[]) {
        int minimo, aux;
        //Ciclo para recorrer todo el vector. Nos indicarà los posiciones del arreglo.
        for (byte i = 0; i < vector.length; i++) {
            //Guardamos la posiciòn del arreglo.
            minimo = i;
            //Ciclo para recorrer el vector.
            for (int j = i + 1; j < vector.length; j++) {
                //Se compara el numero con el siguiente.
                if (vector[j] < vector[minimo]) {
                    //Si se cumple entonces encontramos el numero minimo.
                    minimo = j;
                    //Lo imprimimos en nuestro TextArea
                    for (byte x = 0; x < vector.length; x++) {
                        Areatext1.append(vector[x] + "\n");
                    }
                    Areatext1.append("---------------\n");
                }
            }
            //Guardamos el valor del vector en una variable.
            aux = vector[i];
            //Cuando encontramos el numero menor lo cambiamos de posicion.
            vector[i] = vector[minimo];
            //El numero mayor va a la posiciòn del numero menor anterior.
            vector[minimo] = aux;
        }
    }

    //Método de ordenación
    private int[] rapido(int vector[], int izq, int der) {
        //Cuando estan en la misma posición en el vector.
        if (izq >= der) {
            return vector;
        }
        //Declaramos variables independientes.
        int i = izq, d = der;
        //Si no estan en la misma posición.
        if (izq != der) {
            //Ciclo para imprimir el vector.
            for (byte n = 0; n < vector.length; n++) {
                Areatext1.append(vector[n] + "\n");
                //System.out.println(vector[n] + "\n");
            }
            Areatext1.append("--------------------------------------------\n");
            pasadas++;
            //Declaramos variables.
            int pivote, aux;
            //Asiganmos como pivote el valor de la izquierda.
            pivote = izq;
            //Un ciclo para que se ejecute siempre y cuando sean diferentes.
            while (izq != der) {
                //Cuando el valor de la posicion es mayor al del pivote.
                while (vector[der] >= vector[pivote] && izq < der) {
                    der--;
                }
                //Cuando el valor de la posicion es menor al del pivote.
                while (vector[izq] < vector[pivote] && izq < der) {
                    izq++;
                }
                //Si no es haci aqui se hace el cambio.
                if (der != izq) {
                    //El valor de la derecha se guarda en un auxiliar.
                    aux = vector[der];
                    //El valor de la izquierda cambia a la derecha.
                    vector[der] = vector[izq];
                    //Se intercambia el valor de la derecha con la izquierda.
                    vector[izq] = aux;
                }
                //Aqui se encuentran los dos lados.
                if (izq == der) {
                    rapido(vector, i, izq - 1);
                    rapido(vector, izq + 1, d);
                }
            }
        } else {
            return vector;
        }
        jLabel10.setText(pasadas + "");
        return vector;
    }

    //Método de ordenación.
    private int[] mezcla(int vector[]) {
        //Declaramos nuestras variables.
        int i, j, k;
        //Si el vector es mayor a uno.
        if (vector.length > 1) {
            //Ciclo para ver el procedimiento del mismo.
            for (byte w = 0; w < vector.length; w++) {
                Areatext1.append(vector[w] + "\n");
            }
            Areatext1.append("--------------\n");
            pasadas++;
            //El primero de ellos sera la mitad del mismo.
            int nElementosIzq = vector.length / 2;
            //El segundo comenzara donde termina el anterior.
            int nElementosDer = vector.length - nElementosIzq;
            //Declaramos nuestros vectores auxiliares.
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiamos los valores de la primera parte en el vector izquierdo.
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = vector[i];
            }
            //Copiamos los valores de la segunda parte en el vector derecho.
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                //Este comenzará a guardar los datos donde termina el vector izquierdo.
                arregloDer[i - nElementosIzq] = vector[i];
            }
            //Recursividad.
            arregloIzq = mezcla(arregloIzq);
            arregloDer = mezcla(arregloDer);
            //Reiniciamos nuestras varaibles.
            i = 0;//Indice del vector original.
            j = 0;//Indice del lado izquierdo.
            k = 0;//Indice del lado derecho.
            //El siguiente ciclo ordena los numeros del vector.
            while (arregloIzq.length != j && arregloIzq.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    vector[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    vector[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Areglo final. Unir los vectores auxiliares.
            while (arregloIzq.length != j) {
                vector[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                vector[i] = arregloDer[k];
                i++;
                k++;
            }
        }
        jLabel10.setText(pasadas + "");
        return vector;
    }

    //Método de ordenación
    private void radix(int arreglo[]) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int auxiliar[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mover = arreglo[i] << x >= 0;
                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = arreglo[i];
                    j++;
                } else {
                    //Intercambiamos valores.
                    arreglo[i - j] = arreglo[i];
                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = arreglo[i - j];
            }
            arreglo = auxiliar;  //Copia lo que ya esta ordenado
            for (byte n = 0; n < arreglo.length; n++) {
                Areatext1.append(arreglo[n] + "\n");
                //Areatext.setText(arreglo[n] + "\n");
                //System.out.println(vector[n] + "\n");
            }
            Areatext1.append("--------------------------------------------\n");
            pasadas++;
        }
        jLabel10.setText(pasadas + "");
        Areatext.append("---------Numeros ordenados---------\n");
        for (byte n = 0; n < arreglo.length; n++) {
            Areatext.append(arreglo[n] + "\n");
            //System.out.println(vector[n] + "\n");
        }
        Areatext.append("--------------------------------------------\n");
    }

    //Busqueda
    private void secuencial(int NumeroV[]) {
        //Aqui pedimos el número a buscar.
        byte numero = Byte.parseByte(JOptionPane.showInputDialog("Dame el número que queires buscar"));
        //Ciclo para recorrer todo el arreglo.
        for (byte x = 0; x < NumeroV.length; x++) {
            //Comparamos el número introducido por el usuario, con cada uno de los valores en el vector.
            if (numero == NumeroV[x]) {
                //En caso de que se encuentre imprime en un label.
                jLabel4.setText("El numero: " + numero + " fue encontrado!!!!");
                //Para que no continue trabajando el ciclo lo cerramos.
                break;
                //En caso de no encontrar el número.
            } else {
                //Muestra un pequeño mensaje.
                jLabel4.setText("El numero: " + numero + " NOO fue encontrado!!!!");
            }
        }
    }

    private int binaria(int Numero[], int numero) {
        //Declaramos variables algunas de ellas nos ayudaran como indices.
        int centro, primero, ultimo, valorCentro;
        primero = 0;
        ultimo = Numero.length - 1;
        //Ciclo para recorrer todo el arreglo.
        while (primero <= ultimo) {
            //Calcula la posiciòm del centro.
            centro = (primero + ultimo) / 2;
            //Almacena el valor en una variable.
            valorCentro = Numero[centro];
            //Si el numero que buscamos se encuentra en el centro.
            if (numero == valorCentro) {
                jLabel4.setText("El numero: " + numero + " fue encontrado!!!!");
                //Retorna el indice. Para que siga ejecutando el ciclo.
                return centro;
                //Si el numero es menor al del centro.
            } else if (numero < valorCentro) {
                ultimo = centro - 1; //Nos desplazamos a la izquierda.
                jLabel4.setText("El numero: " + numero + " fue encontrado!!!!");
            } //Si es mayor al valor del centro.
            else {
                primero = centro + 1; //Nos desplazamos a la derecha.
                jLabel4.setText("El numero: " + numero + " fue encontrado!!!!");
            }
        }
        jLabel4.setText("El numero: " + numero + " NOO fue encontrado!!!!");
        //Si no se encuentra el numero.
        return -1;
    }

    private void hashtable(int[] vector, int numero) {
        //Creamos la tabla hash.
        Hashtable has = new Hashtable();
        //Variable que sera utilizada como índice.
        int rando;
        Enumeration names;
        String str, num;
        //Ciclo para convertir el vector en tabla hash.
        for (byte t = 0; t < vector.length; t++) {
            //Generamos un numero que sera utilizado como índice.
            rando = (int) Math.round(Math.random() * 58740);
            //Guardamos el valor y el índice en la tabla hash. 
            has.put(vector[t] + "", new Double(rando));
        }
        //Muestra todos los valores de la tabla.
        names = has.keys();
        //El numero a buscar lo convertimos a string.
        num = numero + "";
        //El ciclo funcionara solo si el hash tiene elementos.
        while (names.hasMoreElements()) {
            //Los valores del hash lo guardamos en una variable.
            str = (String) names.nextElement();
            //Buscamos el numero.
            if (num.equals(str)) {
                jLabel4.setText("El numero: " + numero + " fue encontrado!!!!");
                //Si encuentra el numero se detiene el ciclo.
                break;
            } else {
                jLabel4.setText("El numero: " + numero + " NOO fue encontrado!!!!");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Areatext = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Areatext1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaText2 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Calculadora de metodos de ordenación.");

        jLabel2.setText("1. Dame el total de numeros que quieres.");

        jButton1.setText("Limite.");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel3.setText("* Se usaran numeros al azar.");

        jLabel5.setText("Resultados:");

        Areatext.setColumns(20);
        Areatext.setRows(5);
        jScrollPane1.setViewportView(Areatext);

        jLabel6.setText("2.Selecciona un método de ordenación.");

        jButton3.setText("Burbuja.");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Salir.");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Selección.");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("Inserción.");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setText("Rapido.");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setText("Casilleros.");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jButton9.setText("Mezcla.");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jButton10.setText("Radix.");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        jLabel7.setText("3. Ahora si quieres buscar un número.");

        jButton11.setText("Binaria.");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton12.setText("Secuencial.");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        Areatext1.setColumns(20);
        Areatext1.setRows(5);
        jScrollPane2.setViewportView(Areatext1);

        jLabel8.setText("Procedimiento.");

        AreaText2.setColumns(20);
        AreaText2.setRows(5);
        jScrollPane3.setViewportView(AreaText2);

        jLabel9.setText("Resultados al azar:");

        jButton13.setText("Limpiar.");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        jLabel4.setText("Resultado búsqueda.");

        jLabel10.setText("Interaciones realizadas.");

        jLabel11.setText("Deben estar ordenados primeramente.");

        jButton2.setText("Hash");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(jButton13)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jButton10))
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(177, 177, 177)
                        .addComponent(jLabel5)
                        .addGap(124, 124, 124)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(25, 25, 25))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Usamos el try y catch, en caso de que el usuario ponga un caracter, letra o palabra.
        try {
            //Obtenemos el limite que desea el usuario.
            max = Integer.parseInt(JOptionPane.showInputDialog("Dame el maximo del vector"));
            //Este numero lo pasamos a la clase llenar, y al mismo tiempo guardamos el vector generado en el vector
            //aux.
            aux = llenar(max);
            mostrar(aux);
        } catch (Exception e) {
            //Aqui le decimos al usuario el error.
            JOptionPane.showMessageDialog(null, "Introduce algo y numeros.\n" + "El error es: " + e);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        //Llamamos a nuestra clase de ordenación, le pasaremos como parametro el vector a ordenar.
        Burbuja(aux);
        //Usaremos una clase especial para mostrar el vector ya ordenado.
        mostrarVector(aux);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        //Indicamos al usuario que el programa se cerrara.
        JOptionPane.showMessageDialog(null, "El programa se cerrara");
        //Para cerrar el programa utilizaremos:
        System.exit(1);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        //Llamamos al método de ordenación.
        seleccion(aux);
        //Lo mostramos.
        mostrarVector(aux);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        insercion(aux);
        //Lo mostramos.
        mostrarVector(aux);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        //Limpiamos nuestras areas de texto y el label.
        jLabel4.setText("Resultado búsqueda.");
        Areatext.setText("");
        Areatext1.setText("");
        AreaText2.setText("");
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        secuencial(aux);
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        //Llamamos al método, que recibira 3 parametros:
        //  1. El vector.
        //  2. La posición del lado izquierdo.
        //  3. La posición del lado derecho.
        rapido(aux, 0, aux.length - 1);
        //Lo mostramos.
        mostrarVector(aux);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        //Llamamos al método, por alguna razon la primera vez que se usa se ordenan algunos, pero al llamarlo
        //2 veces se ordena, puede ser por algun ciclo que falto. -.-!!
        mezcla(aux);
        mezcla(aux);
        //Lo mostramos.
        mostrarVector(aux);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        //Llamamos al método.
        radix(aux);
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        //Usamos el try y catch, en caso de que el usuario ponga un caracter, letra o palabra.
        try {
            //Obtenemos el limite que desea el usuario.
            int nume = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero a buscar.\n(Recuerda que el vector debe estar ordenado)."));
            binaria(aux, nume);
        } catch (Exception e) {
            //Aqui le decimos al usuario el error.
            JOptionPane.showMessageDialog(null, "Introduce algo y solo numeros.\n" + "El error es: " + e);
        }
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        //Llamamos al método.
        casilleros(aux);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //Usamos el try y catch, en caso de que el usuario ponga un caracter, letra o palabra.
        try {
            //Obtenemos el limite que desea el usuario.
            int nume = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero a buscar.\n(Recuerda que el vector debe estar ordenado)."));
            hashtable(aux, nume);
        } catch (Exception e) {
            //Aqui le decimos al usuario el error.
            JOptionPane.showMessageDialog(null, "Introduce algo y solo numeros.\n" + "El error es: " + e);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaText2;
    private javax.swing.JTextArea Areatext;
    private javax.swing.JTextArea Areatext1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
