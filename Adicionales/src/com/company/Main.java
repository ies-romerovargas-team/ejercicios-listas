package com.company;

import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {
            System.out.println("");
            System.out.print("\u001B[101m");
            System.out.print("\u001B[97m");
            System.out.print("OPCIONES");
            System.out.println("\u001B[0m");
            System.out.println("");
            System.out.println("1. ordenaRepetidos");
            System.out.println("2. elementosUnicosy elementosRepetidos");
            System.out.println("3. listaDominoDobles");
            System.out.println("4. palabrasMismaLetra");
            System.out.println("5. listaPalabrasLargas");
            System.out.println("6. haceCalor");

            System.out.println("");
            System.out.print("\u001B[101m" + "\u001B[97m");
            //System.out.print();
            System.out.print("0. SALIR");
            System.out.println("\u001B[0m");

            try {
                System.out.println("Selecciona una opción (1-6)");
                opcion = sc.nextInt();
                List<Integer> l = new ArrayList<>();
                List<String> lista_1 = new LinkedList<>();
                List<String> lista_2 = new LinkedList<>();
                List<Double> l2 = new ArrayList<>();
                switch (opcion) {
                    case 1:
                        l = new LinkedList<>(Arrays.asList(5, 5, 1, 2, 8, 3, 0, 3, 2, 2, 5, 7, 5));
                        System.out.print("Original: ");
                        escribeLista(l);
                        System.out.print("Ordenada: ");
                        ordenaRepetidos(l);
                        escribeLista(l);
                        break;
                    case 2:
                        l = new LinkedList<>(Arrays.asList(1, 1, 2, 3, 99, 1, 99, 5));
                        System.out.print("Original: ");
                        escribeLista(l);
                        System.out.print("Elementos Unicos: ");
                        escribeLista(elementosUnicos(l));
                        System.out.print("Elementos Repetidos: ");
                        escribeLista(elementosRepetidos(l));
                        break;
                    case 3:
                        l = new LinkedList<>(Arrays.asList(1, 1, 2, 6, 0, 0, 5, 4));
                        System.out.print("Fichas: ");
                        escribeLista(l);
                        System.out.print("Fichas Dobles: ");
                        escribeLista(listaDominoDobles(l));
                        break;
                    case 4:
                        String cadena = "Amanda tiene tres serpientes";
                        System.out.println(cadena);
                        escribeListaString(palabrasMismaLetra(cadena));
                        break;
                    case 5:
                        cadena = "Mi mamá me mima";
                        System.out.println(cadena);
                        escribeListaString(listaPalabrasLargas(cadena, 4));
                        break;
                    case 6:
                        lista_1 = new LinkedList<>(Arrays.asList("Jerez", "Cadiz", "Barbate", "Arcos", "Sanlucar"));
                        l2 = new LinkedList<>(Arrays.asList(14.5, 13.2, 13.7, 16.1, 14.2));
                        escribeListaString(lista_1);
                        escribeListaDouble(l2);
                        haceCalor(lista_1,l2);
                        System.out.println("Por encima de la media:");
                        escribeListaString(lista_1);
                        escribeListaDouble(l2);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("ERROR: Solo números entre 0 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes insertar un número");
                sc.next();
            }
        }
    }

    public static void haceCalor(List<String> ciudades, List<Double> temperaturas)
    {
        // error si distinto tamaño
        if(ciudades.size()==temperaturas.size())
        {
            // hallar media
            double media = 0;
            for (int i = 0; i < temperaturas.size(); i++) {
                media = media + temperaturas.get(i);
            }
            media = media / temperaturas.size();
            System.out.println("Temperatura Media: " + media);
            //eliminamos ciudades y temperaturas por debajo de la media
            for (int i= 0; i < temperaturas.size(); i++) {
                if(temperaturas.get(i) < media)
                {
                    ciudades.remove(i);
                    temperaturas.remove(i);
                    i--;
                }
            }
        }
        else
        {
            System.out.println("Error, listas de distinto tamaño");
        }
    }

    public static List<String> listaPalabrasLargas(String cadena, int longitud)
    {
        List<String> palabras = new LinkedList<>();
        cadena = cadena.toLowerCase();
        String[] arraycadenas = cadena.split(" ");
        for (int i = 0; i < arraycadenas.length; i++)
        {
            if(arraycadenas[i].length()>=longitud)
            {
                palabras.add(arraycadenas[i]);
            }
        }
        return palabras;
    }

    public static List<String> palabrasMismaLetra(String cadena)
    {
        List<String> palabras = new LinkedList<>();
        cadena = cadena.toLowerCase();
        String[] arraycadenas = cadena.split(" ");
        for (int i = 0; i < arraycadenas.length; i++) {
            if(arraycadenas[i].charAt(0)==arraycadenas[i].charAt(arraycadenas[i].length()-1))
            {
                palabras.add(arraycadenas[i]);
            }
        }
        return palabras;
    }

    public static List<Integer> listaDominoDobles(List<Integer> fichas)
    {
        List<Integer> fichasDobles = new LinkedList<>();
        for (int i = 0; i < fichas.size(); i = i + 2) {
            if(fichas.get(i) == fichas.get(i+1))
            {
                fichasDobles.add(fichas.get(i));
                fichasDobles.add(fichas.get(i));
            }
        }
        return fichasDobles;
    }

    public static List<Integer> elementosUnicos(List<Integer> lista)
    {
        //Ej.: {1, 1, 2, 3, 99, 1, 99, 5} nos devolvería {2, 3, 5}
        List<Integer> eleUnicos = new LinkedList<>();
        int cont;
        for (int i = 0; i < lista.size(); i++)
        {
            cont = 0;
            for (int j = 0; j < lista.size(); j++) {
                if(lista.get(i)==lista.get(j)) cont++;
            }
            if (cont==1) eleUnicos.add(lista.get(i));
        }
        return eleUnicos;
    }

    public static List<Integer> elementosRepetidos(List<Integer> lista)
    {
        //Ej.: {1, 1, 2, 3, 99, 1, 99, 5} nos devolvería {1, 99}
        List<Integer> eleRepes = new LinkedList<>();
        int cont;
        for (int i = 0; i < lista.size(); i++)
        {
            cont = 0;
            for (int j = 0; j < lista.size(); j++) {
                if(lista.get(i)==lista.get(j)) cont++;
            }
            if (cont>1 && !eleRepes.contains(lista.get(i))) eleRepes.add(lista.get(i));
        }
        return eleRepes;
    }

    public static void ordenaRepetidos(List<Integer> lista)
    {
        List<Integer> lista1 = new LinkedList<>();
        while(lista.size()!=0) {
            Integer a = modaLista(lista);
            int cont = 0;
            while (lista.remove(a)) {
                cont++;
            }
            ;
            int empieza = lista1.size();
            for (int i = empieza; i < empieza + cont; i++) {
                lista1.add(empieza, a);
            }
        }
        // reconstruimos la lista orginal
        for (int i = 0; i < lista1.size(); i++) {
            lista.add(lista1.get(i));
        }
    }


    public static int modaLista(List<Integer> lista)
    {
        int max = 0;
        int cont, moda=0;

        for (int i = 0; i < lista.size(); i++)
        {
            cont = 0;
            for (int j = i; j < lista.size(); j++) {
                if(lista.get(i)==lista.get(j))
                {
                    cont ++;
                }
            }
            if (cont > max){
                max = cont;
                moda = lista.get(i);
            }
        }
        return moda;
    }


    private static void escribeListaString(List<String> li)
    {
        // Escribir todos los elementos de una lista
        int i;
        System.out.print("<");
        if(li.size()>0) {
            for (i = 0; i < li.size() - 1; i++) {
                System.out.print(li.get(i));
                System.out.print(", ");
            }
            System.out.print(li.get(i));
        }
        System.out.println(">");

    }

    private static void escribeListaDouble(List<Double> li)
    {
        // Escribir todos los elementos de una lista
        int i;
        System.out.print("<");
        if(li.size()>0) {
            for (i = 0; i < li.size() - 1; i++) {
                System.out.print(li.get(i));
                System.out.print(", ");
            }
            System.out.print(li.get(i));
        }
        System.out.println(">");
    }

    private static void escribeLista(List<Integer> li)
    {
        // Escribir todos los elementos de una lista
        int i;
        System.out.print("<");
        if(li.size()>0) {
            for (i = 0; i < li.size() - 1; i++) {
                System.out.print(li.get(i));
                System.out.print(", ");
            }
            System.out.print(li.get(i));
        }
        System.out.println(">");
    }

    private static void leeLista(List<Integer> li)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Escribe elementos de la lista. -1 para terminar: ");
        do
        {
            a = sc.nextInt();
            if(a!=-1)
            {
                li.add(a);
            }
        }while (a != -1);
    }

    private static void ExplicacionesClase()
    {
        // Definición de variable
        List<Integer> li; // Integer es parecido a int (no me deja usar el int)

        // Creamos la lista
        li = new ArrayList<>(); // más rápida para recorrer la lista (con un for)
        li = new LinkedList<>(); // más rápida para añadir o insertar elementos

        // Añadir elementos a una lista

        li.add(1);
        li.add(2);
        li.add(3);

        int i;
        for(i = 4; i <= 6; i++)
        {
            li.add(i);
        }

        // Sumarle uno a cada posición

        int valor;
        for(i = 0; i < li.size(); i++)
        {
            valor = li.get(i); // Leer un valor de una posición i -> valor = li[i]
            li.set(i, valor + 1); // Modifica el valor de la posición i -> li[i] = valor + 1

            //li.set(i, li.get(i) + 1); // de una sola vez -> l[i]++;
        }

        //escribeBorraLista(li);
        System.out.println(li.size());

        // Más funciones de listas
        // INSERTAR
        li.add(5); // Añade un elemento al final
        li.add(0, 5); // Añade un elemento al principio
        li.add(3, 5); // Añade el 5 en la posición 3
        // Peta si la posición no existe

        // BORRAR POR POSICION
        li.remove(0); // Borra el primer elemento, peta si no hay nada
        li.remove(li.size()-1); // Borra el último elemento, peta si no hay nada

        // BORRAR POR ELEMENTO
        Integer ele = 5;
        li.remove(ele); // Borra el elemento '5' (si hay más de uno, quita el primero).
        // Además, devuelve true si está y false si no.

        li.remove(Integer.valueOf(ele)); // otra manera

        // CONTAINS
        //li.contains(); // igual que el de cadenas

        // INDEXOF
        //li.indexOf(5); // igual que el de cadenas

        // SUBLIST
        //li.subList(3, 6); // como SubString

        // Añadir muchos datos a una lista.
        List<Integer> l2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> l3 = new LinkedList<>(Arrays.asList(11, 12, 13));

        // ADDALL -> añade una lista (o un array) en otra
        l2.addAll(l3);
        System.out.println(l2);

        Integer[] array = {99,98,97};
        l2.addAll(Arrays.asList(array));
        System.out.println(l2);

        // CLEAR
        //li.clear(); // deja vacía la lista

        // ISEMPTY
        //while(!li.isEmpty()) // yo normalmente uso (li.size() > 0)

        // RESTO DE FUNCIONES CHULAS ESTÁN EN COLLECTIONS
        System.out.println("min = " + Collections.min(l2));
        System.out.println("max = " + Collections.max(l2));
        Collections.reverse(l2);
        System.out.println("al reves = " + l2);
        Collections.sort(l2);
        System.out.println("ordenada = " + l2);
        Collections.shuffle(l2);
        System.out.println("desordenada = " + l2);
    }
}
