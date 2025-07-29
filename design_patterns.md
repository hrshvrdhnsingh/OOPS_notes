# Design Patterns

1. A reusable, general solution to a commonly occurring problem within a given context.
1. Rather than providing a finished design that you can plug into your code, a design pattern offers a template or guide for how to solve a problem in a way that’s proven, flexible, and maintainable.

### Why learn them

1. **Maintainability** : By adhering to well‑known patterns, your codebase remains easier for others (and future you) to understand and evolve.
1. **Scalability** : Patterns help you structure your code so that new features can be added with minimal changes to existing classes.
1. **Context‑Driven** : Each pattern describes the situation in which it applies (e.g., when you need to decouple components, or when you need to control how objects are created), the problem it addresses, and the solution approach.
1. **Best‑Practice Provenance** : They capture the collective experience of expert software engineers so you don’t have to reinvent tried‑and‑true solutions.


## Creational Patterns

Managing and centralizing object‐creation logic so that code is decoupled from concrete classes, making it easier to change which objects get created (and how) without touching the client code.
-  `Singleton` : Ensure a class has only one instance.
- `Factory Method` : Define an interface for creating an object, but let subclasses decide which class to instantiate.
- `Abstract Factory` : Provide an interface for creating families of related objects without specifying their concrete classes.

```Java
    // Product interface
    interface Button {
        void render();
    }

    // Concrete Products
    class WindowsButton implements Button {
        public void render() { System.out.println("Rendering Windows button"); }
    }
    class MacButton implements Button {
        public void render() { System.out.println("Rendering macOS button"); }
    }

    // Creator
    abstract class Dialog {
        public void renderWindow() {
            Button ok = createButton();  // factory method
            ok.render();
        }
        protected abstract Button createButton();
    }

    // Concrete Creators
    class WindowsDialog extends Dialog {
        protected Button createButton() { return new WindowsButton(); }
    }

    class MacDialog extends Dialog {
        protected Button createButton() { return new MacButton(); }
    }

    // Client code
    class Application {
        public static void main(String[] args) {
            Dialog dialog = System.getProperty("os").equals("Windows")? new WindowsDialog(): new MacDialog();
            dialog.renderWindow();
        }
    }
```

## Structural Patterns

Composing classes or objects into larger structures while keeping these structures flexible and easy to extend or modify, often by decoupling interfaces from implementations.

- `Adapter` : Convert the interface of a class into another interface clients expect.
- `Decorator` : Attach additional responsibilities to an object dynamically.
- `Facade` : Provide a simplified interface to a complex subsystem.

```Java
    // Target interface clients expect
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Adaptee: incompatible interface
    class AdvancedMediaPlayer {
        void playVlc(String fileName)    { System.out.println("Playing vlc: " + fileName); }
        void playMp4(String fileName)    { System.out.println("Playing mp4: " + fileName); }
    }

    // Adapter makes AdvancedMediaPlayer compatible with MediaPlayer
    class MediaAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedPlayer;
    
        public MediaAdapter(String audioType) {
            advancedPlayer = new AdvancedMediaPlayer();
        }
    
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("vlc")){
                advancedPlayer.playVlc(fileName);
            } else if(audioType.equalsIgnoreCase("mp4")){
                advancedPlayer.playMp4(fileName);
            }
        }
    }

    // Client using the adapter
    class AudioPlayer implements MediaPlayer {
        private MediaAdapter adapter;
    
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("mp3")){
                System.out.println("Playing mp3: " + fileName);
            } else {
                adapter = new MediaAdapter(audioType);
                adapter.play(audioType, fileName);
            }
        }
    }
```

## Behavioral Patterns

Defining clear protocols for object interaction and responsibility assignment, so that objects can communicate, cooperate, and evolve their behavior without tight coupling.

- `Observer` : Define a one‑to‑many dependency so that when one object changes state, all its dependents are notified.
- `Strategy` : Define a family of algorithms, encapsulate each one, and make them interchangeable.
- `Command` : Encapsulate a request as an object, thereby allowing parameterization of clients with queues, requests, and operations.

```Java
    // Observer interface
    interface Observer {
        void update(String message);
    }

    // Subject managing observers
    class NewsAgency {
        private List<Observer> subscribers = new ArrayList<>();
        void subscribe(Observer o)    { subscribers.add(o); }
        void unsubscribe(Observer o)  { subscribers.remove(o); }
        void notifyAll(String news)   {
            for (Observer o : subscribers) {
                o.update(news);
            }
        }
        // When news arrives:
        void setNews(String news) {
            System.out.println("NewsAgency: new news -> " + news);
            notifyAll(news);
        }
    }

    // Concrete Observer
    class NewsChannel implements Observer {
        private String name;
        public NewsChannel(String name) { this.name = name; }
        public void update(String news) {
            System.out.println(name + " received: " + news);
        }
    }

    // Client demo
    class Demo {
        public static void main(String[] args) {
            NewsAgency agency = new NewsAgency();
            NewsChannel cnn = new NewsChannel("CNN");
            NewsChannel bbc = new NewsChannel("BBC");

            agency.subscribe(cnn);
            agency.subscribe(bbc);

            agency.setNews("Design Patterns in OOP explained!");
        }
    }
```