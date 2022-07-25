package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


public class RequestTest {
    public static final String URL = "https://reqres.in";

    @Test
    public void checkAvatarsTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatar");

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }

        Assert.assertTrue(emails.stream().allMatch(x -> x.endsWith("@reqres.in")));

    }

    @Test
    public void successRegistration() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4, id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }

    @Test
    public void unSuccessRegistration() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseError400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "sydney@fife");
        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals("Missing password", error);
    }

    @Test
    public void createUserTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(201));
        given()
                .when().post("api/users")
                .then()
                .log().all();
    }

    @Test
    public void updateUserTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .when().put("api/users/2")
                .then()
                .log().all();
    }

    @Test
    public void deleteUserTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(204));
        given()
                .when().delete("/api/users/2")
                .then()
                .log().all();
    }

    @Test
    public void checkThatUserHaveLastName() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        given()
                .when()
                .get("api/users/2")
                .then().body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void checkThatUserEnterCorrectPassword() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "cityslicka");
        Response response = given()
                .body(user)
                .when()
                .post("api/login")
                .then().log().all()
                .extract().response();
        Assert.assertEquals(user.get("password"), "cityslicka");
    }

    @Test
    public void checkSortedYearsTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        List<Data> data = given()
                .when()
                .get("/api/unknown")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Data.class);

        List<Integer> dataYears = data.stream().map(Data::getYear).collect(Collectors.toList());
        List<Integer> sortedDataYears = dataYears.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(dataYears, sortedDataYears);
        System.out.println(dataYears);
        System.out.println(sortedDataYears);
    }

    @Test
    public void patchRequestTest() {
        Specification.installSpecification(Specification.requestSpec("https://jsonplaceholder.typicode.com"), Specification.responseSpecOK200());
        String requestBody = "{\n" +
                "  \"title\": \"bax\" \n}";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("bax", response.jsonPath().getString("title"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("1", response.jsonPath().getString("id"));
    }
}
