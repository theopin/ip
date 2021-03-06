# User Guide
**Duke**  is a Command Line Interface (CLI) application that helps users to manage
their busy schedules by tracking their important tasks.

## Table of Contents
* [Quick Start](#quick-start)
* [Features](#features)
  * [List](#list)
  * [Find `Task`](#find-task) 
  * [Add `Task`](#add-task)
  * [Remove `Task`](#remove-task)
  * [Mark Completed `Task` as Done](#mark-task-as-done)
  * [Exit](#exit)
  * [Save](#save)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Quick Start 
1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `ip.jar` from [here](https://github.com/theopin/ip/releases).
3. Copy the file to the folder you want to use as the home folder for your program.
4. Use `java -jar ip.jar` to run the program. A welcome message should appear as shown below.

```
	____________________________________________________________
	Hello from
	 ____        _        
	|  _ \ _   _| | _____ 
	| | | | | | | |/ / _ \
	| |_| | |_| |   <  __/
	|____/ \__,_|_|\_\___|

	What can I do for you?
	____________________________________________________________
```
## Features 

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as 
  `todo maths quiz`.
* If a feature requires you to indicate a `DATE` or `TIME`, they
  must be typed in the format specified below. **Duke**  is unable to process
  other `DATE` and `TIME` formats.
  
  * `DATE`: `DD/MM/YYYY`
    * Insert the date, followed by the month and the year, with a forward slash `/` between
    each segment.
    * eg. 25/10/2020
  * `TIME`: `HH:MM`
    * Insert the time in the `24h` time format, with a semicolon `:` between the hours and minutes.
    * eg. 16:50

</div>

### List
Presents all the tasks present in the task manager.

#### Usage

Format: `list`

Expected Outcome:
```
	____________________________________________________________
	Here are the tasks in your list:
	1. [T][X] MA1508E Assignment
	2. [D][X] Cook pizza (by: 4:00 PM)
	3. [E][X] GER1000 Quiz (at: Oct 04 2020 11:59 PM)
	____________________________________________________________
```

### Find `Task`
Presents all the tasks whose description matches the search filter given
by the user.

#### Usage

Format: `find KEYWORD`

Examples of usage:
* `find MA1508E`
* `find assignment`

Expected Outcome:
```
	____________________________________________________________
	Here are the tasks that match this command - MA1508E:
	1. [T][X] MA1508E Assignment
	____________________________________________________________
```

### Add `Task`
Adds a task to the task manager. 
**Duke**  currently supports 3 types of tasks.
* `todo`
* `event`
* `deadline`

#### Usage of `todo`

Format: `todo DESCRIPTION`

Examples of usage:
* `todo MA1508E assignment`
* `todo maths`

Expected Outcome:
```
	____________________________________________________________
	Got it. I've added this task: 
		[T][X] MA1508E assignment
	Now you have 1 tasks in the list.
	____________________________________________________________

```

#### Usage of `event`

Format: `event DESCRIPTION /at DATE TIME`

| :information_source: | `event` requires at least a `DATE` or `TIME` to be stored in the task manager. |
|----------------------|:-------------------------------------|

Examples of usage:
* `event GER1000 Quiz /by 04/10/2020 23:59`
* `event math quiz /by 24/10/2020`
* `event Physics quiz /by 17:00`

Expected Outcome:
```
	____________________________________________________________
	Got it. I've added this task: 
		[E][X] GER1000 Quiz (at: Oct 04 2020 11:59 PM)
	Now you have 1 tasks in the list.
	____________________________________________________________

```

#### Usage of `deadline`

Format: `deadline DESCRIPTION /by DATE TIME`

| :information_source: | `deadline` requires at least a `DATE` or `TIME` to be stored in the task manager. |
|----------------------|:-------------------------------------|

Examples of usage:
* `deadline Learn pizza-making /by 24/10/2020 17:00`
* `deadline math quiz /by 24/10/2020`
* `deadline IPPT /by 17:00`

Expected Outcome:
```
	____________________________________________________________
	Got it. I've added this task: 
		[D][X] Cook pizza (by: 4:00 PM)
	Now you have 1 tasks in the list.
	____________________________________________________________

```
### Remove `Task`
Removes a `Task` from the task manager. You can choose to remove one task at 
a time or all the tasks at the same time.

#### Usage

Format:
* Single `Task`: `remove INDEX`
* Every `Task`: `remove all`

Examples of usage:
* `remove 1`
* `remove all`

Expected Outcome (Single `Task`):
```
	____________________________________________________________
	Got it. I've removed this task: 
		[T][X] MA1508E Assignment
	Now you have 2 tasks in the list.
	____________________________________________________________
```

Expected Outcome (Every `Task`):
```
	____________________________________________________________
	Got it. I've cleared all tasks in the list!
	Now you have no tasks in the list.
	____________________________________________________________
```

### Mark `Task` as Done 
Marks a particular `Task` in the task manager as done. 

#### Usage

Format: `done INDEX`

Examples of usage:
* `done 1`
* `done 3`

Expected Outcome:
```
	____________________________________________________________
	Nice! I've marked this task as done:
	[T][/] MA1508E assignment
	____________________________________________________________

```

### Exit
Closes the application.

#### Usage

Format: `bye`

Expected Outcome:
```
	____________________________________________________________
	Bye. Hope to see you again soon!
	____________________________________________________________

```

### Save
Data related to this application is saved in the hard disk **automatically** 
after any command that changes it is given. There is no need to save manually.

## FAQ

### Q: How do I transfer my data to another computer?
Transfer the folder `/data` containing `duke.txt` into the directory of your other computer that contains `ip.jar`. 
The application will look out for the `duke.txt` within that `/data` folder and fetch the tasks from there.

## Command Summary

Action | Format | Examples
-------- | ---------- | ------------
List | `list` | -
Find `Task` | `done KEYWORD` | `find MA1508E` `find quiz`
Add `Task` - `todo` | `todo DESCRIPTION` | `todo MA1508E assignment` `todo maths`
Add `Task` - `event` | `event DESCRIPTION /at DATE TIME` | `event GER1000 Quiz /by 04/10/2020 23:59` `event math quiz /by 24/10/2020` `event Physics quiz /by 17:00`
Add `Task` - `deadline` | `deadline DESCRIPTION /by DATE TIME` | `deadline Learn pizza-making /by 24/10/2020 17:00` `deadline math quiz /by 24/10/2020`s `deadline IPPT /by 17:00`
Remove `Task` | `remove INDEX` `remove all` | `remove 1` `remove 2`
Mark `Task` as done | `done INDEX` | `done 1` `done 3`
Exit | `bye` | -
