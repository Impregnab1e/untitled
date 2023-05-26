package Lesson2;
//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


public class Task1 {
    public static void SQLQueryBuilder () {
        String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        StringBuilder whereClause = new StringBuilder("select * from students where ");

        String[] filters = jsonFilter.replace("{", "").replace("}", "").split(",");

        boolean isFirstFilter = true;

        for (String filter : filters) {
            String[] keyValue = filter.split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            if (!value.equals("null")) {
                if (!isFirstFilter) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append(" = '").append(value).append("'");
                isFirstFilter = false;
            }
        }

        System.out.println(whereClause.toString());
    }
}