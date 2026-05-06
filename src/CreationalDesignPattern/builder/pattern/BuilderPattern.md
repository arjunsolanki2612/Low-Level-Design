# 🔥 Builder Design Pattern — Complete LLD Notes

---

# 📌 What is Builder Pattern?

Builder Pattern is a **Creational Design Pattern** used to create **complex objects step-by-step** instead of using huge constructors.

It separates:

* object construction
  FROM
* object representation

---

# 📌 Why Builder Pattern?

When object creation becomes:

* too complex
* unreadable
* filled with optional parameters
* difficult to maintain

Builder provides:

* ✅ readability
* ✅ flexibility
* ✅ clean object creation
* ✅ fluent API
* ✅ immutability support

---

# 📌 Problem It Solves

## 🚨 Constructor Explosion Problem

Bad:

```java
new HttpRequest(
    "/users",
    "POST",
    headers,
    body,
    5000,
    true,
    false
);
```

Problems:

* hard to read
* parameter order confusion
* too many optional fields
* poor maintainability

---

# ✅ Builder Solution

```java
HttpRequest request = new HttpRequest.Builder()
        .withUrl("/users")
        .withMethod("POST")
        .withHeader("Authorization", "token")
        .withTimeout(5000)
        .build();
```

Readable + scalable.

---

# 📌 Core Mental Model

# Builder = Configuration Manager

Builder collects configuration step-by-step before creating final object.

---

# 📌 Real Intuition

Builder is used when:

# “Same object can have many configurations.”

Examples:

* HTTP Request
* Pizza customization
* Car configuration
* Laptop customization
* AWS SDK request
* Database configuration

---

# 📌 Best Real-World Example → HTTP Request Builder

HTTP requests can have:

* URL
* Method
* Headers
* Body
* Timeout
* Cache
* Retry
* Auth

Some mandatory.
Some optional.

Perfect Builder use case.

---

# 📌 Real Industry Usage

| Product/System      | Usage                    |
| ------------------- | ------------------------ |
| OkHttp              | HTTP request building    |
| Retrofit            | API client configuration |
| AWS SDK             | Cloud request building   |
| Lombok @Builder     | DTO creation             |
| StringBuilder       | String creation          |
| AlertDialog.Builder | Android dialogs          |

---

# 📌 When to Use Builder Pattern?

Use Builder when:

* object has many fields
* many optional parameters exist
* constructor becomes unreadable
* object creation is step-by-step
* fluent API required
* immutable object desired

---

# 📌 When NOT to Use Builder

Avoid Builder for very small/simple objects.

Bad Example:

```java
Point(x, y)
```

No need for Builder.

---

# 📌 Structure of Builder Pattern

## 1. Product

Final object being created.

Example:

```java
HTTPRequest
```

---

## 2. Builder

Responsible for collecting configurations.

Example:

```java
HTTPRequest.Builder
```

---

## 3. build()

Creates final object.

---

# 📌 Responsibility Flow

```text
Client
  ↓ chooses configuration

Builder
  ↓ stores temporary values

build()
  ↓ validates + creates object

Final Product Object
```

---

# 📌 Important Understanding

Builder does NOT create different object TYPES.

Builder creates:

# SAME object with DIFFERENT CONFIGURATIONS.

---

# 📌 Factory vs Builder

| Factory                        | Builder                         |
| ------------------------------ | ------------------------------- |
| Decides WHICH object to create | Decides HOW to configure object |
| One-shot creation              | Step-by-step creation           |
| Focus on type                  | Focus on customization          |

---

# 📌 Immutable Builder Approach (Industry Preferred)

## Why immutable objects?

Immutable objects are:

* safer
* thread-safe
* predictable
* easier to debug
* protected from accidental modifications

---

# Immutable Design Rules

```java
private final fields
```

* no setters
* values assigned only in constructor

---

# 📌 Why Private Constructor?

```java
private HTTPRequest(Builder builder)
```

Purpose:

* prevent direct object creation
* force object creation through Builder
* ensure validation
* maintain immutability

---

# 📌 Why Parameterized Constructor?

Because final fields must be initialized during object creation.

Builder passes collected configuration:

```java
return new HTTPRequest(this);
```

Constructor copies values from Builder.

---

# 📌 Why NOT Default Constructor?

Default constructor would require:

```java
request.url = value;
```

which:

* breaks immutability
* requires mutable fields
* may create partially initialized objects

---

# 📌 Mutable Builder Approach

Possible approach:

```java
req.url = value;
```

