package api.tests;

import api.services.MainService;
import com.sun.istack.logging.Logger;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class MainServiceTest {

    private MainService mainService;

    static Logger log = Logger.getLogger(MainServiceTest.class);

    @BeforeTest(groups= "ApiTest")
    public void setUp() {
        mainService = new MainService();
        log.info("API Tests are started!");
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByTitleTest() {

        String expectedTitle = "Batman: The Killing Joke";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedTitle, response.extract().path("Search[0].Title"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByYear() {

        String expectedYear = "2010";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedYear, response.extract().path("Search[1].Year"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByImdbID() {

        String expectedImdbID = "tt0106364";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedImdbID, response.extract().path("Search[2].imdbID"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByType() {

        String expectedType = "movie";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedType, response.extract().path("Search[3].Type"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByPoster() {

        String expectedPoster = "https://m.media-amazon.com/images/M/MV5BYTEzMmE0ZDYtYWNmYi00ZWM4LWJjOTUtYTE0ZmQyYWM3ZjA0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedPoster, response.extract().path("Search[4].Poster"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByTotalResults() {

        String expectedTotalResults = "551";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedTotalResults, response.extract().path("totalResults"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByResponse() {

        String expectedResponse = "True";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedResponse, response.extract().path("Response"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByWrongTitle() {

        String expectedResponse = "False";
        String expectedError = "Movie not found!";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman123");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedResponse, response.extract().path("Response"));
        assertEquals(expectedError, response.extract().path("Error"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieByEmptyTitle() {

        String expectedResponse = "False";
        String expectedError = "Incorrect IMDb ID.";

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedResponse, response.extract().path("Response"));
        assertEquals(expectedError, response.extract().path("Error"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByTitle() {

        String expectedTitle = "Batman Ninja";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedTitle, response.extract().path("Title"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByReleasedDate() {

        String expectedReleasedDate = "24 Apr 2018";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedReleasedDate, response.extract().path("Released"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByDirector() {

        String expectedDirector = "Junpei Mizusaki";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedDirector, response.extract().path("Director"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByCountry() {

        String expectedCountry = "Japan, United States";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedCountry, response.extract().path("Country"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByRatings() {

        String expectedRatingOfInternetMovieDatabase = "5.6/10";
        String expectedRatingOfRottenTomatoes = "82%";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedRatingOfInternetMovieDatabase, response.extract().path("Ratings[0].Value"));
        assertEquals(expectedRatingOfRottenTomatoes, response.extract().path("Ratings[1].Value"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByImdbVotes() {

        String expectedImdbVotes = "21,572";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "2018");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedImdbVotes, response.extract().path("imdbVotes"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByWrongTitleAndValidYear() {

        String expectedResponse = "False";
        String expectedError = "Movie not found!";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batmannnn", "2000");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedResponse, response.extract().path("Response"));
        assertEquals(expectedError, response.extract().path("Error"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByValidTitleAndInvalidYear() {

        String expectedResponse = "False";
        String expectedError = "Movie not found!";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "20100");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedResponse, response.extract().path("Response"));
        assertEquals(expectedError, response.extract().path("Error"));
    }

    @Test(groups= "ApiTest")
    void testCreatedMovieWithBothKeywordsByValidTitleAndEmptyYear() {

        // In this case, when you do not send any value into year field, api calls the movie which was released the earliest. (Batman/1989)

        String expectedYear = "1989";

        ValidatableResponse response = mainService.getCreatedMovieByTitleAndYearKeywords("Batman", "");

        response.extract().response().prettyPrint();
        assertEquals(200, response.extract().statusCode());

        assertEquals(expectedYear, response.extract().path("Year"));
    }

    @Test(groups= "ApiTest")
    void testCreatedAllMoviesPageByPage() {
        List<String> allMoviesTittledWithBatman = new ArrayList<>();

        ValidatableResponse response = mainService.getCreatedMovieByTitleKeyword("Batman");
        assertEquals(200, response.extract().statusCode());

        float totalResult = Float.parseFloat(response.extract().path("totalResults"));

        float dividedBy10 = totalResult / 10;

        int paginationCount = (int) Math.ceil(dividedBy10);

        for (int i = 1; i <= paginationCount; i++) {
            ValidatableResponse res = mainService.getCreatedMovieByPage("Batman", String.valueOf(i));
            int moviesCountPerPage = ((List<?>) res.extract().path("Search")).size();

            for (int j = 0; j < moviesCountPerPage; j++) {
                allMoviesTittledWithBatman.add(res.extract().path("Search[" + j + "].Title"));
            }
        }

        boolean isAllMovieTittleContainsBatman = true;

        List<String> doNotMatchConditionList = new ArrayList<>();

        for (String eachMovie : allMoviesTittledWithBatman) {
            if (!eachMovie.toLowerCase().contains("batman")) {
                isAllMovieTittleContainsBatman = false;
                doNotMatchConditionList.add(eachMovie + "\n");
            }
        }
        assertThat(
                "All movies tittle should contain batman but " + "\n" + doNotMatchConditionList + " \n don't match",
                isAllMovieTittleContainsBatman
        );
    }
}
