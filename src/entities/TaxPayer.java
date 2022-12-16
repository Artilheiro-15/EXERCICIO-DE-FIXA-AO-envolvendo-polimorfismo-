package entities;

public abstract class TaxPayer {

  private String name;
  private Double anuallncome;

  public TaxPayer() {}

  public TaxPayer(String name, Double anuallncome) {
    this.name = name;
    this.anuallncome = anuallncome;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getAnuallncome() {
    return anuallncome;
  }

  public void setAnuallncome(Double anuallncome) {
    this.anuallncome = anuallncome;
  }

  // Esse e um metodo abstract ele nao vai ter implementaçao aki porque nao tem como eu dizer a
  //regra dos impostos na class generica eu so vou ter a regra de imposto nas clases especificas...
  public abstract double tax();
}
