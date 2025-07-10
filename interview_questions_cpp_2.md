## Direct Memory Allocation
```cpp
int main() {
    // Allocating memory for a single integer
    int* ptr = new int(10);
    cout << "Value: " << *ptr << endl;

    // Allocating memory for an array
    int* arr = new int[5]{1, 2, 3, 4, 5};

    cout << "Array elements: ";
    for (int i = 0; i < 5; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    // Freeing the allocated memory
    delete ptr;   // Free single integer
    delete[] arr; // Free array
}
```

1. Allows memory to be allocated at runtime, rather than at compile time.
1. This is done using the new keyword, which allocates memory on the heap and returns a pointer to the allocated space.
1. The allocated memory must be freed using the delete operator to prevent memory leaks.

**Purpose :** Allows dynamic object creation and flexible memory management

#### Benefits
    1. Efficient Memory Usage – Allocates memory only when needed, reducing wastage.
    1. Supports Object-Oriented Programming (OOP)
    1. Flexible Array Allocation – Arrays can be allocated dynamically based on user input.
    1. Lifetime Control – Objects persist beyond function calls if necessary.

## Arrow (->) and Dot (.) Operator
- used to access members (variables or functions) of classes

#### .(Dot Operator)
    - Purpose: Used to access members of an object directly.
    - When to Use? When you have an object (not a pointer).
    - Benefits: Simple and easy to read.
#### ->(Arrow Operator)
    - Purpose: Used to access members of an object through a pointer.
    - When to Use? When you have a pointer to an object.
    - Benefits: Allows working with dynamically allocated objects and supports polymorphism.

## Object Creation
#### Without new
```cpp
    int main() {
        MyClass obj;
        return 0;
    }
```
-  obj is allocated on the stack
- The memory is automatically managed and released when the function/block scope ends. No manual delete is required

#### With new
```cpp
    int main() {
    MyClass* obj = new MyClass(); 
    delete obj; // Manually releasing memory
}
```
- Stored in the heap section of memory
- Must be manually deallocated using delete to avoid memory leaks

## const keyword

#### Data members
    - Is a variable within a class whose value cannot be modified after initialization
    - It must be initialized at the time of object creation

#### Member functions
    - Ensures that no class data members (whether const or non-const) can be modified inside it
    - Only allows memory reading
    - Can be accessed by both const and non-const objects

#### Objects
    - Only allows memory reading
    - Cannot modify any data member
    - const objects can only call const member functions

## Solution to the Diamond Problem
```cpp
class A {
public:
    void say() {
        cout << "Hello world" << endl;
    }
};

class B : public virtual A {
};

class C : public virtual A {
};

class D : public B, public C {
};

int main() {
    D abc;
    abc.say();
}
```
- A virtual base class prevents multiple instances of a base class from appearing in the hierarchy.
- Problem: 
    - Class A is a parent class of classes B and C
    - Classes B and C are both parents of class D
    - When D tries to access members of A, it inherits them twice (once through B and once through C)

- Solution: 
    - To solve this issue, declare class A as a virtual base class using the virtual keyword
    - virtual ensures A is inherited only ince
    - This ensures that only one copy of A's members is shared among B and C
    - D inherits from both B and C, but only one copy of A exists

## V-Table
- Due to virtual functions,function calls needed to be determined at runtime (dynamic binding)
- V-Tables solve this problem by storing pointers to the correct function at runtime, allowing polymorphism to work.
- The V-Table stores pointers to virtual functions of that class.
- Each object of such a class has a hidden pointer called vptr (Virtual Pointer) that points to the class's V-Table.

## Object Relations

### 1. Association
    ```cpp
    class Doctor {
    public:
        string name;
        Doctor(string n) : name(n) {}

        void treat() {
            cout << name << " is treating a patient." << endl;
        }
    };

    class Patient {
    public:
        string name;
        Patient(string n) : name(n) {}

        void consult(Doctor &doc) {
            cout << name << " is consulting " << doc.name << "." << endl;
        }
    };
    ```
- Connection between classes where objects interact but have independent cycles
- There is no strict ownership
- ex: Multiple Patients can associate with multiple Doctors, but neither owns the other.

