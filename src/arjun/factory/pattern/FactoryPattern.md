# 🏭 Factory Method Design Pattern (Interface-Based)

> Clean, scalable way to create objects without tightly coupling your code.

---

## 🎯 Problem

Direct object creation leads to tight coupling:

```java
new EmailNotification();
```

### ❌ Issues:

* Service depends on concrete classes
* Adding new types requires modifying existing code
* Leads to messy `if-else` chains

👉 This violates **Open/Closed Principle**

---

## 💡 Core Idea

Move object creation out of business logic.

### Instead of:

```
Service → creates object ❌
```

### Do this:

```
Service → asks Factory → gets object ✅
```

👉 Service uses objects
👉 Factory creates objects

---

## 🧠 Ultra Simple View

At runtime, only 3 things matter:

```
Client → Factory → Product
```

---

## 🧱 Components (Roles)

### 1️⃣ Product (Interface) — WHAT to do

```java
public interface Notification {
    void send();
}
```

---

### 2️⃣ Concrete Products — HOW it works

```java
public class EmailNotification implements Notification {
    public void send() {
        System.out.println("Sending Email 📧");
    }
}
```

```java
public class SMSNotification implements Notification {
    public void send() {
        System.out.println("Sending SMS 📱");
    }
}
```

---

### 3️⃣ Factory (Interface) — HOW to create

```java
public interface NotificationFactory {
    Notification createNotification();
}
```

---

### 4️⃣ Concrete Factories — Actual creators

```java
public class EmailFactory implements NotificationFactory {
    public Notification createNotification() {
        return new EmailNotification();
    }
}
```

```java
public class SMSFactory implements NotificationFactory {
    public Notification createNotification() {
        return new SMSNotification();
    }
}
```

---

### 5️⃣ Service — WHEN to use

```java
public class NotificationService {

    private NotificationFactory factory;

    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void sendNotification() {
        Notification notification = factory.createNotification();
        notification.send();
    }
}
```

---

### 6️⃣ Client (Main) — WHAT to choose

```java
public class Main {
    public static void main(String[] args) {

        NotificationFactory factory = new EmailFactory();

        NotificationService service = new NotificationService(factory);
        service.sendNotification();
    }
}
```

---

## 🔄 Flow (Execution)

```
Main
 ↓
Choose Factory (EmailFactory)
 ↓
Pass Factory to Service
 ↓
Service calls factory.createNotification()
 ↓
Factory returns EmailNotification
 ↓
Service calls send()
```

---

## ⚔️ Before vs After

### ❌ Without Factory

```java
if(type.equals("EMAIL")) {
    new EmailNotification();
} else if(type.equals("SMS")) {
    new SMSNotification();
}
```

---

### ✅ With Factory

```java
Notification n = factory.createNotification();
n.send();
```

---

## 🔗 How Tight Coupling is Removed

### Before:

```
Service → EmailNotification ❌
```

### After:

```
Service → Notification (interface) ✅
```

👉 Service no longer knows concrete classes

---

## ➕ Adding New Type (Push Notification)

Just add:

```java
public class PushNotification implements Notification {
    public void send() {
        System.out.println("Sending Push 🔔");
    }
}
```

```java
public class PushFactory implements NotificationFactory {
    public Notification createNotification() {
        return new PushNotification();
    }
}
```

### Only change in Main:

```java
factory = new PushFactory();
```

---

### ❗ No Changes Required In:

* Service
* Existing factories
* Existing code

👉 Follows **Open/Closed Principle**

---

## 🚀 Why Use Factory Method?

* Loose coupling
* Clean architecture
* Easy to extend
* Scalable design

---

## ⚖️ Trade-Off

### ❌ Cons:

* More classes
* Slightly complex initially

### ✅ Pros:

* Maintainable
* Flexible
* Industry-grade design

---

## 🎯 One-Line Summary

> Factory Method = Move object creation out of service into a factory.

---

## 🧠 Memory Trick

```
Without Factory:
Service → new Object()

With Factory:
Service → Factory → Object
```

---

## 🔥 Final Thought

Don’t think:

> “Too many classes”

Think:

> “Responsibilities are clean”

---

⭐ If this helped, star the repo and keep building!
