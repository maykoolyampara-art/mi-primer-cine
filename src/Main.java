import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner maykool = new Scanner(System.in);

        final int FILAS = 5;
        final int COLUMNAS = 5;

        boolean[][] asientos = new boolean[FILAS][COLUMNAS];

        String[] productos = new String[50];
        double[] precios = new double[50];

        int contador = 0;
        int opcion;
        int fila, columna;

        do {
            System.out.println("==== SISTEMA DE CINE =====");
            System.out.println("1. Mostrar asientos libres");
            System.out.println("2. Mostrar asientos ocupados");
            System.out.println("3. Comprar una butaca");
            System.out.println("4. Comprar palomitas");
            System.out.println("5. Comprar gaseosas");
            System.out.println("6. Mostrar boleto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = maykool.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("ASIENTOS LIBRES (L = Libre, X = Ocupado)");

                    for (int i = 0; i < FILAS; i++) {
                        for (int j = 0; j < COLUMNAS; j++) {
                            if (!asientos[i][j]) {
                                System.out.print("[L] ");
                            } else {
                                System.out.print("[X] ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("ASIENTOS OCUPADOS:");

                    for (int i = 0; i < FILAS; i++) {
                        for (int j = 0; j < COLUMNAS; j++) {
                            if (asientos[i][j]) {
                                System.out.print("[X] ");
                            } else {
                                System.out.print("[-] ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("COMPRAR BUTACA");
                    System.out.print("Ingrese la fila (1-5): ");
                    fila = maykool.nextInt();

                    System.out.print("Ingrese la columna (1-5): ");
                    columna = maykool.nextInt();

                    if (fila >= 1 && fila <= FILAS &&
                            columna >= 1 && columna <= COLUMNAS) {

                        if (!asientos[fila - 1][columna - 1]) {
                            asientos[fila - 1][columna - 1] = true;

                            productos[contador] = "Butaca F" + fila + " C" + columna;
                            precios[contador] = 15.00;
                            contador++;

                            System.out.println("Butaca comprada: S/ 15.00");
                        } else {
                            System.out.println("La butaca ya esta ocupada.");
                        }

                    } else {
                        System.out.println("Fila o columna incorrecta.");
                    }
                    break;

                case 4:
                    System.out.println("COMPRA DE PALOMITAS");
                    System.out.println("1. Pequenas - S/ 8.00");
                    System.out.println("2. Medianas - S/ 12.00");
                    System.out.println("3. Grandes - S/ 16.00");
                    System.out.print("Seleccione el tamano: ");

                    int tipoPalomitas = maykool.nextInt();

                    if (tipoPalomitas >= 1 && tipoPalomitas <= 3
                            && contador < productos.length) {

                        productos[contador] = "Palomitas";
                        precios[contador] = tipoPalomitas == 1 ? 8.00 :
                                tipoPalomitas == 2 ? 12.00 : 16.00;

                        contador++;

                        System.out.println("Palomitas agregadas al boleto.");
                    } else {
                        System.out.println("Opcion incorrecta o carrito lleno.");
                    }
                    break;

                case 5:
                    System.out.println("COMPRA DE GASEOSAS");
                    System.out.println("1. Pequena - S/ 4.00");
                    System.out.println("2. Mediana - S/ 6.00");
                    System.out.println("3. Grande - S/ 8.00");
                    System.out.print("Seleccione el tamano: ");

                    int tipoGaseosa = maykool.nextInt();

                    if (tipoGaseosa >= 1 && tipoGaseosa <= 3
                            && contador < productos.length) {

                        productos[contador] = "Gaseosa";
                        precios[contador] = tipoGaseosa == 1 ? 4.00 :
                                tipoGaseosa == 2 ? 6.00 : 8.00;

                        contador++;

                        System.out.println("Gaseosa agregada al boleto.");
                    } else {
                        System.out.println("Opcion incorrecta o carrito lleno.");
                    }
                    break;

                case 6:
                    System.out.println("========== BOLETO DE CINE ==========");

                    double total = 0;

                    if (contador == 0) {
                        System.out.println("No hay compras registradas.");
                    } else {
                        for (int i = 0; i < contador; i++) {
                            System.out.println(productos[i] +
                                    " - S/ " +
                                    String.format("%.2f", precios[i]));

                            total += precios[i];
                        }

                        System.out.println("------------------------------------");
                        System.out.printf("TOTAL A PAGAR: S/ %.2f%n", total);
                    }

                    System.out.println("====================================");
                    break;

                case 7:
                    System.out.println("Gracias por visitar nuestro cine.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }

        } while (opcion != 7);

        maykool.close();
    }
}
