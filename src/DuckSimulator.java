public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();

//        simulator.simulate();

//        simulator.decoratorSimulate();

//        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
//        AbstractDuckFactory duckFactory = new EchoAndCountingDuckFactory();
//        simulator.abstractFactorySimulate(duckFactory);
//        simulator.compositeSimulate(duckFactory);
        simulator.alphaCompositeSimulate(duckFactory);
    }

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseDuck = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        System.out.println("Duck Simulator: With Goose Adapter and Pigeon Adapter");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
    }

    void decoratorSimulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        // แบบที่ QuackCounter ครอบ QuackEcho จะนับได้แค่ 5 ครั้ง
//        Quackable EchoMallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
        // แบบที่ QuackEcho ครอบ QuackCounter จะนับได้แค่ 6 ครั้ง
        Quackable EchoMallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));

        System.out.println("Duck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
        simulate(EchoMallardDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void abstractFactorySimulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        System.out.println("Duck Simulator: With Abstract Factory");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void compositeSimulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeon);

        System.out.println("Duck Simulator: With Composite - Flocks");

        simulate(flockOfDucks);
    }

    void alphaCompositeSimulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        AlphaFlock flockOfMallards = new AlphaFlock();
        flockOfMallards.add(mallardDuck);
        flockOfMallards.add(redheadDuck);
        flockOfMallards.add(duckCall);
        flockOfMallards.add(rubberDuck);
        flockOfMallards.add(gooseDuck);
        flockOfMallards.add(pigeon);

        System.out.println("Duck Simulator: With Composite - Alpha Flocks");

        simulate(flockOfMallards);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
