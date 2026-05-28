# Visitor Pattern Complete Code + Internal Memory Visualization Notes

# Final Production-Style Project Structure

```text id="5ptw0v"
com.example.filesystem
│
├── element
│   ├── FileSystemNode.java
│   ├── TextFile.java
│   ├── ImageFile.java
│   └── VideoFile.java
│
├── visitor
│   ├── FileSystemVisitor.java
│   ├── CompressionVisitor.java
│   ├── VirusScannerVisitor.java
│   └── SizeCalculatorVisitor.java
│
└── client
    └── FileSystemClient.java
```

---

# FileSystemNode.java

```java id="7ubzsn"
package com.example.filesystem.element;

import com.example.filesystem.visitor.FileSystemVisitor;

public abstract class FileSystemNode {

    protected String name;
    protected long size;

    public FileSystemNode(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public abstract void accept(FileSystemVisitor visitor);

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
```

---

# TextFile.java

```java id="gw8mb5"
package com.example.filesystem.element;

import com.example.filesystem.visitor.FileSystemVisitor;

public class TextFile extends FileSystemNode {

    public TextFile(String name, long size) {
        super(name, size);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {

        System.out.println("TextFile accepting visitor");

        visitor.visit(this);
    }
}
```

---

# ImageFile.java

```java id="0sx35n"
package com.example.filesystem.element;

import com.example.filesystem.visitor.FileSystemVisitor;

public class ImageFile extends FileSystemNode {

    public ImageFile(String name, long size) {
        super(name, size);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {

        System.out.println("ImageFile accepting visitor");

        visitor.visit(this);
    }
}
```

---

# VideoFile.java

```java id="4iq3yq"
package com.example.filesystem.element;

import com.example.filesystem.visitor.FileSystemVisitor;

public class VideoFile extends FileSystemNode {

    public VideoFile(String name, long size) {
        super(name, size);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {

        System.out.println("VideoFile accepting visitor");

        visitor.visit(this);
    }
}
```

---

# FileSystemVisitor.java

```java id="m6cr1t"
package com.example.filesystem.visitor;

import com.example.filesystem.element.ImageFile;
import com.example.filesystem.element.TextFile;
import com.example.filesystem.element.VideoFile;

public interface FileSystemVisitor {

    void visit(TextFile textFile);

    void visit(ImageFile imageFile);

    void visit(VideoFile videoFile);
}
```

---

# CompressionVisitor.java

```java id="3n7jjg"
package com.example.filesystem.visitor;

import com.example.filesystem.element.ImageFile;
import com.example.filesystem.element.TextFile;
import com.example.filesystem.element.VideoFile;

public class CompressionVisitor implements FileSystemVisitor {

    @Override
    public void visit(TextFile textFile) {

        System.out.println(
                "Compressing text file: " +
                textFile.getName()
        );
    }

    @Override
    public void visit(ImageFile imageFile) {

        System.out.println(
                "Compressing image file: " +
                imageFile.getName()
        );
    }

    @Override
    public void visit(VideoFile videoFile) {

        System.out.println(
                "Compressing video file: " +
                videoFile.getName()
        );
    }
}
```

---

# VirusScannerVisitor.java

```java id="gj0z16"
package com.example.filesystem.visitor;

import com.example.filesystem.element.ImageFile;
import com.example.filesystem.element.TextFile;
import com.example.filesystem.element.VideoFile;

public class VirusScannerVisitor implements FileSystemVisitor {

    @Override
    public void visit(TextFile textFile) {

        System.out.println(
                "Scanning text file: " +
                textFile.getName()
        );
    }

    @Override
    public void visit(ImageFile imageFile) {

        System.out.println(
                "Scanning image file: " +
                imageFile.getName()
        );
    }

    @Override
    public void visit(VideoFile videoFile) {

        System.out.println(
                "Scanning video file: " +
                videoFile.getName()
        );
    }
}
```

---

# SizeCalculatorVisitor.java

```java id="3n9g5u"
package com.example.filesystem.visitor;

import com.example.filesystem.element.ImageFile;
import com.example.filesystem.element.TextFile;
import com.example.filesystem.element.VideoFile;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private long totalSize = 0;

    @Override
    public void visit(TextFile textFile) {

        totalSize += textFile.getSize();

        System.out.println(
                "Adding text file size: " +
                textFile.getSize()
        );
    }

    @Override
    public void visit(ImageFile imageFile) {

        totalSize += imageFile.getSize();

        System.out.println(
                "Adding image file size: " +
                imageFile.getSize()
        );
    }

    @Override
    public void visit(VideoFile videoFile) {

        totalSize += videoFile.getSize();

        System.out.println(
                "Adding video file size: " +
                videoFile.getSize()
        );
    }

    public long getTotalSize() {
        return totalSize;
    }
}
```

