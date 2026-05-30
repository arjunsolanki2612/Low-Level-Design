# Mediator Pattern - Design Discovery Notes

## Problem

Hum ek Chat Application bana rahe hain.

Requirements:

* User private message bhej sakta hai.
* User broadcast message bhej sakta hai.
* Future me mute/unmute feature aa sakta hai.
* Users directly communicate nahi karenge.

---

## Design Discovery Process

Humne code se start nahi kiya.

Pehle requirements samjhi:

```text
Arjun wants to send message to Rohit.
```

Question:

```text
Should Arjun know Rohit directly?
```

Answer:

```text
No.
```

Reason:

* Har user ko sab users ke references rakhne padenge.
* Coupling increase ho jayegi.
* System maintain karna difficult ho jayega.

---

## Central Coordinator

Is problem ko solve karne ke liye ek central object introduce kiya:

```text
ChatRoom
```

Communication flow:

```text
User
  |
  v
ChatRoom
  |
  v
User
```

Instead of:

```text
User -------> User
```

---

## Objects Identified

### User

Responsibilities:

* send private message
* broadcast message
* receive message

State:

```java
String name;
ChatRoom chatRoom;
```

---

### ChatRoom

Responsibilities:

* store users
* register users
* find receiver
* route messages
* broadcast messages

State:

```java
Map<String, User> users;
```

---

## Relationships

### ChatRoom HAS-A Users

```java
Map<String, User> users;
```

Reason:

* ChatRoom ko users lookup karne hain.
* ChatRoom hi communication coordinator hai.

---

### User HAS-A ChatRoom

```java
ChatRoom chatRoom;
```

Reason:

* User ko messages route karne ke liye ChatRoom ko request bhejni hai.
* User directly dusre users ko nahi jaanta.

---

## Runtime Flow

Example:

```java
arjun.sendTo(
    "Rohit",
    "Hello Rohit"
);
```

Execution Flow:

```text
Arjun.sendTo()

      |
      v

ChatRoom.sendTo()

      |
      v

users.get("Rohit")

      |
      v

Rohit.receive()
```

Important:

```text
Arjun never calls Rohit directly.
```

---

## Why User Does Not Store Other Users

Bad Design:

```text
Arjun
  |
  +--> Rohit
  +--> Aman
  +--> Vikas
```

Problems:

* High coupling
* Difficult maintenance
* Difficult scalability

---

## Why ChatRoom Stores Users

ChatRoom responsibilities:

```text
1. Find receiver
2. Route message
3. Broadcast message
4. Apply communication rules
```

Therefore ChatRoom owns:

```java
Map<String, User> users;
```

---

## Constructor Decision

User:

```java
User(
    String name,
    ChatRoom chatRoom
)
```

Reason:

* User needs name.
* User needs ChatRoom reference.
* Without ChatRoom user cannot communicate.

---

## Registration Decision

Preferred:

```java
User arjun =
    new User("Arjun", room);

room.addUser(arjun);
```

Instead of:

```java
new User("Arjun", room);
```

automatically registering itself.

Reason:

```text
Object Creation
and
Object Registration

are different responsibilities.
```

---

## User Class Design

```java
class User {

    private String name;

    private ChatRoom chatRoom;

    void sendTo(...)

    void broadcast(...)

    void receive(...)
}
```

---

## ChatRoom Class Design

```java
class ChatRoom {

    private Map<String, User> users;

    void addUser(...)

    void sendTo(...)

    void broadcast(...)
}
```

---

## Important Learning

Design Pattern implementation should not start with:

```text
Interface
Abstract Class
Methods Guessing
```

Instead:

```text
Requirements
    ↓
Objects
    ↓
Responsibilities
    ↓
Relationships
    ↓
Fields
    ↓
Methods
    ↓
Code
```

This approach makes the design emerge naturally instead of forcing the pattern.
