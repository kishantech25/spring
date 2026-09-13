package com.job.miniJVM;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class MiniExecutionEngine {

    private final List<Instrction> bytecode;

    private final Deque<Integer> operandStack =new ArrayDeque<>();

    private int pc =0;
    Map<Integer, Long> executionCount;

    public MiniExecutionEngine(List<Instrction> bytecode) {
        this.bytecode = bytecode;
    }


    public void execute() {
        while (true) {
            Instrction instrction = bytecode.get(pc);
            executionCount.merge(
                    pc,
                    1L,
                    Long::sum
            );
            System.out.println(
                    "PC = " + pc
                            + " Instruction = "
                            + instrction.getOpcode()
                            + " Stack = "
                            + operandStack
            );

            switch (instrction.getOpcode()) {
                case PUSH:
                    operandStack.push(instrction.getOperand());
                    pc++;
                    break;
                case ADD:
                    int a =operandStack.pop();
                    int b=operandStack.pop();

                    operandStack.push(a+b);
                    pc++;
                    break;
               case SUB:

                   int x=operandStack.pop();
                   int y=operandStack.pop();
                   operandStack.push(y-x);
                   pc++;
                   break;
               case MUL:

                   int m =operandStack.pop();
                   int n=operandStack.pop();
                   operandStack.push(m*n);
                   pc++;
                   break;
                case PRINT:
                    System.out.println(operandStack.pop());
                    pc++;
                    break;

                case HALT:
                    return;
            }
        }
    }



}
