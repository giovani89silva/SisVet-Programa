package View;

import Data.DataSetClinic;

import java.util.Scanner;

import Model.Vet;

import Controller.VetController;

import Controller.ClinicController;

public class VetView {
    
    public Vet vet = new Vet();
    private VetController vetController = new VetController();
    private Scanner sc = new Scanner(System.in);
    
    public VetView(){
                
    }
    
    public VetView( int indexClinic){
        DataSetClinic.data.get(indexClinic)
                .getVets().add(new Vet(1,"Giovani Silva", "123456"));
                
        DataSetClinic.data.get(indexClinic)
        .getVets().add(new Vet(2,"Roberto", "246810"));
        
        this.InitVetView();
    }
    
    private void InitVetView(){
        System.out.println("****************");
        System.out.println("MENU VETERINÁRIO");
        System.out.println("****************");
        
        System.out.println( DataSetClinic.selectedClinic.getVets().size()+
                "Veterinários Cadastrados.\n"
        );
        
        int op = 0;
        do{
            System.out.println("********");
            System.out.println("MENU VET");
            System.out.println("********");
            
            System.out.println("1-Incluir Veterinário");
            System.out.println("2-Selecionar Veterinário");
            System.out.println("3-Sair");
            
            op = Integer.parseInt(sc.nextLine());
            
            switch (op){
                case 1:
                    this.InsertVet();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;  
                default:
                    break;
                                     
            }           
        }  while( op!=0 );
    }
    
    private void InsertVet(){
        System.out.println("*******************");
        System.out.println("Incluir Veterinário");
        System.out.println("*******************");
        
        Vet newVet = new Vet();
        
        ClinicController clinicController = new ClinicController();
        int iClinic = clinicController.getClinicIndex(
                DataSetClinic.selectedClinic.getId()
        );
        
        newVet.setId( this.vetController.getNextId( iClinic ));
        System.out.println("Nome:");
        String nome = sc.nextLine();
        System.out.println("CRV:");
        String crv = sc.nextLine();
        
        newVet.setName(nome);
        newVet.setCRV(crv);
        
        this.vetController.insertVet(iClinic, newVet);
        
        System.out.println("Veterinário " + newVet.getName() + 
                "incluido com sucesso!");
    }
}
