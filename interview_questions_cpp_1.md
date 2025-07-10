## Difference between C and C++

**1. Paradigm :** C is a procedural language where the code revolves around functions and global data. Wherease C++ is a multi-paradigm language, which allows procedural, object-oreiented, and generics(templates).

**2. Object-oriented features:** C has no built-in support for classes, inheritance, or polymorphism whereas C++ introduces classes, access specifiers (public/private/protected), inheritance, virtual functions, operator-overloading and polymorphism.

**3. Libraries:** C has a small standard library (<stdio.h>,<stdlib.h>, <string.h>, etc.). I/O is done via printf/scanf. C++ has a much richer STL: containers (vector, map, etc.), algorithms, smart pointers, and I/O streams (cout, cin).

**4. Compatibily :** C++ is usually considered a super-set of C. Where code in C can be run on C++ with some changes, but very few C++ code can run on C.

**5. Abstractions :** C++ provides much more abstractions like namespaces, exceptions, templates etc. whcih makes it easier to wrote complex code when comapred to C.

**6. Type safety :** C has looser type checking and C-style casts ((int)x). Every cast looks the same so it's hard to tell whether we are converting or narrowing to a numeric type.

C++ adds stricter compile-time checks and four distinct casts (static_cast, dynamic_cast, const_cast, reinterpret_cast) for clarity and safety.

```cpp
struct Base { virtual ~Base(){} };
struct Derived : Base { void onlyInDerived(); };

Base* b = new Derived;

// static_cast: compile-time conversion, no runtime check
// Prevents accidental misuse if conversions and makes intentions explicit
Derived* d1 = static_cast<Derived*>(b);
```

**7. Use Cases :** C is often used for low-level programming, system-level programming, embedded systems, and building efficient and lightweight applications. It's popular in operating system development and writing device drivers. C++ is used in a wide range of applications, including game development, graphical user interfaces (GUIs), complex software systems, and large-scale projects that benefit from OOP concepts.

## Low-level vs High-level
- C++ is both(speed and simplicity)

### Low-level language
1. Abstraction - Close to machine code
1. Ease of use - Harder to write & understand
1. Performance - Very fast (direct hardware control)
1. Examples - Assembly, C
1. Memory Management - Manual(Direct Access)
### High-level langauge
1. Abstraction - More human-readable
1. Ease of use - Easier to write & maintain
1. Performance - Slightly slower due to abstraction
1. Examples - C++, Python, Java
1. Memory Management - Automatic (Garbage Collection)

## Key features in C++

**1. OOPS :** C++ supports OOP, allowing you to create classes and objects to encapsulate data and behavior. This feature enables concepts like inheritance, polymorphism, and encapsulation, making and reusability easier. Classes represent objects and define their properties(data members) and behaviour(member functions). Objects are instances of classes.

**2. Templates :** C++ supports templates, which allow you to write generic code that can work with different types. Templates facilitate the creation of functions and classes that can operate on various data types.

```cpp
// A simple function template to return the larger of two values. The type of a and b could be numbers, strings and characters.
template<typename T>
T max_value(T a, T b) {
    return (a > b) ? a : b;
}
```

**3. STL :** The STL is a collection of template classes and functions that provide commonly used data structures (like vectors, lists, and maps) and algorithms (such as sorting and searching). Simplifies the implementation of complex data structures and algorithms in C++.

**4. Exception Handling :** It provides constructs like try, catch, and throw to manage exceptional conditions and perform error handling.

**5. Performance :** Supports features like pointers and direct memory manipulation, enabling developers to optimize code execution and memory usage.

**6. Operator overloading :** Enables you to define custom behaviors for operators when applied to objects of user-defined classes.

```cpp
class Complex {
    double re, im;

public:
    Complex(double r = 0, double i = 0) : re(r), im(i) {}

    // Overload the + operator to add two Complex numbers
    Complex operator+(const Complex& other) const {
        return Complex(re + other.re, im + other.im);
    }
};
```

Over all these, C++ ranks 2nd in programming for usage and the large community allows us to have up-to-date blogs on topic and expert views from the industry versions.

## Difference between class and object

#### Class  
- A blueprint or template that defines:Data members (attributes/state), Member functions (behaviors/operations). 
- Declares what an entity looks like and what it can do, but doesn’t allocate storage. 
- Classes do not consume any memory. They are just a blueprint.

```cpp
class Person {
public:
    string name; int age;
    void introduce() const {
        cout << "Hi, I'm " << name << " and I'm " << age << " years old.\n";
    }
};
```

#### Objects 
- A concrete instance of a class. When you create an object, memory is allocated for its data members, and you can invoke its member functions. 
- Represents one specific entity defined by the class. 
- When objects are created, they actually initialize the class members and methods and therefore consume memory.
- Class is just a template; objects bring it to life by holding real values. They allow actions using their methods and promote code reuse, and easy debugging.

```cpp
int main() {
    Create objects (instances) of that class
    Person alice;          // stack-allocated object
    alice.name = "Alice";
    alice.age = 30;

    Person* bob = new Person(); // heap-allocated object
    bob->name = "Bob";
    bob->age  = 25;

    alice.introduce();   // prints: Hi, I'm Alice and I'm 30 years old.
    bob->introduce();    // prints: Hi, I'm Bob and I'm 25 years old.
}
```

