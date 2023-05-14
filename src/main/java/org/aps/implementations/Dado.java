package org.aps.implementations;

import java.util.ArrayList;

import org.aps.services.Converter;

public class Dado {
    static private ArrayList<Dado> dados;
    
    private String faunaFlora;
    private String grupo;
    private String familia;
    private String especieSimp;
    private String nomeComum;
    private String categoriaAmeaca;
    private String siglaCategoriaAmeaca;
    private String bioma;
    String[] principaisAmeacas;
    private String presencaAreasProt;
    private String pan;
    private String ordenamentoPesqueiro;
    private String nivelProtecao;
    private String especieExclusivaBR;
    String[] estadoOcorrencia;

    public Dado() {

    }

    public Dado(String faunaFlora, String grupo, String familia, String especieSimp, String nomeComum,
            String categoriaAmeaca, String siglaCategoriaAmeaca, String bioma, String[] principaisAmeacas,
            String presencaAreasProt, String pan, String ordenamentoPesqueiro, String nivelProtecao,
            String especieExclusivaBR, String[] estadoOcorrencia) {

        this.faunaFlora = faunaFlora;
        this.grupo = grupo;
        this.familia = familia;
        this.especieSimp = especieSimp;
        this.nomeComum = nomeComum;
        this.categoriaAmeaca = categoriaAmeaca;
        this.siglaCategoriaAmeaca = siglaCategoriaAmeaca;
        this.bioma = bioma;
        this.principaisAmeacas = principaisAmeacas;
        this.presencaAreasProt = presencaAreasProt;
        this.pan = pan;
        this.ordenamentoPesqueiro = ordenamentoPesqueiro;
        this.nivelProtecao = nivelProtecao;
        this.especieExclusivaBR = especieExclusivaBR;
        this.estadoOcorrencia = estadoOcorrencia;
    }
    
    // getters

    public String getFaunaFlora() {
        return faunaFlora;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getFamilia() {
        return familia;
    }

    public String getEspecieSimp() {
        return this.especieSimp;
    }

    public String getNomeComum() {
        return this.nomeComum;
    }

    public String getCategoriaAmeaca() {
        return this.categoriaAmeaca;

    }

    public String getSiglaCategoriaAmeaca() {
        return this.siglaCategoriaAmeaca;
    }

    public String getBioma() {
        return this.bioma;
    }

    public String[] getPrincipaisAmeacas() {
        return this.principaisAmeacas;
    }

    public String getPresencaAreasProt() {
        return this.presencaAreasProt;
    }

    public String getPan() {
        return this.pan;
    }

    public String getOrdenamentoPesqueiro() {
        return this.ordenamentoPesqueiro;
    }

    public String getNivelProtecao() {
        return this.nivelProtecao;
    }

    public String getEspecieExclusivaBR() {
        return this.especieExclusivaBR;
    }

    public String[] getEstadoOcorrencia() {
        return this.estadoOcorrencia;
    }

    // setters

    public void setFaunaFlora(String faunaFlora) {
        this.faunaFlora = faunaFlora;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setEspecieSimp(String especieSimp) {
        this.especieSimp = especieSimp;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public void setCategoriaAmeaca(String categoriaAmeaca) {
        this.categoriaAmeaca = categoriaAmeaca;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public void setPrincipaisAmeacas(String[] principaisAmeacas) {
        this.principaisAmeacas = principaisAmeacas;
    }

    public void setPresencaAreasProt(String presencaAreasProt) {
        this.presencaAreasProt = presencaAreasProt;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setOrdenamentoPesqueiro(String ordenamentoPesqueiro) {
        this.ordenamentoPesqueiro = ordenamentoPesqueiro;
    }

    public void setNivelProtecao(String nivelProtecao) {
        this.nivelProtecao = nivelProtecao;
    }

    public void setEspecieExclusivaBR(String especieExclusivaBR) {
        this.especieExclusivaBR = especieExclusivaBR;
    }

    public void setEstadoOcorrencia(String[] estadoOcorrencia) {
        this.estadoOcorrencia = estadoOcorrencia;
    }

    public void insertData() {
        Converter convert = new Converter();
        dados = convert.csvToJson();
    }

    public void printData() {
        for (int i = 1; i < dados.size(); i++) {
            System.out.println();
            System.out.printf("%s: %s %n", dados.get(0).getFaunaFlora(),dados.get(i).getFaunaFlora());
            System.out.printf("%s: %s %n", dados.get(0).getGrupo(),dados.get(i).getGrupo());
            System.out.printf("%s: %s %n", dados.get(0).getFamilia(),dados.get(i).getFamilia());
            System.out.printf("%s: %s %n", dados.get(0).getEspecieSimp(),dados.get(i).getEspecieSimp());
            System.out.printf("%s: %s %n", dados.get(0).getNomeComum(),dados.get(i).getNomeComum());
            System.out.printf("%s: %s %n", dados.get(0).getCategoriaAmeaca(),dados.get(i).getCategoriaAmeaca());
            System.out.printf("%s: %s %n", dados.get(0).getSiglaCategoriaAmeaca(),dados.get(i).getSiglaCategoriaAmeaca());
            System.out.printf("%s: %s %n", dados.get(0).getBioma(),dados.get(i).getBioma());
            System.out.printf("%s: %n", dados.get(0).getPrincipaisAmeacas()[0]);
            for(int j = 0; j < dados.get(i).getPrincipaisAmeacas().length; j++){
                System.out.print(dados.get(i).getPrincipaisAmeacas()[j]);
            }
            System.out.printf("%s: %s %n", dados.get(0).getPresencaAreasProt(),dados.get(i).getPresencaAreasProt());
            System.out.printf("%s: %s %n", dados.get(0).getPan(), dados.get(i).getPan());
            System.out.printf("%s: %s %n", dados.get(0).getOrdenamentoPesqueiro(),dados.get(i).getOrdenamentoPesqueiro());
            System.out.printf("%s: %s %n", dados.get(0).getNivelProtecao(),dados.get(i).getNivelProtecao());
            System.out.printf("%s: %s %n", dados.get(0).getEspecieExclusivaBR(),dados.get(i).getEspecieExclusivaBR());
            System.out.printf("%s: %n", dados.get(0).getEstadoOcorrencia()[0]);
            for(int j = 0; j < dados.get(i).getEstadoOcorrencia().length; j++) {
                System.out.println(dados.get(i).getEstadoOcorrencia()[j]);
            }
        }
        System.out.println(dados.size());

    }

    public static void main(String[] args) {
        Dado data = new Dado();
        data.insertData();

        
        // impressao de dados para testes 
        // data.printData();
    }

}
