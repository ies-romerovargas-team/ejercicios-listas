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
            System.out.println("9. ordenaListaPalabras");
            System.out.println("10. ordenaListaPalabras2");
            System.out.println("11. insertaArrayEnArrayPro");
            System.out.println("12. sorteoBonoloto");
            System.out.println("13. eliminaRepetidos");
            System.out.println("14. unionListas");
            System.out.println("15. interseccionListas");
            System.out.println("16. desordenaLista");
            System.out.println("17. modaLista");
            System.out.println("18. puntuacionesTrampolin");
            System.out.println("");
            System.out.print("\u001B[101m" + "\u001B[97m");
            //System.out.print();
            System.out.print("0. SALIR");
            System.out.println("\u001B[0m");

            try {
                System.out.println("Selecciona una opción (9-18)");
                opcion = sc.nextInt();
                List<Integer> l = new ArrayList<>();
                List<String> lista_1 = new LinkedList<>();
                List<String> lista_2 = new LinkedList<>();
                switch (opcion) {
                    case 9:
                        lista_1 = new LinkedList<>(Arrays.asList("perro", "gato", "ratón", "león", "abeja"));
                        System.out.print("Original: ");
                        escribeListaString(lista_1);
                        System.out.print("Ordenada: ");
                        escribeListaString(ordenaListaPalabras(lista_1));
                        break;
                    case 10: case 3:
                        lista_1 = new LinkedList<>(Arrays.asList("perro", "gato", "gorrión", "emu", "jirafa"));
                        System.out.print("Original: ");
                        escribeListaString(lista_1);
                        System.out.print("Ordenada: ");
                        escribeListaString(ordenaListaPalabras2(lista_1));
                        break;
                    case 11:
                        int[] array1 = {11,12,13,14,15,16,17,18,19};
                        int[] array2 = {21,22,23,24,25,26,27,28,29};
                        escribeArray(array1);
                        escribeArray(array2);
                        System.out.println("array1, 4, array2:");
                        escribeArray(insertaArrayEnArrayPro(array1, 4, array2));
                        break;
                    case 12:
                        for (int i = 0; i < 100; i++) {
                            escribeLista(sorteoBonoloto());
                        }
                        break;
                    case 13:
                        int[] a;
                        a = new int[8];
                        rellenaAleatorio2(a, -2, 15);
                        escribeArray(a);
                        escribeArray(eliminaRepetidos(a));
                        break;
                    case 14:
                        lista_1 = new LinkedList<>(Arrays.asList("perro", "gato", "ratón", "león", "abeja"));
                        lista_2 = new LinkedList<>(Arrays.asList("burro", "gato", "ratón", "caballo", "abeja"));
                        escribeListaString(lista_1);
                        escribeListaString(lista_2);
                        escribeListaString(unionListas(lista_1,lista_2));
                        break;
                    case 15:
                        lista_1 = new LinkedList<>(Arrays.asList("perro", "gato", "ratón", "león", "abeja"));
                        lista_2 = new LinkedList<>(Arrays.asList("burro", "gato", "ratón", "caballo", "abeja"));
                        escribeListaString(lista_1);
                        escribeListaString(lista_2);
                        escribeListaString(interseccionListas(lista_1,lista_2));
                        break;
                    case 16:
                        lista_1 = new LinkedList<>(Arrays.asList("burro", "gato", "ratón", "caballo", "abeja"));
                        escribeListaString(lista_1);
                        escribeListaString(desordenaLista(lista_1));
                        break;
                    case 17:
                        l = new LinkedList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 8, 8, 9));
                        escribeLista(l);
                        System.out.println(modaLista(l));
                        break;
                    case 18:
                        List<Double> puntos = new ArrayList<Double>();
                        puntos.add(3.81);
                        puntos.add(5.81);
                        puntos.add(7.81);
                        puntos.add(8.81);
                        puntos.add(12.81);
                        puntos.add(20.00);
                        puntos.add(3.81);
                        escribeListaDouble(puntos);
                        System.out.println(puntuacionesTrampolin(puntos));
                        break;
                    case 0:
                        salir = true;
                        break;

                    default:
                        System.out.println("ERROR: Solo números entre 9 y 18, ó 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes insertar un número");
                sc.next();
            }
        }
    }

    public static double puntuacionesTrampolin(List<Double> notas)
    {
        //Ordenamos la lista
        Collections.sort(notas);
        notas.remove(0);
        notas.remove(0);
        notas.remove(notas.size()-1);
        notas.remove(notas.size()-1);
        return notas.get(0) + notas.get(1) + notas.get(2);
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

    public static List<String> desordenaLista(List<String> list1)
    {
        Random r = new Random();
        List<String> list2 = new ArrayList<String>();
        list2.clear();
        int posicion = 0;
        while(list1.size()!=0)
        {
            if(list2.size()>0) {
                posicion = r.nextInt(list2.size());
            }
            list2.add(posicion,list1.get(0));
            list1.remove(list2.get(posicion));
        }
        return list2;
    }

    public static List<String> interseccionListas(List<String> list1, List<String> list2)
    {
        List<String> list3 = new ArrayList<String>();

        for (int i = 0; i < list1.size(); i++) {
            if(list2.contains(list1.get(i))){
                list3.add(list1.get(i));
            }
        }
        return list3;
    }

    public static List<String> unionListas(List<String> list1, List<String> list2)
    {
        List<String> list3 = new ArrayList<String>();

        for (int i = 0; i < list1.size(); i++) {
            if(!list3.contains(list1.get(i))){
                list3.add(list1.get(i));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if(!list3.contains(list2.get(i))){
                list3.add(list2.get(i));
            }
        }
        return list3;
    }

    public static int[] eliminaRepetidos(int[] a)
    {

        List<Integer> lista = new ArrayList<Integer>();
        lista.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            Integer elemento = a[i];
            lista.remove(elemento);
            lista.add(a[i]);
        }
        int[] b;
        b = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            b[i] = lista.get(i);
        }
        return b;
    }

    public static List<Integer> sorteoBonoloto()
    {
        Random r = new Random();

        //Creamos lista con 49 números
        ArrayList<Integer> bombo = new ArrayList<Integer>();
        for (int i = 1; i < 50; i++) {
            bombo.add(i);
        }
        //Creamos lista vacia
        ArrayList<Integer> combinacion = new ArrayList<Integer>();
        for (int j = 0; j < 6; j++) {
            int max = 49 - j;
            int aleatorio = r.nextInt(max);
            combinacion.add(bombo.get(aleatorio));
            bombo.remove(aleatorio);
        }
        return combinacion;
    }

    public static int[] insertaArrayEnArrayPro(int[] a, int pos, int[] b)
    {
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        int i, j;
        // insertar elementos de a desde 0 a pos
        for (i = 0; i < pos; i++) {
            auxiliar.add(a[i]);
        }
        // insertar elementos de b
        for (j = 0; j < b.length; j++) {
            auxiliar.add(b[j]);
        }
        //insertar resto elementos de a
        j = 0;
        for (i = pos; i < a.length; i++) {
            auxiliar.add(a[i]);
        }
        //convertir lista en array
        int longitud = a.length + b.length;
        int[] array = new int[longitud];
        for (i = 0; i < array.length; i++) {
            array[i] = auxiliar.get(i);
        }
        return array;
    }

    private static List<String> ordenaListaPalabras(List<String> lista)
    {
        Collections.sort(lista);
        return lista;
    }

    private static List<String> ordenaListaPalabras2(List<String> lista)
    {
        List<String> auxiliar;
        auxiliar = new LinkedList<>();
        int menor, indice;
        while (lista.size()!=0)
        {
            menor = lista.get(0).length();
            indice = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (menor > lista.get(i).length())
                {
                    menor = lista.get(i).length();
                    indice = i;
                }
            }
            auxiliar.add(lista.get(indice));
            lista.remove(indice);
        }
        return auxiliar;
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

    public static void escribeArray(int[] a) {
        int i;
        System.out.print("[");
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i]);
            System.out.print(", ");
        }
        System.out.print(a[a.length - 1]);
        System.out.println("]");
    }

    public static void rellenaAleatorio2(int[] a, int min, int max) {
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(max - min + 1) + min;
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