This works BUT:

* object becomes mutable
* incomplete states possible
* shared reference issues possible

Industry usually prefers immutable approach.

---

# 📌 Static Nested Builder Class

```java
public static class Builder
```

Why static?

Because Builder belongs to class, not object.

Usage:

```java
new HTTPRequest.Builder()
```

NOT:

```java
new HTTPRequest().Builder()
```

---

# 📌 Why Method Chaining Works?

Because builder methods return:

```java
return this;
```

Example:

```java
builder.withUrl()
       .withMethod()
```

This is called:

# Fluent API

---

# 📌 Internal Working Flow

## Step 1

Builder object created:

```java
new HTTPRequest.Builder()
```

No HTTPRequest object yet.

---

## Step 2

Builder stores temporary configuration:

```java
.withUrl()
.withMethod()
```

---

## Step 3

build() called:

```java
.build()
```

---

## Step 4

Private constructor called internally:

```java
new HTTPRequest(this)
```

---

## Step 5

Final immutable object returned.

---

# 📌 Validation Best Practice

Validation should happen inside:

```java
build()
```

Example:

```java
if(url == null)
```

Because Builder controls object creation.

---

# 📌 Common Mistakes

## ❌ Mistake 1

Using Builder for tiny objects.

---

## ❌ Mistake 2

Making product mutable unnecessarily.

---

## ❌ Mistake 3

Forgetting validation inside build().

---

## ❌ Mistake 4

Calling constructor directly from client.

Wrong:

```java
new HTTPRequest(builder)
```

Correct:

```java
new HTTPRequest.Builder()
```

---

## ❌ Mistake 5

Forgetting `return this`.

Breaks chaining.

---

# 📌 Interview-Level Thinking

## Q1. How to identify Builder Pattern?

Look for:

* many optional fields
* configuration-based creation
* fluent APIs
* step-by-step setup
* constructor explosion

---

## Q2. Why Builder over constructor?

Because:

* constructors become unreadable
* parameter order confusion happens
* optional fields become messy

---

## Q3. Why immutable Builder preferred?

Because immutable objects are:

* safer
* thread-safe
* predictable
* easier to debug

---

## Q4. Difference between mutable and immutable builder?

| Mutable Builder          | Immutable Builder            |
| ------------------------ | ---------------------------- |
| Modifies existing object | Creates final object once    |
| Easier                   | Safer                        |
| Object exists partially  | Object created fully at once |
| Mutable fields           | Final fields                 |

---

# 📌 Complete Working Example

## 📁 HTTPRequest.java

```java
package CreationalDesignPattern.builder.pattern;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {

    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    private final boolean cachingEnabled;

    private HTTPRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.cachingEnabled = builder.cachingEnabled;
    }

    public void printRequest() {

        System.out.println("======= HTTP REQUEST =======");

        System.out.println("URL: " + url);
        System.out.println("Method: " + method);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout);
        System.out.println("Caching Enabled: " + cachingEnabled);
    }

    public static class Builder {

        private String url;
        private String method;

        private Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 3000;
        private boolean cachingEnabled = false;

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder withHeader(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder withEnableCaching() {
            this.cachingEnabled = true;
            return this;
        }

        public HTTPRequest build() {

            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("URL cannot be empty");
            }

            if (method == null || method.isEmpty()) {
                throw new IllegalArgumentException("HTTP Method required");
            }

            return new HTTPRequest(this);
        }
    }
}
```

---

## 📁 Main.java

```java
package CreationalDesignPattern.builder.pattern;

public class Main {

    public static void main(String[] args) {

        HTTPRequest request = new HTTPRequest.Builder()
                .withUrl("/users")
                .withMethod("POST")
                .withHeader("Authorization", "Bearer xyz123")
                .withHeader("Content-Type", "application/json")
                .withBody("{\"name\":\"Arjun\"}")
                .withTimeout(5000)
                .withEnableCaching()
                .build();

        request.printRequest();
    }
}
```

---

# 📌 File Structure

```text
builder-pattern/
│
├── README.md
│
└── src/
    └── CreationalDesignPattern/
        └── builder/
            └── pattern/
                ├── HTTPRequest.java
                └── Main.java
```

---

# 📌 Best One-Line Definition

> Builder Pattern is used to construct complex objects step-by-step while keeping object creation readable, flexible, and maintainable.

---

# 📌 Ultimate Intuition

Builder Pattern is NOT about:

# “Which object to create?”

It is about:

# “How to configure object cleanly?”
