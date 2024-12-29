package org.challenges.chapter5;

public class Runner {
    public static void main(String[] args) {
        ExprAlgebric algebric = new ExprAlgebric.Add(
                new ExprAlgebric.Literal(1),
                new ExprAlgebric.Literal(2)
        );
        EvalAlgebra evalAlgebra = new EvalAlgebra();
        System.out.println(evalAlgebra.print(algebric));
    }
}
