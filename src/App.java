import entities.Company;
import entities.Individual;
import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.println("======================================");
    System.out.print("Enter the number of tax payers: ");
    int N = sc.nextInt();
    System.out.println("======================================");

    //Raciosinio do polimorfismo: repara que o tipo da minha lista e "TaxPayer" e o tipo generico
    // isso e porque se eu usar o tipo generico a minha lista vai aceitar os dois tipos tanto (Individual quanto Campany)
    //como Individual e um texPayer a minha vareavel do tipo texPayer aceita o objeto istanciado do tipo Individual
    // isso e oque agente chama de upcasting
    List<TaxPayer> list = new ArrayList<TaxPayer>();

    for (int i = 1; i <= N; i++) {
      System.out.println("Tax payer #" + i + " data:");
      System.out.print("Individual or company (i/c)? ");
      char type = sc.next().charAt(0);
      System.out.print("Name: ");
      sc.nextLine();
      String name = sc.nextLine();
      System.out.print("Anual income: ");
      double anualIcome = sc.nextDouble();
      if (type == 'i') {
        System.out.print("Health expenditures: ");
        Double healthExpenditures = sc.nextDouble();
        System.out.println("======================================");

        //Como eu ja tenho todos os dados da pessoa fisica eu ja posso istanciar esse cara
        Individual x = new Individual(name, anualIcome, healthExpenditures);
        //Instanciei um Individual agr posso ir na list e add esse Individual
        list.add(x);
      } else {
        System.out.print("Number of employees: ");
        Integer numberOfEmployees = sc.nextInt();
        System.out.println("======================================");
        //Como eu ja tenho todos os dados da pessoa juritica eu ja posso istanciar esse cara e add na list
        list.add(new Company(name, anualIcome, numberOfEmployees));
      }
    }
    System.out.println("===============================================");
    System.out.println("TAXES PAID: ");
    for (TaxPayer tp : list) {
      System.out.println(
        tp.getName() + ": $ " + String.format("%.2f", tp.tax())
      );
      //Repare que na linha acima eu fis a chamada polimorfica

    }
    System.out.println("===============================================");
    double sum = 0.0;
    for (TaxPayer tp : list) {
      sum += tp.tax();
    }

    System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
    System.out.println("===============================================");
    sc.close();
  }
}