---

# FileSystemClient.java

```java id="9upm1r"
package com.example.filesystem.client;

import com.example.filesystem.element.*;
import com.example.filesystem.visitor.*;

public class FileSystemClient {

    public static void main(String[] args) {

        FileSystemNode textFile =
                new TextFile("notes.txt", 100);

        FileSystemNode imageFile =
                new ImageFile("photo.png", 2000);

        FileSystemNode videoFile =
                new VideoFile("movie.mp4", 50000);



        FileSystemVisitor compressionVisitor =
                new CompressionVisitor();

        textFile.accept(compressionVisitor);
        imageFile.accept(compressionVisitor);
        videoFile.accept(compressionVisitor);



        FileSystemVisitor virusScannerVisitor =
                new VirusScannerVisitor();

        textFile.accept(virusScannerVisitor);
        imageFile.accept(virusScannerVisitor);
        videoFile.accept(virusScannerVisitor);



        SizeCalculatorVisitor sizeCalculatorVisitor =
                new SizeCalculatorVisitor();

        textFile.accept(sizeCalculatorVisitor);
        imageFile.accept(sizeCalculatorVisitor);
        videoFile.accept(sizeCalculatorVisitor);

        System.out.println(
                "Total Size = " +
                sizeCalculatorVisitor.getTotalSize()
        );
    }
}
```

---

# MEMORY VISUALIZATION

# STEP 1 — Creating TextFile Object

Code:

```java id="k3d7qd"
FileSystemNode textFile =
        new TextFile("notes.txt", 100);
```

---

# Stack Memory

```text id="4q49em"
textFile
```

This variable stores:

```text id="u3grs4"
reference/address
```

NOT actual object.

---

# Heap Memory

```text id="zw9r4z"
TextFile Object
----------------------
name = "notes.txt"
size = 100
```

---

# Full Visualization

```text id="3c7ezw"
STACK
-----
textFile ----------------------+

HEAP                           |
----                           |
TextFile Object <--------------+
    |
    | inherited fields
    |
    ---> name = "notes.txt"
    ---> size = 100
```

---

# IMPORTANT

Reference type:

```text id="sbk3p0"
FileSystemNode
```

Actual object:

```text id="ls9e8u"
TextFile
```

This is runtime polymorphism.

---

# STEP 2 — Creating Visitor Object

Code:

```java id="3nrd8e"
FileSystemVisitor compressionVisitor =
        new CompressionVisitor();
```

---

# Memory Visualization

```text id="u5xrzm"
STACK
-----
compressionVisitor ------------+

HEAP                            |
----                            |
CompressionVisitor Object <-----+
```

---

# IMPORTANT

Reference type:

```text id="nl2xd9"
FileSystemVisitor
```

Actual object:

```text id="grw17o"
CompressionVisitor
```

Again:
runtime polymorphism.

---

# STEP 3 — Runtime Call Begins

Code:

```java id="3pss6l"
textFile.accept(compressionVisitor);
```

---

# Current Memory State

```text id="26nt8m"
STACK
-----

textFile -------------------------------+
                                        |
compressionVisitor ------------------+  |
                                     |  |
                                     v  v

HEAP
----

TextFile Object
----------------
name = "notes.txt"
size = 100


CompressionVisitor Object
-------------------------
```

---

# STEP 4 — JVM Resolves accept()

Code:

```java id="7fr0gj"
textFile.accept(compressionVisitor);
```

Reference type:

```text id="mk2t88"
FileSystemNode
```

Actual object:

```text id="g0qshn"
TextFile
```

JVM checks:

```text id="c5x0cu"
actual object type
```

So executed method:

```text id="dw84dg"
TextFile.accept()
```

NOT:

```text id="vwx9u0"
FileSystemNode.accept()
```

---

# STEP 5 — Entering accept()

Inside:

```java id="w4yw4o"
visitor.visit(this);
```

Now:

```text id="jlwm7d"
this = current TextFile object
```

---

# Visualization

