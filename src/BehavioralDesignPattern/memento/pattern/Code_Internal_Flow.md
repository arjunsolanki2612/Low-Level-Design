# Memento Pattern — Internal Memory Flow + UML Diagram Notes

# Initial Objects Creation

```java
TextEditor editor = new TextEditor();

HistoryManager history = new HistoryManager();
```

---

# Memory After Object Creation

```text
Heap Memory
------------------------------------------------

TextEditor Object
    |
    ---> text = null


HistoryManager Object
    |
    ---> Stack = empty
```

---

# Step 1

```java
editor.write("Hello");
```

Current editor state:

```text
TextEditor
   |
   ---> text = "Hello"
```

---

# Step 2 — Save Snapshot

```java
history.save(editor.save());
```

---

# Internal Working

First:

```java
editor.save()
```

runs.

Inside save():

```java
return new EditorMemento(text);
```

Current text:

```text
"Hello"
```

New snapshot object created:

```text
EditorMemento
   |
   ---> savedText = "Hello"
```

Now HistoryManager stores snapshot.

---

# Memory Visualization

```text
Heap Memory
------------------------------------------------

TextEditor
   |
   ---> text = "Hello"


EditorMemento
   |
   ---> savedText = "Hello"


HistoryManager
   |
   ---> Stack
            |
            ---> Memento("Hello")
```

---

# Important Understanding

Saved snapshot is NOT same object as editor.

Wrong approach:

```java
savedEditor = editor;
```

This stores same live object reference.

Correct approach:

```java
new EditorMemento(text);
```

This creates separate frozen snapshot.

---

# Step 3

```java
editor.write("Hello World");
```

Now editor changes.

Memory:

```text
TextEditor
   |
   ---> text = "Hello World"
```

Old snapshot remains unchanged.

```text
Memento("Hello")
```

This is possible because snapshot is separate immutable object.

---

# Step 4 — Save Again

```java
history.save(editor.save());
```

New snapshot created:

```text
Memento("Hello World")
```

Stack now:

```text
TOP
 |
 |  Memento("Hello World")
 |
 |  Memento("Hello")
 |
BOTTOM
```

---

# Step 5

```java
editor.write("Hello World Java");
```

Current live editor state:

```text
TextEditor
   |
   ---> text = "Hello World Java"
```

History still contains old snapshots safely.

---

# Step 6 — Undo

```java
editor.restore(history.undo());
```

---

# Internal Working

First:

```java
history.undo()
```

runs.

Inside undo():

```java
return history.pop();
```

Latest snapshot removed:

```text
Memento("Hello World")
```

Stack after pop:

```text
TOP
 |
 |  Memento("Hello")
 |
BOTTOM
```

---

# Restore Process

Now:

```java
editor.restore(memento);
```

runs.

Inside restore():

```java
text = memento.getSavedText();
```

Editor state changes back.

---

# Memory After Restore

```text
TextEditor
   |
   ---> text = "Hello World"
```

Undo successful.

---

# Second Undo

Again:

```java
editor.restore(history.undo());
```

Snapshot restored:

```text
Memento("Hello")
```

Final editor state:

```text
TextEditor
   |
   ---> text = "Hello"
```

---

# Complete Runtime Flow

```text
write()
   ↓
Current state changes
   ↓
save()
   ↓
New immutable snapshot created
   ↓
Caretaker stack stores snapshot
   ↓
More changes happen
   ↓
undo()
   ↓
Latest snapshot popped
   ↓
restore()
   ↓
Old state restored
```

---

# Internal Responsibility Understanding

# TextEditor (Originator)

Responsible for:

* owning live state
* creating snapshots
* restoring snapshots

---

# EditorMemento

Responsible for:

* storing frozen old state
* preserving snapshot safely

---

# HistoryManager (Caretaker)

Responsible for:

* storing history
* managing undo stack
* returning old snapshots

Important:

```text
Caretaker never modifies snapshot data.
```

---

# Why Stack is Used

Undo follows:

```text
Last Saved State
First Restored
```

This is LIFO behavior.

That is why Stack is used.

---

# Encapsulation Visualization

Without Memento:

```text
Outside classes directly access:
- text
- cursor
- internal fields
```

Bad design.

---

# With Memento:

```text
Outside world only handles snapshot object.
```

Originator controls:

* what gets saved
* what gets restored
* what remains hidden

Encapsulation stays protected.

---

# UML Class Diagram

```text
+-------------------+
|    TextEditor     |
+-------------------+
| - text : String   |
+-------------------+
| + write()         |
| + save()          |
| + restore()       |
| + showText()      |
+-------------------+
           |
           | creates/restores
           v
+---------------------------+
|      EditorMemento        |
+---------------------------+
| - savedText : String      |
+---------------------------+
| + getSavedText()          |
+---------------------------+


+----------------------------+
|      HistoryManager        |
+----------------------------+
| - history : Stack          |
+----------------------------+
| + save()                   |
| + undo()                   |
+----------------------------+
           |
           | stores
           v
+---------------------------+
|      EditorMemento        |
+---------------------------+
```

---

# Relationship Understanding

# HistoryManager HAS-A Stack

Because it owns history internally.

---

# Stack HAS-A Mementos

Because stack stores snapshots.

---

# TextEditor creates Mementos

Because only TextEditor knows:

* what state should be saved
* how restoration should happen

---

# Final Core Understanding

```text
Originator:
"I own my current state"

Memento:
"I preserve frozen snapshot"

Caretaker:
"I only manage history"
```