## What are deconstructors

A destructor is a special member function in a class that is responsible for cleaning up resources and performing necessary cleanup tasks when an object is destroyed or goes out of scope. It is called automatically when the lifetime of an object ends, either when it goes out of scope or when it is explicitly deleted.

```cpp
class Resource {
private:
    int* data;
public:
    Resource() {
        data = new int[100];  // Allocate dynamic memory
        cout << "Resource created." << endl;
    }

    ~Resource() { // No explict invocation
        delete[] data;  // Deallocate dynamic memory
        cout << "Resource destroyed." << endl;
    }
};
```

## Virtual Functions

```cpp
struct Base {
    // If a class has even a single pure virtual function - then the class is abstract.
    virtual void foo() = 0; // Pure virtual function  has to be overriden by subclasses to allow it get instantiated on it' own.
    virtual void foo2() { }
};
struct Derived : Base {
    void foo() override {}
    void foo2() override {}
};
// Base b;           // ERROR: abstract
Derived d;          // OK
Base* p = new Derived();
p->foo();           // calls Derived::foo()
```

- Enable runtime polymorphism (dynamic dispatch) for a method. Not virtual unless you mark it. 
- A class having all virtual fucntions is by default abstract. (Dynamic polymorphism) When a virtual function is called, the actual function that runs is looked up at runtime via the v-table(a hidden table of function pointers). 
- Enables function overriding.
- If the base class becomes abstract, then it can't be instantiated.
- Constructors cannot be virtual because vtables (virtual tables) are set up after the object is constructed.


## What are inline-functions

- An inline function in C++ is one where you suggest to the compiler that, instead of performing a normal call/return sequence, it should (where possible) replace each call with the function’s actual body. 
- This can eliminate the overhead of a function call, at the cost of potentially larger generated code.
- As when a function is called, the CPU stores the return address, copies arguments to the call stack, and transfers control to the function. 
- After execution, the return value is stored, and control is returned to the caller. 
- This overhead can be significant for small, frequently used functions, as their execution time is less than the time spent on the call and return process.

```cpp
inline int cube(int x) {
    return x * x * x;  // small enough to inline everywhere
}
```

Each call to square(x) is replaced by x \* x.

## Difference between new and malloc

malloc and new are both mechanisms to allocate memory at runtime — but they work quite differently.

#### Syntax and Safety

```cpp
int* p = (int*)malloc(10 * sizeof(int));
```

Returns a void\*, so you must cast to the desired pointer type and reserves that size bytes on heap. No compile‐time check that the cast is valid—easy to introduce bugs.

```cpp
int* q = new int[10];
```

Returns a pointer of the correct type—no cast needed. Safer as the compiler knows you’re allocating int[].

#### Object Construction & Initialization

**malloc :** Only allocates raw memory; it does not call any constructors or initialize built-in types. You must manually construct objects with placement new if you need initialization.

**new :** Allocates memory and calls the constructor for objects. For built-in types, you can choose: new T; → default‐initializes built-ins (leaves them uninitialized); new T(); → value‐initializes (zeroes built-ins).

#### Error Handling

**malloc :** Returns nullptr on failure. You must always check the return value to avoid dereferencing a null pointer.

**new :** By default, throws bad_alloc on failure

#### Customization

**malloc :** Is a single library function; you can’t override its behavior.

**new :** Can be globally or class-specifically overloaded to control allocation strategy (pool allocators, debugging hooks, etc.).

## What are namespaces

A namespace in C++ is a declarative region that groups related identifiers—types, functions, variables—to avoid name collisions and clarify intent. Two libraries might both define a function called print() and also allows to group realted code under a common name like network::, db:: ,etc. Putting them in different namespaces prevents conflicts:

```cpp
namespace Audio {
  void init();
}
namespace Video {
  void init();
}

Audio::init();  // calls Audio’s init
Video::init();  // calls Video’s init
```

## Multiple-inheritance in C++

```cpp
class A {
public:
    A(int x) {}
};

class B {
public:
    B(double y) {}
};

class C : public A, public B { // Inherits both the individual bases
public:
    C(int x, double y): A(x), B(y) { }
};
```

-   Each of the non-default constructors needs to be explicitly invoked in the derived class.
-   **Constructor Delegation :** Allows one constructor to call another constructor within the same class. Helps avoid code duplication and make object initialization cleaner and maintainable.
    ```cpp
        Rectangle(int side) : Rectangle(side, side) { // calls the primary constructor Rectangle(side, side)
            cout << "Delegating constructor called" << endl;
        }
    ```

## Lambda functions

-   A lambda function (or lambda expression) is a concise way to define an anonymous function object “in place,” capturing local variables if needed.
-   Lambdas are especially handy for short callbacks, algorithms, and event handlers.
-   Makes code more concise and expressive.

```cpp
int main() {
    auto dfs = [&](int r, int c) -> bool {
        return true;
    };
}
```

#### Function Object

