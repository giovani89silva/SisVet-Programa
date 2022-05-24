package Data;

import Model.Clinic;

import java.util.ArrayList;

public abstract class DataSetClinic {

    //coleção de clinicas cadastradas no sistema,
    //aqui a empresa poderia inserir todas as suas filiais por exemplo
    public static ArrayList<Clinic> data
            = new ArrayList<Clinic>();

    //Propriedade estática que será usada para
    //identificar qual a  clínica selecionada pelo
    // usuário para operações no sistema
    public static Clinic selectedClinic;

}
