package com.job.miniJVM;

import java.util.List;
import java.util.Map;

public class MINIJVM {



    public static void main(String[] args) {
        List<Instrction> program = List.of(new Instrction(Opcode.PUSH,30),
                new Instrction(
                        Opcode.PUSH, 20),

                new Instrction(
                        Opcode.SUB),

                new Instrction(
                        Opcode.PRINT),

                new Instrction(
                        Opcode.HALT)
        );
        MiniExecutionEngine engine =new MiniExecutionEngine(program);

        engine.execute();
    }
}
