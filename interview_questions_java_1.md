## Programming Paradigms
A programming paradigm is a fundamental style of programming that dictates how solutions are structured.
### Imperative Programming

-   Works by changing the program state through assignment statements.
-   The main focus in this paradigm is on how to achieve the goal.
    #### Procedural
    1. Sequence of statements that change program state
    1. Use variables, assignments, loops, and subroutines (functions/procedures)
    1. Control flow is explicit (e.g., `for`, `while`, `if`)
    1. Data is often global and less secure
    1. Programs are structured as a sequence of steps or procedures
    1. ex: C, Pascal, BASIC
    #### Object-Oriented
    1. Model data and behavior together in “objects” that interact via messages/method calls
    1. A natural way to represent real-world entities
    1. Data is encapsualted within objects for better security.
    1. Programs are structured around objects and classes.
    1. ex: Java, C++
    #### Parallel Processing
    1. Multiple computations happen in overlapping time—threads, processes, or distributed nodes.
    1. Threads, locks, message-passing, actors.
    1. Synchronization primitives or lock-free data structures.
    1. ex: Java threads

### Declarative Programming

-   Focuses on what is to be executed rather than how it should be executed
-   We express the logic of a computation without considering its control flow.
    #### Logical Programming
    1. Specify what the problem is, not how to solve it. The runtime figures out the steps.
    1. Logic rules and facts; backtracking search.
    1. No explicit control flow.
    1. ex: Prolog
    #### Functional Programming
    1. Compute by evaluating (pure) functions without side-effects, treating functions as first-class values.
    1. Immutable data structures.
    1. Higher-order functions (map, reduce, filter).
    1. ex: Scala

## Advantages of OOPS

1. **Modularity :** Code is organized into discrete “classes” which makes it easier to locate, understand adn maintain functionality.
2. **Encapsulation :** Internal details (private fields, helper methods) are hidden; only a public interface is exposed.
3. **Inheritance :** One can derive new classes from existing ones, inheriting fields and methods. Promotes “DRY” (Don’t Repeat Yourself) by sharing common behavior.
4. **Polymorphism :** A single interface or base class can refer to many concrete implementations.
5. **Extensibility :** Can evolve more gracefully, without modifying existing, tested code.
6. **Real-world mapping :** Objects correspond to real entities (users, products, accounts), making designs more intuitive to non-technical stakeholders.

## Diadvantages of OOPS

1. **Complexity :** Designing correct class hierarchies takes up-front thought; naive designs can lead to deep, tangled inheritance trees.
2. **Tight-coupling :** Subclasses depend on parent implementations; changes high in the hierarchy may ripple unpredictably and break subclasses on changing base class.
3. **Incorrect use of Inheritance :** Over-using “is-a” relationships when “has-a” (composition) would be more flexible. Using inheritance where we only need the behavior and not the type, could lead to explosion of number of subclasses.
4. **Memory footprint :** Each object carries its own metadata and pointers, which can increase memory usage compared to flat data structures.
5. **Steeper Learning Curve :** Misunderstandings often lead to anti-patterns.
6. **Difficulty Testing Some Designs :** Deeply coupled classes can be harder to mock or isolate in unit tests.

## Explain Constructors

A constructor is a special member function in a class that is responsible for initializing the object of that class. It is called automatically when an object is created and is used to set initial values to the object's data members or perform any necessary setup.

