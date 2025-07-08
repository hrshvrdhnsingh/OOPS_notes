#include <iostream>
using namespace std;
// A virtual function is a function that is declared in a base class and overridden in a derived class
// It allows runtime polymorphism (dynamic method dispatch), meaning that the function that gets called 
// depends on the actual type of the object at runtime, not the type of the reference.
// In Java, all non-static methods are virtual by default, so there is no need to use the virtual keyword like in C++.
class Base {
public:
    virtual void show() {  // Virtual function
        cout << "Base class show() function\n";
    }
};

class Derived : public Base {
public:
    void show() override {  // Overriding base class function
        cout << "Derived class show() function\n";
    }
};

// Runtime Polymorphism (also called Dynamic Polymorphism) refers to the ability of a base class pointer 
// or reference to invoke derived class methods at runtime using function overriding and virtual functions.
int main() {
    Base* basePtr;  // Base class pointer. If we use pointers instead of objects here, the whole object is
    // retained, object slicing doesn't occur and runtime polymorphism works properly. If we use object here,
    // then early-binding(compile-time) occurs and show() of Base class would be called even though virtual was used.
    // Object slicing occurs here.
    Derived derivedObj;
    
    basePtr = &derivedObj;  // Assign derived class object to base class pointer
    basePtr->show();  // Calls Derived::show() due to virtual function

    // Had the virtual keyword not been there then basePtr->show() would've called show() of Base class.
    return 0;
}
 