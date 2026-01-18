import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Carregar os dados
        String filePath = "data/housing.csv"; // Substituir com o caminho do dataset
        DataLoader dataLoader = new DataLoader();
        double[][] features = dataLoader.getFeatures(filePath); // Características
        double[] labels = dataLoader.getLabels(filePath); // Preços

        // Criar e treinar o modelo
        Predictor predictor = new Predictor();
        predictor.train(features, labels);

        // Fazer uma previsão de exemplo
        double[] novoImovel = {3000, 4, 1}; // Área (m²), Quartos, Localização (codificada)
        double precoPrevisto = predictor.predict(novoImovel);
        System.out.println("Preço previsto: R$ " + precoPrevisto);
    }
}