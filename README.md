Rules for same precedence of prefix expressions:-

    1) If associativity is from left to right then push into the stack
    2)If associativity is from right to left then pop and check untill lower precednce is left in stack and then push the char
 ----------------------------------------------------------------------------------------------------------------------------------------
 Rules for same precedence of postfix expressions:-
 
    1) If associativity is left to right then pop and check until top is less than character then push the character in the stack
    2) If associativity is right to left then simply push the char into the stack
