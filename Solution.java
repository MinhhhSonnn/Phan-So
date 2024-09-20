public class Solution {

  private int numerator;
  private int denominator = 1;

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;

  }

  /**
   * A.
   */
  public void setDenominator(int denominator) {
    if (denominator != 0) {
      this.denominator = denominator;
    }
  }

  /**
   * A.
   */
  public Solution(int numerator, int denominator) {
    this.numerator = numerator;
    if (denominator != 0) {
      this.denominator = denominator;
    }
  }

  int gcd(int a, int b) {
    if (a % b == 0) {
      return b;
    }
    return gcd(b, a % b);
  }

  void reduce() {
    int a = gcd(denominator, numerator);
    denominator /= a;
    numerator /= a;
  }

  Solution add(Solution solution) {
    numerator = numerator * solution.getDenominator() + denominator * solution.getNumerator();
    denominator = denominator * solution.getDenominator();
    this.reduce();
    return this;
  }

  Solution subtract(Solution solution) {
    numerator = numerator * solution.getDenominator() - denominator * solution.getNumerator();
    denominator = denominator * solution.getDenominator();
    this.reduce();
    return this;
  }

  Solution multiply(Solution solution) {
    numerator = numerator * solution.getNumerator();
    denominator = denominator * solution.getDenominator();
    this.reduce();
    return this;
  }

  Solution divide(Solution solution) {
    if (solution.getNumerator() != 0 && solution.getDenominator() != 0) {
      numerator = numerator * solution.getDenominator();
      denominator = denominator * solution.getNumerator();
      this.reduce();
    }
    return this;
  }

  /**
   * A.
   */
  public boolean equals(Object obj) {
    if (obj instanceof Solution) {
      Solution other = (Solution) obj;
      other.reduce();
      ((Solution) obj).reduce();
      return numerator == other.getNumerator() && denominator == other.getDenominator();
    }
    return false;
  }
}
