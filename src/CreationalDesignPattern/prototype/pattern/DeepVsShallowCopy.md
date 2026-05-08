# Shallow Copy vs Deep Copy in Java

---

# 🚀 Why This Topic is Important

Understanding shallow copy vs deep copy is one of the MOST important concepts in:
- Prototype Pattern
- Java memory management
- Object cloning
- Interview questions
- Real-world backend systems

A lot of bugs happen because developers accidentally share references.

---

# 🧠 Core Idea

When copying an object:

```java
User copied = original;
```

Are we:
- copying the actual object?
  OR
- copying only the reference?

This is the heart of shallow vs deep copy.

---

# 🔥 First Understand References

Suppose:

```java
Weapon weapon = new Weapon("AK-47");
```

And:

```java
GameCharacter soldier =
        new GameCharacter("Soldier", weapon);
```

Memory:

```text
soldier
   |
   +------> Weapon Object
                |
                | weaponName = AK-47
```

The character DOES NOT store actual weapon object.

It stores:
- memory address
- reference

---

# ❌ SHALLOW COPY

## Definition

Shallow copy copies:
- primitive values
- references

BUT NOT nested objects.

---

# 🧠 Mental Model

```text
Outer object copied
Inner objects shared
```

---

# Example

## Shallow Clone

```java
public GameCharacter clone() {

    return new GameCharacter(
            this.name,
            this.weapon
    );
}
```

---

# 🔥 What Happens Here?

```java
this.weapon
```

passes SAME weapon reference.

NO NEW weapon object created.

---

# MEMORY STRUCTURE

```text
ORIGINAL OBJECT

original
   |
   +------> Weapon Object
                |
                | AK-47


CLONED OBJECT

clone
   |
   +------> SAME Weapon Object
```

Both point to SAME nested object.

---

# 🚨 Problem

If clone modifies weapon:

```java
clone.getWeapon()
     .setWeaponName("Rocket Launcher");
```

Then original ALSO changes.

Because:
both share same object.

---

# ⚠ Real Problem Example

Suppose:
- User A settings
- User B cloned settings

If shallow copied:
changing B settings may affect A.

Dangerous bug.

---

# ✅ DEEP COPY

## Definition

Deep copy creates:
- new outer object
- new nested objects

Everything becomes independent.

---

# 🧠 Mental Model

```text
Everything copied independently
```

---

# Example

```java
public GameCharacter clone() {

    Weapon clonedWeapon =
            new Weapon(this.weapon.getWeaponName());

    return new GameCharacter(
            this.name,
            clonedWeapon
    );
}
```

---

# 🔥 What Happens Here?

NEW weapon object created:

```java
new Weapon(...)
```

Now objects are independent.

---

# MEMORY STRUCTURE

```text
ORIGINAL OBJECT

original
   |
   +------> Weapon Object 1
                |
                | AK-47



CLONED OBJECT

clone
   |
   +------> Weapon Object 2
                |
                | AK-47
```

Different objects.

Safe.

---

# 🔥 Key Difference

| Feature | Shallow Copy | Deep Copy |
|---|---|---|
| Nested objects | Shared | Copied |
| References | Shared | New references |
| Memory usage | Lower | Higher |
| Safety | Risky | Safe |
| Performance | Faster | Slower |
| Independence | No | Yes |

---

# 🧠 Golden Rule

## Immutable objects are safe in shallow copy

Example:

```java
String
Integer
LocalDate
```

Because they cannot change.

---

## Mutable objects usually require deep copy

Example:

```java
List
Map
Custom objects
ArrayList
HashMap
```

Because state can change.

---

# 🚨 Common Beginner Mistake

Beginners think:

```java
User copy = original;
```

creates new object.

❌ WRONG

It only copies reference.

---

# MEMORY

```text
copy -----------+
                |
original -------+
                |
                v
             SAME OBJECT
```

---

# 🔥 Real-World Use Cases

## Shallow Copy Used When

- Objects are immutable
- Performance is critical
- Sharing is acceptable

---

## Deep Copy Used When

- Independent objects needed
- User data isolation required
- Nested mutable objects exist

---

# 🚀 Interview Questions

---

## Q1. What is shallow copy?

Copies references of nested objects.

---

## Q2. What is deep copy?

Creates completely independent object graph.

---

## Q3. Why is shallow copy dangerous?

Because shared references can create side effects.

---

## Q4. Is String safe in shallow copy?

Yes, because String is immutable.

---

## Q5. Which copy is expensive?

Deep copy because more objects are created.

---

# 🔥 Ultimate Intuition

---

# SHALLOW COPY

Two people sharing SAME notebook.

```text
Person A ----+
             |
             v
         SAME Notebook
             ^
             |
Person B ----+
```

Changes visible to both.

---

# DEEP COPY

Photocopy notebook.

```text
Person A --> Original Notebook

Person B --> Photocopy Notebook
```

Independent copies.

---

# 🚀 Final One-Line Summary

## Shallow Copy

```text
Copies references
```

## Deep Copy

```text
Copies actual nested objects too
```