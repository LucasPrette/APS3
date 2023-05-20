package org.aps.views;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.List;

class Teste {
    private Boolean type;
    private String grupo;
    private String familia;
    private String specie;
    private String name;
    private String category;
    private String bioma;
    private String threat;
    private String occurrence;


    public Teste () {};

    public Teste
    (
        Boolean type,
        String grupo,
        String familia,
        String specie,
        String name,
        String category,
        String bioma,
        String occurrence,
        String threat
    )
    {
        this.type = type;
        this.grupo = grupo;
        this.familia = familia;
        this.specie = specie;
        this.name = name;
        this.category = category;
        this.bioma = bioma;
        this.occurrence = occurrence;
        this.threat = threat;
    }

    public String getBioma() {
        return bioma;
    }
    public String getCategory() {
        return category;
    }
    public String getFamilia() {
        return familia;
    }
    public String getGrupo() {
        return grupo;
    }

    public String getName() {
        return name;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public String getSpecie() {
        return specie;
    }

    public Boolean getType() {
        return type;
    }
    
    public String getThreat() {
        return threat;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }



    public ArrayList<Teste> faker() {
        ArrayList<Teste> list = new ArrayList<Teste>();
        for(int i = 0; i < 1001; i++){
            Teste t = new Teste(true, "Grupo" + i, "Familia" + i, "specie" + i, "-", "VU", "mata atlantica", "PR","ameaça" +i);
            list.add(t);
        }

        return list;
    }

}

public class AddDataTable {
    
    public TableModel addRowToJTable() {
        Teste n = new Teste();

        ArrayList<Teste> endangeredSpecies = n.faker();

        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String[]> values = new ArrayList<String[]>();

        columns.add("Fauna/Flora");
        columns.add("Grupo");
        columns.add("Familia");
        columns.add("Especie(simplificado)");
        columns.add("Nome comum");
        columns.add("Categoria ameaça");
        columns.add("Bioma");
        columns.add("Principais ameaças");
        columns.add("Estados de Ocorrências");

        

        for (int i = 0; i < 100; i++) {
            values.add(
                new String[] 
                {
                    String.valueOf(endangeredSpecies.get(i).getType()),
                    endangeredSpecies.get(i).getGrupo(),
                    endangeredSpecies.get(i).getFamilia(),
                    endangeredSpecies.get(i).getSpecie(),
                    endangeredSpecies.get(i).getName(),
                    endangeredSpecies.get(i).getCategory(),
                    endangeredSpecies.get(i).getBioma(),
                    endangeredSpecies.get(i).getThreat(),
                    endangeredSpecies.get(i).getOccurrence()
                }
                );
        }

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

        return tableModel;
    }

}