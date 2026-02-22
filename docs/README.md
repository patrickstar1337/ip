# ROKO's User Guide

<img src="https://raw.githubusercontent.com/patrickstar1337/ip/refs/heads/master/docs/Ui.png" height="450">

ROKO is a cutting edge last generation software that helps you keep track of your various tasks 
so that you won't forget it.

## Commands

### todo
Adds a simple reminder with a single description  
Usage: `todo [description]`  
Example: `todo Buy a pencil`  
```text
[T][] Buy a pencil
```

### deadline
Adds a simple reminder with a description and a deadline  
Usage: `deadilne [description] /by [yyyy-mm-dd]`  
Example: `deadline Submit homework /by 2026-02-20`
```text
[D][] Submit homework (by: Feb 20 2026)
```

### deadline
Adds a simple reminder with a description and a from and to date  
Usage: `event [description] /from [yyyy-mm-dd] /to [yyyy-mm-dd]`  
Example: `event cry /from 2026-01-01 /to 2026-12-31`
```text
[E][] cry from:(Jan 1 2026 to: Dec 31 2026)
```

### undo
Undoes the previous command  
Usage: `undo`  
Example: `undo`  

### mark / unmark
Marks a tasks complete or incomplete  
Usage: `mark [int]` or `unmark [int]`  
Example: `mark 1` then `unmark 1`
```text
[T][X] Buy a pencil
[T][] Buy a pencil
```

### bye
Exits and terminates the program  
Usage: `bye`  
Example: `bye`
```text

```