package com.job.miniJVM;

public class Instrction {
    private final  Opcode opcode;
    private final int operand;

  public Instrction(Opcode opcode) {
      this(opcode,0);
  }
  public Instrction(Opcode opcode, int operand) {
      this.opcode = opcode;
      this.operand = operand;
  }
    public Opcode getOpcode() {
        return opcode;
    }

    public int getOperand() {
        return operand;
    }

}
