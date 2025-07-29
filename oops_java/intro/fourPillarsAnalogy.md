### 1. Encapsulation  
**Real‑life analogy:** A car’s engine and transmission live under the hood, hidden from the driver.  
- **Hidden internals:** You don’t tinker with pistons or spark plugs while driving.  
- **Public interface:** You control the car via the steering wheel, pedals, gear selector.  
- **Benefit:** Keeps you safe from complexity and lets the manufacturer change the engine design without altering how you drive.

---

### 2. Abstraction  
**Real‑life analogy:** The car’s dashboard shows only what you need to know (speed, fuel level), not every sensor reading.  
- **Simplified view:** You see “80 km/h” or “½ tank,” not “oxygen sensor at 0.21 V.”  
- **Essential operations:** Turn the key (or push “Start”), press the accelerator, flip on the headlights.  
- **Benefit:** You don’t have to learn every detail of how the engine or electronics work—just the high‑level commands you need.

---

### 3. Inheritance  
**Real‑life analogy:** Different vehicle models (sedan, SUV, pickup) all build upon a common “Vehicle” blueprint.  
- **Base blueprint:** Wheels, seats, steering mechanism, engine mount.  
- **Specialization:**  
  - **Sedan:** inherits the base and adds a trunk.  
  - **SUV:** inherits the base and adds four‑wheel drive.  
  - **Pickup:** inherits the base and adds a cargo bed.  
- **Benefit:** You reuse common design components and only extend or override what’s different.

---

### 4. Polymorphism  
**Real‑life analogy:** You “start” any vehicle the same way—even if the exact mechanism differs.  
- **Common action:** Turn the key or push the “Start” button.  
- **Different implementations:**  
  - Gasoline car: cranks the starter motor.  
  - Hybrid: engages an electric motor first.  
  - Electric car: activates the battery management system.  
- **Benefit:** You write one “startEngine()” routine that works with any vehicle type, and each model does what it needs under the hood.
