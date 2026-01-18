import smile.regression.OLS;

public class Predictor {
    private OLS model; // Modelo de regressão linear

    // Treinar o modelo
    public void train(double[][] features, double[] labels) {
        model = new OLS(features, labels);
        System.out.println("Modelo treinado com sucesso!");
    }

    // Realizar uma previsão
    public double predict(double[] inputFeatures) {
        if (model == null) {
            throw new IllegalStateException("O modelo ainda não foi treinado!");
        }
        return model.predict(inputFeatures);
    }
}