```Java
public class Person {
    String name; int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

1. Initialization: The primary purpose of a constructor is to initialize the object's data members to a valid state.

1. Name and Return Type: Constructors have the same name as the class and do not have an explicit return type, not even void.

1. Implicit Invocation: Constructors are implicitly called when an object is created, without the need for explicit invocation.

1. Multiple Constructors: A class can have multiple constructors, each with different parameter lists. "super(...)" can be used to call the constructor of the superclass.

1. Copy Contructor : Purpose is to copy an object to another ie; clone an object and it's values to another object provided they are of the same class.
    ```Java
    class ABC {
        int x;
        ABC(ABC abc) {
            x = abc.x;
        }
    }
    ```

## Abstract classes

Declare a method (or class) that has no implementation and must be overridden by subclasses. Always virtual dispatch for any non-static, non-private method — even if you don’t write virtual. Marking a class as abstract means it can't be instantiated ie; it's object can't be made.

Abstract methods have no body - can't be implemented in the abstract class.

```Java
public abstract class Base {
    public abstract void foo();  // abstract → Base is abstract
}
public class Derived extends Base {
    @Override
    public void foo() { /*…*/ }
}
// Base b = new Base();    // compile‐error: Base is abstract
Base b = new Derived();    // OK
b.foo();
```

## Method overloading

Defining multiple methods in the same class that share the same name but differ in parameter lists (number, order, or types). Static-binding based on argument list.

```Java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

}
```

## Method Overriding

A subclass provides its own implementation for a method that is already defined in its superclass. The signature (name + parameters) and return type must match. Dynamic-binding. Depends on the type of object being referred to and is resolved via dynamic dispatch mechanism based on object type.

```Java
public class Animal {
    public void speak() {
        System.out.println("Animal makes a sound");
    }
}
public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}
```

## Shallow copy vs Deep copy of an object

#### Shallow copy:

1. Creates a new instance of the same class.
1. Copies all primitive fields (ints, booleans, etc.) by value.
1. Copies all reference fields (objects) by reference—so both the original and the copy point to the same sub-objects.
1. Fast, minimal work -> O(1)
1. Shared mutable state can lead to unexpected side-effects.

Used where deep duplication is costly or the object only holds immutable fields.

#### Deep copy:

1. A deep copy duplicates not only the top-level object, but also recursively copies all objects it refers to — so the copy has its own independent sub-objects.
1. O(N) work as each object has it's own copies.
1. Used where complete isolation is needed to avoid side-effects.

## Limitations of inheritance

1. Tight Coupling Between Base and Derived Classes - If you change a protected or public method or data member in the base, you may inadvertently break behavior in all subclasses(even with small changes).
1. Inflexible Hierarchies - Difficult to “insert” new abstractions or reorganize responsibilities without massive refactoring, and can end up with wide hierarchies that are hard to understand.
1. Violates Encapsulation - Subclasses often need to know about the base class’s internals (protected members), which breaks the principle of encapsulation.
1. Diamond Problem - With multiple inheritance (e.g., C++), a class can inherit the same base more than once through different paths, leading to ambiguity about which base’s implementation should be used. The alternatives ie; Interfaces add complexity
1. Overridden Methods Can Be Non-Obvious - Clients using polymorphism may call the base version unexpectedly, or vice versa, leading to subtle bugs.
1. Limited Reuse Across Unrelated Classes - You cannot share behavior via inheritance between classes that don’t naturally fit into the same hierarchy.

## Abstraction

The mechanism of hiding the complex implementation details of a system and exposing only the necessary parts to the user. It lets you focus on what an object does rather than how it does it.

#### Via Classes

1. Can have instance variables of any visibility.
1. Can define constructors (invoked via super(...)).
1. Single inheritance only (one superclass).
1. When you need to share code (common fields or method implementations) across related classes.
1. Every abstract method must be declared in subclass, unless the subclass is abstract as well.
1. Any instance methods are simply inherited, with override possible unless they are final.
1. Private methods are never inherited.

```cpp
public abstract class Vehicle {
    private String name;
    public Vehicle(String name) {
        this.name = name;
    }
    // Abstract method: must be implemented by subclasses
    public abstract void move();
    // Concrete method: shared across all vehicles
    public void printName() {
        System.out.println("Vehicle: " + name);
    }
}
// Concrete subclass providing details
public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }
    @Override
    public void move() {
        System.out.println("Driving on roads");
    }
}
```

#### Via interfaces

1. Only public static final constants (compile-time constants).
1. No constructors (cannot be instantiated or subclassed via extends in that way).
1. A class may implement multiple interfaces, allowing mix-in of behaviors.
1. When you need a pure contract without implementation or shared state.
1. Every abstract methods without a body should be implemented.
1. The default methods of the interface are inherited as it if were the subclass's own, with override possible.

```cpp
// Define an abstraction for “Playable”
public interface Playable {
    void play();         // abstract by default
    default void stop() {  // provided implementation
        System.out.println("Stopped");
    }
}

// Class can implement multiple interfaces
public class MusicPlayer implements Playable, Runnable {
    @Override
    public void play() {
        System.out.println("Playing music");
    }
}
```

## Exception

1. Exceptions are objects that represent abnormal conditions or errors that occur during program execution. They let you separate error‐handling code from your regular logic.
1. Hierarchy : Throwable is the root and has two main subclasses:
    1. Exception:
        1. Checked: _IOException_, _ClassNotFoundException_. Forced by compiler to handle or declare them.
        1. Unchecked: _RuntimeException_, _NullPointerException_, _IllegalArgumentException_. Not required to catch or declare them.
    1. Error: _OutOfMemoryError_, _StackOverflowError_. Serious problems generated by the JVM; you generally don’t catch these.
1. Throwing Exceptions
    1. To signal an error
    ```cpp
        if (configFile == null) {
        throw new IllegalArgumentException("configFile must not be null");
    }
    ```
    2. Methods can propagate checked exceptions
    ```cpp
    public void load(File f) throws IOException { … }
    ```
1. Handling exceptions:

-   Catch the most specific exceptions first

```cpp
try {
    in = new FileInputStream(filePath);
    // … read from stream …
}
catch (FileNotFoundException fnfe) {
    System.err.println("File not found: " + fnfe.getMessage());
}
catch (IOException ioe) {
    System.err.println("I/O error: " + ioe.getMessage());
}
finally { // Runs always - for cleanup
    if (in != null) in.close();
}
```

## Garbage Collection

Java’s garbage collection (GC) is the automatic process by which the JVM reclaims memory that’s no longer in use by your application, freeing you from explicit free() or delete() calls. At a high level, GC:

1. Reduces Memory Leaks by automatically cleaning up objects that are no longer reachable.
1. Simplifies Code by removing the need for manual memory management.

#### JVM Heap Structure

1. Young(Eden) Survivor:
    - Where new objects are allocated.
    - Objects that survive one GC cycle move here.
1. Old Generation
    - Objects that survive multiple young-GCs get “promoted” here.
1. Metaspace
    - Stores class metadata

#### Phases

1. Traverse the object graph from the root and mark all reachable objects.
1. Unmarked objects are reclaimed and moves live objects together and reclaims the rest reducing fragmentation. Also moves the enw objects to the one-cycle passed phase.
1. Slide objects to one end of memory region to reduce fragmentation.
1. Minor GC - Collects just the young gen. Fast, frequent.<br> Major GC - Collects old + young. Slower, less frequent.

