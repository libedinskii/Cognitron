import java.util.Random;

public class Cognitron {
    private double[][] weights; // Матрица весов
    private int inputSize; // Размер входного вектора
    private int outputSize; // Количество классов
    
    public Cognitron(int inputSize, int outputSize) {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
        this.weights = new double[outputSize][inputSize];
        initializeWeights();
    }
    
    // Инициализация весов случайными значениями
    private void initializeWeights() {
        Random rand = new Random();
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                weights[i][j] = rand.nextDouble() * 0.1; // Небольшие значения
            }
        }
    }
    
    // Метод активации (пороговая функция)
    private int activationFunction(double[] input) {
        double[] output = new double[outputSize];
        for (int i = 0; i < outputSize; i++) {
            output[i] = 0;
            for (int j = 0; j < inputSize; j++) {
                output[i] += weights[i][j] * input[j];
            }
        }
        // Возвращаем индекс класса с максимальным значением
        return maxIndex(output);
    }
    
    // Функция максимума
    private int maxIndex(double[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    // Метод обучения когнитрона
    public void train(double[][] inputs, int[] labels, double learningRate, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                int predicted = activationFunction(inputs[i]);
                int target = labels[i];
                // Обновление весов, если предсказание неверное
                if (predicted != target) {
                    for (int j = 0; j < inputSize; j++) {
                        weights[target][j] += learningRate * inputs[i][j]; // Обновление для целевого класса
                        weights[predicted][j] -= learningRate * inputs[i][j]; // Уменьшение для предсказанного класса
                    }
                }
            }
        }
    }
    
    // Метод распознавания образа
    public int predict(double[] input) {
        return activationFunction(input);
    }
}
