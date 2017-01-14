<h1 align="center">Calculator</h1>

## Introduction
### Definitions
<dl>
  <dt>Function</dt>
  <dd>Takes one or more arguments and evaluates to a single number</dd>
  <dt>Operator</dt>
  <dd>A mathematical function that has two arguments and is written in infix notation</dd>
  <dt>Operand</dt>
  <dd>A numerical argument to an operator</dd>
  <dt>Expression</dt>
  <dd>A syntactically correct string of numbers and operators</dd>
  <dt>Result</dt>
  <dd>The evaluation of an expression</dd>
  <dt>Field</dt>
  <dd>The text area that acts as a display for expressions</dd>
  <dt>Precedence</dt>
  <dd>Determines the order of operations</dd>
</dl>

### Purpose
The purpose of this document is to specify the requirements of the client-requested calculator.
This document tries to state all necessary user and system requirements and will act as a guideline for system developers.

## System Requirements
### Properties
Compatible Platforms: Windows, Mac OS X, Linux<br>
Language: Java SE 8

## User Requirements
### History
Up to 10 of the most recently evaluated expressions will be stored in a text file when the application is closed by the user.
When the application is opened, that text file's existence is checked.
If it exists, use it to initialize history; otherwise, start normally.

### Operators
All conventional operations are supported along with the modulus operator as well.
Below is a table that specifies each operation's related symbol and precedence.
For precedence, 1 is the “highest”, and 3 is the “lowest”, and all operators are left associative.
<table>
  <tr>
    <th>Operator</th>
    <th>Symbol</th>
    <th>Precedence</th>
  </tr>
  <tr>
    <td>Exponentiate</td>
    <td align="center">^</td>
    <td>1</td>
  </tr>
  <tr>
    <td>Multiply</td>
    <td align="center">*</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Divide</td>
    <td align="center">/</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Modulo</td>
    <td align="center">%</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Add</td>
    <td align="center">+</td>
    <td>3</td>
  </tr>
  <tr>
    <td>Subtract</td>
    <td align="center">-</td>
    <td>3</td>
  </tr>
</table>

### Output
Each result will be a decimal number with up to 10 digits of precision.

### Functionality
* When one of the six conversion functions is clicked,
an appropriate expression will be generated as the last expression,
and the result will be displayed in the field.
* If the current expression is empty, all six conversion functions are disabled.
* If the current expression is not the last expression, the “=” button is disabled.
* The “Ans” button inserts the result of the previous calculation into the last expression.
* The “Clr” button clears all expressions and the current result, if they exist.
* The “Del” button deletes the last character in the last expression, if either exists.
