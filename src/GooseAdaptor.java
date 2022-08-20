public class GooseAdaptor implements Quackable {
    private Goose goose;

    public GooseAdaptor(Goose goose) {
        this.goose = goose;
    }

    // ในเมื่อมันไม่ร้อง quack เราเลยต้องเก็บ implementation นั้นไว้ข้างใน
    @Override
    public void quack() {
        goose.honk();
    }
}
