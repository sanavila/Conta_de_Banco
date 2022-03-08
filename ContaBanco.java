package exercicio1;

public class ContaBanco {
  public int numConta;
  protected String tipo;
  private String dono;
  private float saldo;
  private boolean status;

  public void estadoAtual() {
    System.out.println("______________________________");
    System.out.println("Conta: " + this.getNumConta());
    System.out.println("Tipo: " + this.getTipo());
    System.out.println("Dono: " + this.getDono());
    System.out.println("Saldo: " + this.getSaldo());
    System.out.println("Status: " + this.getStatus());
  }

  public ContaBanco() {
    this.setSaldo(0);
    this.setStatus(false);
  }

  public ContaBanco(int numero, String dono, String tipoConta) {
    this.setNumConta(numero);
    this.setDono(dono);
    this.abrirConta(tipoConta);
  }

  public void abrirConta(String tipo) {
    this.setTipo(tipo);
    this.setStatus(true);
    switch (tipo) {
      case "corrente":
        this.setSaldo(50);
        break;
      case "poupança":
        this.setSaldo(150);
        break;
      default:
        this.setStatus(false);
    }

    System.out.println(
      this.getStatus() ?
        "Conta aberta com sucesso!" : 
        "Falha na abertura da conta."
    );
  }

  public void fecharConta() {
    if (this.getSaldo() > 0) {
      System.out.println("Conta ainda tem saldo");
    } else if (this.getSaldo() < 0) {
      System.out.println("Conta não pode ser fechada pois tem débito");
    } else {
      this.setStatus(false);
      System.out.println("Conta fechada com sucesso");
    }
  }

  public void depositar(float valorDeposito) {
    if (this.getStatus()) {
      this.setSaldo(this.getSaldo() + valorDeposito);
      System.out.println("Depósito realizado com sucesso na conta de " + this.getDono());
    } else {
      System.out.println("Impossível depositar em uma conta fechada");
    }
  }

  public void sacar(float valorSaque) {
    if (this.getStatus()) {
      if (this.getSaldo() >= valorSaque) {
        this.setSaldo(this.getSaldo() - valorSaque);
        System.out.println("Saque realizado na conta de " + this.getDono());
      } else {
        System.out.println("Saldo insuficiente para saque");
      }
    } else {
      System.out.println("Impossível sacar de uma conta fechada");
    }
  }

  public void pagarMensal() {
    int mensalidade = 0;
    if (this.getTipo() == "corrente") {
      mensalidade = 12;
    } else if (this.getTipo() == "poupança") {
      mensalidade = 20;
    }
    if (this.getStatus()) {
      this.setSaldo(this.getSaldo() - mensalidade);
      System.out.println("Mensalidade paga com sucesso por " + this.getDono());
    } else {
      System.out.println("Impossível pagar uma conta fechada");
    }

  }

  public int getNumConta() {
    return this.numConta;
  }

  public void setNumConta(int numConta) {
    this.numConta = numConta;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDono() {
    return this.dono;
  }

  public void setDono(String dono) {
    this.dono = dono;
  }

  public float getSaldo() {
    return this.saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}