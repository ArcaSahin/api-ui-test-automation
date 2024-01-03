package api.services;

import io.restassured.response.ValidatableResponse;

public class MainService extends BaseApiService {

    public ValidatableResponse getCreatedMovieByTitleKeyword(String titleKeyword) {
        return crud(
                "get",
                null,
                null,
                "/?s=" + titleKeyword + "&page=2&apikey=" + API_KEY + ""
        );
    }

    public ValidatableResponse getCreatedMovieByTitleAndYearKeywords(String titleKeyword, String yearKeyword) {
        return crud(
                "get",
                null,
                null,
                "/?t=" + titleKeyword + "&y=" + yearKeyword + "&apikey=" + API_KEY + ""
        );
    }

    public ValidatableResponse getCreatedMovieByPage(String keyword, String pageNumber) {
        return crud(
                "get",
                null,
                null,
                "/?s=" + keyword + "&page=" + pageNumber + "&apikey=" + API_KEY + ""
        );
    }

}
