public class Main {
    public static void main(String[] args) {
        // Примерные данные (вместо реальных данных используйте свои)
        double[][] trainingInputs = {
            {1.0, 0.5, 0.2}, // Пример изображения или вектора
            {0.4, 1.0, 0.5},
            {0.3, 0.6, 0.9}
            // Добавьте больше изображений
        };
        int[] labels = {0, 1, 1}; // Соответствующие метки классов
        
        // Настройка когнитрона
        int inputSize = 3; // Размер входа
        int outputSize = 2; // Количество классов
        Cognitron cognitron = new Cognitron(inputSize, outputSize);
        
        // Обучение
        cognitron.train(trainingInputs, labels, 0.01, 100);
        
        // Тестирование
        double[] testInput = {0.5, 0.5, 0.1};
        int predictedClass = cognitron.predict(testInput);
        System.out.println("Предсказанный класс: " + predictedClass);
    }
}
