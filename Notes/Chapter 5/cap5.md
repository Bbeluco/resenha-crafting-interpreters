In this chapter we're going to talk about **Representing Code**. To understand this we first need to know about

# Context-Free Grammars
A CFG is basically a group of rules that has _Tokens_, _Expressions_ and it depends on a _Parser_ to join all this information into a computer instructions.

## Rules for grammar
In a normal language (like portuguese or english) we have a huge amount of combinations that are considered valid, how can we manage almost an infinite number of grammar rules inside a computer?

The simple answer is: We can't.

To match this porpouse in a satisfatory way we can instead set just a few rules and create "phrases" from that rule, it work like this:

**breakfast** → **protein** "with" **breakfast** "on the side" ;
**breakfast** → **protein** ;
**breakfast** → **bread** ;

**protein** → **crispiness** "crispy" "bacon" ;
**protein** → "sausage" ;
**protein** → **cooked** "eggs" ;

**crispiness**  → "really" ;
**crispiness**  → "really" **crispiness** ;

**cooked** → "scrambled" ;
**cooked** → "poached" ;
**cooked** → "fried" ;

**bread** → "toast" ;
**bread** → "biscuits" ;
**bread** → "English muffin" ;

Here's our table, we basically can create any combination for breakfast as we want (assuming that we're following the rules defined in it).

Let's for example choose for **breakfast** the phrase _**protein** "with" **breakfast** "on the side"_

We'll as we chose this we need to change the **protein** and **breakfast** for its representations in the table.

For **protein** I chose _**crispiness** "crispy" "bacon"_, so we have again to choose something for **crispiness**, I chose _"really"_.

So far we have the following phrase

_"really" "crispy" "bacon" "with" **breakfast** "on the side"_

You can see the breakfast must be replace for something else, basically in this example we show that using just a couple of rules we can cover almost an infinite possible ways to write.

Challenges:

_1. Earlier, I said that the | , * , and + forms we added to our grammar metasyntax were just syntactic sugar. Given this grammar:expr → expr ( "(" ( expr ( "," expr  * )? ")" | "." IDENTIFIER )+ | IDENTIFIER | NUMBER Produce a grammar that matches the same language but does not use any of that notational sugar._

expr -> expr expr_list expr_list_tail expr_group | IDENTIFIER | NUMBER
expr_list -> expr expr_list_tail
expr_list_tail -> "," expr
expr_group -> "(" expr ")"

_Bonus: What kind of expression does this bit of grammar encode?_
((123), "ABC") 123