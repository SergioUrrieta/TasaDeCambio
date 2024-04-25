import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Converter {
    private static final String API_KEY = "5d8c3d86de664d44f46f6605";

    public static void main(String[] args) {
        // Menú de opciones
        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Convertir de dólar a peso colombiano");
            System.out.println("2. Convertir de peso colombiano a dólar");
            System.out.println("3. Convertir de dólar a peso argentino");
            System.out.println("4. Convertir de peso argentino a dolar");
            System.out.println("5 convertir de dolar a Bolivares Linda Venezuela");
            System.out.println("6. Convertir de Bolivares Linda Venezuela a dolar");
            // Agrega más opciones según tus necesidades

            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = obtenerEntradaNumerica();

            switch (opcion) {
                case 1:
                    convertirUSDToCOP();
                    break;
                case 2:
                    convertirCOPToUSD();
                    break;
                case 3:
                    convertirUSDToARS();
                    break;
                case 4:
                    convertirARSToUSD();
                    break;
                case 5:
                    convertirUSDToVNZ();
                    break;
                case 6:
                    convertirVNZToUSD();
                    break;
                // Agrega más casos según tus necesidades

                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }

    private static int obtenerEntradaNumerica() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void convertirUSDToCOP() {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
            System.out.println("Ingrese la cantidad en dólares a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaCambio;
            System.out.println("El resultado es: " + resultado + " pesos colombianos.");
        } catch (Exception e) {
            System.out.println("Error al convertir de dólar a peso colombiano: " + e.getMessage());
        }
    }

    private static void convertirCOPToUSD() {
        // Método para convertir de peso colombiano a dólar
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
            double tasaUSDToCOP = 1 / tasaCambio; // Obtenemos la tasa de cambio de COP a USD
            System.out.println("Ingrese la cantidad en pesos colombianos a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaUSDToCOP;
            System.out.println("El resultado es: " + resultado + " dólares.");
        } catch (Exception e) {
            System.out.println("Error al convertir de peso colombiano a dólar: " + e.getMessage());
        }
    }

    private static void convertirUSDToARS() {
        // Método para convertir de dólar a peso argentino
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();
            System.out.println("Ingrese la cantidad en dólares a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaCambio;
            System.out.println("El resultado es: " + resultado + " pesos argentinos.");
        } catch (Exception e) {
            System.out.println("Error al convertir de dólar a peso argentino: " + e.getMessage());
        }
    }

    private  static void convertirARSToUSD(){
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/ARS";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
            double tasaUSDtoARS = 1 / tasaCambio; // Obtenemos la tasa de cambio de USD a ARS
            System.out.println("Ingrese la cantidad en pesos argentinos a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaUSDtoARS;
            System.out.println("El resultado es: " + resultado + " dólares.");
        } catch (Exception e) {
            System.out.println("Error al convertir de peso argentino a dólar: " + e.getMessage());
        }
    }

    private static void convertirUSDToVNZ(){
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("VES").getAsDouble();
            System.out.println("Ingrese la cantidad en dólares a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaCambio;
            System.out.println("El resultado es: " + resultado + " bolívares soberanos.");
        } catch (Exception e) {
            System.out.println("Error al convertir de dólar a bolívar soberano: " + e.getMessage());
        }
    }

    public static void convertirVNZToUSD(){
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/VES";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            double tasaCambio = jsonResponse.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
            double tasaUSDtoVES = 1 / tasaCambio; // Obtenemos la tasa de cambio de USD a VES
            System.out.println("Ingrese la cantidad en bolívares soberanos a convertir:");
            double cantidad = obtenerEntradaNumerica();
            double resultado = cantidad * tasaUSDtoVES;
            System.out.println("El resultado es: " + resultado + " dólares.");
        } catch (Exception e) {
            System.out.println("Error al convertir de bolívar soberano a dólar: " + e.getMessage());
        }
    }

    // Agrega más métodos de conversión según tus necesidades
}