### 2. Aggregation (Has-A Relationship)
- **Has-A :** It represents an object containing another object as part of its attributes. Helps in code reusability.
```cpp
class Employee {
public:
    string name;
    Employee(string n) : name(n) {}
    void show() {
        cout << "Employee: " << name << endl;
    }
};

class Company {
public:
    string companyName;
    vector<Employee*> employees;  // Aggregation: Employees exist independently

    Company(string name) : companyName(name) {}

    void addEmployee(Employee* emp) {
        employees.push_back(emp);
    }
    void showEmployees() {
        cout << companyName << " has employees: " << endl;
        for (auto emp : employees) {
            emp->show();
        }
    }
};

int main() {
    Employee e1("John"), e2("Alice");
    Company c1("Tech Corp");
    c1.addEmployee(&e1);
    c1.addEmployee(&e2);
    c1.showEmployees();
}
```
- Objects have their own lifecycle but their is an ownership between parent and child.
- Parent has children but they are independent and can be shared where the parent holds reference to children, not the actual object
- ex: A single Employee can belong to multiple Companies, but deleting a company does not delete the employee
- ex: A company has multiple employees, but if the company is deleted, the employees still exist

### 3. Composition (String Has-A Relationship)
    ```cpp
    class Heart {
    public:
        Heart() {
            cout << "Heart Created!" << endl;
        }
        ~Heart() {
            cout << "Heart Destroyed!" << endl;
        }
    };

    class Person {
    private:
        Heart heart;  // Composition: Heart belongs to Person

    public:
        Person() {
            cout << "Person Created!" << endl;
        }
        ~Person() {
            cout << "Person Destroyed!" << endl;
        }
    };

    int main() {
        Person p1;
    }
    ```
>Heart Created!<br>
>Person Created!<br>
>Person Destroyed!<br>
>Heart Destroyed!
- Form of aggreagation where teh child object can't exist without the parent. If parent is deleted, so is the child
- ex: A human has a heart; the heart cannot exist without the human
- ex: A Person has a Heart; if the person is deleted, the heart must also be deleted

### 4. Generalization (Is-A Relationship)
- **Is-A :** One class is a specialized version of another class, allowing it to inherit properties and behaviors
```cpp
class Vehicle {
public:
    void move() {
        cout << "Vehicle is moving..." << endl;
    }
};

class Car : public Vehicle { // Is-a Relationship
public:
    void honk() {
        cout << "Car horn: Beep Beep!" << endl;
    }
};

int main() {
    Car myCar;
    myCar.move();
    myCar.honk();
}
```
- Code reusability via inheritane
- Less flexible and tightly coupled
- Changes in the base class affects derived classes

## Real-life Example
```cpp
class BankAccount {
private:
    double balance;

public:
    void deposit(double amount) { /*...*/ }
    void withdraw(double amount) { /*...*/ }
    double getBalance() const { return balance; }
};

```
### 1. **Class**
- `BankAccount` class: Defines attributes like accountNumber, accountHolderName, and balance

### 2. **Object**
- `account1`, `account2` :  Instances of the BankAccount class representing actual customer accounts

### 3. **Encapsulation** 
- Private: balance is private and accessed via public methods like `deposit()` and `withdraw()` 
- Users can't directly modify balance; internal validation ensures safe access

### 4. **Abstraction**
- The user calls `withdraw()` without knowing how overdraft checks, transaction logging, or fee deductions work
- Complex implementation is hidden behind simple method calls

### 5. **Inheritance**
```cpp
class SavingsAccount : public BankAccount {
    // inherits BankAccount and adds interest
};
class CurrentAccount : public BankAccount {
    // inherits BankAccount and adds overdraft features
};
```

### 6. **Polymorphism**
- `calculateInterest()` behaves differently in `SavingsAccount` and `CurrentAccount`

### 7. **Static vs Dynamic Binding**
- **Static :** Method `printStatement()` is resolved at compile time
- **Dynamic :** Virtual method `calculateInterest()` is resolved at runtime when called via base pointer

### 8. **Function Overloading**
```cpp
void openAccount(string name);
void openAccount(string name, double initialDeposit);
```

### 9. **Function Overriding**
```cpp
class BankAccount {
public:
    virtual void calculateInterest() {
        cout << "Base Interest Calculation" << endl;
    }
};

class SavingsAccount : public BankAccount {
public:
    void calculateInterest() override {
        cout << "Savings Account Interest Calculation" << endl;
    }
};
```

### 10. **Inheritance Types**
- **Single Inheritance :** `SavingsAccount` inherits from `BankAccount`
- **Multiple Inheritance :** `HybridAccount` inherits from `SavingsAccount` and `InvestmentAccount`.
- **Hierarchical Inheritance :** `BankAccount` → `SavingsAccount`, `CurrentAccount`, `FixedDepositAccount`