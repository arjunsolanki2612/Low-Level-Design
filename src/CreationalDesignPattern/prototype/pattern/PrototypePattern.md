# Prototype Design Pattern

---

# 🚀 What is Prototype Pattern?

Prototype Pattern is a Creational Design Pattern
used to create new objects by copying existing objects.

Instead of:

```java
new Object()
```

we do:

```java
object.clone()
```

---

# 🎯 Main Goal

Avoid expensive object creation by cloning existing objects.

---

# 🧠 Core Idea

```text
Create once
Clone many times
```

---

# 🔥 Why Use Prototype?

Sometimes object creation is:
- expensive
- complex
- time-consuming

Examples:
- game characters
- large configuration objects
- UI templates
- documents

Instead of recreating:
we clone.

---

# 🔥 Real-World Examples

---

## 🎮 Game Development

Clone enemy templates.

```text
Zombie Prototype
      ↓ clone
100 zombies
```

---

## 🎨 Figma / Canva

Duplicate UI components.

---

## 📝 Google Docs

Duplicate document templates.

---

## 🛒 E-commerce

Clone product templates.

---

# 🧠 Mental Model

Prototype Pattern is like:

```text
Object Photocopying
```

Instead of building everything again:
copy existing object and modify small parts.

---

# 🔥 When to Use

Use Prototype when:

- object creation is expensive
- many similar objects needed
- runtime duplication required
- cloning feature needed
- object setup is complex

---

# 🚨 Identification Signals

If problem says:
- duplicate
- clone
- copy template
- repeated similar objects

Think:

```text
Prototype Pattern
```

---

# 🏗 Structure

```text
Prototype Interface
        ↑
Concrete Prototype
        ↑
Client
```

---

# 🔥 Components

---

## 1. Prototype Interface

Defines clone contract.

```java
interface Prototype<T> {
    T clone();
}
```

---

## 2. Concrete Prototype

Actual class implementing cloning.

Example:
- User
- Car
- GameCharacter
- Document

---

## 3. Client

Uses clone instead of new.

---

# 🔥 Responsibility Flow

---

## Who creates original object?

Usually:
- startup
- factory
- config loader

---

## Who clones object?

Client.

---

## Who modifies clone?

Client.

---

# 🧠 Flow

```text
Create original object
        ↓
Store prototype
        ↓
Clone prototype
        ↓
Modify clone
        ↓
Use cloned object
```

---

# 🔥 Example

---

# Prototype Interface

```java
public interface Prototype<T> {
    T clone();
}
```

---

# Weapon Class

```java
public class Weapon {

    private String weaponName;

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
```

---

# GameCharacter Class

```java
public class GameCharacter
        implements Prototype<GameCharacter> {

    private String name;
    private Weapon weapon;

    public GameCharacter(String name,
                         Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    @Override
    public GameCharacter clone() {

        Weapon clonedWeapon =
                new Weapon(
                        this.weapon.getWeaponName()
                );

        return new GameCharacter(
                this.name,
                clonedWeapon
        );
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void showDetails() {

        System.out.println(
                "Character: " + name
                + ", Weapon: "
                + weapon.getWeaponName()
        );
    }
}
```

---

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        Weapon ak47 =
                new Weapon("AK-47");

        GameCharacter original =
                new GameCharacter(
                        "Soldier",
                        ak47
                );

        GameCharacter clone =
                original.clone();

        clone.setName("Sniper");

        clone.getWeapon()
                .setWeaponName("Sniper Gun");

        System.out.println("ORIGINAL:");
        original.showDetails();

        System.out.println();

        System.out.println("CLONE:");
        clone.showDetails();
    }
}
```

---

# OUTPUT

```text
ORIGINAL:
Character: Soldier, Weapon: AK-47

CLONE:
Character: Sniper, Weapon: Sniper Gun
```

---

# 🔥 Deep Copy vs Shallow Copy

This is MOST IMPORTANT in Prototype Pattern.

---

## Shallow Copy

```text
Outer object copied
Nested objects shared
```

Danger:
modifying clone affects original.

---

## Deep Copy

```text
Everything copied independently
```

Safe approach.

---

# 🚨 Common Mistakes

---

## ❌ Mistake 1

Accidentally doing shallow copy.

---

## ❌ Mistake 2

Sharing mutable objects.

---

## ❌ Mistake 3

Using clone when object is simple.

Sometimes:
```java
new Object()
```

is enough.

---

## ❌ Mistake 4

Blindly using Java Cloneable.

Real-world projects often prefer:
- copy constructors
- builders
- static copy methods

---

# ✅ Pros

- Faster object creation
- Avoid expensive initialization
- Cleaner duplication
- Runtime flexibility

---

# ❌ Cons

- Deep copy complexity
- Circular reference issues
- Shared reference bugs

---

# 🚀 Interview Questions

---

## Q1. Difference between Factory and Prototype?

| Factory | Prototype |
|---|---|
| Creates new object | Copies existing object |
| Uses constructors | Uses cloning |

---

## Q2. What is shallow copy?

Copies references.

---

## Q3. What is deep copy?

Creates independent nested objects.

---

## Q4. Why use Prototype?

To avoid expensive object creation.

---

## Q5. Why avoid Java Cloneable sometimes?

Because:
- shallow copy confusion
- bad API design
- checked exceptions

---

# 🧠 How to Think in LLD Problems

---

## Problem

"Build duplicate dashboard feature"

Think:

```text
Prototype Pattern
```

---

## Problem

"Spawn 100 game enemies"

Think:

```text
Clone templates instead of creating repeatedly
```

---

# 🚀 Ultimate Intuition

Prototype Pattern is:

```text
Object Photocopying
```

Create once.
Copy many times.

---

# 🔥 Final One-Line Summary

```text
Prototype Pattern creates new objects
by cloning existing objects instead of
creating from scratch.
```