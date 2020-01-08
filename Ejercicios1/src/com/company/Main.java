package com.company;

import java.util.*;

public class Main
{
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
            System.out.println("1. leeLista");
            System.out.println("2. leeListaN");
            System.out.println("3. escribeLista");
            System.out.println("4. eliminaNegativos");
            System.out.println("5. clasificaNumeros");
            System.out.println("6. eliminaRepetidos");
            System.out.println("7. ordenaListaSeleccion");
            System.out.println("8. ordenaListaInsercion");
            System.out.println("");
            System.out.print("\u001B[101m" + "\u001B[97m");
            //System.out.print();
            System.out.print("0. SALIR");
            System.out.println("\u001B[0m");

            try {
                System.out.println("Selecciona una opción (0-8)");
                opcion = sc.nextInt();
                List<Integer> l = new ArrayList<>();
                switch (opcion) {
                    case 1:
                        leeLista(l);
                        escribeLista(l);
                        break;
                    case 2: case 3:
                        leeListaN(l,5);
                        escribeLista(l);
                        break;
                    case 4:
                        leeListaN(l, 5);
                        eliminaNegativos(l);
                        escribeLista(l);
                        break;
                    case 5:
                        List<Integer> positivos = new ArrayList<>();
                        List<Integer> negativos = new ArrayList<>();
                        leeListaN(l, 10);
                        clasificaNumeros(l, positivos, negativos);
                        escribeLista(positivos);
                        escribeLista(negativos);
                        break;
                    case 6:
                        leeListaN(l, 10);
                        escribeLista(l);
                        eliminaRepetidos(l);
                        escribeLista(l);
                        break;
                    case 7:
                        leeListaN(l,10);
                        escribeLista(l);
                        escribeLista(ordenaListaSeleccion(l));
                        break;
                    case 8:
                        List<Integer> l2 = new LinkedList<>(Arrays.asList(3, 1, 85, 2, 3, -8, 3, 41, 4, -4));
                        System.out.print("Original: ");
                        escribeLista(l2);
                        System.out.print("Ordenada: ");
                        escribeLista(ordenaListaInsercion(l2));
                        break;
                    case 0:
                        salir = true;
                        break;
                    case 9:
                        for (int i = 0; i < 255; i++) {
                            System.out.print(i + " \u001B["+ i +"m");
                            System.out.print("P R U E B A");
                            System.out.println("\u001B[0m");
                        }

                        break;
                    default:
                        System.out.println("ERROR: Solo números entre 0 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes insertar un número");
                sc.next();
            }
        }
    }

    private static void eliminaRepetidos(List<Integer> l1)
    {
        List<Integer> auxiliar;
        auxiliar = new LinkedList<>();
        for (int i = 0; i < l1.size(); i++) {
            if (!auxiliar.contains(l1.get(i)))
            {
                auxiliar.add(l1.get(i));
            }
        }
        l1.clear();
        for (int i = 0; i < auxiliar.size(); i++) {
            l1.add(auxiliar.get(i));
        }
    }

    private static void clasificaNumeros(List<Integer> l1, List<Integer> l2, List<Integer> l3)
    {
        for (Integer integer : l1) {
            if (integer >= 0) {
                l2.add(integer);
            }
            else
            {
                l3.add(integer);
            }
        }
        l1.clear();
        ordenaLista(l2);
        ordenaLista(l3);
    }

    private static void ordenaLista(List<Integer> li)
    {
        List<Integer> resultado;
        resultado = new LinkedList<>();
        int indice = 0;
        while(li.size()!=0) {
            int masPequenno = li.get(0);
            for (int i = 0; i < li.size(); i++) {
                if (li.get(i) <= masPequenno) {
                    masPequenno = li.get(i);
                    indice = i;
                }
            }
            li.remove(indice);
            resultado.add(masPequenno);
        }
        for (int i = 0; i < resultado.size(); i++) {
            li.add(resultado.get(i));
        }
    }

    private static List<Integer> ordenaListaInsercion(List<Integer> li)
    {
        List<Integer> resultado;
        resultado = new ArrayList<>();
        int indice = 0;
        for (int i = 0; i < li.size(); i++) {
            if(resultado.size() > 0)
            {
                indice = 0;
                while(li.get(i) >= resultado.get(indice))
                {
                    indice++;
                    if (indice==resultado.size()) break;
                }
                resultado.add(indice, li.get(i));
            }
            else
            {
                resultado.add(li.get(i));
            }
        }
        return resultado;
    }

    private static List<Integer> ordenaListaSeleccion(List<Integer> li)
    {
        List<Integer> resultado;
        resultado = new LinkedList<>();
        int indice = 0;
        while(li.size()!=0) {
            int masPequenno = li.get(0);
            for (int i = 0; i < li.size(); i++) {
                if (li.get(i) <= masPequenno) {
                    masPequenno = li.get(i);
                    indice = i;
                }
            }
            li.remove(indice);
            resultado.add(masPequenno);
        }
        return resultado;
    }

    private static void eliminaNegativos(List<Integer> li)
    {
        List<Integer> li2;
        li2 = new ArrayList<>();
        for (Integer integer : li) {
            if (integer >= 0) {
                li2.add(integer);
            }
        }
        li.clear();
        for (int i = 0; i < li2.size(); i++) {
            li.add(li2.get(i));
        }
        li2.clear();
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

    private static void leeListaN(List<Integer> li, int n)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Escribe a continuación los " + n +" elementos de la lista:");
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            li.add(a);
        }
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

    private static void escribeBorraLista(List<Integer> li)
    {
        // Escribir todos los elementos de una lista e irlos borrando
        while(li.size() > 0)
        {
            System.out.println(li.get(0));
            li.remove(0);
        }
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