```text id="ej4s5e"
visitor.visit(this)

             |
             |
             v

        TextFile Object
```

---

# STEP 6 — Compiler Resolves visit()

Compiler sees:

```text id="rttq3k"
this = TextFile
```

So selected overload:

```text id="2h7ceh"
visit(TextFile)
```

This is compile-time overload resolution.

---

# STEP 7 — Runtime Polymorphism Again

Visitor reference type:

```text id="8j1e8x"
FileSystemVisitor
```

Actual object:

```text id="9khn8h"
CompressionVisitor
```

So JVM executes:

```text id="n9hx0m"
CompressionVisitor.visit(TextFile)
```

---

# Final Runtime Flow

```text id="q2ecj9"
Client
  |
  | textFile.accept(visitor)
  v

TextFile.accept(visitor)
  |
  | visitor.visit(this)
  v

CompressionVisitor.visit(TextFile)
```

---

# DOUBLE DISPATCH FLOW

# Dispatch #1

```text id="gg1qik"
Which accept() method?
```

Decided by:

```text id="xn2l4p"
actual file object type
```

Result:

```text id="9smp4n"
TextFile.accept()
```

---

# Dispatch #2

```text id="0ndqwv"
Which visit(...) method?
```

Decided by:

```text id="6k9h04"
concrete type passed using this
```

Result:

```text id="9f6my6"
visit(TextFile)
```

Then runtime polymorphism chooses:

```text id="dzj3j7"
CompressionVisitor.visit(TextFile)
```

---

# WHY "this" IS IMPORTANT

Inside TextFile:

```java id="qlphm0"
visitor.visit(this);
```

Here:

```text id="8g1x5w"
this = TextFile
```

So compiler selects:

```text id="z4jlwm"
visit(TextFile)
```

---

# If We Did This Instead

```java id="x3o00t"
FileSystemNode current = this;

visitor.visit(current);
```

Now compiler sees:

```text id="2r7v2m"
FileSystemNode
```

NOT:

```text id="s5nq0h"
TextFile
```

So specific overload lost ho jata.

---

# WHY JAVA IS NORMALLY SINGLE DISPATCH

Normally Java only checks:

```text id="m3i06y"
receiver object type
```

Example:

```java id="9c9g7r"
animal.sound();
```

Only:

```text id="83vfhi"
animal object
```

participates in runtime dispatch.

Arguments do NOT participate.

That is why Java is called:

```text id="09u8fa"
single dispatch language
```

---

# HOW VISITOR CREATES DOUBLE DISPATCH

Visitor Pattern combines:

* runtime overriding
* compile-time overloading

to simulate:

```text id="c6x6yc"
double dispatch
```

Both:

* element object
* visitor object

participate in final method selection.

---

# Stateful Visitor Memory Visualization

Code:

```java id="yg8b7n"
SizeCalculatorVisitor visitor =
        new SizeCalculatorVisitor();
```

---

# Heap Object

```text id="4fxxw0"
SizeCalculatorVisitor Object
----------------------------
totalSize = 0
```

---

# After Visiting TextFile

```text id="zhq42m"
totalSize = 100
```

---

# After Visiting ImageFile

```text id="vxrv0h"
totalSize = 2100
```

---

# After Visiting VideoFile

```text id="vq6mvs"
totalSize = 52100
```

---

# Why Concrete Reference Used Here

Code:

```java id="r2d0za"
SizeCalculatorVisitor sizeVisitor =
        new SizeCalculatorVisitor();
```

instead of:

```java id="f2c2qk"
FileSystemVisitor sizeVisitor
```

because later:

```java id="4k6mnk"
sizeVisitor.getTotalSize()
```

call karna tha.

Interface reference only exposes:

```text id="jmd6ga"
visit(...)
```

methods.

Concrete-specific methods inaccessible ho jate.

---

# Complete Object Interaction Flow

```text id="s7wzqq"
Client
   |
   |
   +----------------------+
   |                      |
   v                      v

TextFile           CompressionVisitor
   |
   | accept(visitor)
   |
   v

visitor.visit(this)
   |
   v

CompressionVisitor.visit(TextFile)
```

---

# Final Core Insight

Visitor Pattern works because:

```text id="6xl4fm"
Concrete element passes
its exact concrete type
using this
```

That exact type allows:

* correct overloaded method selection
* type-specific behavior
* clean extensibility
* double dispatch simulation
