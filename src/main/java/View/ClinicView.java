package View;

import java.util.Scanner;
import Controller.ClinicController;
import Model.Clinic;
import Data.DataSetClinic;

//Método Construtor da View de Clinica
//Quando a view clinica for instanciada, automaticamente,
//o metodo de incialização será invocado
public class ClinicView {

    private Scanner sc = new Scanner(System.in);
    private ClinicController clinicController = new ClinicController();

    public ClinicView() {
        DataSetClinic.data.add(new Clinic(1, "Amigo do Bicho"));
        DataSetClinic.data.add(new Clinic(2, "Pet Lovers"));
        this.InitClinicView();
    }

    private void InitClinicView() {
        System.out.println("**************************");
        System.out.println("***BEM VINDO AO SISVET ***");
        System.out.println("**************************");
        System.out.println("");

        System.out.println(DataSetClinic.data.size()
                + "clínicas cadastradas.");
        System.out.println("");

        int op = 0;
        do {
            System.out.println("*****");
            System.out.println("MENU");
            System.out.println("*****");

            System.out.println("1- Incluir Clínica");
            System.out.println("2- Selecionar Clínica");
            System.out.println("3- Exportar Clínicas");
            System.out.println("4- Importar Clínicas");
            System.out.println("0- Sair");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    this.InsertClinic();
                    break;
                case 2:
                    this.SelectClinic();
                    this.ShowMenuClinic();
                    break;
                case 3:
                    this.clinicController.exportData();
                    break;
                case 4:
                    this.clinicController.importData();
                    break;
                case 0:
                    System.out.println("Encerrando Clínica...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (op != 0);
    }

    private void SelectClinic() {
        int op = 0;
        do {
            System.out.println("Selecione o código da Clínica");
            for (Clinic c : DataSetClinic.data) {
                System.out.println(c.getId() + " - " + c.getName());
            }
            op = sc.nextInt();
            DataSetClinic.selectedClinic
                    = this.clinicController.searchClinic(op);
            if (DataSetClinic.selectedClinic == null) {
                System.out.println("Clínica Inválida.");
                op = 0;
            }
        } while (op == 0);

    }

    private void InsertClinic() {
        System.out.println("********************");
        System.out.println("Inserir Nova Clínica");
        System.out.println("********************");

        Clinic newClinic = new Clinic();
        newClinic.setId(this.clinicController.getNextId());
        System.out.println("Nome:");
        String name = sc.nextLine();
        newClinic.setName(name);
        this.clinicController.insertClinic(newClinic);
    }

    private void ShowMenuClinic() {

        int opcao = 0;
        do {
            System.out.println("************");
            System.out.println("MENU CLÍNICA");
            System.out.println("************");
            System.out.println("Você está em CLÍNICA: "
                    + DataSetClinic.selectedClinic.getId() + "-"
                    + DataSetClinic.selectedClinic.getName()
            );
            System.out.println("");

            System.out.println("1- Veterinário");
            System.out.println("2- Animal");
            System.out.println("3- Atendimento");
            System.out.println("0- Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // refatorar acesso ao metodo getclinicindex
                    VetView vetview = new VetView(
                    this.clinicController.getClinicIndex(
                            DataSetClinic.selectedClinic.getId()
                        )
                    );
                    break;
                case 2:
                    AnimalView animalView = new AnimalView();
                    break;

                case 3:
                    //chamar view do Atendimento
                    break;
                case 0:
                    System.out.println("Saindo da Clínica.....");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    opcao = 0;
                    break;

            }
        } while (opcao != 0);

    }

}
