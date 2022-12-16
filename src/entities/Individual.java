package entities;

public class Individual extends TaxPayer {

  private Double healthExpenditures;

  public Individual() {
    super();
  }

  public Individual(
    String name,
    Double anuallncome,
    Double healthExpenditures
  ) {
    super(name, anuallncome);
    this.healthExpenditures = healthExpenditures;
  }

  public Double getHealthExpenditures() {
    return healthExpenditures;
  }

  public void setHealthExpenditures(Double healthExpenditures) {
    this.healthExpenditures = healthExpenditures;
  }

  @Override
  public double tax() {
    // double basicTax = (getAnuallncome() < 20000.0) ? getAnuallncome() * 0.15 : getAnuallncome() * 0.25;

    double basicTax;
    if (getAnuallncome() < 20000.0) {
      basicTax = getAnuallncome() * 0.15;
    } else {
      basicTax = getAnuallncome() * 0.25;
    }
    basicTax = basicTax - getHealthExpenditures() * 0.5;
    if (basicTax < 0.0) {
      return 0.0;
    } else {
      return basicTax;
    }
  }
}
