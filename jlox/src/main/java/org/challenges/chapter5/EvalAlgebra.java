package org.challenges.chapter5;

public class EvalAlgebra implements ExprAlgebric.Operations<Integer> {
    Integer print(ExprAlgebric exprAlgebric) {
        return exprAlgebric.accept(this);
    }

    @Override
    public Integer literal(ExprAlgebric.Literal literal) {
        return literal.value;
    }

    @Override
    public Integer add(ExprAlgebric.Add add) {
        return ((ExprAlgebric.Literal)add.left).value + ((ExprAlgebric.Literal)add.right).value;
    }

    @Override
    public Integer multiply(ExprAlgebric.Multiply multiply) {
        return ((ExprAlgebric.Literal)multiply.left).value * ((ExprAlgebric.Literal)multiply.right).value;
    }

    @Override
    public Integer negate(ExprAlgebric.Negate negate) {
        return - ((ExprAlgebric.Literal)negate.expr).value;
    }
}
