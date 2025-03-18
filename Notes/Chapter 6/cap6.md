As we move forward into creating a syntax, there's one important concept that we may not forget, this is **the precedence parsing expressions**

# Parsing expression
This problem comes way before computers, in math we do have a problem when trying to evaluate some expressions, let's see an example

Image you have the following expression

6 / 3 - 1

What is the correct answer?
Well, the correct way to solve the question is dividing the problem into pieces

1. 6 / 3 = 2
2. 2 - 1 = 1

That's right, but what if we want to evaluate the 3 - 1 first? In this case we can use the () operator to show the person that this part of the equation must be done first of all.

The same logic we apply here while creating compilers. Those concepts are called

**Precedence**: When you define one grup that must be evaluated before another
**Associativity**: Then you define the order to evaluate things (left-to-right (example math expressions) right-to-left (example assign value to a variable))

## Parser responsabilities
The parser has two main responsabilities

Produce a syntax tree based on tokens previous input
Detect errors and tell the user about it

The second part is so important that in the book theres a section just talking about it.

### Syntax Errors
Devs make errors everytime, is up to the IDE show them this kind of error and try help them how to solve it. The IDEs has also a hard work to do, thats because user may input invalid code but IDE while trying parsing it should not crash or getting stuck (this is because the code that's been writting is not the oficial code so far)

A decent parser should

1. Be fast
2. Report any distict error as there are
3. Minimize cascade errors

The 2 last point are the most polemic, that's because the user can make an error, and the entire line (and the following) being affected by this error. As developers, we don't want our code be entirely red just because one single error. This is a little hard to do, to achieve this behaviour we should setup limits to our parser, that way when it sees the limit no more line will consider affected by the previous one, this is called **panic mode**, and the "limit" that we setup is called **synchronization**