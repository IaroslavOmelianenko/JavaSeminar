public class Task1 {
    /***
     * 1) Дана строка sql-запроса "select * from students where ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */

    public void formRequest() {
        String jsonFilterParameters = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String sqlRequest = "SELECT * FROM STUDENTS WHERE ";

        StringBuilder sqlRequestBuilder = new StringBuilder();
        sqlRequestBuilder.append(sqlRequest);

        jsonFilterParameters = jsonFilterParameters
                .substring(1, jsonFilterParameters.length() - 1)
                .replaceAll(":", "=")
                .replaceAll("\"", "'")
                .replaceAll(",", " AND");

        String[] jsonFilterParametersArray = jsonFilterParameters.split("(?=AND)");
        for (String parameter : jsonFilterParametersArray) {
            if (!parameter.contains("null")) {
                sqlRequestBuilder.append(parameter);
            }
        }
        System.out.println(sqlRequestBuilder);
    }
}
