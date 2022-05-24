package Controller;

import Model.Clinic;

import Data.DataSetClinic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClinicController implements IClinicController {

    @Override
    public void insertClinic(Clinic clinic) {
        DataSetClinic.data.add(clinic);
    }

    @Override
    public Clinic updateClinic(Clinic clinic) {
        return null;
    }

    @Override
    public Clinic deleteClinic(Clinic clinic) {
        DataSetClinic.data.remove(clinic);
        return clinic;
    }

    @Override
    public Clinic searchClinic(int id) {
        Clinic retorno = null;
        for (Clinic c : DataSetClinic.data) {
            if (c.getId() == id) {
                retorno = c;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Clinic searchClinic(String name) {
        Clinic retorno = new Clinic();
        for (int i = 0; i < DataSetClinic.data.size(); i++) {
            if (DataSetClinic.data.get(i)
                    .getName().toLowerCase().equals(name.toLowerCase())) {
                retorno = DataSetClinic.data.get(i);
                break;
            }
        }
        return retorno;
    }

    public int getNextId() {
        int id = 0;
        for (Clinic c : DataSetClinic.data) {
            if (c.getId() > id) {
                id = c.getId();
            }
        }
        return (id + 1);
    }

    public int getClinicIndex(int idClinic) {
        return DataSetClinic.data.indexOf(searchClinic(idClinic));
    }

    public void exportData() {
        System.out.println("LOG GERANDO ARQUIVO...");
        File arquivo = new File("ExportClinics.txt");

        String line = "";
        for (Clinic c : DataSetClinic.data) {
            line += c.getId() + ";"
                    + c.getName() + "\n";
        }
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);//converte string em bytes
            fos.write(line.getBytes());//escreve string em bytes
            fos.close();
            System.out.println("LOG ARQUIVO GERADO COM SUCESSO!");
        } catch (Exception ex) {
            System.out.println("LOG: ocorreu uma exceção!");
            System.out.println(ex.getMessage());
        }
    }

    public void importData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ATENÇÃO: INFORME O NOME DO ARQUIVO.TXT");
        String fileName = sc.nextLine();

        try {
            FileReader arq = new FileReader(fileName);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                Clinic clinic
                        = new Clinic(Integer.parseInt(dados[0]), dados[1]);
                this.insertClinic(clinic);
                
                linha = lerArq.readLine();

            }
            arq.close();

        } catch (IOException ex) {
            System.out.println("Erro ao tentar ler o arquivo.");
            System.out.println(ex.getMessage());

        }
    }

}
