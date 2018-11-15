public class runCalculator {
    public static void main(String[] args) {
        modelCalculator model = new modelCalculator();
        viewCalculator view = new viewCalculator();
        controllerCalculator controller = new controllerCalculator(model, view);

    }


}
