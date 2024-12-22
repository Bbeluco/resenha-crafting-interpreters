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