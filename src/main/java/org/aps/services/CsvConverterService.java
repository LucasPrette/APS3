package org.aps.services;


import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;


public class CsvConverterService {

    String file = "APS3/src/main/java/org/aps/configs/lista-de-especies-ameacas-2020.csv";
    BufferedReader reader;
    String line = "";
    
    public CsvConverterService() {

    }
    int i = 0;

    public void csvToJson() {
        try {

            reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String result = line.replace("; ", ",");
                String[] row = result.split(";");

                String faunaFlora = row[0];
                String grupo = row[1];
                String familia = row[2];
                String especieSimp = row[3];
                String nomeComum = row[4];
                String categoriaAmeaca = row[5];
                String siglaCategoriaAmeaca = row[6];
                String bioma = row[7];
                String linha8 = row[8];
                String[] principaisAmeacas = linha8.split(",");
                String presencaAreasProt = row[9];
                String pan = row[10];
                String ordenamentoPesqueiro = row[11];
                String nivelProtecao = row[12];
                String especieExclusivaBR = row[13];
                String[] estadoOcorrencia = row[14].split(",");

                // Dado dados = new Dado(faunaFlora, grupo, familia, especieSimp, nomeComum, categoriaAmeaca,
                // siglaCategoriaAmeaca, bioma, principaisAmeacas, presencaAreasProt, pan, ordenamentoPesqueiro,
                // nivelProtecao, especieExclusivaBR, estadoOcorrencia);
                // data.add(dados);
               
            }

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        // return data;

    }
    
}