Simply any class or struct that overloads operator(), so its instances can be “called” like functions. The compiler knows the type at compile-time, thus calls can be inlined - no calling overhead.

```cpp
class Compare {
public:
bool operator()(data_type a, data_type b) {
    if(cond) {
        return true;
    }
    return false;
}
};
```

## Struct vs Class

#### Struct

```cpp
struct Point {
    double x, y;// members default to public
    void move(double dx, double dy) { // methods default to public
        x += dx; y += dy;
    }
};

struct Derived1 : Point { };  // public Base ie; the access modifiers are retained
```
-   NO direct access restriction
-   Members and methods default to public
-   Public inheritance by default

#### Class

```cpp
class Circle {
    double radius; // members default to private
public:
    Circle(double r) : radius(r) {}
    double area() const {
        return 3.14159 * radius * radius;
    }
};

class  Derived2 : Point { };  // private Base ie; the methods
// are now private and the private in Point is not accessible.
```
-   Allows encapsulation via private and protected members
-   Members and methods default to private
-   Private inheritance by default
-   Supports methods, constructors, and destructors

## Threading

```cpp
#include <iostream>
#include <thread>

void worker(int id) {
    cout << "Worker " << id << " starting\n";
    // code logic
    cout << "Worker " << id << " done\n";
}

int main() {
    // Launch two threads running the same function with different arguments
    thread t1(worker, 1);
    thread t2(worker, 2);

    // Wait for them to finish. No guarantee over which one OS schedules first or how they interleave.
    // Join() just waits; it doesn't force ordering.
    t1.join();
    t2.join();

    cout << "All workers finished\n";
}
```

## Synchronization

### Mutex

```cpp
#include <mutex>

mutex mtx; // The gatekeeper to create a lock so only one thread can hold mutex at a time.
int counter = 0; // The shared resource

void increment() {
    for (int i = 0; i < 1000; ++i) {
        // On construction calls mtx.lock(), blocking if another already holds.
        // On deconstruction call mtx.unlock(), letting another thread access it.
        lock_guard<mutex> lock(mtx);
        ++counter;
    }
}

int main() {
    thread a(increment), b(increment);
    a.join(); b.join();
    // counter is now reliably 2000
    // Without the mutex, the counter would vary as boh these threads read the same
    // value of counter before either write it back so one incrmen overrides the other.
}
```

## Resource Acquisition is Initialization (RAII)

RAII ties resource lifetime (memory, locks, file handles, sockets, etc.) to object lifetime:

-   Acquire the resource in the constructor.
-   Release it in the destructor—this runs automatically, even if an exception unwinds the stack through that scope.

#### Common RAII Types

-   std::unique_ptr<T> / std::shared_ptr<T> : Manages heap memory ie; new/delete under the hood.
-   std::lock_guard<std::mutex> / std::unique_lock<std::mutex> : Locks a mutex in their constructor and unlocks in their destructor.
-   std::thread (joining) : Ensures you don’t accidentally let a std::thread go out of scope without joining or detaching.

## unique_ptr vs shared_ptr vs weak_ptr(Smart pointers)

```cpp
std::unique_ptr<Widget> up1(new Widget);
std::unique_ptr<Widget> up2 = std::move(up1);  // transfer ownership
// up1 is now empty; up2 owns the Widget


std::shared_ptr<Widget> sp1(new Widget);
std::shared_ptr<Widget> sp2 = sp1;             // both share ownership
// object destroyed only when BOTH sp1 and sp2 are reset or go out of scope

std::weak_ptr<Widget> wp = sp1;
```

#### unique_ptr

1. Exclusive ownership
1. Not copyable but can be moved
1. Internally just a raw pointer
1. Single owner so no need for built-in synchronization

#### shared_ptr

1. Shared ownership
1. Copyable and movable too
1. Has a control block with deleter, allocator and pointer to the managed object. Also a ref_count(which is 2 in this case)
1. Access to the managed object itself needs synchronization(like locking)

#### weak_ptr

1. Observer for an object managed by one or more shared_ptr
1. Allows to check existence of object
1. Allows temporarily acquiring the object when needed to use it.

## constexpr specifier

1. Variables - Implicitly const, compile-time initialized
1. Functions - Single‐return, no side effects, compile-time evaluable and can be used in constant expressions
1. Constructors - Can produce constant expressions for objects

Basically we push the computation into the compiler yielding safer and faster code.

## File I/O

#### Writing to a file

```cpp
#include <fstream>
#include <iostream>

int main() {
    std::ofstream out("example.txt");
    if (!out) {
        std::cerr << "Failed to open file for write\n";
        return 1;
    }

    out << "Line 1\n";
    out << "Line 2: " << 42 << "\n";

    // out.close() is called automatically when out goes out of scope
    return 0;
}
```

#### Reading from a file

```cpp
#include <fstream>
#include <iostream>
#include <string>

int main() {
    std::ifstream in("example.txt"); // open for reading
    if (!in) {
        std::cerr << "Failed to open file for read\n";
        return 1;
    }

    std::string line;
    while (std::getline(in, line)) { // read line by line
        std::cout << "Read: " << line << "\n";
    }

    return 0;
}
```



    