Lexemes = Basically this is the minimum information a code can hold as substring to execute some action, think like this:

let abc = 123;

The lexemes in that line are:
let, abc, =, 123

These informations are lexemes because if we combine this (in the correct order) we can give the computer an instruction. In this case the instructions are

reserve a memory space (let)
call this memory space abc
set the value of memory to something (=)
the memory space that we addressed as abc now has the value 123.

When we combine (in the correct order) the lexemes we got a **token**

Challenges:
_1. The lexical grammars of Python and Haskell are not regular. What does that mean,and why aren't they?_
A regular grammar means a language that can be expressed with regular expressions or a deterministic (or non-deterministic) finite automata or state machine. Python needs indentation to based its scope, so identation cannot be expression with regular grammar, the same logic applies to haskell

_2. Aside from separating tokens—distinguishing **print foo** from **printfoo** spaces aren't used for much in most languages. However, in a couple of darkcorners, a space does a!ect how code is parsed in Co!eeScript, Ruby, and the C preprocessor. Where and what e!ect does it have in each of those languages?_
In some languages like coffeScript if we arbitrary introduces a space in some specifc pois the code dont run (reference)[https://stackoverflow.com/questions/9014970/why-does-coffeescript-require-whitespace-after-map]

_3. Our scanner here, like most, discards comments and whitespace since those aren't needed by the parser. Why might you want to write a scanner that does not discard those? What would it be useful for?_
Maybe in linters, if the linter discards the comments the code could get messy with the comments