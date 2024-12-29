package org.challenges.chapter5;

public class PrettyPrintExprAlgebric implements ExprAlgebric.Operations<Integer>{
    @Override
    public Integer literal(ExprAlgebric.Literal literal) {
        return 0;
    }

    @Override
    public Integer add(ExprAlgebric.Add add) {
        return 0;
    }

    @Override
    public Integer multiply(ExprAlgebric.Multiply multiply) {
        return 0;
    }

    @Override
    public Integer negate(ExprAlgebric.Negate negate) {
        return 0;
    }
}
