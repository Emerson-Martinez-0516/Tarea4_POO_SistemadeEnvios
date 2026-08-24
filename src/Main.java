import java.util.Scanner;

public class Main {


        private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        boolean salir = false;

        while (!salir) {
            mostrarmenu();
            int opcion = leerOpcionMenu();

            switch (opcion){
                case 1:
                    registEnvioNacional();
                    break;
                case 2:
                    registEnvioInternacional();
                    break;
                case 3:
                    salir = true;
                    System.out.printf("Saliendo del sistema");
                    break;
            }

        }
    scan.close();
    }

    private static void mostrarMenu(){
        System.out.printf("Sistema de Envíos");
        System.out.println("1. Registrar envío nacional");
        System.out.println("2. Registrar envío internacional");
        System.out.printf("3. Salir");
        System.out.println("Seleccine un opción: ");
    }

    private static int leerOpcionMenu() {
        while (true) {
            String entrada = scan.nextLine().trim();
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Opcioón inválida. Ingrese 1, 2 o 3: ");
        }
    }


        private static void registEnvioNacional() {
            System.out.println("Registro de envío nacional");

            String codigo = leerTextoNVacio("Código del envío: ");
            String destinatario = leerTextoNVacio("Nombre del destinatario: ");
            double peso = leerDoublePositivo("Peso del paquete (kg): ");
            String departamento = leerTextoNVacio("Departamento de destino: ");
            double distancia = leerDoublePositivo("Distancia del envío (km): ");

            // Se guarda en una variable de tipo Envio (polimorfismo)
            Envio envio = new EnvioNacional(codigo, destinatario, peso, departamento, distancia);

            System.out.println("Envío registrado con éxito.");
            envio.mostrarResumen(true); // se usa la versiÃ³n sobrecargada con desglose completo

            preguntaOtroRegistro();
        }



        private static void preguntaOtroRegistro() {
            System.out.print("¿Desea registrar otro envío? (S/N): ");
            String respuesta = scan.nextLine().trim().toUpperCase();
            if (!respuesta.equals("S")) {
                System.out.println("Regresando al menú principal...");
            }
        }

        private static String leerTextoNVacio(String mensaje){
            String texto;
            while (true){
                System.out.println(mensaje);
                texto = scan.nextLine().trim();
                if(!texto.isEmpty()){
                    return texto;
                }
                System.out.println("Intente de nuevo.");
            }
        }

        private static double leerDoublePositivo(String mensaje){
            while (true){
                System.out.println(mensaje);
                String entrada = scan.nextLine().trim();
                try {
                    double valor = Double.parseDouble(entrada);
                    if(valor > 0){
                        return valor;
                    }
                    System.out.println("El valor debe ser mayor a cero");
                }catch (NumberFormatException e){
                    System.out.println("Debe ingresar un número válido");
                }
            }
        }
    }

