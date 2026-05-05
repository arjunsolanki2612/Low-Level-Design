# 🏭 Abstract Factory Pattern — Complete Notes

---

## 📌 Definition

Abstract Factory Pattern provides an interface to create **families of related objects** without specifying their concrete classes.

👉 It ensures that **all created objects are compatible with each other**.

---

## 🎯 Core Idea

* Not creating one object
* Creating a **group (family) of related objects**

👉 Example:
India → Payment + Invoice
USA → Payment + Invoice

---

## ❓ What Problem Does It Solve

* Removes tight coupling with concrete classes
* Eliminates large if-else blocks in client code
* Prevents mixing incompatible objects

❌ Bad:
Stripe payment + India invoice

✅ Good:
India factory → India payment + India invoice

---

## 📅 When to Use

* When you have **families of related objects**
* When objects must be **used together consistently**
* When you want to **switch entire system behavior easily**

---

## 🧠 Mental Model (VERY IMPORTANT)

👉 Think like this:

"Pick ONE factory → get a full compatible system"

---

### 🔥 Mental Steps

1. Identify related objects → (Payment + Invoice)
2. These form a FAMILY
3. Identify variants → (India, USA)
4. Create one factory per variant
5. Each factory creates ALL objects of that family
6. Client uses only factory

---

## 🧭 Ultimate Mental Map

```
STEP 1: Identify related objects (family)
STEP 2: Create interfaces (products)
STEP 3: Create factory interface
STEP 4: Identify variants (India, USA)
STEP 5: Create factories per variant
STEP 6: Each factory returns its own products
STEP 7: Client uses only factory
```

---

## 🧱 Structure

### 🏭 Abstract Factory

```
interface PaymentFactory {
    PaymentProcessor createPaymentProcessor(String type);
    Invoice createInvoice();
}
```

---

### 🧾 Abstract Products

```
interface PaymentProcessor {
    void pay(double amount);
}

interface Invoice {
    void generate(double amount);
}
```

---

### 🏭 Concrete Factories

```
IndiaPaymentFactory
USAPaymentFactory
```

👉 These decide:

* Which family to use

---

### 📦 Concrete Products

#### 🇮🇳 India Family

* RazorpayProcessor
* PayUProcessor
* IndiaInvoice

#### 🇺🇸 USA Family

* StripeProcessor
* PayPalProcessor
* USAInvoice

---

## 🔁 Responsibility Flow

👉 Factory decides REGION
👉 Factory creates ALL related objects

```
IndiaFactory:
    → Razorpay / PayU
    → IndiaInvoice

USFactory:
    → Stripe / PayPal
    → USAInvoice
```

---

## 💻 Payment Example (Simplified Code)

### Abstract Factory

```
interface PaymentFactory {
    PaymentProcessor createPaymentProcessor(String type);
    Invoice createInvoice();
}
```

---

### India Factory

```
class IndiaPaymentFactory implements PaymentFactory {

    public PaymentProcessor createPaymentProcessor(String type) {
        if (type.equalsIgnoreCase("RAZORPAY")) {
            return new RazorpayProcessor();
        } else if (type.equalsIgnoreCase("PAYU")) {
            return new PayUProcessor();
        }
        throw new IllegalArgumentException();
    }

    public Invoice createInvoice() {
        return new IndiaInvoice();
    }
}
```

---

### USA Factory

```
class USAPaymentFactory implements PaymentFactory {

    public PaymentProcessor createPaymentProcessor(String type) {
        if (type.equalsIgnoreCase("STRIPE")) {
            return new StripeProcessor();
        } else if (type.equalsIgnoreCase("PAYPAL")) {
            return new PayPalProcessor();
        }
        throw new IllegalArgumentException();
    }

    public Invoice createInvoice() {
        return new USAInvoice();
    }
}
```

---

### Client

```
class CheckoutService {

    private PaymentFactory factory;

    public CheckoutService(PaymentFactory factory) {
        this.factory = factory;
    }

    public void checkout(double amount, String type) {
        PaymentProcessor p = factory.createPaymentProcessor(type);
        Invoice i = factory.createInvoice();

        p.pay(amount);
        i.generate(amount);
    }
}
```

---

## 🔥 Key Insight (IMPORTANT)

👉 Abstract Factory handles:

* WHICH FAMILY (India vs USA)

👉 Inside factory (if-else) handles:

* WHICH PRODUCT (Razorpay vs PayU)

---

## ⚠️ Common Mistakes

❌ Creating objects directly in client
❌ Mixing families
❌ Using Abstract Factory for single object

---

## ✅ Pros

* Ensures consistency
* Easy to switch systems
* Loose coupling
* Scalable

---

## ❌ Cons

* More classes
* Hard to add new product types
* Can become complex

---

## 🔥 Interview Points

* Factory Method → one product
* Abstract Factory → multiple related products

👉 “It ensures compatibility between related objects.”

👉 “Client depends only on abstraction (factory).”

---

## 🧠 One-Line Memory Trick

👉 **"Factory Method creates one, Abstract Factory creates a family."**

---

## 🧠 Final Understanding

```
Level 1 → Abstract Factory → chooses REGION
Level 2 → if-else inside → chooses PRODUCT
Client → uses only factory
```

---

## 🚀 Final Takeaway

👉 “Select a factory → get a complete, consistent system.”

---
