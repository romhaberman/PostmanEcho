import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class PostmanEchoTest {
    @Test
    void shouldReturnSendData() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hi") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when().log().all()
                .post("/post")
// Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hello"));

    }
}
