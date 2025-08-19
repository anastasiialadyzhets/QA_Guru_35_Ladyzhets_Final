package api.specification;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class AuthSpec extends BaseSpec {
    public static RequestSpecification authRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType("application/json")
            .headers("Referer", "https://www.chitai-gorod.ru/")
            .headers("Accept", "*/*")
            .headers("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36")
            .headers("Authority", "web-agr.chitai-gorod.ru")
            .headers("Host", "web-agr.chitai-gorod.ru")


            .log().uri()
            .log().body()
            .log().headers()
            .basePath("web/api/v1/auth/anonymous");
    public static ResponseSpecification authResponse201Spec = build(201);
}
