import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
    public double[][] getFeatures(String filePath) throws IOException {
        ArrayList<double[]> featureList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        br.readLine(); // Ignorar o cabeçalho
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            double[] features = new double[values.length - 1]; // Última coluna é o label
            for (int i = 0; i < values.length - 1; i++) {
                features[i] = Double.parseDouble(values[i]);
            }
            featureList.add(features);
        }
        br.close();

        // Converter lista para matriz
        double[][] features = new double[featureList.size()][];
        return featureList.toArray(features);
    }

    public double[] getLabels(String filePath) throws IOException {
        ArrayList<Double> labelList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        br.readLine(); // Ignorar o cabeçalho
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            labelList.add(Double.parseDouble(values[values.length - 1])); // Última coluna é o label (preço)
        }
        br.close();

        // Converter lista para array
        double[] labels = new double[labelList.size()];
        for (int i = 0; i < labelList.size(); i++) {
            labels[i] = labelList.get(i);
        }
        return labels;
    }
}