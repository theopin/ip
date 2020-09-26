# User Guide
**Duke** is a Command Line Interface (CLI) application that helps users to manage
their busy schedules by tracking their important tasks.

## Table of Contents
* Quick Start
* Features
  * List 
  * Find `Task`
  * Add `Task`
  * Remove` Task`
  * Mark `Task` as Done
  * Exit
  * Save
* Troubleshooting
* FAQ
* Command Summary

## Quick Start 
1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest ip.jar from [here].
3. Copy the file to the folder you want to use as the home folder for your program.
4. Use java -jar ip.jar to run the program. A welcome message should appear as shown below.

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

### List
Presents all the tasks present in the task manager as a list.

#### Usage

Format: `list`

Expected Outcome:
```
	____________________________________________________________
	Here are the tasks in your list:
	[T][✘] MA1508E Assignment
	[D][✘] Cook pizza (by: 4:00 PM)
	[E][✘] GER1000 Quiz (at: Oct 04 2020 11:59 PM)
	____________________________________________________________
```

### Find `Task`
Presents all the tasks whose description matches the search filter given
by the user.

#### Usage

Format: `find KEYWORD`

Example of usage:
* `find MA1508E`

Expected Outcome:
```
	____________________________________________________________
	Here are the tasks that match this command - MA1508E:
	1. [T][✘] MA1508E Assignment
	____________________________________________________________
```

### Add `Task`
Adds a task to the task manager. 
Duke currently supports 3 types of tasks.
* Todo
* Event
* Deadline

#### Usage

Format: `bye`

Expected Outcome:
```
	____________________________________________________________
	Bye. Hope to see you again soon!
	____________________________________________________________

```

### Remove `Task`
Removes a `Task` from the task manager. You can choose to remove one task at 
a time or all the tasks at the same time.

#### Usage

Format:
* Single `Task`: `remove INDEX`
* Every `Task`: `remove all`

Example of usage:
* `remove 1`
* `remove all`

Expected Outcome (Single `Task`):
```
	____________________________________________________________
	Got it. I've removed this task: 
		[T][✘] MA1508E Assignment
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

Example of usage:
* `done 1`

Expected Outcome:
```
	____________________________________________________________
	Nice! I've marked this task as done:
	[T][✓] MA1508E assignment
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
after any command that changes it is given. 

## FAQ

### Q: 

## Command Summary
