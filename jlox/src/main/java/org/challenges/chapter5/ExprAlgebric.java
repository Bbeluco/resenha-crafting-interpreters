package org.challenges.chapter5;


public abstract class ExprAlgebric {

    abstract <R> R accept(Operations<R> operations);

    interface Operations<T> {
        T literal(Literal literal);
        T add(Add add);
        T multiply(Multiply multiply);
        T negate(Negate negate);
    }

    public static class Literal extends ExprAlgebric{
        final int value;

        Literal(int value) {
            this.value = value;
        }

        @Override
        <R> R accept(Operations<R> operations) {
            return operations.literal(this);
        }
    }

    public static class Add extends ExprAlgebric{
        final ExprAlgebric left, right;

        Add(ExprAlgebric left, ExprAlgebric right) {
            this.left = left;
            this.right = right;
        }

        @Override
        <R> R accept(Operations<R> operations) {
            return operations.add(this);
        }
    }

    public class Multiply extends ExprAlgebric{
        final ExprAlgebric left, right;

        Multiply(ExprAlgebric left, ExprAlgebric right) {
            this.left = left;
            this.right = right;
        }

        @Override
        <R> R accept(Operations<R> operations) {
            return operations.multiply(this);
        }
    }

    public class Negate extends ExprAlgebric{
        final ExprAlgebric expr;

        Negate(ExprAlgebric expr) {
            this.expr = expr;
        }

        @Override
        <R> R accept(Operations<R> operations) {
            return operations.negate(this);
        }
    }
}
