package Lesson2;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

//Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class Task2 {

    public static void JSONParser() {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        List<JSONObject> students = parseJSON(jsonString);

        StringBuilder output = new StringBuilder();

        for (JSONObject student : students) {
            String surname = student.getString("фамилия");
            String grade = student.getString("оценка");
            String subject = student.getString("предмет");

            output.append("Студент ").append(surname)
                    .append(" получил ").append(grade)
                    .append(" по предмету ").append(subject).append(".\n");
        }

        System.out.println(output.toString());
    }

    private static List<JSONObject> parseJSON(String jsonString) {
        Objects.requireNonNull(jsonString);

        List<JSONObject> result = new ArrayList<>();

        jsonString = jsonString.trim();

        if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
        }

        String[] elements = jsonString.split("\\},\\s*\\{");

        for (String element : elements) {
            element = element.trim();

            if (!element.startsWith("{")) {
                element = "{" + element;
            }

            if (!element.endsWith("}")) {
                element = element + "}";
            }

            JSONObject jsonObject = parseJSONObject(element);

            if (jsonObject != null) {
                result.add(jsonObject);
            }
        }

        return result;
    }

    private static JSONObject parseJSONObject(String jsonString) {
        Objects.requireNonNull(jsonString);

        jsonString = jsonString.trim();

        if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
            return null;
        }

        jsonString = jsonString.substring(1, jsonString.length() - 1).trim();

        String[] keyValuePairs = jsonString.split(",");

        JSONObject jsonObject = new JSONObject();

        for (String keyValuePair : keyValuePairs) {
            String[] parts = keyValuePair.split(":");

            if (parts.length != 2) {
                return null;
            }

            String key = parts[0].trim();
            String value = parts[1].trim();

            if (key.startsWith("\"") && key.endsWith("\"")) {
                key = key.substring(1, key.length() - 1);
            } else {
                return null;
            }

            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            } else {
                return null;
            }

            jsonObject.put(key, value);
        }

        return jsonObject;
    }
}

class JSONObject {
    private final List<String> keys;
    private final List<String> values;

    public JSONObject() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void put(String key, String value) {
        keys.add(key);
        values.add(value);
    }

    public String getString(String key) {
        int index = keys.indexOf(key);
        return (index != -1) ? values.get(index) : null;
    }
}