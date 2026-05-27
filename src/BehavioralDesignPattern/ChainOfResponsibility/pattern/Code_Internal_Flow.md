# Chain of Responsibility — Internal Object Linking & Runtime Flow

# MOST IMPORTANT CONCEPT

Chain of Responsibility internally works like:

```text
Handler -> Handler -> Handler
```

Every handler object stores reference of next handler.

Exactly like a linked list.

---

# Step 1 — Objects Creation

```java
ExpenseHandler teamLead = new TeamLeadHandler();
ExpenseHandler manager = new ManagerHandler();
ExpenseHandler director = new DirectorHandler();
```

Now memory contains 3 separate objects.

---

# Initial Internal Structure

## TeamLeadHandler Object

```text
+----------------------+
| TeamLeadHandler Obj  |
|----------------------|
| nextHandler = null   |
+----------------------+
```

---

## ManagerHandler Object

```text
+----------------------+
| ManagerHandler Obj   |
|----------------------|
| nextHandler = null   |
+----------------------+
```

---

## DirectorHandler Object

```text
+-----------------------+
| DirectorHandler Obj   |
|-----------------------|
| nextHandler = null    |
+-----------------------+
```

---

# Where did nextHandler come from?

From parent abstract class:

```java
public abstract class ExpenseHandler {

    protected ExpenseHandler nextHandler;
}
```

Because child classes inherit parent properties.

So every handler object internally contains:

```text
nextHandler reference
```

---

# Step 2 — Chain Building

```java
teamLead.setNextHandler(manager);
```

---

# What happens internally?

Method:

```java
public void setNextHandler(ExpenseHandler nextHandler) {
    this.nextHandler = nextHandler;
}
```

Here:

```text
this = TeamLeadHandler object
argument = ManagerHandler object
```

So internally:

```java
this.nextHandler = manager;
```

Meaning:

```text
TeamLeadHandler object now stores
reference of ManagerHandler object
```

---

# Memory After Linking

```text
+----------------------+
| TeamLeadHandler Obj  |
|----------------------|
| nextHandler ---------|-------------------+
+----------------------+                   |
                                           |
                                           v
                             +----------------------+
                             | ManagerHandler Obj   |
                             |----------------------|
                             | nextHandler = null   |
                             +----------------------+
```

---

# Step 3 — Next Linking

```java
manager.setNextHandler(director);
```

Internally:

```text
ManagerHandler.nextHandler = DirectorHandler
```

---

# Final Chain Structure

```text
+----------------------+
| TeamLeadHandler Obj  |
|----------------------|
| nextHandler ---------|--------------------+
+----------------------+                    |
                                            |
                                            v

                             +----------------------+
                             | ManagerHandler Obj   |
                             |----------------------|
                             | nextHandler ---------|------------------+
                             +----------------------+                  |
                                                                        |
                                                                        v

                                                       +-----------------------+
                                                       | DirectorHandler Obj   |
                                                       |-----------------------|
                                                       | nextHandler = null    |
                                                       +-----------------------+
```

---

# MOST IMPORTANT INSIGHT

Chain is not magic.

It is simply:

```text
Objects storing references of next objects
```

This is pure composition.

---

# Why Composition?

Because:

```text
Handler HAS-A next handler
```

NOT:

```text
Handler IS-A next handler
```

So CoR is composition-heavy.

---

# Step 4 — Request Starts

```java
teamLead.approveExpense(request);
```

Client only knows first handler.

---

# Runtime Flow

```text
Client
   |
   v
TeamLeadHandler
```

---

# TeamLeadHandler Executes

Suppose request amount = 90000

Code:

```java
if(request.getAmount() <= 10000)
```

Condition fails.

So:

```java
nextHandler.approveExpense(request);
```

---

# IMPORTANT

What is nextHandler here?

```text
Reference to ManagerHandler object
```

Because earlier:

```java
teamLead.setNextHandler(manager);
```

So actual runtime call becomes:

```java
manager.approveExpense(request);
```

---

# Request Moves Forward

```text
TeamLeadHandler
      |
      v
ManagerHandler
```

---

# ManagerHandler Executes

Again checks:

```java
if(request.getAmount() <= 50000)
```

Condition fails.

Again:

```java
nextHandler.approveExpense(request);
```

---

# nextHandler Now Points To

```text
DirectorHandler object
```

Because:

```java
manager.setNextHandler(director);
```

So runtime call becomes:

```java
director.approveExpense(request);
```

---

# Director Handles Request

```java
System.out.println("Approved");
```

Chain stops.

---

# Complete Runtime Request Flow

```text
Client
   |
   v
TeamLeadHandler
   |
   | nextHandler
   v
ManagerHandler
   |
   | nextHandler
   v
DirectorHandler
   |
   v
Request handled
```

---

# MOST IMPORTANT DESIGN INSIGHT

Client does NOT know:

- ManagerHandler
- DirectorHandler
- chain traversal

Client only knows:

```text
First handler
```

This creates:

```text
Loose Coupling
```

---

# Who Decides Handle OR Forward?

Current handler itself.

Example:

```java
if(canHandle)
   handle
else
   forward
```

Meaning:

```text
Behavior is decentralized
```

No giant central controller exists.

---

# Why This Removes Huge if-else?

Without CoR:

```java
if(amount <= 10000)
else if(amount <= 50000)
else if(amount <= 100000)
```

One huge method.

With CoR:

```text
Each handler owns one responsibility
```

Responsibilities become distributed.

---

# Runtime Polymorphism

```java
protected ExpenseHandler nextHandler;
```

Type is:

```text
ExpenseHandler
```

But actual object can be:

- TeamLeadHandler
- ManagerHandler
- DirectorHandler
- Future handlers

So JVM resolves actual method at runtime.

This is runtime polymorphism.

---

# Final Mental Model

Every handler says:

```text
"I'll try to handle request.
If I cannot,
I'll pass it to next handler."
```

This is the entire Chain of Responsibility pattern.