# Objectiu de la pràctica
### Aprendre a treballar amb fitxers de text utilitzant decoradors (BufferedReader, BufferedWriter), aplicar transformacions de text i xifrat simple (Cèsar).

1. Llegir un fitxer de text (entrada.txt) amb **BufferedReader**.
2. Per cada línia llegida:

    * Invertir la línia (exemple: "Hola món" → "nóm aloH").
    * Aplicar xifrat **Cèsar**: cada caràcter es desplaça N posicions en Unicode.

3. Escriure el resultat a un fitxer de sortida (xifrat.txt) utilitzant **BufferedWriter**.
4. Crear un mètode per desxifrar el fitxer:
    * Llegir el fitxer xifrat.
    * Aplicar **desplaçament invers** de la clau.
    * Tornar a invertir cada línia per recuperar el missatge original.
    * Escriure el resultat a desxifrat.txt.

5. Opcional: permetre que l’usuari introdueixi la clau de xifrat/desxifrat per consola.
6. Mostrar per consola missatges de progrés i errors.

# Flux de el programa Main.java
## Fase de Inversión concatenaria:
- En aquesta fase, s'inverteix la String obtenida per el bufferedReader.

    La inversió té efecte dintre de un bucle While:
    {
    
        while ((linia = brNormal.readLine()) != null) {
            String liniaInvertida = "";
            String liniaCifrada = "";
        
    Dintre del bucle While s'executa un ForEach encarregat de fer la inversió:
    {

        for (char c: linia.toCharArray()) {
            iniaInvertida = c+liniaInvertida;
        }
    
## Fase de Encriptació Cesar:
- En aquesta fase, s'encripta trasladant cada caràcter X numero de posicions.

    La encriptació es guarda a la variable interior del While de liniaCifrada agafant el valor que retorna el metode **cifradoCesar**.
    {

        private static String cifradoCesar(String input) {
            String liniaCifrada = "";

            for (char c: input.toCharArray()) {
                int ASCII = c+cesar;
                char letra = (char) ASCII;
                liniaCifrada = liniaCifrada+letra;
            }
            return liniaCifrada;
        }

    En el bucle For s'agafa el valor ASCII de cada lletra i es sumà el valor de Cesar.
    
    Una vegada tot correcte es fa un cast a char amb el nou valor trasladant així la lletra xnum de posicions.

    Per acabar es forma el string amb tota la linia Xifrada i es retorna amb el mètode.

## Fase de escriptura de xifrat.txt:
- En aquesta frase s'escriu el fitxer **xifrar.txt** i es tanquen els **decoradors(Buffers)**.

    {

        bwCifrado.write(liniaCifrada);
        bwCifrado.newLine();
        }

        brNormal.close();
        bwCifrado.close();

## Fase de desxifratge i escriptura de desxifrat.txt:
- El desxifratge de el fitxer **xifrat.txt** s'executa en 2 fases internes, al main on s'executa la escriptura de **desxifrat.txt** dintre de un bucle While. I el desxiframent a el mètode **descifrarFichero**.

### Desxifrar
Mètodo: {

    private static String descifrarFichero(String input) {
        String liniaDescifrada = "";

        // Bucle ForEach actuando sobre input para realizar el descifrado y ordenación de el string.
        for (char c: input.toCharArray()) {
            int ASCII = c-cesar;
            char letra = (char) ASCII;
            liniaDescifrada = letra+liniaDescifrada;
        }
        return liniaDescifrada;
    }

En el mètode recorrem cada càracter de input, el convertim a ASCII i després fem un cast char per tornar a tenir una lletra.

Una vegada comptem amb la lletra desxifrada, invertim la cadena abans de retornarla.

### Escriptura:
La escritura es realitza dintre del bucle While. {

    while ((linia = brCifrado.readLine()) != null) {
        bwDescifrado.write(descifrarFichero(linia));
        bwDescifrado.newLine();
    }

# Control de errors
- El exercici compta amb un catch per controlar les Excepcions amb missatges de control significatius:
{

        } catch (FileNotFoundException e) {
            System.err.println("Error crítico: No se encuentra la ruta del archivo.");
            System.err.println("Detalle del sistema: " + e.getMessage());
            System.err.println("Finalizando programa...");
        } catch (IOException e) {
            System.err.println("Error crítico: Problema de lectura o escritura en el archivo.");
            System.err.println("Detalle del sistema: " + e.getMessage());
            System.err.println("Finalizando programa...");
        }