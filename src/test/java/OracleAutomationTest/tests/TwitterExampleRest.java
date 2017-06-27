package OracleAutomationTest.tests;

/**
 * Created by david on 23/06/2017.
 */

import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;


public class TwitterExampleRest {




    static String CONSUMER_KEY="CAqMruvGzllJBDiLf3WSlbJmW";
    static String CONSUMER_SECRET="IrPs1kTd3j5UmoR5rT3gFkW3lrJJPsryPVzukn6ys5PkjWtUTE";
    static String ACCESS_TOKEN="102238235-S0AWSZ6aV4sxrZcOTBYkPxjaNFluylL9XICPOaI6";
    static String SECRET_TOKEN="tcCvnFyqB9ZDq1xg5sag8TIjVfDZDHpjAsnz75ZjO1P79";

    @Test
    public void TwitterRESTCheckOauth() throws Exception {


        given().auth().oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, SECRET_TOKEN)
                .when()
                .get("https://api.twitter.com/1.1/account/verify_credentials.json").then().statusCode(200);

    }
}
