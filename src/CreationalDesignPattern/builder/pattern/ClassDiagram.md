# 📌 Class Diagram

```text
                 +------------------+
                 |      Client      |
                 +------------------+
                           |
                           v
                 +------------------+
                 |      Builder     |
                 |------------------|
                 | withUrl()        |
                 | withMethod()     |
                 | build()          |
                 +------------------+
                           |
                           v
                 +------------------+
                 |    HTTPRequest   |
                 |------------------|
                 | final fields     |
                 +------------------+
```

---

# 📌 Director in Builder Pattern

Director is an optional component that defines
a fixed sequence of building steps.

Example:

* Gaming PC Builder
* Office PC Builder
* Premium Car Builder

Director tells builder:

1. add engine
2. add seats
3. add GPS

In modern Java applications, Director is often skipped
because fluent Builder APIs are simpler.

---

# 📌 Telescoping Constructor Problem

When constructors keep increasing because of optional parameters:

```java id="bgms84"
User()
User(name)
User(name, age)
User(name, age, address)
```

This is called:

# Telescoping Constructor Problem

Builder Pattern solves this elegantly.

---

# 📌 Why build() Method Exists?

build() acts as the:

# Final Assembly Point

Responsibilities:

* validate data
* create immutable object
* ensure object completeness
* prevent invalid states

Without build():

* partially configured objects may exist
* validation becomes difficult

---

# 📌 Fluent Interface

Builder Pattern commonly uses:

# Fluent Interface

Meaning:
methods return same object to allow chaining.

Example:

```java id="3qxfmt"
builder.withUrl()
       .withMethod()
       .withTimeout();
```

This improves readability.

---

# 📌 How to Identify Builder Pattern?

Ask these questions:

1. Does object have many fields?
2. Are many fields optional?
3. Is constructor becoming unreadable?
4. Is object configured gradually?
5. Is fluent API desired?
6. Is immutability preferred?

If YES → Builder Pattern is a strong candidate.

---

# 📌 Types of Builder Implementations

## 1. Mutable Builder

* modifies object gradually
* simpler
* less safe

## 2. Immutable Builder (Preferred)

* creates object only in build()
* safer
* thread-safe
* industry preferred

---

# 📌 Responsibility Mapping

| Component | Responsibility             |
| --------- | -------------------------- |
| Client    | chooses configuration      |
| Builder   | stores temporary data      |
| build()   | validates + creates object |
| Product   | final immutable object     |
